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
    Module Ty.
    Definition A := TyRef (Name "A") [:: ].
    End Ty.
    Module I.
    Definition A :Declaration:=
    Interface (Name "A") 0 [:: ] [::
      ].
    End I.
    Definition Prog:Program:=Decls[::A].
    RecordTheorems:={}.
    """
    );}
  @Test void test2(){ok("""
    I<AA>:{foo<F>(f : I<F>):I<AA>;}
    A<X1,X2>:I<X1>{
      m<X3>(i3:I<X3>, i1:I<X1>):I<X2> =
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
    Module Ty.
    Definition I(AA:TyRef):= TyRef(Name"I")[::AA].
    Definition A(X1 X2:TyRef):= TyRef(Name"A")[::X1; X2].
    End Ty.
    Module I.
    Definition I :Declaration:=Interface(Name"I")1[::][::
      AbstractMethod(
        MethodHeader 1 (Ty.I(ClassTyVar 0)) (Name "foo") [:: (Ty.I(MethodTyVar0)) ]
        )
      ].
    Definition A :Declaration:=Interface(Name"A")2
      [::(Ty.I (ClassTyVar 0))]
      [::
      DefaultMethod
        (MethodHeader 1(Ty.I(ClassTyVar 1))(Name "m") [::(Ty.I(MethodTyVar 0));(Ty.I(ClassTyVar 0))])
          (MethodCall(Var 0)(Name "foo")
            [::(Ty.A(ClassTyVar 0)(ClassTyVar 1))]
            [::(Lambda (Ty.I(Ty.I(ClassTyVar 1))) 1 (Var 0) )])
      ].
    End I.
    DefinitionProg:Program:=Decls[::I;A].
    RecordTheorems:={}.
    """);}
  @Test void test3(){ok("""  
    Void:{}
    F0<R>:{ apply():R; }
    F1<A,R>:{ apply(a:A):R; }
    F2<A,B,R>:{ apply(a:A,b:B):R ; }
    Tuple0:{dummy(x:Void):Void;}      
    Bool:{
      checkTrue:True;
      @Total
      and(other:Bool):Bool;
      @Total
      or(other:Bool):Bool;
      not:Bool;
      eq(other:Bool):Bool;
      match<T>(onTrue:F0<T>, onFalse:F0<T>):T;
      }
    False:Bool,Tuple0{
      checkTrue:True = this.checkTrue;
      and(other:Bool):Bool = this;
      or(other:Bool):Bool = other;
      not:Bool = True;
      eq(other:Bool):Bool = other.not;
      match<T>(onTrue:F0<T>, onFalse:F0<T>):T = onFalse.apply;
      }
    True:Bool,Tuple0{
      checkTrue:True = this;
      and(other:Bool):Bool = other;
      or(other:Bool):Bool = this;
      not:Bool = False;
      eq(other:Bool):Bool = other;
      match<T>(onTrue:F0<T>, onFalse:F0<T>):T = onTrue.apply;
      }
    """,null,null,null,"""
    Module Ty.
    Definition Void := TyRef (Name "Void") [::].
    Definition F0 (R: TyRef) := TyRef (Name "F0") [:: R ].
    Definition F1 (A R: TyRef) := TyRef (Name "F1") [:: A; R ].    
    Definition F2 (A B R: TyRef) := TyRef (Name "F2") [:: A; B; R ].
    Definition Tuple0 := TyRef (Name "Tuple0") [::].
    Definition Bool := TyRef (Name "Bool") [::].
    Definition False := TyRef (Name "False") [::].
    Definition True := TyRef (Name "True") [::].
    End Ty.
    Module I.
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
      [:: AbstractMethod (MethodHeader 0 Ty.Void (Name "dummy") [:: Ty.Void ]) ].
    Definition Bool: Declaration :=
      Interface (Name "Bool") 0 [::]
            [:: AbstractMethod (MethodHeader 0 Ty.True (Name "checkTrue") [::])
             ; AbstractMethod (MethodHeader 0 Ty.Bool (Name "and") [:: Ty.Bool])
             ; AbstractMethod (MethodHeader 0 Ty.Bool (Name "or") [:: Ty.Bool])
             ; AbstractMethod (MethodHeader 0 Ty.Bool (Name "not") [::])
             ; AbstractMethod (MethodHeader 0 Ty.Bool (Name "eq") [:: Ty.Bool])
             ; AbstractMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
               [:: (Ty.F0 (MethodTyVar 0)); (Ty.F0 (MethodTyVar 0)) ])
            ].
    Definition False: Declaration :=
      Interface (Name "False") 0 [:: Ty.Bool; Ty.Tuple0 ]
      [:: DefaultMethod (MethodHeader 0 Ty.True (Name "checkTrue") [::])
        (MethodCall (Var 0) (Name "checkTrue") [::] [::])
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "and") [:: Ty.Bool]) (Var 0)
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "or") [:: Ty.Bool]) (Var 1)
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "not") [::])
          (Lambda Ty.True 1 (Var 0))
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "eq") [:: Ty.Bool])
          (MethodCall (Var 1) (Name "not") [::] [::])
        ; DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
          [:: (Ty.F0 (MethodTyVar 0)); (Ty.F0 (MethodTyVar 0)) ])
          (MethodCall (Var 2) (Name "apply") [::] [::])
        ].
    Definition True: Declaration :=
      Interface (Name "True") 0 [:: Ty.Bool; Ty.Tuple0 ]
      [:: DefaultMethod (MethodHeader 0 Ty.True (Name "checkTrue") [::]) (Var 0)
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "and") [:: Ty.Bool]) (Var 1)
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "or") [:: Ty.Bool]) (Var 0)
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "not") [::])
            (Lambda Ty.False 1 (Var 0))
        ; DefaultMethod (MethodHeader 0 Ty.Bool (Name "eq") [:: Ty.Bool]) (Var 1)
        ; DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
            [:: (Ty.F0 (MethodTyVar 0)); (Ty.F0 (MethodTyVar 0)) ])
            (MethodCall (Var 1) (Name "apply") [::] [::])
            ].
    End I.
    DefinitionProg:Program:=Decls[::
      Void; F0; F1; F2; Tuple0; Bool; False; True
      ].
    RecordTheorems:={Bool_and:Terminates(Name"Bool")(Name"and");Bool_or:Terminates(Name"Bool")(Name"or");}.
    """);
    }
    
  }