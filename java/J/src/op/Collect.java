package op;

import java.util.*;

import ast.*;
import visitor.*;

public abstract class Collect<K> implements CollectorVisitor{
  private List<K> cs;
  protected void add(K k){cs.add(k);}
  public List<K> collect(Visitable.Root<?> v){
    cs=new ArrayList<>();
    v.visitable().accept(this);
    return Collections.unmodifiableList(cs);    
    }
  public static class AllC extends Collect<T.C> {
    @Override public void visitC(T.C c){add(c);}}
  public static class AllX extends Collect<E.X> {
    @Override public void visitX(E.X x){add(x);}}
  }
