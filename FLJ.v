From mathcomp Require Import all_ssreflect.
Set Bullet Behavior "Strict Subproofs".
Import EqNotations.
Require Import Relations.Relation_Operators.
Require Import Relations.Operators_Properties.

Variable IName: countType.
Variable MName: countType.

Inductive Expression : Type :=
| Var: nat -> Expression
| MethodCall: Expression -> IName -> MName -> Expression -> Expression
| Lambda: IName ->  Expression -> Expression.

Inductive Ty : Type :=
| TyRef : IName -> Ty.

Inductive Signature : Type :=
| MethodHeader: Ty -> MName -> Ty -> Signature.

Inductive MethodDeclaration: Type :=
| AbstractMethod: Signature -> MethodDeclaration
| DefaultMethod: Signature -> Expression -> MethodDeclaration.

Inductive Declaration : Type :=
| Interface: IName -> seq IName -> seq MethodDeclaration -> Declaration.

Inductive Program : Type :=
| Decls: seq Declaration -> Program.

Inductive Value : Type :=
| VLambda : IName -> Expression -> Value.



Section MathcompInstances.
  Fixpoint Expression2Tree (e: Expression): GenTree.tree (nat + IName + MName) :=
    match e with
    | Var n => GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))]
    | MethodCall o i m arg => GenTree.Node 1 [:: Expression2Tree o; GenTree.Leaf (inl (inr i)); GenTree.Leaf (inr m); Expression2Tree arg]
    | Lambda i e => GenTree.Node 2 [:: GenTree.Leaf (inl (inr i)); Expression2Tree e]
    end.

  Fixpoint Tree2Expression (t: GenTree.tree (nat + IName + MName)): option Expression :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))] => Some (Var n)
    | GenTree.Node 1 [:: ot; GenTree.Leaf (inl (inr i)); GenTree.Leaf (inr m); argt] =>
      if Tree2Expression ot is Some o then
        if Tree2Expression argt is Some arg then
          Some (MethodCall o i m arg)
        else None
      else None
    | GenTree.Node 2 [:: GenTree.Leaf (inl (inr i)); et] =>
      if Tree2Expression et is Some e then Some (Lambda i e) else None
    | _ => None
    end.

  Lemma pcan_Expression2Tree: pcancel Expression2Tree Tree2Expression.
  Proof.
    elim => //=; by [ move => ? -> ? ? ? -> | move => ? ? -> ].
  Qed.

  Definition Expression_eqMixin := PcanEqMixin pcan_Expression2Tree.
  Canonical Expression_eqType := EqType Expression Expression_eqMixin.
  Definition Expression_choiceMixin := PcanChoiceMixin pcan_Expression2Tree.
  Canonical Expression_choiceType := ChoiceType Expression Expression_choiceMixin.
  Definition Expression_countMixin := PcanCountMixin pcan_Expression2Tree.
  Canonical Expression_countType := CountType Expression Expression_countMixin.

  Definition Ty2Tree (t: Ty): GenTree.tree IName :=
    match t with
    | TyRef i => GenTree.Node 0 [:: GenTree.Leaf i ]
    end.

  Definition Tree2Ty (t:  GenTree.tree IName): option Ty :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf i ] => Some (TyRef i)
    | _ => None
    end.

  Lemma pcan_Ty2Tree: pcancel Ty2Tree Tree2Ty.
  Proof.
      by case.
  Qed.

  Definition Ty_eqMixin := PcanEqMixin pcan_Ty2Tree.
  Canonical Ty_eqType := EqType Ty Ty_eqMixin.
  Definition Ty_choiceMixin := PcanChoiceMixin pcan_Ty2Tree.
  Canonical Ty_choiceType := ChoiceType Ty Ty_choiceMixin.
  Definition Ty_countMixin := PcanCountMixin pcan_Ty2Tree.
  Canonical Ty_countType := CountType Ty Ty_countMixin.

  Definition Signature2Tree (s: Signature): GenTree.tree (Ty + MName) :=
    match s with
    | MethodHeader r m s => GenTree.Node 0 [:: GenTree.Leaf (inl r); GenTree.Leaf (inr m); GenTree.Leaf (inl s)]
    end.

  Definition Tree2Signature (t: GenTree.tree (Ty + MName)): option Signature :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl r); GenTree.Leaf (inr m); GenTree.Leaf (inl s)] => Some (MethodHeader r m s)
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

  Definition Declaration2Tree (d: Declaration): GenTree.tree (IName + seq IName + seq MethodDeclaration) :=
    match d with
    | Interface i ps ms => GenTree.Node 0 [:: GenTree.Leaf (inl (inl i)); GenTree.Leaf (inl (inr ps)); GenTree.Leaf (inr ms)]
    end.

  Definition Tree2Declaration (t: GenTree.tree (IName + seq IName + seq MethodDeclaration)): option Declaration :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl i)); GenTree.Leaf (inl (inr ps)); GenTree.Leaf (inr ms)]  => Some (Interface i ps ms)
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

  Definition Value2Tree (p: Value): GenTree.tree (IName + Expression) :=
    match p with
    | VLambda i e => GenTree.Node 0 [:: GenTree.Leaf (inl i); GenTree.Leaf (inr e)]
    end.

  Definition Tree2Value (t: GenTree.tree (IName + Expression)): option Value :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl i); GenTree.Leaf (inr e)] => Some (VLambda i e)
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


