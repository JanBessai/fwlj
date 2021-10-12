package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import ast.Dec.*;
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
    c("Definition "+unclash(dec.name().s())+":Declaration:=\n");
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
        
        Module Ty.
        """);  
    for(var d:p.decs()){ preVisitDec(d); }
    c("End Ty.\nModule I.\n");
    p=new DeBruIndexes().visitProgram(p);
    for(var d:p.decs()){ visitDec(d); }
    c("End I.\n"); 
    //Note: no visit to visitE(p.main());
    defineProgram(p);
    defineRecord(p);
    }
  private void defineProgram(Program p){
    c("Definition Prog: Program := Decls[::\n  ");
    String decs=p.decs().stream().map(d->unclash(d.name().s())).collect(Collectors.joining(";\n  "));
    c(decs+"].\n");
    }
  private void defineRecord(Program p){
    c("Record Theorems := {\n"  );
    for(var di:p.decs()) {
      for(var mi: di.ms()) {
        if(mi.mH().s().isEmpty()){continue;}
        defineRecordEntry(di,mi);
        }
      }
    c("}.");
    }
  private void defineRecordEntry(Dec di, M mi){
    c("  "+unclash(di.name().s())+"_"
      +unclash(mi.mH().m().s())+" : Terminates (Name \""
      +di.name().s()+"\") (Name \""
      +mi.mH().m().s()+"\");\n  ");
    }
  private static Map<String,String>clashes=Map.of(
    "Definition","Definition_"
    );
  private static String unclash(String s){return clashes.getOrDefault(s, s);}
  public String cToName(T.C c){
    return "Ty."+unclash(c.s());
    }
  public void preVisitDec(Dec d){
    c("Definition "+unclash(d.name().s()));
    if(!d.gens().isEmpty()){
      c("(");
      var pars=d.gens().stream().map(g->unclash(g.s())).collect(Collectors.joining(" "));
      c(pars+":TyRef)");
      }
    c(" := TyRef ");
    visitC(d.name());
    c(" [:: ");
    var pars=d.gens().stream().map(g->unclash(g.s())).collect(Collectors.joining("; "));
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