package ast;

import java.util.List;

import caching.*;
import op.*;
import visitor.*;

public sealed interface T extends Visitable.Root<T>{
  final class C implements Visitable.Record<C,C>{
    private final String s;
    public final String s(){ return s; }
    private final static Cache<String,C> cache=new Cache<>(C::new);
    private C(String s){ this.s=s; }
    public static C of(String s){ return cache.of(s); } 
    public C accept(CloneVisitor v){return v.visitC(this);}
    public void accept(CollectorVisitor v) {v.visitC(this);}
    public Visitable<C> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  final class CT implements T,Visitable.Record<T,T>{
    private final C c;
    private final List<T>ts;
    public final C c(){ return c; }
    public final List<T>ts(){ return ts; }
    private record Inner(C c, List<T>ts){}
    private final static Cache<Inner,CT> cache=new Cache<>(CT::new);
    private CT(Inner i){ c=i.c;ts=i.ts; }
    public static CT of(C c, List<T>ts){ return cache.of(new Inner(c,ts)); }
    public T accept(CloneVisitor v){return v.visitCT(this);}
    public void accept(CollectorVisitor v) {v.visitCT(this);}
    public Visitable<T> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  final class CX implements T,Visitable.Record<T,T>{
    private final String s;
    public final String s(){ return s; }
    private final static Cache<String,CX> cache=new Cache<>(CX::new);
    private CX(String s){ this.s=s; }
    public static CX of(String s){ return cache.of(s); } 
    public T accept(CloneVisitor v){return v.visitCX(this);}
    public void accept(CollectorVisitor v) {v.visitCX(this);}
    public Visitable<T> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }

  final class MX implements T,Visitable.Record<T,T>{
    private final String s;
    public final String s(){ return s; }
    private final static Cache<String,MX> cache=new Cache<>(MX::new);
    private MX(String s){ this.s=s; }
    public static MX of(String s){ return cache.of(s); } 
    public T accept(CloneVisitor v){return v.visitMX(this);}
    public void accept(CollectorVisitor v) {v.visitMX(this);}
    public Visitable<T> visitable(){return this;}
    public String toString() { return new ToSource().of(this); }
    }
  }