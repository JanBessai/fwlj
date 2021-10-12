package ast;

import java.util.*;
import caching.*;
import op.*;
import visitor.*;

public final class Program implements Visitable.Record<Program,Program>{
  private final List<Dec>decs;
  public final List<Dec>decs(){ return decs; }
  private Program(List<Dec>decs){this.decs=decs;}
  private final static Cache<List<Dec>,Program> cache=new Cache<>(Program::new);
  public static Program of(List<Dec>decs){ return cache.of(decs); }  
  public Program accept(CloneVisitor v){return v.visitProgram(this);}
  public void accept(CollectorVisitor v){v.visitProgram(this);}
  public Visitable<Program> visitable(){return this;}
  public String toString() { return new ToSource().of(this); }
  }