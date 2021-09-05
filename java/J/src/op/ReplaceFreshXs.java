package op;

import java.util.*;

import ast.*;
import ast.E.*;
import parser.*;
import visitor.*;

public class ReplaceFreshXs implements CloneVisitor{
  private Set<E.X>allXs;
  private int counter=0;
  public Program fixProgram(Program p){
    var xs=new Collect.AllX().collect(p);
    allXs=new HashSet<>(xs);
    counter=0;
    return p.accept(this);
    }
  E.X freshX(){
    var res=new E.X("u"+(counter++));
    var notContained=allXs.add(res);
    if(notContained){ return res; }
    return freshX();
  }
  @Override public E.L visitL(E.L l){
    l=CloneVisitor.super.visitL(l);
    if(!(l.e() instanceof E.MCall mc)){ return l; }
    var skip = l.xs().size()!=1 
      || mc.receiver()!=l.xs().get(0)
      || mc.receiver()!=ParserVisitor.freshX;
    if(skip){return l;}
    var x=freshX();
    mc=new MCall(x,mc.m(),mc.es());
    return new E.L(l.t(),List.of(x),mc);
    }
  }