Inductive ECtxt (exp: Expression): Type :=
| EvalCallTgt : IName -> MName -> Expression -> ECtxt exp
| EvalCallArg : Value -> IName -> MName -> ECtxt exp.

Definition Ctxt : Type := seq Ty.

Definition typeof (v: Value) : Ty :=
  match v with | VLambda i _ => TyRef i end.

Definition types (p: Program) :=
  match p with
  | Decls decls => map (fun d => match d with Interface i _ _ => i end) decls
  end.

Definition decls (p: Program): seq Declaration :=
  match p with | Decls decls => decls end.

Definition mdecls (i: Declaration): seq MethodDeclaration :=
  match i with | Interface _ _ mdecls => mdecls end.

Definition name (decl: Declaration): IName :=
  match decl with | Interface i _ _ => i end.

Definition parents (decl: Declaration): seq IName :=
  match decl with | Interface _ pis _ => pis end.

Definition mname (mdecl: MethodDeclaration): MName :=
  match mdecl with
  | AbstractMethod (MethodHeader _ m _) => m
  | DefaultMethod (MethodHeader _ m _) _ => m
  end.

Definition signatures (i: Declaration): seq Signature :=
  map (fun mdecl => match mdecl with
                 | AbstractMethod sig => sig
                 | DefaultMethod sig _ => sig
                 end) (mdecls i).

Inductive HasDefault (p: Program) (i: IName) (m: MName): Expression -> Prop :=
| HasDefault_Here: forall pis mdecls r s e,
    ((DefaultMethod (MethodHeader r m s) e) \in mdecls) ->
    ((Interface i pis mdecls) \in decls p) ->
    HasDefault p i m e.

Definition has_parent (p: Program) (i: IName) (pi: IName): bool :=
  has (fun decl => (name decl == i) && (pi \in parents decl)) (decls p).

Definition HasParentTrans (p: Program): IName -> IName -> Prop :=
  clos_trans _ (has_parent p).

Definition ST (p: Program): IName -> IName -> Prop :=
  clos_refl _ (HasParentTrans p).

Inductive MBody (p: Program) (i: IName) (m: MName): IName -> Expression -> Prop :=
| MBody_here: forall e, HasDefault p i m e -> MBody p i m i e
| MBody_parent: forall pi ppi e,
    (~HasDefault p i m e) ->
    has_parent p i pi ->
    MBody p pi m ppi e ->
    MBody p i m ppi e.

Definition method_names_unique_in_types (p: Program): bool := all (fun decl => uniq (map mname (mdecls decl))) (decls p).
Definition types_unique (p: Program): bool := uniq (types p).

Definition DiamondResolved (p: Program): Prop :=
  forall i m pi1 pi2 ppi1 ppi2 e1 e2,
    has_parent p i pi1 ->
    has_parent p i pi2 ->
    MBody p pi1 m ppi1 e1 ->
    MBody p pi2 m ppi2 e2 ->
    (ppi1 = ppi2) \/ (exists e, HasDefault p i m e).

