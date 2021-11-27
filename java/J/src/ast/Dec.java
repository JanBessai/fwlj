package ast;

import java.util.*;

import ast.E.*;
import caching.*;
import op.*;
import visitor.*;

public final class Dec implements Visitable.Record<Dec,Dec>{
  private final T.C name;
  private final List<T.CX>gens;
  private final List<T.CT>supers;
  private final List<M>ms;
  public final T.C name(){ return name; }
  public final List<T.CX>gens(){ return gens; }
  public List<T.CT>supers(){ return supers; }
  public final List<M>ms(){ return ms; }
  private record Inner(T.C name,List<T.CX>gens,List<T.CT>supers,List<M>ms){}
  private Dec(Inner i){
    name=i.name;gens=i.gens;supers=i.supers;ms=i.ms; 
    var mmap=new HashMap<E.X,M>();
    for(M m:ms){ mmap.put(m.mH.m(), m); }
    map=Collections.unmodifiableMap(mmap);
    }    
  private final static Cache<Inner,Dec> cache=new Cache<>(Dec::new);
  public static Dec of(T.C name,List<T.CX>gens,List<T.CT>supers,List<M>ms){ return cache.of(new Inner(name,gens,supers,ms)); }    
  public Dec accept(CloneVisitor v){return v.visitDec(this);}
  public void accept(CollectorVisitor v) {v.visitDec(this);}
  public Visitable<Dec> visitable(){return this;}
  public String toString() { return new ToSource().of(this); }
  private final Map<E.X,M> map;
  public M get(E.X x){ return map.get(x); }
  
  public static final class M implements Visitable.Record<M,M>{
    private final MH mH;
    private final Optional<E>e;
    public final MH mH(){ return mH; }
    public final Optional<E>e(){ return e; }    
    private record Inner(MH mH,Optional<E>e){};
    private M(Inner i){ mH=i.mH;e=i.e; }    
    private final static Cache<Inner,M> cache=new Cache<>(M::new);
    public static M of(MH mH,Optional<E>e){ return cache.of(new Inner(mH,e)); }
    public M with(MH mH){ return cache.of(new Inner(mH,e)); }
    public M with(Optional<E>e){ return cache.of(new Inner(mH,e)); }
    public M accept(CloneVisitor v){return v.visitM(this);}
    public void accept(CollectorVisitor v) {v.visitM(this);}
    public Visitable<M> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  public static final class MH implements Visitable.Record<MH,MH>{
    private final Optional<S> s;
    private final List<T.MX> gens;
    private final T retType;
    private final E.X m;
    private final List<T>ts;
    private final List<E.X>xs;
    public final Optional<S> s() { return s; }
    public final List<T.MX> gens(){ return gens; }
    public final T retType() { return retType; }
    public final E.X m(){ return m; }
    public final List<T>ts(){ return ts; }
    public final List<E.X>xs(){ return xs; }    
    record Inner(Optional<S> s,List<T.MX> gens,T retType,E.X m,List<T>ts,List<E.X>xs){}
    private MH(Inner i){ s=i.s;gens=i.gens;retType=i.retType;m=i.m;ts=i.ts;xs=i.xs; }    
    private final static Cache<Inner,MH> cache=new Cache<>(MH::new);
    public static MH of(Optional<S> s,List<T.MX> gens,T retType,E.X m,List<T>ts,List<E.X>xs){ return cache.of(new Inner(s,gens,retType,m,ts,xs)); }
    public MH with(Optional<S> s){ return cache.of(new Inner(s,gens,retType,m,ts,xs)); }
    public MH accept(CloneVisitor v){return v.visitMH(this);}
    public void accept(CollectorVisitor v) {v.visitMH(this);}
    public Visitable<MH> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    public T get(E.X x){
      for(int i=0;i<xs.size();i++){ if(xs.get(i)==x) {return ts.get(i); }}
      throw new RuntimeException("parameter "+x+" undeclared in "+this);
      }
    }
  public static final class Inductive implements Visitable.Record<Inductive,Inductive>{
    private final X x;
    private final E e;
    public final X x(){ return x; }
    public final E e(){ return e; }
    private record Inner(X x,E e){}
    private Inductive(Inner i){ x=i.x;e=i.e; }    
    private final static Cache<Inner,Inductive> cache=new Cache<>(Inductive::new);
    public static Inductive of(X x, E e){ return cache.of(new Inner(x,e)); }
    public Inductive accept(CloneVisitor v){return v.visitInductive(this);}
    public void accept(CollectorVisitor v) {v.visitInductive(this);}
    public Visitable<Inductive> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  public static final class H implements Visitable.Record<H,H>{
    private final List<T.MX> xs;
    private final Map<E.X,T> g;
    private final E e;
    private final List<H> hs;
    public final List<T.MX> xs(){ return xs; }
    public final Map<E.X,T> g(){ return g; }
    public final E e(){ return e; }
    public final List<H> hs(){ return hs; }
    private record Inner(List<T.MX> xs,Map<E.X,T> g,E e,List<H>hs){}
    private H(Inner i){ xs=i.xs;g=i.g;e=i.e;hs=i.hs; }    
    private final static Cache<Inner,H> cache=new Cache<>(H::new);
    public static H of(List<T.MX> xs,Map<E.X,T> g,E e,List<H> hs){ return cache.of(new Inner(xs,g,e,hs)); }
    public H accept(CloneVisitor v){return v.visitH(this);}
    public void accept(CollectorVisitor v) {v.visitH(this);}
    public Visitable<H> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  public static final class S implements Visitable.Record<S,S>{
    private final boolean total;
    private final Optional<Inductive> inductive;
    private final List<H> hs;
    public final boolean total(){ return total; }
    public final Optional<Inductive> inductive(){ return inductive; }
    public final List<H> hs(){ return hs; }    
    private record Inner(boolean total, Optional<Inductive> inductive, List<H> hs){}
    private S(Inner i){ total=i.total;inductive=i.inductive;hs=i.hs; }    
    private final static Cache<Inner,S> cache=new Cache<>(S::new);
    public static S of(boolean total, Optional<Inductive> inductive, List<H> hs){ return cache.of(new Inner(total,inductive,hs)); }
    public S with(boolean total){ return cache.of(new Inner(total,inductive,hs)); }
    public S with(Optional<Inductive> inductive){ return cache.of(new Inner(total,inductive,hs)); }
    public S with(List<H> hs){ return cache.of(new Inner(total,inductive,hs)); }
    public S accept(CloneVisitor v){return v.visitS(this);}
    public void accept(CollectorVisitor v) {v.visitS(this);}
    public Visitable<S> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  }