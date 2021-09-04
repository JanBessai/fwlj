package ast;

import java.util.List;
import java.util.Optional;
import visitor.*;

public record Dec(T.C name,List<T.CX>gens,List<T>supers,List<M>ms)
  implements Visitable.Record<Dec,Dec>{
  public Dec accept(CloneVisitor v){return v.visitDec(this);}
  public void accept(CollectorVisitor v) {v.visitDec(this);}
  public Visitable<Dec> visitable(){return this;}
  
  public static record M(MH mH,Optional<E>e)implements Visitable.Record<M,M>{
    public M accept(CloneVisitor v){return v.visitM(this);}
    public void accept(CollectorVisitor v) {v.visitM(this);}
    public Visitable<M> visitable(){return this;}
    }
  public static record MH(S s,List<T.MX> gens,T retType,E.X m,List<T>ts,List<E.X>xs)
    implements Visitable.Record<MH,MH>{
    public MH accept(CloneVisitor v){return v.visitMH(this);}
    public void accept(CollectorVisitor v) {v.visitMH(this);}
    public Visitable<MH> visitable(){return this;}
    }
  public static record S(String s) implements Visitable.Record<S,S>{
    public S accept(CloneVisitor v){return v.visitS(this);}
    public void accept(CollectorVisitor v) {v.visitS(this);}
    public Visitable<S> visitable(){return this;}
    }
  }