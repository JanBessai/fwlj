package visitor;
import java.util.List;
import ast.*;

public interface CollectorVisitor {
  default void visitE(E e){e.visitable().accept(this);}
  default void visitX(E.X x){}
  default void visitL(E.L l){
    l.t().ifPresent(this::visitT);
    list(l.xs());
    visitE(l.e());
    }
  default void visitMCall(E.MCall m){
    visitE(m.receiver());
    visitX(m.m());
    list(m.es());
    }  
  default void visitT(T t){t.visitable().accept(this);}
  default void visitCT(T.CT ct){
    visitC(ct.c());
    list(ct.ts());
    }
  default void visitCX(T.CX cx){}
  default void visitMX(T.MX mx){}
 
  default void visitC(T.C c){}
  default void visitDec(Dec dec){
    visitC(dec.name());
    list(dec.gens());
    list(dec.supers());
    list(dec.ms());
    }
  default void visitProgram(Program p){
    list(p.decs());
    visitE(p.main());
    }
  default void visitM(Dec.M m){
    visitMH(m.mH());
    m.e().ifPresent(this::visitE);
    }
  default void visitMH(Dec.MH mh){
    visitS(mh.s());
    list(mh.gens());
    visitT(mh.retType());
    visitX(mh.m());
    list(mh.ts());
    list(mh.xs());
    }
  default void visitS(Dec.S s){}
  default void list(List<? extends Visitable.Root<?>>vs){
    for(var v:vs) {v.visitable().accept(this);}
    }
  }