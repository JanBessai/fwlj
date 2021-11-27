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
      Num:{ @total toZero:Num; succ:Succ=Succ[this];}
      Zero:Num{ dummy(x:Num):Num;  @total toZero:Num=this; }
      Succ:Num{
        pred:Num;
        @total induction(this,this.pred.toZero)
        toZero:Num=this.pred.toZero;
        @aux  |-n.toZero
        ___(n:Num):--=Succ[n].pred.toZero
        @aux  
        ___(n:Num):--=n.toZero
        }
      ""","""
      []
      """);}
  @Test void testToZeroExternal(){prove("""
      pr::=property|(ID:)?lemma
      Pr::=pr Xs (x:T)s =>e by induction? Hs
      H::= e | Xs (x:T)s =>e
      e::=...
      
      //what to do for induction on generic stuff T
      //List<T>
      Matrix<R>:{
        zero():R
        one():R
        add(a:R,b:R):R
        mul(a:R,b:R):R
        theorem <T>(m:Matrix<T>,t:T)=>m.add(m.zero(),t).eq(t).ct
          by induction(m)
        }
      Foo<T>:{
        
        }
      pre:theorem x:T,y:T => x.foo.imples(y.foo).ct
      imply:theorem a:Bool,b:Bool=> b.ct
        by a.implies(b).ct, a.ct
      theorem that:Z => that.bar.foo.ct
      by 
        pre(that.b,that.bar)//should generate the below or just accept it, and add pre to the reuired tree
        imply(that.b.foo,that.bar.foo)
        that.b.foo.ct
      
      lemma that:T = pre(that.b,that.bar)
        by
          a:Bool,b:Bool pre(a,b)
          that.b
          that.bar
        by 
        that.bar
        that.b
        //pre(that.b,that.bar)
        --that.b.foo.imples(that.bar.foo).ct //
        //imply(that.b.foo,that.bar.foo)
        --that.bar.foo.ct //
        that.b.foo.ct
      
      eqTotal:theorem n1:Num, n2:Num => n1.eq(n2)
      
      eqTotal:theorem n1:Num, n2:Num => n1.eq(n2)
      
      eqRefl:theorem n:Num =>n.eq(n).ct
        by induction n
      lemma =>Zero.eq(Zero).ct
      lemma n:Num=>Succ[n].eq(Succ[n]).ct
        by n.eq(n).ct
        
      sqr not a/b
      theorem a:Num,b:Num =>a.div(b).eq(SQR.of(2)).not.ct 
      
      forall s:Num =>s.times(s).eq(S[S[Z]]).not.ct
        by induction(s)
      lemma =>Zero.times(Zero).eq(2).not.ct
      lemma n:Num=>Succ[n].times(Succ[n]).eq(2).not.ct
        by n.times(n).eq(2).not.ct
      
      name:property X1..Xn, f1:T1..fk:Tk => a.foo(bar.baz.beer)
        by induction(f,A.m2(f.b)),
           Beer.of(f)
           <X1,X2>(x:N) |-x.beer by ...
        
        f.x()  
        A.m1(f.c).m2(f.b)
        A.m2(f.b)
      
      Beer.of(f) = f.c
      BeerFoo:{ f:Foo<Num> }
      BFF:{
        BeerFoo new(f:Foo<Num>)=
          F2<Any,BeerFoo>[x,y|y].of(
            Beer.of(f),
            BeerFoo[f]
            )
        BeerFoo new(f:Foo<Num>)=
          Let<Void,BeerFoo>[Beer.of(f)].of([x|
            BeerFoo[f]
            ])
        BeerFoo new(f:Foo<Num>)=
          F1<Any,F1<Any,BeerFoo>>.of(Beer.of(f)).of([x|
            BeerFoo[f]
            ])
          Assert.fact(Beer.of()).in(BeerFoo[f])
          Let.var(Beer.of()).in([x|BeerFoo[f]])
          Let
            .var(Beer.of())
            .in([x|Let.var(Beer.of2())
              .in([y|BeerFoo[f]])
              )
          pollock incompleteness
          Let var->Let1
          Let1 in, var->Let2
          Assert<BeerFoo>[BeerFoo[f]]
            .with(Beer.of(f))
          Beer.of(f) @ F1<Any,BeerFoo>>[x|BeerFoo[f]]
          
        }
      theorem (b:BeerFoo)=Beer.of(b.f)
      theorem (b:BeerFoo) = b.f.x
        by induction(b)
      lemma (f:Foo<Num>)=BeerFoo[f].f.x
        by Beer.of(f)
        
        by induction(f,A.m2(f.b)), Beer.of(f)
      f.x()  
      A.m1(f.c).m2(f.b)
      A.m2(f.b)
            
      
      Bar:Foo<Num>{  }
      
      theorem (n:Num)=>Zero.add(n).eq(n).ct
      MatrixNum:Matrix<Num>{
        zero():Num=Zero
        add(a:Num,b:Num):Num=a.add(b)
        lemma (t:Num)=>MatrixNum.add(MatrixNum.zero(),t).eq(t).ct
          //MatrixNum.add(Zero,t).eq(t).ct
          //Zero.add(t).eq(t).ct
          //t.eq(t).ct
          by numRefl
          
        }
      A:{toZero:B;}
      B:A{dummy toZero:B=this}
      C:A{pred:A toZero:B=this.pred.toZero}
      Prop:{
        
        }
      
      Num:{
        toZero:Zero;
          theorem (n:Num) => n.toZero by induction(n)
        succ:Succ=Succ[this];
        }      
      Zero:Num{
        dummy(x:Num):Num;
        toZero:Zero=this;
        }
      Succ:Num{
        pred:Num;
        toZero:Zero=this.pred.toZero;
        }
      Property:{dummy(x:Property):Property;
        @total  induction(n)
        toZeroTotal(n:Num):Zero =n.toZero;
        
        @aux 
        toZeroTotalZero():Zero = Zero.toZero;
        
        @aux |- n.toZero
        toZeroTotalSucc(n:Num):Zero =Succ[n].toZero;
        }
      theorem (n:Num) =>n.toZero by induction(n);
      lemma =>Zero.toZero;
      lemma (n:Num)=>Zero.toZero by n.toZero;
      ""","""
      []
      """);}
  //ideal above?
  /*
      Num:{
        toZero:Zero;
        succ:Succ=Succ[this];
        }
      NumProperties{
        @total n:Num,induction(n)|-n.toZero;         
        |-Zero.toZero;
        n:Num; n.toZero |- Succ[n].toZero;
        }
      ..  
   */
/*  @Test void testInductionWithAux(){prove("""
      Num:{
        @total toZero:Zero;
        @total succ:Succ=Succ[this]
        }
      Zero:Num{
        dummy(x:Num):Num;
        @total toZero:Zero=this;
        }
      Succ:Num{
        pred:Num;
        @total induction(this) ??
        toZero:Zero=this.pred.toZero;
        }
      Aux:{dummy(x:Aux):Aux;
        ????
        }
      ""","""
      []
      """);}
*/
  }
