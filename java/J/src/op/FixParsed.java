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
  public Dec.M visitM(Dec.M m){
    if(m.mH().s().isEmpty()){ return CloneVisitor.super.visitM(m); }
    var i=m.mH().s().get().inductive();
    var toFix=i.isPresent() && i.get().e()==null;
    if (toFix && m.e().isEmpty()){
      throw new ParserVisitor.ParserFailed("abstract methods must specify induction expression explicitly");
      }
    if(toFix){
      i=Optional.of(Dec.Inductive.of(i.get().x(),m.e().get()));
      var s=m.mH().s().get().with(i);      
      var mh=m.mH().with(Optional.of(s));
      m=m.with(mh);
      }
    return CloneVisitor.super.visitM(m);
    }
  public Dec.H visitH(Dec.H h){
    var old=this.mxs;
    this.mxs=h.xs();
    try{return CloneVisitor.super.visitH(h);}
    finally{this.mxs=old;}
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
    if(inMxs){ return T.MX.of(n); }
    if(inCxs){ return T.CX.of(n); }
    return t;
    }
  E.X freshX(){
    var res=E.X.of("u"+(counter++));
    var notContained=allXs.add(res);
    if(notContained){ return res; }
    return freshX();
  }
  @Override public E.L visitL(E.L l){
    l=CloneVisitor.super.visitL(l);
    if(l.e()==ParserVisitor.freshX){
      var x=freshX();
      return E.L.of(l.t(),List.of(x),x);
      }
    if(!(l.e() instanceof E.MCall mc)){ return l; }
    var skip = l.xs().size()!=1 
      || mc.receiver()!=l.xs().get(0)
      || mc.receiver()!=ParserVisitor.freshX;
    if(skip){return l;}
    var x=freshX();
    mc=MCall.of(x,mc.m(),mc.gensT(),mc.es());
    return E.L.of(l.t(),List.of(x),mc);
    }
  }
