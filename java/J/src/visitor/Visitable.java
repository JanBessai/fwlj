package visitor;
public interface Visitable<K>{
  K accept(CloneVisitor v);
  void accept(CollectorVisitor v);
  public interface Root<K>{ Visitable<? extends K> visitable(); }
  public interface Record<K,KK> extends Visitable<K>, Root<KK>{}
  }