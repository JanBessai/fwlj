package op;

import visitor.*;

public class AbstractToString implements CollectorVisitor{
  public String of(Visitable.Root<?> v){
    v.visitable().accept(this);
    return this.res.toString();
    }
  private StringBuilder res=new StringBuilder();
  protected void c(String s){res.append(s);}
  }
