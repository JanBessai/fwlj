package ast;

import java.util.List;
import visitor.*;

public sealed interface T extends Visitable.Root<T>{
  record C(String s) implements Visitable.Record<C,C>{
    public C accept(CloneVisitor v){return v.visitC(this);}
    public void accept(CollectorVisitor v) {v.visitC(this);}
    public Visitable<C> visitable(){return this;}
    }
  record CT(C c, List<T>ts) implements T,Visitable.Record<CT,T>{
    public CT accept(CloneVisitor v){return v.visitCT(this);}
    public void accept(CollectorVisitor v) {v.visitCT(this);}
    public Visitable<CT> visitable(){return this;}
    }
  record CX(String s) implements T,Visitable.Record<CX,T>{
    public CX accept(CloneVisitor v){return v.visitCX(this);}
    public void accept(CollectorVisitor v) {v.visitCX(this);}
    public Visitable<CX> visitable(){return this;}  
    }
  record MX(String s) implements T,Visitable.Record<MX,T>{
    public MX accept(CloneVisitor v){return v.visitMX(this);}
    public void accept(CollectorVisitor v) {v.visitMX(this);}
    public Visitable<MX> visitable(){return this;}
    }
  }