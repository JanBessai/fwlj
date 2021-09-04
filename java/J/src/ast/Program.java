package ast;

import java.util.*;

import visitor.*;

public record Program(List<Dec>decs,E main) implements Visitable.Record<Program,Program>{
  public Program accept(CloneVisitor v){return v.visitProgram(this);}
  public void accept(CollectorVisitor v){v.visitProgram(this);}
  public Visitable<Program> visitable(){return this;}
  }