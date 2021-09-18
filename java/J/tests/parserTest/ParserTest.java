package parserTest;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.*;

import org.junit.jupiter.api.*;

import ast.*;
import op.*;

class ParserTest {
  
 public static String trim(String s){
   return s.replace(" ","").replace("\n","");
   }
 public static void ok(String in,String toString, String toSource,String toJava, String toCoq){
   Program p=new parser.JParser().program(
     Path.of("Dummy.txt"),
     in+"\n Foo[x|x]"
     );
   String actualToString=p.toString();
   String actualToSource=new ToSource().of(p);
   String actualToJava=new ToJava("MainOut").of(p);
   String actualToCoq=new ToCoq().of(p);
   if(toString!=null){ assertEquals("Program[decs=["+trim(toString)+"]",
     trim(actualToString)); }
   if(toSource!=null){ assertEquals(trim(toSource)+"Foo",trim(actualToSource)); }
   if(toJava!=null){ assertEquals(trim(toJava)+
   "publicclassMainOut{publicstaticvoidmain(String[]a){((Foo)(x)->x);}}"
   ,trim(actualToJava)); }
   if(toCoq!=null){ assertEquals(trim("""
     From mathcomp Require Import all_ssreflect.
     Require Import FLGJ.
     Require Import Names.
     Require Import String.
     Import StringSyntax.
     """+toCoq),
     trim(actualToCoq)
     ); }
   }
  @Test void test1(){ok("""
    A:{}
    ""","""
    Dec[name=C[s=A], gens=[], supers=[], ms=[]]], main=L[t=Optional[CT[c=C[s=Foo], ts=[]]], xs=[X[s=x]], e=X[s=x]]
    ""","""
    A:{}
    ""","""
    interface A{}
    ""","""
    Definition ATy := TyRef (Name "A") [:: ].
    Definition A :Declaration:=
    Interface (Name "A") 0 [:: ] [::
      ].
    """
    );}
  @Test void test2(){ok("""
    I<AA>:{I<AA> foo<F>(I<F> f);}
    A<X1,X2>:I<X1>{
      I<X2> m<X3>(I<X3> i3, I<X1> i1) =
        this.foo<A<X1,X2>>(I<I<X2>>);
      }
    ""","""
    Dec[name=C[s=I],gens=[CX[s=AA]],supers=[],ms=[
      M[mH=MH[
        s=S[s=],
        gens=[MX[s=F]],
        retType=CT[c=C[s=I],ts=[CX[s=AA]]],
        m=X[s=foo],
        ts=[ CT[ c=C[s=I],ts=[MX[s=F]] ] ],
        xs=[X[s=f]]],
        e=Optional.empty
        ]]],
      Dec[name=C[s=A],gens=[CX[s=X1],CX[s=X2]],supers=[
        CT[c=C[s=I],ts=[CX[s=X1]]]
        ],ms=[
        M[mH=
          MH[s=S[s=],gens=[MX[s=X3]],retType=CT[c=C[s=I],ts=[CX[s=X2]]],
          m=X[s=m],
          ts=[CT[c=C[s=I],ts=[MX[s=X3]]],CT[c=C[s=I],ts=[CX[s=X1]]]],
          xs=[X[s=i3],X[s=i1]]],
          e=Optional[MCall[
            receiver=X[s=this],
            m=X[s=foo],
            gensT=[CT[c=C[s=A],ts=[CX[s=X1],CX[s=X2]]]],
            es=[L[t=Optional[CT[c=C[s=I],ts=[CT[c=C[s=I],ts=[CX[s=X2]]]]]],xs=[X[s=u0]],e=X[s=u0]]]]]
          ]
        ]]],
    main=L[t=Optional[CT[c=C[s=Foo],ts=[]]],xs=[X[s=x]],e=X[s=x]]
    ""","""
    I<AA>:{
      I<AA>foo<F>(I<F>f);
      }
    A<X1,X2>:I<X1>{
      I<X2> m<X3>(I<X3>i3,I<X1>i1) = 
        this.foo<A<X1,X2>>(I<I<X2>>);
        }
    ""","""
    interface I<AA>{
      <F> I<AA> foo(I<F>f);
      }
    interface A<X1,X2>extends I<X1>{
      default <X3> I<X2> m(I<X3>i3,I<X1>i1){
        return this.<A<X1,X2>>foo( ((I<I<X2>>)(u0)->u0));
        }
      }
    ""","""
    Definition ITy(AA:Ty):= TyRef(Name"I")[::AA].
    Definition ATy(X1 X2:Ty):= TyRef(Name"A")[::X1; X2].
    Definition I :Declaration:=Interface(Name"I")1[::][::
      AbstractMethod(
        MethodHeader 1 (ITy(ClassTyVar 0)) (Name "foo") [:: (ITy(MethodTyVar0)) ]
        )
      ].
    Definition A :Declaration:=Interface(Name"A")2
      [::(ITy (ClassTyVar 0))]
      [::
      DefaultMethod
        (MethodHeader 1(ITy(ClassTyVar 1))(Name "m") [::(ITy(MethodTyVar 0));(ITy(ClassTyVar 0))])
          (MethodCall(Var 0)(Name "foo")
            [::(ATy(ClassTyVar 0)(ClassTyVar 1))]
            [::(Lambda (ITy(ITy(ClassTyVar 1))) 1 (Var 0) )])
      ].
    """);}
  @Test void test3(){ok("""  
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
      T match<T>(F0<T> onTrue, F0<T> onFalse);
      }
    False:Bool,Tuple0{
      True checkTrue = this.checkTrue;
      Bool and(Bool other) = this;
      Bool or(Bool other) = other;
      Bool not = True;
      Bool eq(Bool other) = other.not;
      T match<T>(F0<T> onTrue,F0<T> onFalse) = onFalse.apply;
      }
    True:Bool,Tuple0{
      True checkTrue = this;
      Bool and(Bool other) = other;
      Bool or(Bool other) = this;
      Bool not = False;
      Bool eq(Bool other) = other;
      T match<T>(F0<T> onTrue,F0<T> onFalse) = onTrue.apply;
      }
    """,null,null,null,"""
    Definition VoidTy := TyRef (Name "Void") [::].
    Definition F0Ty (R: Ty) := TyRef (Name "F0") [:: R ].
    Definition F1Ty (A R: Ty) := TyRef (Name "F1") [:: A; R ].    
    Definition F2Ty (A B R: Ty) := TyRef (Name "F2") [:: A; B; R ].
    Definition Tuple0Ty := TyRef (Name "Tuple0") [::].
    Definition BoolTy := TyRef (Name "Bool") [::].
    Definition FalseTy := TyRef (Name "False") [::].
    Definition TrueTy := TyRef (Name "True") [::].

    Definition Void: Declaration :=
      Interface (Name "Void") 0 [::] [::].   
    Definition F0: Declaration :=
      Interface (Name "F0") 1 [::]
      [:: AbstractMethod (MethodHeader 0 (ClassTyVar 0) (Name "apply") [::]) ].
    Definition F1: Declaration :=
      Interface (Name "F1") 2 [::]
        [:: AbstractMethod (MethodHeader 0 (ClassTyVar 1) (Name "apply") [:: (ClassTyVar 0)]) ].
    Definition F2: Declaration :=
      Interface (Name "F2") 3 [::]
      [:: AbstractMethod (MethodHeader 0 (ClassTyVar 2) (Name "apply")
        [:: (ClassTyVar 0); (ClassTyVar 1)]
        )].
    Definition Tuple0: Declaration :=
    Interface (Name "Tuple0") 0 [::]
      [:: AbstractMethod (MethodHeader 0 VoidTy (Name "dummy") [:: VoidTy ]) ].
    Definition Bool: Declaration :=
      Interface (Name "Bool") 0 [::]
            [:: AbstractMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "not") [::])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy])
             ; AbstractMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
               [:: (F0Ty (MethodTyVar 0)); (F0Ty (MethodTyVar 0)) ])
            ].
    Definition False: Declaration :=
      Interface (Name "False") 0 [:: BoolTy; Tuple0Ty ]
      [:: DefaultMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::])
        (MethodCall (Var 0) (Name "checkTrue") [::] [::])
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy]) (Var 0)
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy]) (Var 1)
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "not") [::])
          (Lambda TrueTy 1 (Var 0))
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy])
          (MethodCall (Var 1) (Name "not") [::] [::])
        ; DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
          [:: (F0Ty (MethodTyVar 0)); (F0Ty (MethodTyVar 0)) ])
          (MethodCall (Var 2) (Name "apply") [::] [::])
        ].
    Definition True: Declaration :=
      Interface (Name "True") 0 [:: BoolTy; Tuple0Ty ]
      [:: DefaultMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::]) (Var 0)
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy]) (Var 1)
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy]) (Var 0)
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "not") [::])
            (Lambda FalseTy 1 (Var 0))
        ; DefaultMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy]) (Var 1)
        ; DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
            [:: (F0Ty (MethodTyVar 0)); (F0Ty (MethodTyVar 0)) ])
            (MethodCall (Var 1) (Name "apply") [::] [::])
            ].
    """);
    }
    
  }