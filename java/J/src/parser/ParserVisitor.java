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

@SuppressWarnings("serial")
class ParserFailed extends RuntimeException{
  public ParserFailed(){}
  public ParserFailed(String msg){super(msg);}
  }

public class ParserVisitor implements JVisitor<Object>{
  List<String> cxs=List.of();
  List<String> mxs=List.of();
  public static E.X freshX=new E.X("_toBeReplaced_");
  public StringBuilder errors=new StringBuilder();
  void check(ParserRuleContext ctx){  
    if(ctx.children!=null){return;}
    throw new ParserFailed();
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
    return new E.X(ctx.getText());
    }
  @Override public E visitL(LContext ctx) {
    check(ctx);
    Optional<T>t=Optional.empty();
    if(ctx.t()!=null){t=Optional.of(visitT(ctx.t()));}
    //t | t? '[' e ']' | t? '[' x* '|' e ']' | t? '[' mCall* ']';
    // TODO: does [foo] means [x|x.foo()] or [foo] the local var?
    // TODO: need transformation at the end to replace all the 'fresh variables'
    List<E.X> xs=ctx.e()==null?
      List.of(freshX):ctx.x().stream().map(x->visitX(x)).toList();
    E e=ctx.e()==null?
      freshX:visitE(ctx.e());
    for(var mCall : ctx.mCall()) {e=visitMCall(e,mCall);}
    return new E.L(t,xs,e);
    }
  @Override public E visitNum(NumContext ctx) {throw todo();}
  @Override public E visitString(StringContext ctx) {throw todo();}
  public E visitMCall(E rec,MCallContext ctx) {
    check(ctx);
    E.X m=visitX(ctx.x());
    List<E> es=ctx.e().stream().map(e->visitE(e)).toList();
    return new E.MCall(rec, m, es);
    }
  @Override public E visitNudeE(NudeEContext ctx) {
    check(ctx);
    return visitE(ctx.e());
    }
  @Override public T visitT(TContext ctx) {
    check(ctx);
    String c=ctx.C().getText();
    if(cxs.contains(c)) {return new T.CX(c);}
    if(mxs.contains(c)) {return new T.MX(c);}
    List<T> ts=ctx.t().stream().map(t->visitT(t)).toList();
    return new T.CT(new T.C(c),ts);
    }
  @Override public List<String> visitGens(GensContext ctx) {
    if(ctx.children!=null){return List.of();}
    //check(ctx);
    return ctx.C().stream().map(c->c.getText()).toList();
    }
  @Override public Dec.MH visitMH(MHContext ctx) {
    check(ctx);
    List<String> gens=visitGens(ctx.gens());
    var gensShadow=gens.stream().anyMatch(cxs::contains);
    if(gensShadow){throw todo();}
    var gg=gens.stream().map(s->new T.MX(s)).toList();
    var s=new Dec.S(ctx.S()==null?"":ctx.S().getText());
    List<T> ts=ctx.t().stream().map(t->visitT(t)).toList();
    List<E.X> xs=ctx.x().stream().map(x->visitX(x)).toList();
    assert ts.size()==xs.size();
    return new Dec.MH(s,gg, ts.get(0), xs.get(0),popLeft(ts), popLeft(xs));    
    }
  @Override public Dec.M visitMDec(MDecContext ctx) {
    check(ctx);
    Dec.MH mH=visitMH(ctx.mH());
    Optional<E> e=Optional.empty();
    if(ctx.e()!=null){e=Optional.of(visitE(ctx.e()));}
    return new Dec.M(mH, e);    
    }
  @Override public Dec visitDec(DecContext ctx) {
    check(ctx);
    var name=new T.C(ctx.C().getText());
    List<String> gens=visitGens(ctx.gens());
    var gg=gens.stream().map(s->new T.CX(s)).toList();
    List<T> ts=ctx.t().stream().map(t->visitT(t)).toList();
    List<Dec.M>ms=ctx.mDec().stream().map(m->visitMDec(m)).toList();
    return new Dec(name,gg,ts,ms);
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
    E e=visitE(ctx.e());
    return new Program(decs, e);
    }
  }