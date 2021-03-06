package parser;

import static utils.General.*;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.*;

import ast.*;
import generated.JParser.*;
import generated.JVisitor;

public class ParserVisitor implements JVisitor<Object>{
  @SuppressWarnings("serial")
  public static class ParserFailed extends RuntimeException{
    public ParserFailed(){}
    public ParserFailed(String msg){super(msg);}
    }
  public static final E.X freshX=E.X.of("_toBeReplaced_");
  public StringBuilder errors=new StringBuilder();
  void check(ParserRuleContext ctx){  
    if(ctx.children!=null){return;}
    throw new ParserFailed("line ="+ctx.start.getLine()+"\ntext=["+ctx.getText()+"]");
    }
  @Override public Void visit(ParseTree arg0) {throw bug();}
  @Override public Void visitChildren(RuleNode arg0) {throw bug();}
  @Override public Void visitErrorNode(ErrorNode arg0) {throw bug();}
  @Override public Void visitTerminal(TerminalNode arg0) {throw bug();}
  @Override public E visitE(EContext ctx) {
    check(ctx);
    E res=visitEAtom(ctx.eAtom());
    for(var mCi:ctx.mCall()){ res=visitMCall(res,mCi); }
    return res;
    }
  @Override public E visitEAtom(EAtomContext ctx) {
    check(ctx);
    Optional<E> res=Stream.of(
      opt(ctx.x(),null,this::visitX),
      opt(ctx.l(),null,this::visitL),
      opt(ctx.num(),null,this::visitNum),
      opt(ctx.string(),null,this::visitString)
      ).filter(a->a!=null).findFirst();
    return res.get();
    }
  @Override public E.X visitX(XContext ctx) {
    check(ctx);
    assert !ctx.getText().isBlank();
    return E.X.of(ctx.getText());
    }
  @Override public E visitL(LContext ctx) {
    check(ctx);
    Optional<T.CT>t=Optional.empty();
    if(ctx.t()!=null){t=Optional.of((T.CT)visitT(ctx.t()));}
    // Note, [foo] means [foo] the local var, not [x|x.foo()]
    // to disambiguate, parenthesis are kept in that sugar
    List<E.X> xs=ctx.e()==null?
      List.of(freshX):ctx.x().stream().map(x->visitX(x)).toList();
    E e=ctx.e()==null?
      freshX:visitE(ctx.e());
    for(var mCall : ctx.mCall()) {e=visitMCall(e,mCall);}
    return E.L.of(t,xs,e);
    }
  @Override public E visitNum(NumContext ctx) {throw todo();}
  @Override public E visitString(StringContext ctx) {throw todo();}
  public E visitMCall(E rec,MCallContext ctx) {
    check(ctx);
    E.X m=visitX(ctx.x());
    List<E> es=ctx.e().stream().map(e->visitE(e)).toList();
    List<T> gensT=visitGensT(ctx.gensT());
    return E.MCall.of(rec, m, gensT, es);
    }
  @Override public E visitNudeE(NudeEContext ctx) {
    check(ctx);
    return visitE(ctx.e());
    }
  @Override public T visitT(TContext ctx) {
    check(ctx);
    String c=ctx.C().getText();
    List<T> ts=ctx.t().stream().map(t->visitT(t)).toList();
    return T.CT.of(T.C.of(c),ts);
    }
  @Override public List<String> visitGens(GensContext ctx) {
    if(ctx.children==null){return List.of();}
    return ctx.C().stream().map(c->c.getText()).toList();
    }
  @Override public List<T> visitGensT(GensTContext ctx) {
    if(ctx.children==null){return List.of();}
    return ctx.t().stream().map(t->visitT(t)).toList();
    }
  @Override public Dec.S visitS(SContext ctx){
    check(ctx);
    var total=ctx.getText().startsWith("@total");
    var i=ctx.induction();
    Optional<Dec.Inductive> ind=i==null?Optional.empty():Optional.of(visitInduction(i));
    var h=ctx.h();
    List<Dec.H> hs=h==null?List.of():h.stream().map(this::visitH).toList();
    return Dec.S.of(total, ind, hs);
    }
  @Override public Dec.Inductive visitInduction(InductionContext ctx){
    check(ctx);
    E.X x=visitX(ctx.x());
    E e=ctx.e()==null?null:visitE(ctx.e());
    return Dec.Inductive.of(x, e);
    }
  @Override public Dec.H visitH(HContext ctx){
    check(ctx);
    List<T.MX> xs=ctx.cs()==null?List.of():visitCs(ctx.cs());
    Map<E.X,T> g=ctx.g()==null?Map.of():visitG(ctx.g());
    return Dec.H.of(xs, g, visitE(ctx.e()));
    }
  @Override public List<T.MX> visitCs(CsContext ctx){
    check(ctx);
    var c=T.MX.of(ctx.C().getText());
    if (ctx.cs()==null){ return List.of(c); }
    return push(c,visitCs(ctx.cs()));
    }
  @Override public Map<E.X,T> visitG(GContext ctx){
    check(ctx);
    var x=visitX(ctx.x());
    var t=visitT(ctx.t());    
    if (ctx.g()==null){ return Map.of(x,t); }
    var res=new LinkedHashMap<>(Map.of(x,t));
    res.putAll(visitG(ctx.g()));
    return res;
    }
  @Override public Dec.MH visitMH(MHContext ctx) {
    check(ctx);
    List<String> gens=visitGens(ctx.gens());
    var gg=gens.stream().map(s->T.MX.of(s)).toList();
    Optional<Dec.S> s=ctx.s()==null?Optional.empty():Optional.of(visitS(ctx.s()));
    List<T> ts=ctx.t().stream().map(t->visitT(t)).toList();
    List<E.X> xs=ctx.x().stream().map(x->visitX(x)).toList();
    assert ts.size()==xs.size();
    return Dec.MH.of(s,gg, ts.get(ts.size()-1), xs.get(0),popRight(ts), popLeft(xs));    
    }
  @Override public Dec.M visitMDec(MDecContext ctx) {
    if(ctx.children==null && ctx.getText().isEmpty()){
      throw new ParserFailed("line ="+ctx.start.getLine()+"\npossible missing ';' at the end of abstract method");  
      }
    check(ctx);
    Dec.MH mH=visitMH(ctx.mH());
    Optional<E> e=Optional.empty();
    if(ctx.e()!=null){e=Optional.of(visitE(ctx.e()));}
    return Dec.M.of(mH, e);    
    }
  @Override public Dec visitDec(DecContext ctx) {
    check(ctx);
    var name=T.C.of(ctx.C().getText());
    List<String> gens=visitGens(ctx.gens());
    var gg=gens.stream().map(s->T.CX.of(s)).toList();
    List<T.CT> ts=ctx.t().stream().map(t->(T.CT)visitT(t)).toList();
    List<Dec.M>ms=ctx.mDec().stream().map(m->visitMDec(m)).toList();
    return Dec.of(name,gg,ts,ms);
    }
  static <A,B> B opt(A a,B def,Function<A,B>f){
    if(a==null){return def;}
    return f.apply(a);
    }
  /*
  private int stringToInt(TerminalNode ctx) {
    return opt(ctx,-1,n0->stringToInt(n0.getText(),()->
      this.errors.append("dd"))); 
    }
  private int stringToInt(String n,Runnable err){
    if(n.contains(".") || n.contains("_") || n.contains("-")){
      err.run();
      return -1;
      }
    if(n.startsWith("0")){
      err.run();
      return -1;
      }
    try{return Integer.parseInt(n);}
    catch(NumberFormatException nfe){
      err.run();
      return -1;
      }
    }*/
  @Override public Object visitMCall(MCallContext ctx) {throw bug();}
  @Override public Program visitProg(ProgContext ctx) {
    check(ctx);
    List<Dec> decs=ctx.dec().stream().map(d->visitDec(d)).toList();
    return Program.of(decs);
    }
  }