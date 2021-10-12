package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import visitor.*;

public class ToJava extends AbstractToString{
  public String lift(String s){
    if(keywords.contains(s)){ return "_"+s; }
    return s;
  }
  public Set<String> keywords=Set.of(
    "abstract", "continue", "for",        "new",       "switch",
    "assert",   "default",  "goto",       "package",   "synchronized",
    "boolean",  "do",       "if",         "private",   /*"this",*/
    "break",    "double",   "implements", "protected", "throw",
    "byte",     "else",     "import",     "public",    "throws",
    "case",     "enum",     "instanceof", "return",    "transient",
    "catch",    "extends",  "int",        "short",     "try",
    "char",     "final",    "interface",  "static",    "void",
    "class",    "finally",  "long",       "strictfp",  "volatile",
    "const",    "float",    "native",     "super",     "while",
    "true",     "false",    "null"
    );
  public void visitX(E.X x){c(lift(x.s()));}
  public void visitCX(T.CX cx){c(cx.s());}
  public void visitMX(T.MX mx){c(mx.s());}
  public void visitC(T.C c){c(c.s());}

  public void visitTL(E.L l){
    c("((");visitT(l.t().get());c(")");
    visitLambda(l);
    c(")");
    }
  public void visitLambda(E.L l){
    c("(");
    list(l.xs());
    c(")->");
    visitE(l.e());
    }
  public void visitL(E.L l){
    if(l.t().isPresent()){ visitTL(l); return; }
    visitLambda(l);
    }
  public void visitMCall(E.MCall m){
    visitE(m.receiver());
    c(".");
    if(!m.gensT().isEmpty()){
       c("<");
       list(m.gensT());
       c(">");
       }
    visitX(m.m());
    c("(");
    list(m.es());
    c(")");
    }  
  public void visitCT(T.CT ct){
    visitC(ct.c());
    if(ct.ts().isEmpty()) {return;}
    c("<");
    list(ct.ts());
    c(">");
    }
  public void visitDec(Dec dec){
    c("interface ");
    visitC(dec.name());
    if(!dec.gens().isEmpty()){
      c("<");
      list(dec.gens());
      c(">");
      }
    if(!dec.supers().isEmpty()){
      c(" extends ");
      list(dec.supers());
      }
    c("{");
    for(var m:dec.ms()){
      c("\n");
      visitM(m);
      }
    c("\n  }\n");
    }
  public void visitM(Dec.M m){
    m.e().ifPresent(e->c("default "));
    visitMH(m.mH());
    m.e().ifPresentOrElse(e->{
      c("{\n    return ");
      visitE(e);
      c(";\n    }");
      },()->c(";"));
    }
  public void visitMH(Dec.MH mh){
    mh.s().ifPresent(this::visitS);
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
    if(mh.ts().isEmpty()){ c("()");return; }
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
    c("  //");
    c(s.total()?"total\n":"aux\n");
    s.inductive().ifPresent(this::visitInductive);
    list(s.hs());
    }
  public void visitProgram(Program p){
    for(var d:p.decs()){ visitDec(d); }
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
