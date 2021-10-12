package op;

import static utils.General.*;

import java.util.*;

import ast.*;
import ast.E.*;
import parser.*;
import visitor.*;

public class DeBruIndexes implements CloneVisitor{
  Dec dec;
  Dec.MH mh;
  List<X>vars;
  public Dec visitDec(Dec dec){
    this.dec=dec;
    return CloneVisitor.super.visitDec(dec);
  }
  public Dec.MH visitMH(Dec.MH mh){
    this.mh=mh;
    this.vars=push(X.thisX, mh.xs());
    return CloneVisitor.super.visitMH(mh);
    }
  public E.X visitX(E.X x){
    var i=vars.indexOf(x);
    assert i!=-1:
      "";
    return E.X.of(""+i);
    }
  public T.CX visitCX(T.CX cx){
    var i=dec.gens().indexOf(cx);
    assert i!=-1;
    return T.CX.of(""+i);
    }
  public T.MX visitMX(T.MX mx){
    var i=mh.gens().indexOf(mx);
    assert i!=-1;
    return T.MX.of(""+i);
    }
  public E.L visitL(E.L l){
    var oldV=vars;
    if(vars!=null){ vars=concat(l.xs(),vars); }
    else{ vars=l.xs(); }
    try{return CloneVisitor.super.visitL(l);}
    finally {vars=oldV;}
    }
  }
