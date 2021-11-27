package op;

import java.util.*;
import java.util.stream.*;

import ast.*;
import ast.Dec.*;
import ast.T.*;
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
    for(var h:toProve){ proveCloseSolve(h); }
    return errors;
  }
  private void proveCloseSolve(Dec.H h){
    // TODO Auto-generated method stub    
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
    proveWFSubtypingSConsistent(d,m);  
    //TODO: there is much more WF to check
    }
  public void proveWFSubtypingSConsistent(Dec d,Dec.M m){    
    //-forall the m implemented by d.m, if they are total m must be total,
    //if they are aux, m must be total or aux
    for(var cti:d.supers()){
      Dec di=p.get(cti.c());
      assert di!=null;
      Dec.M mi=di.get(m.mH().m());
      if(mi==null){ continue; }
      mi.mH().s().ifPresent(s->proveWFSubtypingS(d.name(),di.name(),s,m.mH()));
      }
    }
  public void proveWFSubtypingS(T.C name, T.C namei, Dec.S si,Dec.MH mh){
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
  private List<Dec.H> toProve=new ArrayList<>();
  public void proveClose(Dec d,Dec.M m){
    m.e().ifPresent(e->m.mH().s().ifPresent(s->{ if(s.total()){ proveCloseAdd(d,m,s); } }));
    }
  public void proveCloseAdd(Dec d,Dec.M m,Dec.S s){ 
    assert s.total();
    s.inductive().ifPresent(i->proveCloseAddInductive(d,m,i));
    for(var h:s.hs()) { toProve.add(h); }
    }
  HashMap<T.CT,List<H>> iCases=new HashMap<>();
  private List<H> makeICase(T.CT ct){
    List<H> res=new ArrayList<>();
    for(var d: p.decs()){
      for(var m:d.ms()){
        if(m.e().isEmpty()){ break; }
        new ICase(d,m,ct,res).of();
        }
      }
    return res;
    }  
  private void proveCloseAddInductive(Dec d, M m, Inductive i) {
    var ct=(T.CT)m.mH().get(i.x());
    iCases.computeIfAbsent(ct,this::makeICase);
    // TODO Auto-generated method stub
    //take the type of the induction var
    //examine the program for all of the cases of that type
    //What if it is generic? throw todo for now?
    //for each case, generate the ...
    //@total n:Num,induction(n,n.toZero)|-n.toZero;         
    //|-Zero.toZero;
    //n:Num; n.toZero |- Succ[n].toZero;
    }
  }
