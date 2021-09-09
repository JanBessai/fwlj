From mathcomp Require Import all_ssreflect.
Require Import FLGJ.
Require Import Names.
Require Import String.
Import StringSyntax.

Definition Void: Declaration :=
  Interface (Name "Void") 0 [::] [::].
Definition VoidTy := (TyRef (Name "Void") [::]).

Definition F0: Declaration :=
  Interface (Name "F0") 1 [::]
            [:: AbstractMethod (MethodHeader 0 (ClassTyVar 0) (Name "apply") [::]) ].
Definition F0Ty (R: Ty) := (TyRef (Name "F0") [:: R ]).

Definition F1: Declaration :=
  Interface (Name "F1") 2 [::]
            [:: AbstractMethod (MethodHeader 0 (ClassTyVar 1) (Name "apply") [:: ClassTyVar 0]) ].
Definition F1Ty (A R: Ty) := (TyRef (Name "F0") [:: A; R ]).

Definition F2: Declaration :=
  Interface (Name "F2") 3 [::]
            [:: AbstractMethod (MethodHeader 0 (ClassTyVar 2) (Name "apply")
                                            [:: ClassTyVar 0; ClassTyVar 1]) ].
Definition F2Ty (A B R: Ty) := (TyRef (Name "F0") [:: A; B; R ]).

Definition Tuple0: Declaration :=
  Interface (Name "Tuple0") 0 [::]
            [:: AbstractMethod (MethodHeader 0 VoidTy (Name "dummy") [:: VoidTy ]) ].
Definition Typle0Ty := TyRef (Name "Tuple0") [::].

Definition BoolTy := TyRef (Name "Bool") [::].
Definition TrueTy := TyRef (Name "True") [::].
Definition FalseTy := TyRef (Name "False") [::].

Definition Bool: Declaration :=
  Interface (Name "Bool") 0 [::]
            [:: AbstractMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "not") [::])
             ; AbstractMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy])
             ; AbstractMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
                                            [:: F0Ty (MethodTyVar 0); F0Ty (MethodTyVar 0) ])
            ].

Definition IFalse: Declaration :=
  Interface (Name "False") 0 [:: BoolTy; Typle0Ty ]
            [:: (DefaultMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::])
                              (MethodCall (Var 0) (Name "checkTrue") [::] [::]))
             ; DefaultMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy]) (Var 0)
             ; DefaultMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy]) (Var 1)
             ; (DefaultMethod (MethodHeader 0 BoolTy (Name "not") [::])
                              (Lambda TrueTy 1 (Var 1)))
             ; (DefaultMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy])
                              (MethodCall (Var 1) (Name "not") [::] [::]))
             ; (DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
                                            [:: F0Ty (MethodTyVar 0); F0Ty (MethodTyVar 0) ])
                              (MethodCall (Var 2) (Name "apply") [::] [::]))
            ].

Definition ITrue: Declaration :=
  Interface (Name "True") 0 [:: BoolTy; Typle0Ty ]
            [:: DefaultMethod (MethodHeader 0 TrueTy (Name "checkTrue") [::]) (Var 0)
             ; DefaultMethod (MethodHeader 0 BoolTy (Name "and") [:: BoolTy]) (Var 1)
             ; DefaultMethod (MethodHeader 0 BoolTy (Name "or") [:: BoolTy]) (Var 0)
             ; (DefaultMethod (MethodHeader 0 BoolTy (Name "not") [::])
                              (Lambda FalseTy 1 (Var 1)))
             ; DefaultMethod (MethodHeader 0 BoolTy (Name "eq") [:: BoolTy]) (Var 0)
             ; (DefaultMethod (MethodHeader 1 (MethodTyVar 0) (Name "match")
                                            [:: F0Ty (MethodTyVar 0); F0Ty (MethodTyVar 0) ])
                              (MethodCall (Var 1) (Name "apply") [::] [::]))
            ].

Definition MainOut: Program :=
  Decls
    [:: Void
     ; Tuple0
     ; F0
     ; F1
     ; F2
     ; Bool
     ; IFalse
     ; ITrue
     ].
