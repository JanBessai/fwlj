package op;

import java.util.*;

import ast.*;
import ast.Dec.*;
import ast.T.*;
import visitor.*;

/*
t  ::= Xs,G, Hs |- e  |  SOLVED
e  ::= x | T[xs|e] | e.m(es)
v  ::= T[xs|e]
ctx::= [] | ctx.m(es) |  e.(es ctx es’)
H  ::= t  |  induction(e,x)

#Define x in e == e of form ctx[x]
#Define WF Ds t= WF Ds empty,empty [t]
#Define WF Ds XsG [H]

WF Ds Xs G [ Xs’,G’,Hs |- e ]
   Exists T, Ds Xs,Xs’ G,G’ |- e : T
   Forall H in Hs, WF Xs,Xs’ G,G’ [ H ]
   Forall H in Hs minimal(H,Hs)//optional
   FV(e)=dom(g)
   Xs=FTV(G)//free type variables

WF Ds Xs G [ induction(e,x) ]
    x in e
    Exists T, Ds Xs G |- e : T

#Define Ds,Xs,G |- total(Hs,e)
0- Ds,Xs,G|- total(Hs,x)
1- Ds,Xs,G|- total(Hs,v)
2- Ds,Xs,G|- total(Hs, e)
     Xs', G',empty |- ctx[e]  in Hs
3- Ds,Xs,G|- total(Hs,e)
  H in Hs
  x1..xn = H.G
  H.e[x1=e1..xn=en] = e  //Note: thanks to no hiding in typing, x1..xn not any lambda body
  Ds,Xs,G|- e1 : _ <= H.G(x1) ..  Ds,Xs,G|- en : _ <= H.G(xn)
  Ds,Xs,G|- total(Hs,e1) .. Ds,Xs,G|- total(Hs,en)
4- Ds,Xs,G|- total(Hs,e)
  Xs',G',empty|- v.m(vxs) in Hs
  Xs',G',empty|- bodyOf(v.m(vxs)) notin Hs
  Ds,Xs,G|- total(Hs Xs,G,empty|- bodyOf(v.m(vxs))  ,e)

      Ds,Xs,G|- total(Hs,e)
H -----------------------------------
      Ds  Xs,G,Hs |-e → SOLVED

     bodyOf(Ds,v.m)=Xs0,Xs1,xs,e 
     //bodyOf will do the inheritance chain tweaks and also alpha rename them to fresh
     e’=e[Xs0=v.Ts Xs1=Ts ][this=v,xs=e1..en  ]
     Ds,Xs,G|- total(Hs,e1)...       Ds,Xs,G|- total(Hs,en)
M ------------------------------------------------------------------------------
     Ds    Xs,G,Hs |- ctx[ v.m<Ts>(e1..en) ] → Xs,G,Hs |- ctx[ e’ ]

     //x in e required by well formedness anyway  // e of form ctx[x]
     G(x) notin Xs
     induction(e,x) in Hs
I -----------------------------------
     Ds     Xs,G,Hs |- e → SOLVED

*/
public record Termination(Program p, Dec d, S s, List<MX> mxs){  
  public static S expandHs(S s){
    return s;/*
    var currentHs=s.hs();
    var newHs=new ArrayList<H>();
    for(H h:currentHs){ 
      if(!(h.e() instanceof E.MCall m)){ continue; }
      }
    TODO: Problematic: what about submeth calls?
    */
    }
  public String valid(E e){
    Set<String> res=exploreMCalls(e, false);
    if(res.isEmpty()){ return ""; }
    return exploreMCalls(e, true).toString();
    }
  public static Set<String> simpleErr=Set.of("ERR");
  public Set<String> exploreMCalls(E e,boolean err){
    if(s.inductive().isPresent()){
      var i=s.inductive().get();
      if(i.e()==e){ return Set.of(); }
      }
    if(total(e)){ return Set.of(); }
    var one=oneStep(e);
    if(one.isEmpty()){ return err?Set.of("Stucked on "+e):simpleErr; }//when errors will be better it will become important
    Set<String>errs=new HashSet<>();
    for(E ei:one){
      Set<String> res=exploreMCalls(ei,err);
      if(res.isEmpty()){ return res; }
      if(err){ errs.addAll(res); }
      }
    if(!err) { return simpleErr; }
    return errs;
    //TODO: this should be cached for performance
    }
  public List<E> oneStep(E e){
    var res=new ArrayList<E>();
    e.visitable().accept(new CollectorVisitor() {
      @Override public void visitL(E.L l){}
      @Override public void visitMCall(E.MCall m){
        CollectorVisitor.super.visitMCall(m);
        if(!(m.receiver() instanceof E.L l)){ return; }
        var allTerm=m.es().stream().allMatch(e->total(e));
        if(!allTerm){ return; }
        var xse=bodyOf(l,m.m());//bodyOf(Ds,v.m)=Xs0,Xs1,xs,e 
        res.add(xse.subst(l,m.es()));               
        }
      });
    return res;
    }
  record BodyOf(List<E.X> xs,E e){

    public E subst(E self,List<E> es) {
      assert xs.size()==es.size();
      return e.visitable().accept(new CloneVisitor(){
        @Override public E visitX(E.X x){
          if(x==E.X.thisX){return self;}
          for(int i=0;i<xs.size();i++){
            if(xs.get(i)==x){ return es.get(i); }
            }
          return x;
          }});
      }
    }
  public BodyOf bodyOf(E.L v,E.X m){
    T.CT t=(T.CT)v.t().get();
    M meth=bodyRecOf(t.c(),m);
    if(meth!=null){ return new BodyOf(meth.mH().xs(),meth.e().get()); }
    //otherwise, given that is well typed, the lambda body is the method body
    return new BodyOf(v.xs(),v.e());
    //TODO: missing alpharenaming
    }
  public Dec.M bodyRecOf(T.C c, E.X m){
    Dec d=p.get(c);
    M meth=d.get(m);
    var abs=meth==null || meth.e().isEmpty();
    if(!abs){ return meth; }
    for(T.CT t:d.supers()){ 
      var res=bodyRecOf(t.c(),m);
      if(res!=null){ return res; }
      }
    return null;
    }
  public boolean total(E e){
    if(e instanceof E.X){ return true; }
    if(e instanceof E.L){ return true; }
    for(H h:s().hs()){//Note: empty h.hs by construction 
      if (in(e,h.e())){return true;}
      }
    //TODO: still point 3, point 4 is expanded
    return false;
    }
  public static boolean in(E e,E large){
    boolean[]found= {false};
    large.visitable().accept(new CollectorVisitor(){
      @Override public void visitX(E.X x){ found[0] |= x==e; }
      @Override public void visitL(E.L l){ found[0] |= l==e; }
      @Override public void visitMCall(E.MCall m){
        if(m==e) { found[0]=true; return; }
        visitE(m.receiver());
        list(m.es());
        }
      });
    return found[0];
    }
  }
