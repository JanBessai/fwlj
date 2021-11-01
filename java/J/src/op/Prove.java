package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import visitor.*;

public class Prove {
  Program p;
  public Prove(Program p){ this.p=p; }
  List<String>errors=new ArrayList<>();
  public List<String> of(){
    for(var d:p.decs()){ for(var m:d.ms()){ proveWF(d,m);   } }
    for(var d:p.decs()){ for(var m:d.ms()){ proveOpen(d,m); } }
    if(!errors.isEmpty()){ return errors; }
    for(var d:p.decs()){ for(var m:d.ms()){ proveClose(d,m); } }
    return errors;
  }
  public void proveOpen(Dec d,Dec.M m){ 
    m.e().ifPresent(e->m.mH().s().ifPresent(s->proveOpen(d,m,s))); 
    }
  public <K> K normGen(Visitable<K> v){
    return v.accept(new CloneVisitor(){
      @Override public T visitCX(T.CX cx){return T.MX.of(cx.s()); }
      });
    }
  public void proveWF(Dec d,Dec.M m){
    //TODO: there is much more WF to check
    //-forall the m implemented by d.m, if they are total m must be total,
    //if they are aux, m must be total or aux
    for(var cti:d.supers()){
      Dec di=p.get(cti.c());
      assert di!=null;
      Dec.M mi=di.get(m.mH().m());
      if(mi==null){ continue; }
      mi.mH().s().ifPresent(s->proveWF(d.name(),di.name(),s,m.mH()));
      }
    }
  public void proveWF(T.C name, T.C namei, Dec.S si,Dec.MH mh){
    if(mh.s().isEmpty()){
      errors.add("Method "+name+"."+mh.m()+" has no specification, but inherits from method "
        +namei+"."+mh.m()+", that specifies "+si);
      return;
      }
    var s=mh.s().get();
    if(s.total() && !s.total()){
      errors.add("Method "+name+"."+mh.m()+" has no total specification, but inherits from method "
          +namei+"."+mh.m()+", that specifies "+si);
      }
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
    m.e().ifPresent(e->m.mH().s().ifPresent(s->{ if(s.total()){ proveClose(d,m,s); } })); 
    }
  public void proveClose(Dec d,Dec.M m,Dec.S s){ 
    
    }
  }
