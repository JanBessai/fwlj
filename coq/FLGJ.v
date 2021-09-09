From mathcomp Require Import all_ssreflect.
Set Bullet Behavior "Strict Subproofs".
Import EqNotations.
Require Import Relations.Relation_Operators.
Require Import Relations.Operators_Properties.
Require Import Coq.Arith.Wf_nat.

Require Import Names.

Definition IName: countType := UserIdent_countType.
Definition MName: countType := UserIdent_countType.

(* Standard elimination scheme is not enough cause of nested inductive type seq.
   Will manually recover it later, when \in is available with eqType instance. *)
Unset Elimination Schemes.
Inductive Ty : Type :=
| TyRef : IName -> seq Ty -> Ty
| ClassTyVar : nat -> Ty
| MethodTyVar : nat -> Ty.

Inductive Expression : Type :=
| Var: nat -> Expression
| MethodCall: Expression -> MName -> seq Expression -> Expression
| Lambda: Ty -> nat -> Expression -> Expression.
Set Elimination Schemes.

Inductive Signature : Type :=
| MethodHeader: nat -> Ty -> MName -> seq Ty -> Signature.

Inductive MethodDeclaration: Type :=
| AbstractMethod: Signature -> MethodDeclaration
| DefaultMethod: Signature -> Expression -> MethodDeclaration.

Inductive Declaration : Type :=
| Interface: IName -> nat -> seq Ty -> seq MethodDeclaration -> Declaration.

Inductive Program : Type :=
| Decls: seq Declaration -> Program.

Inductive Value : Type :=
| VLambda : Ty -> nat -> Expression -> Value.


