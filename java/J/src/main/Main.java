package main;

import java.nio.file.*;
import ast.*;
import op.*;

public class Main {
  public static void main(String[]a){    
    //var l=new JLexer(CharStreams.fromString(s));
    //var t = new CommonTokenStream(l);
    //var p=new JParser(t);
    //Program pp=new ParserVisitor().visitProg(p.prog());
    Program p=new parser.JParser().program(Path.of("Dummy.txt"),s);
    var res=new ToSource().of(p);
    System.out.println(res);    
    }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


  static String s="""
      Void:{}
      F0<R>:{ R apply() }
      F1<A,R>:{ R apply(A a) }
      F2<A,B,R>:{ R apply(A a,B b) }
      Tuple0:{Void dummy(Void x)}      
      Bool:{
        True checkTrue
        Bool and(Bool other)
        Bool or(Bool other)
        Bool not
        Bool eq(Bool other)
        <T> T match(F0<T> onTrue,F0<T> onFalse)
        }
      False:Bool{
        True checkTrue = this.checkTrue
        Bool and(Bool other) = this
        Bool or(Bool other) = other
        Bool not = True
        Bool eq(Bool other) = other.not
        <T> T match(F0<T> onTrue,F0<T> onFalse) = onFalse.apply
        }
      True:Bool{
        True checkTrue = this
        Bool and(Bool other) = other
        Bool or(Bool other) = this
        Bool not = False
        Bool eq(Bool other) = other
        <T> T match(F0<T> onTrue,F0<T> onFalse) = onTrue.apply
        }
      Num:{
        Num pred
        @Total
        Num succ = S[this]
        @Total
        Num add(Num other)
        @Total
        Bool isZero
        @Total
        Bool eq(Num other)
        }
      Z:Num,Tuple0{
        Num pred = this.pred
        Num add(Num other) = other
        Bool isZero = True
        Bool eq(Num other) = other.isZero        
        }
      S:Num{
        Num add(Num other) = this.pred.add(other).succ
        Bool isZero = False
        Bool eq(Num other) = other.isZero.match(
          [False]
          [this.pred.eq(other.pred)]
          )
        }
      Union2<A,B>:{
        A toA = this.toA
        B toB = this.toB
        }
      Union2A<A,B>:Union2<A,B>{ A toA }
      Union2B<A,B>:Union2<A,B>{ B toB }
      Selector2<A,B>:{ Union2<A,B> new(A a, B b) }
      Tuple2<A,B>:{
        A _1 = this.toUnion( [a,b|FromA<A,B>[a]] ).toA
        B _2 = this.toUnion( [a,b|FromB<A,B>[b]] ).toA
        Union2<A,B> toUnion(Selector2<A,B> s)
        }
      Tuples:Tuple0{
        <A,B> Tuple2<A,B> of(A a,B b) = [new(a,b)]
        }
      List<T>:Tuple0{
        <R> R match(F0<R> onEmpty,F1<Cons<T>,R> onCons) = onEmpty.apply
        Bool isEmpty = True
        Cons<T> push(T e) = [new(e,this)]
        <R> List<R> map(F1<T,R> f) = []
        }
      Cons<T>:Tuple2{
        Void dummy(Void x) = x
        <R> R match(F0<R> onEmpty,F1<Cons<T>,R> onCons) = onCons.apply(this)
        Bool isEmpty = False
        <R> List<R> map(F1<T,R> f) = 
          this._2.map(f).push(f.apply(this._1)) 
        }  
      Properties:Tuple0{
        @Total
        True addAssociative(Num a, Num b, Num c) =
          a.add(b.add(c)).eq(a.add(b).add(c)).checkTrue
        }
      nope
      """;
  }