Definition OverridesCompatible (p: Program): Prop :=
  forall decl_sub decl_super m r1 r2 s1 s2,
    HasParentTrans p (name decl_sub) (name decl_super) ->
    (MethodHeader (TyRef r1) m (TyRef s1) \in signatures decl_sub) ->
    (MethodHeader (TyRef r2) m (TyRef s2) \in signatures decl_super) ->
    HasParentTrans p r2 r1 /\ HasParentTrans p s1 s2.

Inductive ParentsWellFounded (i: IName): Program -> Prop :=
| PWF : forall decls1 decls2 ps ms,
    (forall p, p \in ps -> ParentsWellFounded p (Decls (decls1 ++ decls2))) ->
    ParentsWellFounded i (Decls (decls1 ++ [:: Interface i ps ms & decls2])).

Definition ParentsAcyclic (p: Program): Prop :=
  forall i pi, HasParentTrans p i pi -> ~HasParentTrans p pi i.

Definition ParentsDefined (p: Program): Prop := forall i pi, HasParentTrans p i pi -> pi \in types p.

Lemma has_parent_defined: forall p i pi, has_parent p i pi -> i \in types p.
Proof.
  case.
  elim => // [] [] i1 pis1 mdecls decls IH i pi.
  rewrite /has_parent /=.
  move => /orP [].
  - move => /andP [] /eqP -> _.
      by rewrite in_cons eq_refl.
  - move => /IH.
    rewrite in_cons.
    move => ->.
      by rewrite orbT.
Qed.

Lemma HasParentTrans_defined: forall p i pi, HasParentTrans p i pi -> i \in types p.
Proof.
  move => p i pi.
  elim => //.
    by apply: has_parent_defined.
Qed.

Lemma ParentsWellFounded_defined: forall p i, ParentsWellFounded i p -> i \in types p.
Proof.
  move => p i [] decls1 decls2 ps ms _.
    by rewrite /types map_cat mem_cat /= in_cons eq_refl orbT.
Qed.

Lemma has_parent_unique_in:
  forall decls1 decls2 i pi pis mdecls,
    types_unique (Decls (decls1 ++ Interface i pis mdecls :: decls2)) ->
    has_parent (Decls (decls1 ++ Interface i pis mdecls :: decls2)) i pi ->
    pi \in pis.
Proof.
  move => decls1 decls2 i pi pis mdecls uniqueprf.
  rewrite /has_parent has_cat /=.
  move => /orP.
  case.
  - move: uniqueprf.
    rewrite /types_unique /types map_cat cat_uniq.
    move => /andP [] _ /andP [] disprf _.
    move: disprf.
    rewrite map_cons /=.
    move => /negbTE /orP disprf.
    move => /hasP [] decl inprf /andP [] nameprf _.
    exfalso.
    apply: disprf.
    left.
    rewrite -(eqP nameprf).
      by apply map_f.
  - move => /orP.
    case.
    + by move => /andP [] _ ->.
    + move: uniqueprf.
      rewrite /types_unique /types map_cat cat_uniq.
      move => /andP [] _ /andP [] _ /= /andP [] nin _ /hasP [] decl inprf /andP [] /eqP nameprf _.
      exfalso.
      move: nin.
        by rewrite /(_ \notin _) -nameprf map_f.
Qed.

Lemma ParentsWellFounded_acyclic_step: forall p i pi, types_unique p -> ParentsWellFounded i p -> has_parent p i pi -> i != pi.
Proof.
  move => p i pi uniqueprf prf.
  move: prf uniqueprf.
  elim.
  move: i => _ i decls1 decls2 pis ms wfprf _ uniqueprf /(has_parent_unique_in _ _ _ _ _ _ uniqueprf) /wfprf /ParentsWellFounded_defined prf.
  apply: negbT.
  apply: (introF eqP ).
  move => eqprf.
  move: uniqueprf.
  rewrite /types_unique /types map_cat cat_uniq.
  move => /andP [] _ /andP [] /=.
  rewrite eqprf.
  move: prf.
  rewrite /types map_cat mem_cat.
    by move => /orP [] ->.
Qed.


