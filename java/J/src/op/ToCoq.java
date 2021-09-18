package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import visitor.*;

public class ToCoq extends AbstractToString{
  public void visitX(E.X x){c("(Var "+x.s()+")");}
  public void visitCX(T.CX cx){c("(ClassTyVar "+cx.s()+")");}
  public void visitMX(T.MX mx){c("(MethodTyVar "+mx.s()+")");}
  public void visitC(T.C c){c("(Name \""+c.s()+"\")");}
  public void visitCT(T.CT ct){
    if(ct.ts().isEmpty()){ c(cToName(ct.c())); return; }
    c("(");
    c(cToName(ct.c()));
    c(" ");
    list(ct.ts()," ");
    c(")");
    }

  public void visitL(E.L l){
    c("(Lambda ");
    if(l.t().isEmpty()){ throw new Error("Lambda without type: "+new ToSource().of(l)); }
    visitT(l.t().get());
    c(" "+l.xs().size()+" ");
    visitE(l.e());
    c(")");
    }
  public void visitMCall(E.MCall m){
    // (MethodCall (Var 1) (Name "apply") [::] [::]))
    c("(MethodCall ");
    visitE(m.receiver());
    c("(Name \""+m.m().s()+"\")");
    c("[:: ");
    list(m.gensT(),"; ");
    c("] ");
    c("[:: ");
    list(m.es(),"; ");
    c("])");
    }  
  public void visitDec(Dec dec){
    //TODO: some names are unfortunate in Coq. Void + IFalse is not enough for me. What is a full solution?
    c("Definition "+dec.name().s()+":Declaration:=\n");
    c("  Interface ");visitC(dec.name());
    c(" "+dec.gens().size()+" [:: ");
    list(dec.supers(),"; ");
    c("] [::\n  ");
    list(dec.ms(),";\n  ");
    c("  ].");    
    }
  public void visitM(Dec.M m){
    c(m.e().isPresent()?"DefaultMethod ":"AbstractMethod ");
    visitMH(m.mH());
    c(" ");
    m.e().ifPresent(e->visitE(e));
    }
  public void visitMH(Dec.MH mh){
    //(MethodHeader 0 TrueTy (Name "checkTrue") [::])
    //(MethodHeader 0 BoolTy (Name "and") [:: BoolTy])
    c("(MethodHeader "+mh.gens().size()+" ");
    visitT(mh.retType());
    c(" ");
    c("(Name \""+mh.m().s()+"\")");
    c(" [:: ");
    list(mh.ts(),"; ");
    c(" ])");    
    }
  public void visitS(Dec.S s){
    //TODO: here we should generate the required theorem somehow?
    }
  public void visitProgram(Program p){
    c("""
        From mathcomp Require Import all_ssreflect.
        Require Import FLGJ.
        Require Import Names.
        Require Import String.
        Import StringSyntax.
         
        """);  
    for(var d:p.decs()){ preVisitDec(d); }
    p=new DeBruIndexes().visitProgram(p);
    for(var d:p.decs()){ visitDec(d); }
    //TODO: visitE(p.main());//NO? Yes? How?
    }
  public String cToName(T.C c){
    //TODO: this conflicts if we have class A and class ATy
    return c.s()+"Ty";
    }
  public void preVisitDec(Dec d){
    c("Definition "+cToName(d.name()));
    if(!d.gens().isEmpty()){
      c("(");
      var pars=d.gens().stream().map(g->g.s()).collect(Collectors.joining(" "));
      c(pars+":Ty)");
      }
    c(" := TyRef ");
    visitC(d.name());
    c(" [:: ");
    var pars=d.gens().stream().map(g->g.s()).collect(Collectors.joining("; "));
    c(pars+"].");    
    }
  public void list(List<? extends Visitable.Root<?>>vs,String sep){
    if (vs.isEmpty()){ return; }
    vs.get(0).visitable().accept(this);
    for(var v:vs.subList(1,vs.size())){
      c(sep);
      v.visitable().accept(this);
      }
    }
  }