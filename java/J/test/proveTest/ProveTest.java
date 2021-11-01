package proveTest;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;

import ast.Program;
import op.Prove;

public class ProveTest {
  public static void prove(String in, String errs){
    Program p=new parser.JParser().program(Path.of("Dummy.txt"),in);
    var res=new Prove(p).of();
    assertEquals(res.toString()+"\n",errs);
    }
  @Test void testNothing(){prove("""
    A:{ a:A=this; }
    ""","""
    []
    """);}
  @Test void testTermThis(){prove("""
      A:{ 
        @total
        a:A=this;
        }
      ""","""
      []
      """);}
  @Test void testTermSimpleFail(){prove("""
      A:{ 
        @total
        a:A=this.a;
        }
      ""","""
      [[Stucked on this.a]]
      """);}
  @Test void testTermSimplePassAss(){prove("""
      A:{ 
        @total |-this.b
        a:A=this.b;
        @total
        b:A=this;
        }
      ""","""
      []
      """);}
  @Test void testTermFailPropagation(){prove("""
      Num:{
        @total 
        toZero:Num;
        }
      Zero:Num{
        dummy(x:Num):Num;
        @total
        toZero:Num=this;
        }
      Succ:Num{
        pred:Num;
        toZero:Num=this.pred.toZero;
        }
      ""","""
      [Method Succ.toZero has no specification, but inherits from method Num.toZero, that specifies total]
      """);}

  @Test void testTermPropagationOk(){prove("""
      Num:{
        @total 
        toZero:Num;
        }
      Zero:Num{
        dummy(x:Num):Num;
        @total
        toZero:Num=this;
        }
      Succ:Num{
        pred:Num;
        @total
        toZero:Num=this.pred.toZero;
        }
      ""","""
      [[Stucked on this.pred.toZero]]
      """);}

  @Test void testInduction(){prove("""
      Num:{ @total toZero:Num; }
      Zero:Num{ dummy(x:Num):Num;  @total toZero:Num=this; }
      Succ:Num{
        pred:Num;
        @total induction(this, this.pred.toZero)
        toZero:Num=this.pred.toZero;
        }
      ""","""
      []
      """);}
  @Test void testInductionShort(){prove("""
      Num:{ @total toZero:Num; }
      Zero:Num{ dummy(x:Num):Num;  @total toZero:Num=this; }
      Succ:Num{
        pred:Num;
        @total induction(this)
        toZero:Num=this.pred.toZero;
        }
      ""","""
      []
      """);}

  }
