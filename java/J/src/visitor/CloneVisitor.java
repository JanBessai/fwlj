package visitor;
import java.util.*;

import ast.*;

public interface CloneVisitor {
  default E visitE(E e){return e.visitable().accept(this);}
  default E.X visitX(E.X x){return x;}
  default E.L visitL(E.L l){
    var t=l.t().map(this::visitT);
    var xs=this.listR(l.xs());
    var e=visitE(l.e());
    return E.L.of(t, xs,e);
    }
  default E.MCall visitMCall(E.MCall m){
    var r=visitE(m.receiver());
    var gensT=list(m.gensT());
    var es=list(m.es());
    return E.MCall.of(r,m.m(),gensT,es);
    }  
  default T visitT(T t){return t.visitable().accept(this);}
  default T visitCT(T.CT ct){
    var c=visitC(ct.c());
    var tx=list(ct.ts());
    return T.CT.of(c, tx);
    }
  default T.CX visitCX(T.CX cx){return cx;}
  default T.MX visitMX(T.MX mx){return mx;}
 
  default T.C visitC(T.C c){return c;}
  default Dec visitDec(Dec dec){
    var name=visitC(dec.name());
    var gens=listR(dec.gens());
    var supers=list(dec.supers());
    var ms=listR(dec.ms());
    return Dec.of(name,gens,supers,ms);
    }
  default Program visitProgram(Program p){
    var decs=listR(p.decs());
    return Program.of(decs);
    }
  default Dec.M visitM(Dec.M m){
    var mh=visitMH(m.mH());
    var e=m.e().map(this::visitE);
    return Dec.M.of(mh,e);
    }
  default Dec.MH visitMH(Dec.MH mh){
    var s=mh.s().map(this::visitS);
    var gens=listR(mh.gens());
    var retType=visitT(mh.retType());
    var ts=list(mh.ts());
    var xs=listR(mh.xs());
    return Dec.MH.of(s,gens,retType,mh.m(),ts,xs);
    }
  default Dec.S visitS(Dec.S s){
    var i=s.inductive().map(this::visitInductive);
    var hs=listR(s.hs());
    return Dec.S.of(s.total(),i,hs);
    }
  default Dec.Inductive visitInductive(Dec.Inductive i){
    var x=visitX(i.x());
    var e=visitE(i.e());
    return Dec.Inductive.of(x, e);
    }
  default Dec.H visitH(Dec.H h){
    var xs=listR(h.xs());
    Map<E.X,T> g=new LinkedHashMap<>();
    for(var ei: h.g().entrySet()) {
      g.put(visitX(ei.getKey()),visitT(ei.getValue()));
      }
    if(g.equals(h.g())){ g=h.g(); }
    else{ g=Collections.unmodifiableMap(g); }
    var e=visitE(h.e());
    return Dec.H.of(xs,g,e);
    }
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
