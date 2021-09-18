package op;

import java.util.*;

import ast.*;
import ast.E.*;
import parser.*;
import visitor.*;

public class FixParsed implements CloneVisitor{
  private Set<E.X>allXs;
  private List<T.MX>mxs=List.of();
  private List<T.CX>cxs=List.of();
  private int counter=0;
  public Program fixProgram(Program p){
    var xs=new Collect.AllX().collect(p);
    allXs=new HashSet<>(xs);
    counter=0;
    return p.accept(this);
    }
  public Dec.MH visitMH(Dec.MH mh){
    this.mxs=mh.gens();
    return CloneVisitor.super.visitMH(mh);
    }
  public Dec visitDec(Dec dec){
    this.cxs=dec.gens();
    return CloneVisitor.super.visitDec(dec);
    }
  public T visitCT(T.CT t){
    if(!t.ts().isEmpty()){ return CloneVisitor.super.visitCT(t); }
    var n=t.c().s();
    var inCxs=cxs.stream().anyMatch(e->e.s().equals(n));
    var inMxs=mxs.stream().anyMatch(e->e.s().equals(n));
    if(inMxs){ return new T.MX(n); }
    if(inCxs){ return new T.CX(n); }
    return t;
    }
  E.X freshX(){
    var res=new E.X("u"+(counter++));
    var notContained=allXs.add(res);
    if(notContained){ return res; }
    return freshX();
  }
  @Override public E.L visitL(E.L l){
    l=CloneVisitor.super.visitL(l);
    if(l.e()==ParserVisitor.freshX){
      var x=freshX();
      return new E.L(l.t(),List.of(x),x);
      }
    if(!(l.e() instanceof E.MCall mc)){ return l; }
    var skip = l.xs().size()!=1 
      || mc.receiver()!=l.xs().get(0)
      || mc.receiver()!=ParserVisitor.freshX;
    if(skip){return l;}
    var x=freshX();
    mc=new MCall(x,mc.m(),mc.gensT(),mc.es());
    return new E.L(l.t(),List.of(x),mc);
    }
  }