Lemma ParentsWellFounded_ParentsDefined: forall p, types_unique p -> (forall i, i \in types p -> ParentsWellFounded i p) -> ParentsDefined p.
Proof.
  move => p uniqueprf wfprf i pi /(clos_trans_t1n _ _ _ _) parentprf.
  move: parentprf uniqueprf wfprf.
  elim => //.
  move: i pi => _ _ i pi parentprf.
  move: (has_parent_defined _ _ pi parentprf) => iinprf.
  move => uniqueprf wfprf.
  move: (wfprf i iinprf) => iwfprf.
  move: iwfprf parentprf iinprf uniqueprf wfprf.
  move => [] decls1 decls2 pis ms piwfprf parentprf iinprf uniqueprf wfprf.
  apply: (mem_subseq (s1 := types (Decls (decls1 ++ decls2)))).
  - rewrite /types map_cat map_cat.
    apply: cat_subseq => //.
      by apply: subseq_cons.
  - apply: (ParentsWellFounded_defined).
    apply: piwfprf.
      by apply: has_parent_unique_in; [ by exact uniqueprf | done ].
Qed.

Lemma HasParentTrans_strengthen: forall decls1 decls2 decl i pi,
    ~(HasParentTrans (Decls (decls1 ++ [:: decl & decls2])) (name decl) pi) ->
    types_unique (Decls (decls1 ++ [:: decl & decls2])) ->
    HasParentTrans (Decls (decls1 ++ [:: decl & decls2])) i pi ->
    HasParentTrans (Decls (decls1 ++ decls2)) i pi.
Proof.
  move => decls1 decls2 decl i pi ndeclpi uniqueprf ipi.
  move: ipi uniqueprf ndeclpi.
  elim.
  - move: i pi => _ _ i pi /hasP [] idecl ideclin /andP [] idecl_name piprf uniqueprf ndeclpi.
    constructor.
    rewrite /has_parent.
    eapply elimT.
    + apply: hasP.
    apply: (rwP (hasP _ _)).
    move: (hasP.




    


Lemma ParentsWellFounded_acyclic: forall p, types_unique p -> (forall i, i \in types p -> ParentsWellFounded i p) -> ParentsAcyclic p.
Proof.
  move => p uniqueprf wfprf i pi parentprf.
  move: parentprf uniqueprf wfprf.
  move => /(clos_trans_t1n _ _ _ _).
  elim.
  - move: i pi => _ _ i pi ipi uniqueprf wfprf pii.
    move: (wfprf i (has_parent_defined _ _ _ ipi)) => pwfi.
    move: pwfi pii wfprf uniqueprf ipi => [] decls1 decls2 pis ms piswfprf pii wfprf uniqueprf ipi.
  (* TODO: show this part:
     show that parents of p are wellfounded using piswfprf
     strengthen pii to be HasParentTrans (Delcs (decls1 ++ decls2)) pi i
     conclude that i must be declared in decls1 ++ decls2
     disprf using uniqueprf.
   *)
    assert (piwf: ParentsWellFounded pi (Decls (decls1 ++ decls2))).
    { apply: piswfprf.
      apply: has_parent_unique_in; [ by apply: uniqueprf | done ]. }
    assert (strong_pii: HasParentTrans (Decls (decls1 ++ decls2)) pi i).
    { move: pii piwf uniqueprf.
      clear.
      elim.
      - admit.
      - 

    

  - (* DONE. *)
    move: i pi => _ _ i pi ppi parentprf pparentprf ih uniqueprf wfprf.
    move: (ih uniqueprf wfprf) => disprf.
    move: ih => _ /(clos_trans_t1n _ _ _ _) devil.
    move: devil disprf parentprf pparentprf.
    case.
    + move => mid ppimid disprf midpi _.
      apply: disprf.
      apply: (t_trans _ _ _ mid); by constructor.
    + move => mid1 mid2 ppimid1 mid1mid2 disprf mid2pi _.
      apply: disprf.
      apply: (t_trans _ _ _ mid1); [ by constructor | ].
      apply: (t_trans _ _ _ mid2); [ | by constructor ].
        by apply: clos_t1n_trans.
Qed.

Definition mbody (p: Program) (t: Ty) (m: MName) :=
  match p with
  | Decls decls =>
    omap (fun decl =>
            match decl with
            | Interface i exts body => 
              
         ) decls




