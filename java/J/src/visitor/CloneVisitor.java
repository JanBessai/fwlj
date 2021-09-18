package visitor;
import java.util.List;

import ast.*;
import ast.Dec.*;

public interface CloneVisitor {
  default E visitE(E e){return e.visitable().accept(this);}
  default E.X visitX(E.X x){return x;}
  default E.L visitL(E.L l){
    var t=l.t().map(this::visitT);
    var xs=this.listR(l.xs());
    var e=visitE(l.e());
    return new E.L(t, xs,e);
    }
  default E.MCall visitMCall(E.MCall m){
    var r=visitE(m.receiver());
    var gensT=list(m.gensT());
    var es=list(m.es());
    return new E.MCall(r,m.m(),gensT,es);
    }  
  default T visitT(T t){return t.visitable().accept(this);}
  default T visitCT(T.CT ct){
    var c=visitC(ct.c());
    var tx=list(ct.ts());
    return new T.CT(c, tx);
    }
  default T.CX visitCX(T.CX cx){return cx;}
  default T.MX visitMX(T.MX mx){return mx;}
 
  default T.C visitC(T.C c){return c;}
  default Dec visitDec(Dec dec){
    var name=visitC(dec.name());
    var gens=listR(dec.gens());
    var supers=list(dec.supers());
    var ms=listR(dec.ms());
    return new Dec(name,gens,supers,ms);
    }
  default Program visitProgram(Program p){
    var decs=listR(p.decs());
    var main=visitE(p.main());
    return new Program(decs,main);
    }
  default Dec.M visitM(Dec.M m){
    var mh=visitMH(m.mH());
    var e=m.e().map(this::visitE);
    return new Dec.M(mh,e);
    }
  default Dec.MH visitMH(Dec.MH mh){
    var s=visitS(mh.s());
    var gens=listR(mh.gens());
    var retType=visitT(mh.retType());
    var ts=list(mh.ts());
    var xs=listR(mh.xs());
    return new Dec.MH(s,gens,retType,mh.m(),ts,xs);
    }
  default Dec.S visitS(Dec.S s){return s;}

  default <K> K mapping(Visitable.Root<K> v){
    return v.visitable().accept(this);
    }
  default <R extends K,K extends Visitable.Root<R>> List<R> list(List<K>vs){
    return vs.stream().map(k->mapping(k)).toList();
    }
  default <K extends Visitable.Record<K,?>> List<K> listR(List<K>vs){
    return vs.stream().map(k->k.accept(this)).toList();
    }  
  }
