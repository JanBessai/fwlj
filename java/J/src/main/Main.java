package main;

import java.nio.file.*;
import java.util.function.*;

import ast.*;
import op.*;

public class Main {
  public static void main(String[]a){    
    Program p=new parser.JParser().program(Path.of("Dummy.txt"),s);
    //var res=new ToSource().of(p);
    //System.out.println(res);
    var resJ=new ToJava().of(p);
    System.out.println(resJ);
    var resCoq=new ToCoq().of(p);
    System.out.println(resCoq);    
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  static String s="""
      Void:{}
      F0<R>:{ R apply(); }
      F1<A,R>:{ R apply(A a); }
      F2<A,B,R>:{ R apply(A a,B b); }
      Tuple0:{Void dummy(Void x);}      
      Bool:{
        True checkTrue;
        Bool and(Bool other);
        Bool or(Bool other);
        Bool not;
        Bool eq(Bool other);
        <T> T match(F0<T> onTrue,F0<T> onFalse);
        }
      False:Bool,Tuple0{
        True checkTrue = this.checkTrue;
        Bool and(Bool other) = this;
        Bool or(Bool other) = other;
        Bool not = True;
        Bool eq(Bool other) = other.not;
        <T> T match(F0<T> onTrue,F0<T> onFalse) = onFalse.apply;
        }
      True:Bool,Tuple0{
        True checkTrue = this;
        Bool and(Bool other) = other;
        Bool or(Bool other) = this;
        Bool not = False;
        Bool eq(Bool other) = other;
        <T> T match(F0<T> onTrue,F0<T> onFalse) = onTrue.apply;
        }
      Num:{
        Num pred;
        @Total
        Num succ = S[this]; //Zero, Succ[Num]
        @Total
        Num add(Num other);
        @Total
        Bool isZero;
        @Total
        Bool eq(Num other);
        }
      Z:Num,Tuple0{
        Num pred = this.pred;
        Num add(Num other) = other;
        Bool isZero = True;
        Bool eq(Num other) = other.isZero;        
        }
      S:Num{
        Num add(Num other) = this.pred.add(other).succ;
        Bool isZero = False;
        Bool eq(Num other) = other.isZero.match(
          [False]
          [this.pred.eq(other.pred)]
          );
        }
      Fix<A,R>:{ F1<A,R> mesh(Fix<A,R> cog); }
      DoFix:Tuple0 {//Does this works?  DoFix.of([self|[arg|body]]) //sugar? [self|arg|body]
        F1<A,R> of<A,R>(F1<F1<A,R>,F1<A,R>> fun) =
          F1<Cog<A,R>,F1<A,R>>[cog|cog.apply(cog)]
          .apply(cogF->fun.apply(arg->cogF.apply(cogF).apply(arg)));
        }//@Total on a method need to generate proofs for all of the heirs
        
      A:Tuple0{
        Person safe(String name,Num age)=(
          Void u1=CheckString.of(name)
          Void u2=CheckAge.of(age)
          Person[of(name,age)]
          )//refinement types

        Foo make(A a,B b)=(
          C c=a.foo(b)
          Foo[x->c.beer(x,a,b)]
          )
        Foo make(A a,B b)=
          F1<C,Foo>[c|Foo[x|c.beer(x,a,b)]]
          .apply(a.foo(b))
        -->
          a.foo(b) ->
          Foo[x|a.foo(b).beer(x,a,b)]

Terminate N1 N2-->
explore program, forall types subtype of N1 if the method N2 is implemented, prove
explore program, forall lambdas subtype of N1, if the implemented method is N2, prove ctx,L

        x:Foo
        f.m(LL):LL
          
        // a:A,b:B,c:C ->Foo[x|c.beer(x,a,b)]
        // a:A,b:B,c:C & a.foo(b) ->Foo[x->c.beer(x,a,b)]
        // a:A,b:B,c:C & c=a.foo(b)  & c=b.foo(a) ->Foo[x->c.beer(x,a,b)]
        // a:A,b:B & a.foo(b) ->Foo[x->a.foo(b).beer(x,a,b)]
        }
        
      Union2<A,B>:{
        A toA = this.toA;
        B toB = this.toB;
        }
      Union2A<A,B>:Union2<A,B>{ A toA; }
      Union2B<A,B>:Union2<A,B>{ B toB; }
      Selector2<A,B>:{ Union2<A,B> new(A a, B b); }
      Tuple2<A,B>:{
        A _1 = this.toUnion( [a,b|Union2A<A,B>[a]] ).toA;
        B _2 = this.toUnion( [a,b|Union2B<A,B>[b]] ).toB;
        Union2<A,B> toUnion(Selector2<A,B> s);
        }
      Tuples:Tuple0{
        <A,B> Tuple2<A,B> of(A a,B b) = [new(a,b)];
        }
      List<T>:Tuple0{
        <R> R match(F0<R> onEmpty,F1<Cons<T>,R> onCons) = onEmpty.apply;
        Bool isEmpty = True;
        Cons<T> push(T e) = [new(e,this)];
        <R> List<R> map(F1<T,R> f) = [];
        }
      Cons<T>:List<T>,Tuple2<T,List<T>>{
        Void dummy(Void x) = x;
        <R> R match(F0<R> onEmpty,F1<Cons<T>,R> onCons) = onCons.apply(this);
        Bool isEmpty = False;
        <R> List<R> map(F1<T,R> f) = 
          this._2.map(f).push(f.apply(this._1)); 
        }  
      Properties:Tuple0{
        @Total
        True addAssociative(Num a, Num b, Num c) =
          a.add(b.add(c)).eq(a.add(b).add(c)).checkTrue;
        }
      Let<T>:{
        T val;
        <R> R in(F1<T,R> f) = f.apply(this.val);
        }
      UseLet:Tuple0{
        Num res(Num a,Num b) = 
          Let<Num>[a.add(b)].in<Num>([tmp1|
          Let<Num>[tmp1.add(tmp1)].in<Num>([tmp2|
          tmp2.add(tmp1)])]);
        //Num tmp1=a.add(b)
        //Num tmp2=tmp1.add(tmp1)
        //tmp2.add(tmp1)
        }
      GNode:{
        List<GNode> edges;
        Num label;
        }
      //ENode:GNode{ List<GNode> edges = List<GNode> }
      NNode:GNode,Tuple2<List<GNode>,Num>{
        List<GNode> edges = this._1;
        Num label = this._2;
        }
      SelfNode:GNode{ List<GNode> edges = NNode[of(List<GNode>.push(this),num24)] }
      //  SelfNode[myNum]
      //NNode[of(myList,myNum)]
      nope
      """;
  }