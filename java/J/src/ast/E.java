package ast;

import java.util.*;
import visitor.*;

public sealed interface E extends Visitable.Root<E>{
  record X(String s) implements E,Visitable.Record<X,E>{
    public X accept(CloneVisitor v){return v.visitX(this);}
    public void accept(CollectorVisitor v) {v.visitX(this);}
    public Visitable<X> visitable(){return this;}
    }
  record L(Optional<T> t,List<X> xs, E e) implements E,Visitable.Record<L,E>{
    public L accept(CloneVisitor v){return v.visitL(this);}
    public void accept(CollectorVisitor v) {v.visitL(this);}
    public Visitable<L> visitable(){return this;}
    }
  record MCall(E receiver,X m,List<T> gensT,List<E>es) implements E,Visitable.Record<MCall,E>{
    public MCall accept(CloneVisitor v){return v.visitMCall(this);}
    public void accept(CollectorVisitor v) {v.visitMCall(this);}
    public Visitable<MCall> visitable(){return this;}
    }
  }