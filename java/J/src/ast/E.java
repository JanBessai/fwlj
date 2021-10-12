package ast;

import java.util.*;

import caching.*;
import op.*;
import visitor.*;

public sealed interface E extends Visitable.Root<E>{
  final class X implements E,Visitable.Record<X,E> {
    private final String s;
    public final String s(){ return s; }
    private X(String s){this.s=s;}
    private final static Cache<String,X> cache=new Cache<>(X::new);
    public static X of(String s){ return cache.of(s); }
    public X accept(CloneVisitor v){return v.visitX(this);}
    public void accept(CollectorVisitor v) {v.visitX(this);}
    public Visitable<X> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    public static final X thisX=X.of("this");
  }
  final class L implements E,Visitable.Record<L,E>{
    private final Optional<T> t;
    private final List<X> xs;
    private final E e;
    public final Optional<T> t(){ return t; }
    public final List<X> xs(){ return xs; }
    public final E e(){ return e; }
    private record Inner(Optional<T> t, List<X> xs, E e){}
    private L(Inner i){t=i.t;xs=i.xs;e=i.e;}    
    private final static Cache<Inner,L> cache=new Cache<>(L::new);
    public static L of(Optional<T> t, List<X> xs, E e){ return cache.of(new Inner(t,xs,e)); }
    public L accept(CloneVisitor v){return v.visitL(this);}
    public void accept(CollectorVisitor v) {v.visitL(this);}
    public Visitable<L> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  
  final class MCall implements E,Visitable.Record<MCall,E>{
    private final E receiver;
    private final X m;
    private final List<T> gensT;
    private final List<E>es;
    public final E receiver(){ return receiver; }
    public final X m(){return m; }
    public final List<T> gensT(){ return gensT; }
    public final List<E>es(){ return es; }
    private record Inner(E receiver,X m,List<T> gensT,List<E>es){}
    private MCall(Inner i){ receiver=i.receiver;m=i.m;gensT=i.gensT;es=i.es; }    
    private final static Cache<Inner,MCall> cache=new Cache<>(MCall::new);
    public static MCall of(E receiver,X m,List<T> gensT,List<E>es){ return cache.of(new Inner(receiver,m,gensT,es)); }
    public MCall accept(CloneVisitor v){return v.visitMCall(this);}
    public void accept(CollectorVisitor v) {v.visitMCall(this);}
    public Visitable<MCall> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  }