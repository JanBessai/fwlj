package op;

import java.util.*;

import ast.*;
import ast.Dec.*;
import visitor.*;

public record ICase(Dec d,M m,T.CT ct,List<H> acc) implements CollectorVisitor{
  public void of(){ m.e().get().visitable().accept(this); }
  //look to lambda terms
  //then, look inside by saving the visible variables
  //do we need an extra map x->t?
}
