package op;

import static utils.General.*;

import java.util.*;
import java.util.stream.*;

import ast.*;
import visitor.*;

public class ToSource extends AbstractToString{
  public void visitX(E.X x){c(x.s());}
  public void visitCX(T.CX cx){c(cx.s());}
  public void visitMX(T.MX mx){c(mx.s());}
  public void visitC(T.C c){c(c.s());}

  private E atomE(E e){
    if(! (e instanceof E.MCall mc)){ return e; }
    return atomE(mc.receiver());
    }
  public void visitL(E.L l){
    l.t().ifPresent(this::visitT);
    var id=l.xs().size()==1 && l.xs().get(0).equals(l.e());
    if(id){
      if (l.t().isEmpty()){ c("[]"); }
      return; 
      }
    c("[");
    var meth=l.xs().size()==1 && l.xs().get(0).equals(atomE(l.e()));
    if(!meth){
      list(l.xs());
      if(!l.xs().isEmpty()){ c("|"); }
      visitE(l.e());
      c("]");
      return;
      }
    if(!(l.e() instanceof E.MCall mc)){throw bug();}//does not work with assertions
    printOmitRootReceiver(mc);
    c("]");
    }
  void printOmitRootReceiver(E.MCall m){
    if (m.receiver() instanceof E.MCall mc){
      printOmitRootReceiver(mc);
      c(".");
      }    
    visitX(m.m());
    c("(");
    list(m.es());
    c(")");
    }
  public void visitMCall(E.MCall m){
    visitE(m.receiver());
    c(".");
    visitX(m.m());
    if(!m.gensT().isEmpty()){
      c("<");
      list(m.gensT());
      c(">");
      }
    if(!m.es().isEmpty()){
      c("(");
      list(m.es());
      c(")");
      }
    }  
  public void visitCT(T.CT ct){
    visitC(ct.c());
    if(ct.ts().isEmpty()) {return;}
    c("<");
    list(ct.ts());
    c(">");
    }
  public void visitDec(Dec dec){
    visitC(dec.name());
    if(!dec.gens().isEmpty()){
      c("<");
      list(dec.gens());
      c(">");
      }
    c(":");
    list(dec.supers());
    c("{");
    for(var m:dec.ms()){
      c("\n");
      visitM(m);
      }
    c("\n  }\n");
    }
  public void visitM(Dec.M m){
    visitMH(m.mH());
    m.e().ifPresent(e->{
      c(" = \n    ");
      visitE(e);
      });
    c(";");
    }
  public void visitMH(Dec.MH mh){
    visitS(mh.s());
    c("  ");
    if(!mh.gens().isEmpty()){
      c("<");
      list(mh.gens());
      c("> ");
      }
    visitT(mh.retType());
    c(" ");
    visitX(mh.m());
    assert mh.ts().size()==mh.xs().size();
    if(mh.ts().isEmpty()){ return; }
    c("(");
    visitT(mh.ts().get(0));
    c(" ");
    visitX(mh.xs().get(0));
    IntStream.range(1, mh.ts().size()).forEach(i->{
      c(", ");
      visitT(mh.ts().get(i));
      c(" ");
      visitX(mh.xs().get(i));
      });
    c(")");
    }
  public void visitS(Dec.S s){
    if(s.s().isEmpty()) { return; }
    c("  ");c(s.s());
    }
  public void visitProgram(Program p){
    for(var d:p.decs()){ visitDec(d); }
    visitE(p.main());
    }
  public void list(List<? extends Visitable.Root<?>>vs){
    if (vs.isEmpty()){ return; }
    vs.get(0).visitable().accept(this);
    for(var v:vs.subList(1,vs.size())){
      c(", ");
      v.visitable().accept(this);
      }
    }
  }
