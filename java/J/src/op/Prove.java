package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import visitor.*;

public class Prove {
  Program p;
  Prove(Program p){ this.p=p; }
  List<String>errors=new ArrayList<>();
  public List<String> of(){
    for(var d:p.decs()){ for(var m:d.ms()){ proveOpen(d,m); } }
    if(!errors.isEmpty()){ return errors; }
    for(var d:p.decs()){ for(var m:d.ms()){ proveClose(d,m); } }
    return errors;
  }
  public Optional<Dec.S> sOf(Dec d,Dec.M m){
    return m.mH().s();//TODO: need to also explore supertypes
  }
  public void proveOpen(Dec d,Dec.M m){ 
    m.e().ifPresent(e->sOf(d,m).ifPresent(s->proveOpen(d,m,s))); 
    }
  public <K> K normGen(Visitable<K> v){
    return v.accept(new CloneVisitor(){
      @Override public T visitCX(T.CX cx){return T.MX.of(cx.s()); }
      });
    }
  public void proveOpen(Dec d,Dec.M m, Dec.S s){
    var g=new LinkedHashMap<E.X,T>();
    IntStream.range(0, m.mH().xs().size()).forEach(i->{
      g.put(m.mH().xs().get(i), normGen(m.mH().ts().get(i).visitable()));
      });
    var s1=d.gens().stream().map(x->T.MX.of(x.s()));
    var s2=m.mH().gens().stream();
    List<T.MX> mxs=Stream.concat(s1,s2).toList();
    var e=normGen(m.e().get().visitable());
    s=Termination.expandHs(normGen(s));
    String msg=new Termination(p,d,s,mxs).valid(e);
    if(!msg.isEmpty()){ errors.add(msg); }
    }
  public void proveClose(Dec d,Dec.M m){
    m.e().ifPresent(e->sOf(d,m).ifPresent(s->{ if(s.total()){ proveClose(d,m,s); } })); 
    }
  public void proveClose(Dec d,Dec.M m,Dec.S s){ 
    
    }
  }
