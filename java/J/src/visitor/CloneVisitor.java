package visitor;
import java.util.List;

import ast.*;

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
    var name=visitX(m.m());
    var es=list(m.es());
    return new E.MCall(r,name,es);
    }  
  default T visitT(T t){return t.visitable().accept(this);}
  default T.CT visitCT(T.CT ct){
    var c=visitC(ct.c());
    var tx=list(ct.ts());
    return new T.CT(c, tx);
    }
  default T.CX visitCX(T.CX cx){return cx;}
  default T.MX visitMX(T.MX mx){return mx;}
 
  default T.C visitC(T.C c){return c.accept(this);}
  default Dec visitDec(Dec dec){return dec.accept(this);}
  default Program visitProgram(Program p){return p.accept(this);}
  default Dec.M visitM(Dec.M m){return m.accept(this);}
  default Dec.MH visitMH(Dec.MH mh){return mh.accept(this);}
  default Dec.S visitS(Dec.S s){return s.accept(this);}

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