Section MathcompInstances.

  Fixpoint Ty2Tree (t: Ty): GenTree.tree (IName + nat) :=
    match t with
    | TyRef i tys => GenTree.Node 0 [:: GenTree.Leaf (inl i) & map Ty2Tree tys ]
    | ClassTyVar n => GenTree.Node 1 [:: GenTree.Leaf (inr n) ]
    | MethodTyVar n => GenTree.Node 2 [:: GenTree.Leaf (inr n) ]
    end.

  Fixpoint Tree2Ty (t:  GenTree.tree (IName + nat)): option Ty :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl i) & ts ] => Some (TyRef i (pmap Tree2Ty ts))
    | GenTree.Node 1 [:: GenTree.Leaf (inr n) ] => Some (ClassTyVar n)
    | GenTree.Node 2 [:: GenTree.Leaf (inr n) ] => Some (MethodTyVar n)
    | _ => None
    end.

  Lemma pcan_Ty2Tree: pcancel Ty2Tree Tree2Ty.
  Proof.
    rewrite /pcancel.
    fix ih 1.
    case.
    - move => i /=.
      elim; [ done | ].
      move => arg args ih_args /=.
      rewrite (ih arg) /=.
      set (ins := fun x => match x with | Some (TyRef i args) => Some (TyRef i [:: arg & args]) | _ => None end).
      rewrite -/(ins (Some (TyRef i args))) -/(ins (Some (TyRef i (pmap Tree2Ty (map Ty2Tree args))))).
        by rewrite ih_args.
    - move => n /=.
        by constructor.
    - move => n /=.
        by constructor.
  Qed.

  Definition Ty_eqMixin := PcanEqMixin pcan_Ty2Tree.
  Canonical Ty_eqType := EqType Ty Ty_eqMixin.
  Definition Ty_choiceMixin := PcanChoiceMixin pcan_Ty2Tree.
  Canonical Ty_choiceType := ChoiceType Ty Ty_choiceMixin.
  Definition Ty_countMixin := PcanCountMixin pcan_Ty2Tree.
  Canonical Ty_countType := CountType Ty Ty_countMixin.

  Fixpoint Expression2Tree (e: Expression): GenTree.tree (nat + seq Ty + MName) :=
    match e with
    | Var n => GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))]
    | MethodCall o m args => GenTree.Node 1 [:: Expression2Tree o, GenTree.Leaf (inr m) & map Expression2Tree args]
    | Lambda i n e => GenTree.Node 2 [:: GenTree.Leaf (inl (inr [:: i])); GenTree.Leaf (inl (inl n)); Expression2Tree e]
    end.

  Fixpoint Tree2Expression (t: GenTree.tree (nat + seq Ty + MName)): option Expression :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))] => Some (Var n)
    | GenTree.Node 1 [:: ot, GenTree.Leaf (inr m) & args] =>
      if Tree2Expression ot is Some o
      then Some (MethodCall o m (pmap Tree2Expression args))
      else None
    | GenTree.Node 2 [:: GenTree.Leaf (inl (inr [:: i])); GenTree.Leaf (inl (inl n)); et] =>
      if Tree2Expression et is Some e then Some (Lambda i n e) else None

    | _ => None
    end.

  Lemma pcan_Expression2Tree: pcancel Expression2Tree Tree2Expression.
  Proof.
    rewrite /pcancel.
    fix ih 1.
    case.
    - move => n /=.
        by exact: (refl_equal (Some (Var n))).
    - move => e m args /=.
      rewrite (ih e).
      apply: f_equal.
      apply: f_equal.
      elim: args; [ done | ].
      move => arg args ih'.
        by rewrite /= ih ih'.
    - move => i n e /=.
        by rewrite (ih e).
  Qed.

  Definition Expression_eqMixin := PcanEqMixin pcan_Expression2Tree.
  Canonical Expression_eqType := EqType Expression Expression_eqMixin.
  Definition Expression_choiceMixin := PcanChoiceMixin pcan_Expression2Tree.
  Canonical Expression_choiceType := ChoiceType Expression Expression_choiceMixin.
  Definition Expression_countMixin := PcanCountMixin pcan_Expression2Tree.
  Canonical Expression_countType := CountType Expression Expression_countMixin. 

  Definition Signature2Tree (s: Signature): GenTree.tree (nat + Ty + MName + seq Ty) :=
    match s with
    | MethodHeader n r m s =>
      GenTree.Node 0 [:: GenTree.Leaf (inl (inl (inl n)));
                     GenTree.Leaf (inl (inl (inr r)));
                     GenTree.Leaf (inl (inr m));
                     GenTree.Leaf (inr s)]
    end.

  Definition Tree2Signature (t: GenTree.tree (nat + Ty + MName + seq Ty)): option Signature :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl (inl n)));
                     GenTree.Leaf (inl (inl (inr r)));
                     GenTree.Leaf (inl (inr m));
                     GenTree.Leaf (inr s)] =>
      Some (MethodHeader n r m s)
    | _ => None
    end.

  Lemma pcan_Signature2Tree: pcancel Signature2Tree Tree2Signature.
  Proof.
      by case.
  Qed.

  Definition Signature_eqMixin := PcanEqMixin pcan_Signature2Tree.
  Canonical Signature_eqType := EqType Signature Signature_eqMixin.
  Definition Signature_choiceMixin := PcanChoiceMixin pcan_Signature2Tree.
  Canonical Signature_choiceType := ChoiceType Signature Signature_choiceMixin.
  Definition Signature_countMixin := PcanCountMixin pcan_Signature2Tree.
  Canonical Signature_countType := CountType Signature Signature_countMixin.

  Definition MethodDeclaration2Tree (decl: MethodDeclaration): GenTree.tree (Signature + Expression) :=
    match decl with
    | AbstractMethod s => GenTree.Node 0 [:: GenTree.Leaf (inl s) ]
    | DefaultMethod s e => GenTree.Node 1 [:: GenTree.Leaf (inl s); GenTree.Leaf (inr e) ]
    end.

  Definition Tree2MethodDeclaration (t: GenTree.tree (Signature + Expression)): option MethodDeclaration :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl s) ] => Some (AbstractMethod s)
    | GenTree.Node 1 [:: GenTree.Leaf (inl s); GenTree.Leaf (inr e) ] => Some (DefaultMethod s e)
    | _ => None
    end.

  Lemma pcan_MethodDeclaration2Tree: pcancel MethodDeclaration2Tree Tree2MethodDeclaration.
  Proof.
      by case.
  Qed.

  Definition MethodDeclaration_eqMixin := PcanEqMixin pcan_MethodDeclaration2Tree.
  Canonical MethodDeclaration_eqType := EqType MethodDeclaration MethodDeclaration_eqMixin.
  Definition MethodDeclaration_choiceMixin := PcanChoiceMixin pcan_MethodDeclaration2Tree.
  Canonical MethodDeclaration_choiceType := ChoiceType MethodDeclaration MethodDeclaration_choiceMixin.
  Definition MethodDeclaration_countMixin := PcanCountMixin pcan_MethodDeclaration2Tree.
  Canonical MethodDeclaration_countType := CountType MethodDeclaration MethodDeclaration_countMixin.

  Definition Declaration2Tree (d: Declaration): GenTree.tree (IName + nat + seq Ty + seq MethodDeclaration) :=
    match d with
    | Interface i n ps ms =>
      GenTree.Node 0 [:: GenTree.Leaf (inl (inl (inl i)));
                     GenTree.Leaf (inl (inl (inr n)));
                     GenTree.Leaf (inl (inr ps));
                     GenTree.Leaf (inr ms)]
    end.

  Definition Tree2Declaration (t: GenTree.tree (IName + nat + seq Ty + seq MethodDeclaration)): option Declaration :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl (inl i)));
                     GenTree.Leaf (inl (inl (inr n)));
                     GenTree.Leaf (inl (inr ps));
                     GenTree.Leaf (inr ms)]  =>
      Some (Interface i n ps ms)
    | _ => None
    end.

  Lemma pcan_Declaration2Tree: pcancel Declaration2Tree Tree2Declaration.
  Proof.
      by case.
  Qed.

  Definition Declaration_eqMixin := PcanEqMixin pcan_Declaration2Tree.
  Canonical Declaration_eqType := EqType Declaration Declaration_eqMixin.
  Definition Declaration_choiceMixin := PcanChoiceMixin pcan_Declaration2Tree.
  Canonical Declaration_choiceType := ChoiceType Declaration Declaration_choiceMixin.
  Definition Declaration_countMixin := PcanCountMixin pcan_Declaration2Tree.
  Canonical Declaration_countType := CountType Declaration Declaration_countMixin.

  Definition Program2Tree (p: Program): GenTree.tree (seq Declaration) :=
    match p with
    | Decls decls => GenTree.Node 0 [:: GenTree.Leaf decls]
    end.

  Definition Tree2Program (t: GenTree.tree (seq Declaration)): option Program :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf decls] => Some (Decls decls)
    | _ => None
    end.

  Lemma pcan_Program2Tree: pcancel Program2Tree Tree2Program.
  Proof.
      by case.
  Qed.

  Definition Program_eqMixin := PcanEqMixin pcan_Program2Tree.
  Canonical Program_eqType := EqType Program Program_eqMixin.
  Definition Program_choiceMixin := PcanChoiceMixin pcan_Program2Tree.
  Canonical Program_choiceType := ChoiceType Program Program_choiceMixin.
  Definition Program_countMixin := PcanCountMixin pcan_Program2Tree.
  Canonical Program_countType := CountType Program Program_countMixin.

  Definition Value2Tree (p: Value): GenTree.tree (Ty + nat + Expression) :=
    match p with
    | VLambda i n e => GenTree.Node 0 [:: GenTree.Leaf (inl (inl i)); GenTree.Leaf (inl (inr n)); GenTree.Leaf (inr e)]
    end.

  Definition Tree2Value (t: GenTree.tree (Ty + nat + Expression)): option Value :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl i)); GenTree.Leaf (inl (inr n));  GenTree.Leaf (inr e)] => Some (VLambda i n e)
    | _ => None
    end.

  Lemma pcan_Value2Tree: pcancel Value2Tree Tree2Value.
  Proof.
      by case.
  Qed.

  Definition Value_eqMixin := PcanEqMixin pcan_Value2Tree.
  Canonical Value_eqType := EqType Value Value_eqMixin.
  Definition Value_choiceMixin := PcanChoiceMixin pcan_Value2Tree.
  Canonical Value_choiceType := ChoiceType Value Value_choiceMixin.
  Definition Value_countMixin := PcanCountMixin pcan_Value2Tree.
  Canonical Value_countType := CountType Value Value_countMixin.
