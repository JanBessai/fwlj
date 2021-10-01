package main;
interface Void{}
interface F0<R>{R apply();}
interface F1<A, R>{R apply(A a);}
interface F2<A, B, R>{R apply(A a, B b);}
interface Tuple0{Void dummy(Void x);}
interface Bool{
  True checkTrue();
  Bool and(Bool other);
  Bool or(Bool other);
  Bool not();
  Bool eq(Bool other);
  <T> T match(F0<T> onTrue, F0<T> onFalse);
  }
interface False extends Bool, Tuple0{
  default True checkTrue(){ return this.checkTrue(); }
  default Bool and(Bool other){ return this; }
  default Bool or(Bool other){ return other; }
  default Bool not(){ return ((True)(u0)->u0); }
  default Bool eq(Bool other){ return other.not(); }
  default <T> T match(F0<T> onTrue, F0<T> onFalse){ return onFalse.apply(); }
  }
interface True extends Bool, Tuple0{
  default True checkTrue(){ return this; }
default   Bool and(Bool other){
  return other;
  }
default   Bool or(Bool other){
  return this;
  }
default   Bool not(){
  return ((False)(u1)->u1);
  }
default   Bool eq(Bool other){
  return other;
  }
default   <T> T match(F0<T> onTrue, F0<T> onFalse){
  return onTrue.apply();
  }
}
interface Num{
Num pred();
default   //@Total
Num succ(){
  return ((S)()->this);
  }
//@Total
Num add(Num other);
//@Total
Bool isZero();
//@Total
Bool eq(Num other);
}
interface Z extends Num, Tuple0{
default   Num pred(){
  return this.pred();
  }
default   Num add(Num other){
  return other;
  }
default   Bool isZero(){
  return ((True)(u2)->u2);
  }
default   Bool eq(Num other){
  return other.isZero();
  }
}
interface S extends Num{
default   Num add(Num other){
  return this.pred().add(other).succ();
  }
default   Bool isZero(){
  return ((False)(u3)->u3);
  }
default   Bool eq(Num other){
  return other.isZero().match(()->((False)(u4)->u4), ()->this.pred().eq(other.pred()));
  }
}
interface Union2<A, B>{
default   A toA(){
  return this.toA();
  }
default   B toB(){
  return this.toB();
  }
}
interface Union2A<A, B> extends Union2<A, B>{
A toA();
}
interface Union2B<A, B> extends Union2<A, B>{
B toB();
}
interface Selector2<A, B>{
Union2<A, B> _new(A a, B b);
}
interface Tuple2<A, B>{
default   A _1(){
  return this.toUnion((a, b)->((Union2A<A, B>)()->a)).toA();
  }
default   B _2(){
  return this.toUnion((a, b)->((Union2B<A, B>)()->b)).toB();
  }
Union2<A, B> toUnion(Selector2<A, B> s);
}
interface Tuples extends Tuple0{
default   <A, B> Tuple2<A, B> of(A a, B b){
  return (u5)->u5._new(a, b);
  }
}
interface List<T> extends Tuple0{
default   <R> R match(F0<R> onEmpty, F1<Cons<T>, R> onCons){
  return onEmpty.apply();
  }
default   Bool isEmpty(){
  return ((True)(u6)->u6);
  }
default   Cons<T> push(T e){
  return (u7)->u7._new(e, this);
  }
default   <R> List<R> map(F1<T, R> f){
  return (u8)->u8;
  }
}
interface Cons<T> extends List<T>, Tuple2<T, List<T>>{
default   Void dummy(Void x){
  return x;
  }
default   <R> R match(F0<R> onEmpty, F1<Cons<T>, R> onCons){
  return onCons.apply(this);
  }
default   Bool isEmpty(){
  return ((False)(u9)->u9);
  }
default   <R> List<R> map(F1<T, R> f){
  return this._2().map(f).push(f.apply(this._1()));
  }
}
interface Properties extends Tuple0{
default   //@Total
True addAssociative(Num a, Num b, Num c){
  return a.add(b.add(c)).eq(a.add(b).add(c)).checkTrue();
  }
}
interface Let<T>{
T val();
default   <R> R in(F1<T, R> f){
  return f.apply(this.val());
  }
}
interface UseLet extends Tuple0{
default   Num res(Num a, Num b){
  return ((Let<Num>)()->a.add(b)).<Num>in((tmp1)->((Let<Num>)()->tmp1.add(tmp1)).<Num>in((tmp2)->tmp2.add(tmp1)));
  }
}
public class MainOut{
public static void main(String[]a){

  }
}