End MathcompInstances.

Section RecursiveEliminationSchemes.
  Fixpoint Ty_rect (P : Ty -> Type)
           (Ref_case: forall (i : IName) (args : seq Ty), (forall arg, arg \in args -> P arg) -> P (TyRef i args))
           (ClassTyVar_case: forall n : nat, P (ClassTyVar n))
           (MethodTyVar_case: forall n : nat, P (MethodTyVar n))
           (ty : Ty): P ty :=
    match ty with
    | TyRef i args =>
      Ref_case i args ((fix arg_rec args arg :=
                          match args as args return arg \in args -> P arg with
                          | [::] => fun inprf => False_rect _ (not_false_is_true inprf)
                          | [:: arg' & args] =>
                            fun inprf =>
                              match arg == arg' as r return r || (arg \in args) -> (r = (arg' == arg)) -> P arg  with
                              | true => fun here eq => rew [P] (eqP (rew eq in here)) in
                                           Ty_rect P Ref_case ClassTyVar_case MethodTyVar_case arg'
                              | false => fun there _ => arg_rec args arg there
                              end inprf (eq_sym _ _)
                          end) args)
    | ClassTyVar n => ClassTyVar_case n
    | MethodTyVar n => MethodTyVar_case n
    end.

  Definition Ty_rec: forall (P : Ty -> Set)
                       (Ref_case: forall (i : IName) (args : seq Ty), (forall arg, arg \in args -> P arg) -> P (TyRef i args))
                       (ClassTyVar_case: forall n : nat, P (ClassTyVar n))
                       (MethodTyVar_case: forall n : nat, P (MethodTyVar n))
                       (ty : Ty), P ty := Ty_rect.

  Definition Ty_ind: forall (P : Ty -> Prop)
                       (Ref_case: forall (i : IName) (args : seq Ty), (forall arg, arg \in args -> P arg) -> P (TyRef i args))
                       (ClassTyVar_case: forall n : nat, P (ClassTyVar n))
                       (MethodTyVar_case: forall n : nat, P (MethodTyVar n))
                       (ty : Ty), P ty := Ty_rect.

  Fixpoint ty_size (ty: Ty): nat :=
    match ty with
    | TyRef _ args => 1 + (sumn (map ty_size args))
    | _ => 1
    end.

  Definition Ty_size_rect (P : Ty -> Type)
             (caseLT: forall ty, (forall ty', ty_size ty' < ty_size ty -> P ty') -> P ty)
             (ty : Ty): P ty :=
    induction_ltof2 Ty ty_size P
                    (fun ty ih => caseLT ty (fun ty' prf => ih ty' (elimT ltP prf))) ty.

  Definition Ty_size_rec: forall (P : Ty -> Set)
             (caseLT: forall ty, (forall ty', ty_size ty' < ty_size ty -> P ty') -> P ty)
             (ty : Ty), P ty := Ty_size_rect.

  Definition Ty_size_ind: forall (P : Ty -> Prop)
             (caseLT: forall ty, (forall ty', ty_size ty' < ty_size ty -> P ty') -> P ty)
             (ty : Ty), P ty := Ty_size_rect.

  Fixpoint Expression_rect (P: Expression -> Type)
           (Var_case: forall n, P (Var n))
           (MethodCall_case: forall e m args, P e -> (forall arg, arg \in args -> P arg) -> P (MethodCall e m args))
           (Lambda_case: forall i n e, P e -> P (Lambda i n e))
           (e: Expression): P e :=
    match e with
    | Var n => Var_case n
    | MethodCall e m args =>
      MethodCall_case e m args
                      (Expression_rect P Var_case MethodCall_case Lambda_case e)
                      ((fix arg_rec args arg :=
                          match args as args return arg \in args -> P arg with
                          | [::] => fun inprf => False_rect _ (not_false_is_true inprf)
                          | [:: arg' & args] =>
                            fun inprf =>
                              match arg == arg' as r return r || (arg \in args) -> (r = (arg' == arg)) -> P arg  with
                              | true => fun here eq => rew [P] (eqP (rew eq in here)) in
                                           Expression_rect P Var_case MethodCall_case Lambda_case arg'
                              | false => fun there _ => arg_rec args arg there
                              end inprf (eq_sym _ _)
                          end) args)
    | Lambda i n e => Lambda_case i n e (Expression_rect P Var_case MethodCall_case Lambda_case e)
    end.

  Definition Expression_ind: forall (P: Expression -> Prop)
           (Var_case: forall n, P (Var n))
           (MethodCall_case: forall e m args, P e -> (forall arg, arg \in args -> P arg) -> P (MethodCall e m args))
           (Lambda_case: forall i n e, P e -> P (Lambda i n e))
           (e: Expression), P e := Expression_rect.

  Definition Expression_rec: forall (P: Expression -> Set)
           (Var_case: forall n, P (Var n))
           (MethodCall_case: forall e m args, P e -> (forall arg, arg \in args -> P arg) -> P (MethodCall e m args))
           (Lambda_case: forall i n e, P e -> P (Lambda i n e))
           (e: Expression), P e := Expression_rect.

  Fixpoint exp_size (e: Expression): nat :=
    match e with
    | Var n => 1
    | MethodCall e m args => 1 + exp_size e + (sumn (map exp_size args))
    | Lambda i n e => 1 + exp_size e
    end.

  Definition Expression_size_rect (P : Expression -> Type)
             (caseLT: forall e, (forall e', exp_size e' < exp_size e -> P e') -> P e)
             (e : Expression): P e :=
    induction_ltof2 Expression exp_size P
                    (fun e ih => caseLT e (fun e' prf => ih e' (elimT ltP prf))) e.

  Definition Expression_size_rec: forall (P : Expression -> Set)
             (caseLT: forall e, (forall e', exp_size e' < exp_size e -> P e') -> P e)
             (e : Expression), P e := Expression_size_rect.

  Definition Expression_size_ind: forall (P : Expression -> Prop)
             (caseLT: forall e, (forall e', exp_size e' < exp_size e -> P e') -> P e)
             (e : Expression), P e := Expression_size_rect.

  Definition arity (sig: Signature): nat :=
    match sig with
    | MethodHeader _ _ _ args => size args
    end.

  Definition Signature_arity_rect (P : Signature -> Type)
           (Method_case: forall (sig: Signature), (forall sig', arity sig' < arity sig -> P sig') -> P sig)
           (sig: Signature): P sig :=
    induction_ltof2 Signature arity P
                    (fun sig ih => Method_case sig (fun sig' prf => ih sig' (elimT ltP prf))) sig.

  Definition Signature_param_rec: forall (P : Signature -> Set)
           (Method_case: forall (sig: Signature), (forall sig', arity sig' < arity sig -> P sig') -> P sig)
           (sig: Signature), P sig := Signature_arity_rect.

  Definition Signature_param_ind: forall (P : Signature -> Prop)
           (Method_case: forall (sig: Signature), (forall sig', arity sig' < arity sig -> P sig') -> P sig)
           (sig: Signature), P sig := Signature_arity_rect.

  Definition generic_arity (sig: Signature): nat :=
    match sig with
    | MethodHeader n _ _ _ => n
    end.

  Definition Signature_generic_arity_rect (P : Signature -> Type)
           (Method_case: forall (sig: Signature), (forall sig', generic_arity sig' < generic_arity sig -> P sig') -> P sig)
           (sig: Signature): P sig :=
    induction_ltof2 Signature generic_arity P
                    (fun sig ih => Method_case sig (fun sig' prf => ih sig' (elimT ltP prf))) sig.

  Definition Signature_generic_arity_rec: forall (P : Signature -> Set)
           (Method_case: forall (sig: Signature), (forall sig', generic_arity sig' < generic_arity sig -> P sig') -> P sig)
           (sig: Signature), P sig := Signature_generic_arity_rect.

  Definition Signature_generic_arity_ind: forall (P : Signature -> Prop)
           (Method_case: forall (sig: Signature), (forall sig', generic_arity sig' < generic_arity sig -> P sig') -> P sig)
           (sig: Signature), P sig := Signature_generic_arity_rect.
End RecursiveEliminationSchemes.

(* exp is the hole of the context *)
Inductive EvalCtx (exp: Expression): Type :=
| EvalCallReceiver : MName -> seq Expression -> EvalCtx exp
| EvalCallArg : Value -> MName -> seq Value -> seq Expression -> EvalCtx exp.

Definition TypeCtx : Type := seq Ty.

Definition typeof (v: Value) : Ty :=
  match v with | VLambda i _ _ => i end.

Definition iname (ty: Ty): option IName :=
  match ty with
  | TyRef i _ => Some i
  | _ => None
  end.

Definition i_generic_arity (decl: Declaration): nat :=
  match decl with | Interface _ n _ _ => n end.

Definition domain (p: Program): seq IName :=
  match p with
  | Decls decls => map (fun d => match d with Interface i _ _ _ => i end) decls
  end.

Definition decls (p: Program): seq Declaration :=
  match p with | Decls decls => decls end.

Definition mdecls (i: Declaration): seq MethodDeclaration :=
  match i with | Interface _ _ _ mdecls => mdecls end.

Definition name (decl: Declaration): IName :=
  match decl with | Interface i _ _ _ => i end.

Definition parents (decl: Declaration): seq Ty :=
  match decl with | Interface _ _ pis _ => pis end.

Definition mname (mdecl: MethodDeclaration): MName :=
  match mdecl with
  | AbstractMethod (MethodHeader _ _ m _) => m
  | DefaultMethod (MethodHeader _ _ m _) _ => m
  end.

Definition signatures (i: Declaration): seq Signature :=
  map (fun mdecl => match mdecl with
                 | AbstractMethod sig => sig
                 | DefaultMethod sig _ => sig
                 end) (mdecls i).

Fixpoint substitute (classTyArgs: seq Ty) (methodTyArgs: seq Ty) (ty: Ty): Ty :=
  match ty with
  | TyRef i args => TyRef i (map (substitute classTyArgs methodTyArgs) args)
  | ClassTyVar n => nth (ClassTyVar n) classTyArgs n
  | MethodTyVar n => nth (MethodTyVar n) classTyArgs n
  end.

Inductive SubtypeStep (p: Program): Ty -> Ty -> Prop :=
| SubtypeStep_Parent:
    forall i pis ibody pi ppis pibody iargs piargs,
      ((Interface i (size iargs) pis ibody) \in (decls p)) ->
      ((Interface pi (size piargs) ppis pibody) \in (decls p)) ->
      ((TyRef pi piargs) \in pis) ->
      SubtypeStep p (TyRef i iargs) (TyRef pi (map (substitute iargs [::]) piargs)).

Definition Subtype (p: Program): Ty -> Ty -> Prop := clos_refl_trans Ty (SubtypeStep p).

Section SubtypeProperties.

  Definition SubtypeStep_inv {p: Program} {ty ty': Ty} (st: SubtypeStep p ty ty') :=
    let diag ty ty' :=
        match ty with
        | TyRef i iargs =>
          forall (X: Program -> IName -> seq Ty -> Ty -> Prop),
            (forall pis ibody pi ppis pibody piargs,
                ((Interface i (size iargs) pis ibody) \in (decls p)) ->
                ((Interface pi (size piargs) ppis pibody) \in (decls p)) ->
                ((TyRef pi piargs) \in pis) ->
                X p i iargs (TyRef pi (map (substitute iargs [::]) piargs))) ->
            X p i iargs ty'
        | _ => False
        end in
    match st in SubtypeStep _ ty ty' return diag ty ty' with
    | SubtypeStep_Parent i pis ibody pi ppis pibody iargs piargs iprf piprf pi_in_pis =>
      fun X k => k pis ibody pi ppis pibody piargs iprf piprf pi_in_pis
    end.

  Inductive InheritanceChain (p: Program): seq IName -> Prop :=
  | InheritanceChain_start: forall i, InheritanceChain p [:: i]
  | InheritanceChain_step:
      forall i n pis ibody pi args ppis,
        ((Interface i n pis ibody) \in (decls p)) ->
        ((TyRef pi args) \in pis) ->
        InheritanceChain p [:: pi & ppis] ->
        InheritanceChain p [:: i, pi & ppis].

  Definition InheritanceChain_inv {p: Program} {chain: seq IName} (ic: InheritanceChain p chain) :=
    let diag chain :=
        match chain with
        | [:: i] =>
          forall (X: Program -> IName -> Prop), X p i -> X p i
        | [:: i, pi & chain'] =>
          forall (X: Program -> IName -> IName -> seq IName -> Prop),
            (forall n pis ibody args ppis,
                ((Interface i n pis ibody) \in (decls p)) ->
                ((TyRef pi args) \in pis) ->
                InheritanceChain p [:: pi & ppis] ->
                X p i pi ppis) ->
            X p i pi chain'
        | _ => False
        end in
    match ic in InheritanceChain _ chain return diag chain with
    | InheritanceChain_start i => fun X k => k
    | InheritanceChain_step i n pis ibody pi args ppis inprf pi_in_pis piprf =>
      fun X k => k n pis ibody args ppis inprf pi_in_pis piprf
    end.

  Lemma Subtype_InheritanceChain: forall p i args ty',
      Subtype p (TyRef i args) ty' ->
      exists chain,
        iname (TyRef i args) = ohead chain /\
        iname ty' = ohead (rev chain) /\
        InheritanceChain p chain.
  Proof.
    move => p i args ty' /(clos_rt_rt1n _ _ _ _).
    set (P ty ty' :=
           match ty with
           | TyRef i args =>
             exists chain,
               iname (TyRef i args) = ohead chain /\
               iname ty' = ohead (rev chain) /\
               InheritanceChain p chain
           | _ => True
           end).
    rewrite -/(P (TyRef i args) ty').
    elim.
    - case => //.
      move: i args => _ _ i args.
      exists [:: i].
      do 2 (split => //=).
        by constructor.
    - move: i args ty' => _ _ _ ty pty ppty /SubtypeStep_inv.
      case: ty => // i iargs inv.
      apply inv.
      move => pis ibody pi ppis pibody piargs iprf piprf pi_in_pis trans [] chain [] head_eq [] last_eq is_chain.
      exists [:: i & chain].
      do 2 (split => //=).
      + rewrite last_eq.
        move: head_eq.
        clear...
        rewrite (rev_cat [:: i]).
        move: i [:: i] => _.
        move: pi.
        elim: chain => //= pi chain ih pi' chain' pieq.
        move: ih.
        case: chain => // ppi chain ih.
        rewrite (rev_cat [:: pi]) -catA.
        rewrite -(ih ppi [:: pi]) => //.
        rewrite -rev_cat.
          by rewrite (ih ppi (chain' ++ [::pi])) => //.
      + move: head_eq last_eq is_chain.
        case: chain => //= pi' chain.
        case => pi_eq last_eq pichain.
        rewrite -pi_eq.
        econstructor; [ eassumption | eassumption | ].
          by rewrite pi_eq.
  Qed.

  Lemma InheritanceChain_cat: forall p chain1 i chain2,
      InheritanceChain p (chain1 ++ [:: i]) ->
      InheritanceChain p [:: i & chain2] ->
      InheritanceChain p (chain1 ++ [:: i & chain2]).
  Proof.
    move => p.
    elim => // i chain1 ih pi chain2 ch1.
    move: ch1 ih => /InheritanceChain_inv.
    case: chain1 => /=.
    - move => inv.
      apply inv.
      move => n pis ibody args ppis inprf pi_in_pis pichain ih pichain'.
        by econstructor; eassumption.
    - move => pi1 chain1 inv ih pichain2.
      rewrite (catA chain1 [:: pi] chain2).
      move: ih (ih pi chain2) => _.
      rewrite (catA chain1 [::pi] chain2).
      apply inv.
      move => n pis ibody args ppis iprf pi1_in_pis pi1chain ih.
      econstructor; [ eassumption | eassumption | ].
        by apply: ih.
  Qed.

  Definition Strict {A : Type} (P : A -> A -> Prop) := forall x y, P x y -> P y x -> x = y.

  Lemma ohead_rev: forall {A: Type} (x: A) (s: seq A), ohead (rev (s ++ [:: x])) = Some x.
  Proof.
    move => A x s.
      by rewrite rev_cat.
  Qed.

  Lemma Subtype_args_eq: forall p i args1 args2,
      (forall chain, InheritanceChain p chain -> uniq chain) ->
      Subtype p (TyRef i args1) (TyRef i args2) ->
      args1 = args2.
  Proof.
    move => p i args1 args2 uniqprf.
    move: {1 3}(TyRef i args2) (eq_refl (TyRef i args2)) => B /eqP B_eq /(clos_rt_rt1n _ _ _ _) prf.
    move: B_eq.
    case: prf.
    - by move => [].
    - move: B => _ B C /SubtypeStep_inv inv.
      apply inv.
      move: inv => _ pis ibody pi ppis pibody piargs iprf piprf piinpis.
      move => /(clos_rt1n_rt _ _ _ _) /(Subtype_InheritanceChain) chainprops eqprf.
      move: chainprops.
      rewrite eqprf.
      move => [] chain [] chainprops.
      assert (chain_ipi: InheritanceChain p [:: i; pi]).
      { by econstructor; [ eassumption | eassumption | constructor ]. }
      move: chainprops.
      case: chain => //= i' chain /= [] <- [] chain_tail chainprf.
      move: (InheritanceChain_cat _ [::i] _ _ chain_ipi chainprf) => /uniqprf.
      rewrite cat_uniq => /andP [] _ /andP [] /hasP [].
      exists i.
      + move: chain_tail.
        clear ...
        case /lastP: chain => /=.
        * move => [] ->.
            by rewrite in_cons eq_refl.
        * move => chain i'.
          rewrite (rev_cat [::pi]) rev_rcons /=.
          move => [] ->.
            by rewrite in_cons mem_rcons in_cons eq_refl orbT.
      + by rewrite /= in_cons eq_refl.
  Qed.

  Lemma Subtype_inames_ineq: forall p i1 i2 args1 args2,
      (forall chain, InheritanceChain p chain -> uniq chain) ->
      Subtype p (TyRef i1 args1) (TyRef i2 args2) ->
      ~(i1 = i2) \/ (TyRef i1 args1 = TyRef i2 args2).
  Proof.
    move => p i1 i2 args1 args2 uniqprf.
    case: (i1 == i2) /eqP.
    - move => -> /(Subtype_args_eq _ _ _ _ uniqprf) ->.
        by right.
    - move => ? _.
        by left.
  Qed.

  Definition uniform (A B: Ty): bool :=
    match A, B with
    | TyRef _ _, TyRef _ _ => true
    | ClassTyVar _, ClassTyVar _ => true
    | MethodTyVar _, MethodTyVar _ => true
    | _, _ => false
    end.

  Lemma Subtype_uniform:
    forall p A B, Subtype p A B -> uniform A B.
  Proof.
    move => p A B /(clos_rt_rt1n _ _ _ _).
    elim.
    - by case.
    - move: A B => _ _ A B C /SubtypeStep_inv.
      case: A => // i iargs inv /(clos_rt1n_rt _ _ _ _).
      rewrite -/(Subtype p).
      apply inv.
        by case C.
  Qed.

  Lemma UniqueInheritance_Strict:
    forall p, (forall chain, InheritanceChain p chain -> uniq chain) -> Strict (Subtype p).
  Proof.
    move => p uniqprf A B.
    case: A.
    - case: B.
      + move => pi piargs i iargs ipi pii.
        case: (Subtype_inames_ineq _ _ _ _ _ uniqprf ipi) => // ineq.
        exfalso.
        have: (Some pi = iname (TyRef pi piargs)); [ done | ].
        move: ipi ineq (Subtype_uniform _ _ _ ipi) pii => /(clos_rt_rt1n _ _ _ _).
        case.
        * move => disprf _ _ [] /eqP.
            by rewrite eq_sym => /eqP /disprf.
        * move => B C /SubtypeStep_inv inv.
          apply inv.
          move: inv => _ pis ibody pi' ppis pibody piargs' iprf pi'prf pi'inpis /(clos_rt1n_rt _ _ _ _).
          move => /Subtype_InheritanceChain [] chain chainprf.
          assert (ipichain: InheritanceChain p [:: i; pi']).
          { by econstructor; [ eassumption | eassumption | constructor ]. }
          move: chainprf => [].
          case: chain => //= ? chain [] <- [].
          case: C => // ppi ppiargs ppichain pi'chain ineq _ /Subtype_InheritanceChain.
          move => [] []; first by case.
          move => ? chain2 [] [] <- [] ppichain2 ppichain2prf [] pi_ppi_eq.
          assert (ipi'chain: InheritanceChain p [:: i, pi' & chain]).
          { by apply: (InheritanceChain_cat p [:: i]). }
          assert (ipi'chainchain2: InheritanceChain p [:: i, pi' & chain ++ chain2]).
          { rewrite -cat_cons -cat_cons.
            move: ppichain ipi'chain ppichain2prf.
            clear ...
            case /lastP: chain.
            - move => [] -> p1 p2.
              rewrite cat_cons.
                by apply: (InheritanceChain_cat _ [:: i]).
            - move => chain ?.
              rewrite rev_cons rev_rcons => /= [] [] <-.
              rewrite -cats1 -cat_cons -cat_cons -catA -cat_cons -cat_cons.
              move => p1 p2.
                by apply: InheritanceChain_cat. }
          move: (uniqprf _ ipi'chainchain2).
          rewrite -cat_cons -cat_cons cat_uniq.
          move => /andP [] _ /andP [] /hasP devil _.
          apply: devil.
          exists i.
          ** move: ppichain2 pi_ppi_eq ineq.
             clear ...
             case /lastP: chain2.
             *** by move => [] -> ->.
             *** move => chain2 i'.
                 rewrite rev_cons rev_rcons mem_rcons in_cons => /= [] [] ->.
                   by rewrite eq_refl.
          ** by rewrite /= in_cons eq_refl.
      + by move => ? ? ? /Subtype_uniform.
      + by move => ? ? ? /Subtype_uniform.
    - move => n /(clos_rt_rt1n _ _ _ _).
        by case => //= ? ? /SubtypeStep_inv.
    - move => n /(clos_rt_rt1n _ _ _ _).
        by case => //= ? ? /SubtypeStep_inv.
  Qed.

End SubtypeProperties.

Inductive HasDefault (p: Program) (i: IName) (m: MName): Expression -> Prop :=
| HasDefault_Here: forall ni pis mdecls r nm s e,
    ((Interface i ni pis mdecls) \in decls p) ->
    ((DefaultMethod (MethodHeader r nm m s) e) \in mdecls) ->
    HasDefault p i m e.

Definition has_default (p: Program) (i: IName) (m: MName) (e: Expression): bool :=
  has (fun decl =>
         (name decl == i) &&
         has (fun mdecl => if mdecl is DefaultMethod (MethodHeader r nm m' s) e' then (m == m') && (e == e') else false)
             (mdecls decl))
      (decls p).

Lemma HasDefaultP: forall p i m e, reflect (HasDefault p i m e) (has_default p i m e).
Proof.
  move => p i m e.
  move: {1 3}(has_default p i m e) (refl_equal (has_default p i m e)).
  case.
  - move => defaultprf.
    constructor.
    move: defaultprf (sym_equal defaultprf) => _.
    rewrite /has_default.
    move => /hasP [] [] i' ni pis mdecls iinprf /andP [] /= /eqP i_eq /hasP [] [] //= [] r nm m' s e' minprf /andP [] /eqP m_eq /eqP e_eq.
    econstructor.
    + rewrite -i_eq; by exact iinprf.
    + rewrite m_eq e_eq; by exact minprf.
  - move => disprf.
    constructor.
    move => prf.
    move: disprf.
    case: prf.
    move: e => _ ni pis mdecls r nm s e iinprf minprf.
    rewrite /has_default.
    move => /(@sym_equal _ _ _) /negbT /negP disprf.
    apply: disprf.
    apply: introT; [ by apply: hasP | ].
    eexists; [ by exact iinprf | ].
    rewrite eq_refl /=.
    apply: introT; [ by apply: hasP | ].
    eexists; [ by exact minprf | ].
      by rewrite /= eq_refl eq_refl.
Qed.

Definition MBody (p: Program) (m: MName) (from: IName) (defining: IName) (e: Expression): Prop :=
  exists (chain: seq IName),
    InheritanceChain p (chain ++ [:: defining]) /\
    from = head defining chain /\
    HasDefault p defining m e /\
    all (fun i => ~~(has_default p i m e)) chain.

Definition method_names_unique_in_types (p: Program): bool :=
  all (fun decl => uniq (map mname (mdecls decl))) (decls p).

Definition domain_unique (p: Program): bool := uniq (domain p).

Definition DiamondResolved (p: Program): Prop :=
  forall i pi1 pi2 m e1 e2,
    MBody p m i pi1 e1 ->
    MBody p m i pi2 e2 ->
    pi1 = pi2 /\ e1 = e2.

Definition OverridesCompatible (p: Program): Prop :=
  forall decl_sub decl_super tyargs1 tyargs2 m n r1 r2 s1 s2,
    Subtype p (TyRef (name decl_sub) tyargs1) (TyRef (name decl_super) tyargs2) ->
    (MethodHeader n r1 m s1 \in signatures decl_sub) ->
    (MethodHeader n r2 m s2 \in signatures decl_super) ->
    Subtype p r2 r1 /\ (map (substitute tyargs1 [::]) s1 = map (substitute tyargs2 [::]) s2).



