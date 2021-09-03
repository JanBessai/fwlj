From mathcomp Require Import all_ssreflect.
Set Bullet Behavior "Strict Subproofs".
Import EqNotations.
Require Import Relations.Relation_Operators.
Require Import Relations.Operators_Properties.

Variable IName: countType.
Variable MName: countType.

Inductive Ty : Type :=
| TyRef : IName -> (*seq Ty ->*) Ty
(*| ClassTyVar : nat -> Ty
| MethodTyVar : nat -> Ty*).

Inductive Expression : Type :=
| Var: nat -> Expression
| MethodCall: Expression -> MName -> Expression -> Expression
| Lambda: Ty -> Expression -> Expression.

Inductive Signature : Type :=
| MethodHeader: (*nat ->*) Ty -> MName -> Ty -> Signature.

Inductive MethodDeclaration: Type :=
| AbstractMethod: Signature -> MethodDeclaration
| DefaultMethod: Signature -> Expression -> MethodDeclaration.

Inductive Declaration : Type :=
| Interface: IName -> (*nat ->*) seq Ty -> seq MethodDeclaration -> Declaration.

Inductive Program : Type :=
| Decls: seq Declaration -> Program.

Inductive Value : Type :=
| VLambda : Ty -> Expression -> Value.


Section MathcompInstances.

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

  Fixpoint Expression2Tree (e: Expression): GenTree.tree (nat + Ty + MName) :=
    match e with
    | Var n => GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))]
    | MethodCall o m arg => GenTree.Node 1 [:: Expression2Tree o; GenTree.Leaf (inr m); Expression2Tree arg]
    | Lambda i e => GenTree.Node 2 [:: GenTree.Leaf (inl (inr i)); Expression2Tree e]
    end.

  Fixpoint Tree2Expression (t: GenTree.tree (nat + Ty + MName)): option Expression :=
    match t with
    | GenTree.Node 0 [:: GenTree.Leaf (inl (inl n))] => Some (Var n)
    | GenTree.Node 1 [:: ot; GenTree.Leaf (inr m); argt] =>
      if Tree2Expression ot is Some o then
        if Tree2Expression argt is Some arg then
          Some (MethodCall o m arg)
        else None
      else None
    | GenTree.Node 2 [:: GenTree.Leaf (inl (inr i)); et] =>
      if Tree2Expression et is Some e then Some (Lambda i e) else None
    | _ => None
    end.

  Lemma pcan_Expression2Tree: pcancel Expression2Tree Tree2Expression.
  Proof.
    elim => //=; by [ move => ? -> ? ? -> | move => ? ? -> ].
  Qed.

  Definition Expression_eqMixin := PcanEqMixin pcan_Expression2Tree.
  Canonical Expression_eqType := EqType Expression Expression_eqMixin.
  Definition Expression_choiceMixin := PcanChoiceMixin pcan_Expression2Tree.
  Canonical Expression_choiceType := ChoiceType Expression Expression_choiceMixin.
  Definition Expression_countMixin := PcanCountMixin pcan_Expression2Tree.
  Canonical Expression_countType := CountType Expression Expression_countMixin. 

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

  Definition Declaration2Tree (d: Declaration): GenTree.tree (IName + seq Ty + seq MethodDeclaration) :=
    match d with
    | Interface i ps ms => GenTree.Node 0 [:: GenTree.Leaf (inl (inl i)); GenTree.Leaf (inl (inr ps)); GenTree.Leaf (inr ms)]
    end.

  Definition Tree2Declaration (t: GenTree.tree (IName + seq Ty + seq MethodDeclaration)): option Declaration :=
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

  Definition Value2Tree (p: Value): GenTree.tree (Ty + Expression) :=
    match p with
    | VLambda i e => GenTree.Node 0 [:: GenTree.Leaf (inl i); GenTree.Leaf (inr e)]
    end.

  Definition Tree2Value (t: GenTree.tree (Ty + Expression)): option Value :=
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


(* exp is the hole of the context *)
Inductive EvalCtx (exp: Expression): Type :=
| EvalCallReceiver : MName -> Expression -> EvalCtx exp
| EvalCallArg : Value -> MName -> EvalCtx exp.

Definition TypeCtx : Type := seq Ty.

Definition typeof (v: Value) : Ty :=
  match v with | VLambda i _ => i end.

Definition domain (p: Program): seq IName :=
  match p with
  | Decls decls => map (fun d => match d with Interface i _ _ => i end) decls
  end.

Definition decls (p: Program): seq Declaration :=
  match p with | Decls decls => decls end.

Definition mdecls (i: Declaration): seq MethodDeclaration :=
  match i with | Interface _ _ mdecls => mdecls end.

Definition name (decl: Declaration): IName :=
  match decl with | Interface i _ _ => i end.

Definition parents (decl: Declaration): seq Ty :=
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
    ((Interface i pis mdecls) \in decls p) ->
    ((DefaultMethod (MethodHeader r m s) e) \in mdecls) ->
    HasDefault p i m e.

Definition has_parent (p: Program) (i: IName) (pi: IName): bool :=
  has (fun decl => (name decl == i) && (TyRef pi \in parents decl)) (decls p).

Definition HasParentTrans (p: Program): IName -> IName -> Prop :=
  clos_trans _ (has_parent p).

Definition ST (p: Program): IName -> IName -> Prop :=
  clos_refl _ (HasParentTrans p).

Inductive MBody (p: Program) (i: IName) (m: MName): IName -> Expression -> Prop :=
| MBody_Here: forall e, HasDefault p i m e -> MBody p i m i e
| MBody_Parent: forall pi ppi e,
    (~HasDefault p i m e) ->
    has_parent p i pi ->
    MBody p pi m ppi e ->
    MBody p i m ppi e.

Definition method_names_unique_in_types (p: Program): bool :=
  all (fun decl => uniq (map mname (mdecls decl))) (decls p).
Definition domain_unique (p: Program): bool := uniq (domain p).

Definition DiamondResolved (p: Program): Prop :=
  forall i m pi1 pi2 ppi1 ppi2 e1 e2,
    has_parent p i pi1 ->
    has_parent p i pi2 ->
    MBody p pi1 m ppi1 e1 ->
    MBody p pi2 m ppi2 e2 ->
    (ppi1 = ppi2) \/ (exists e, HasDefault p i m e).

Definition OverridesCompatible (p: Program): Prop :=
  forall decl_sub decl_super m r1 r2 s,
    HasParentTrans p (name decl_sub) (name decl_super) ->
    (MethodHeader (TyRef r1) m (TyRef s) \in signatures decl_sub) ->
    (MethodHeader (TyRef r2) m (TyRef s) \in signatures decl_super) ->
    HasParentTrans p r2 r1.

Inductive ParentsWellFounded (i: IName): Program -> Prop :=
| PWF : forall decls1 decls2 pis ms,
    (forall pi, pi \in pis -> ParentsWellFounded pi (Decls (decls1 ++ decls2))) ->
    ParentsWellFounded i (Decls (decls1 ++ [:: Interface i (map TyRef pis) ms & decls2])).

Definition ParentsAcyclic (p: Program): Prop :=
  forall i pi, HasParentTrans p i pi -> ~HasParentTrans p pi i.

Definition ParentsDefined (p: Program): Prop := forall i pi, HasParentTrans p i pi -> pi \in domain p.

Lemma has_parent_defined: forall p i pi, has_parent p i pi -> i \in domain p.
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

Lemma HasParentTrans_defined: forall p i pi, HasParentTrans p i pi -> i \in domain p.
Proof.
  move => p i pi.
  elim => //.
    by apply: has_parent_defined.
Qed.

Lemma ParentsWellFounded_defined: forall p i, ParentsWellFounded i p -> i \in domain p.
Proof.
  move => p i [] decls1 decls2 ps ms _.
    by rewrite /domain map_cat mem_cat /= in_cons eq_refl orbT.
Qed.

Lemma has_parent_unique_in:
  forall decls1 decls2 i pi pis mdecls,
    domain_unique (Decls (decls1 ++ Interface i (map TyRef pis) mdecls :: decls2)) ->
    has_parent (Decls (decls1 ++ Interface i (map TyRef pis) mdecls :: decls2)) i pi ->
    pi \in pis.
Proof.
  move => decls1 decls2 i pi pis mdecls uniqueprf.
  rewrite /has_parent has_cat /=.
  move => /orP.
  case.
  - move: uniqueprf.
    rewrite /domain_unique /domain map_cat cat_uniq.
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
    + move => /andP [] _.
        by rewrite mem_map => // ? ? [] ->.
    + move: uniqueprf.
      rewrite /domain_unique /domain map_cat cat_uniq.
      move => /andP [] _ /andP [] _ /= /andP [] nin _ /hasP [] decl inprf /andP [] /eqP nameprf _.
      exfalso.
      move: nin.
        by rewrite /(_ \notin _) -nameprf map_f.
Qed.

Lemma ParentsWellFounded_irrefl_step: forall p i pi, domain_unique p -> ParentsWellFounded i p -> has_parent p i pi -> i != pi.
Proof.
  move => p i pi uniqueprf prf.
  move: prf uniqueprf.
  elim.
  move: i => _ i decls1 decls2 pis ms wfprf _ uniqueprf /(has_parent_unique_in _ _ _ _ _ _ uniqueprf) /wfprf /ParentsWellFounded_defined prf.
  apply: negbT.
  apply: (introF eqP ).
  move => eqprf.
  move: uniqueprf.
  rewrite /domain_unique /domain map_cat cat_uniq.
  move => /andP [] _ /andP [] /=.
  rewrite eqprf.
  move: prf.
  rewrite /domain map_cat mem_cat.
    by move => /orP [] ->.
Qed.

Lemma ParentsWellFounded_ParentsDefined: forall p, domain_unique p -> (forall i, i \in domain p -> ParentsWellFounded i p) -> ParentsDefined p.
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
  apply: (mem_subseq (s1 := domain (Decls (decls1 ++ decls2)))).
  - rewrite /domain map_cat map_cat.
    apply: cat_subseq => //.
      by apply: subseq_cons.
  - apply: (ParentsWellFounded_defined).
    apply: piwfprf.
      by apply: has_parent_unique_in; [ by exact uniqueprf | done ].
Qed.

Lemma HasParentTrans_strengthen: forall decls1 decls2 decl i pi,
    ~(HasParentTrans (Decls (decls1 ++ [:: decl & decls2])) (name decl) pi) ->
    domain_unique (Decls (decls1 ++ [:: decl & decls2])) ->
    HasParentTrans (Decls (decls1 ++ [:: decl & decls2])) i pi ->
    HasParentTrans (Decls (decls1 ++ decls2)) i pi.
Proof.
  move => decls1 decls2 decl i pi ndeclpi uniqueprf ipi.
  move: ipi uniqueprf ndeclpi.
  elim.
  - move: i pi => _ _ i pi /hasP [] idecl ideclin /andP [] idecl_name piprf uniqueprf ndeclpi.
    constructor.
    rewrite /has_parent.
    apply: (introT hasP).
    exists idecl; [ | by apply: (introT andP) ].
    move: ideclin.
    rewrite /= mem_cat in_cons.
    move => /orP []; [ | move => /orP [] ].
    + rewrite mem_cat.
        by move => ->.
    + move => /eqP devil.
      move: ndeclpi.
      rewrite -devil.
      move => ndeclpi.
      exfalso.
      apply: ndeclpi.
      constructor.
      rewrite /has_parent.
      apply: (introT hasP).
      exists idecl; [ | by apply: (introT andP) ].
        by rewrite /= mem_cat in_cons eq_refl orbT.
    + rewrite mem_cat.
      move => ->.
        by rewrite orbT.
  - move: i pi => _ _ i mid pi imid ihimid midpi ihmidpi uniqueprf ndeclpi.
    apply: (t_trans _ _ _ mid); [ | by apply ihmidpi ].
    apply: ihimid => //.
    move => devil.
    apply: ndeclpi.
      by apply: (t_trans _ _ _ mid).
Qed.

Lemma ParentsWellFounded_perm: forall p1 p2 i,
    ParentsWellFounded i p1 ->
    perm_eq (decls p1) (decls p2) ->
    ParentsWellFounded i p2.
Proof.
  move => p1 p2 i wfprf.
  move: p2.
  elim: wfprf.
  move: p1 i => _ _ i decls1 decls2 pis ms wfprf ih p2 permeq.
  assert (p2_eq: exists decls1' decls2', p2 = Decls (decls1' ++ [:: Interface i (map TyRef pis) ms & decls2'])).
  { assert (iin: Interface i (map TyRef pis) ms \in (decls (Decls (decls1 ++ [:: Interface i (map TyRef pis) ms & decls2])))).
    { by rewrite /= mem_cat in_cons eq_refl orbT. }
    move: permeq iin => /perm_mem ineq.
    rewrite ineq.
    clear ...
    move: p2 => [].
    elim => // decl decls ih.
    rewrite in_cons .
    move => /orP [].
    - move => /eqP decl_eq.
      exists [::], decls.
        by rewrite decl_eq.
    - move => /ih  [] decls1' [] decls2' [] eqprf.
      exists [:: decl & decls1'], decls2'.
      apply: f_equal.
        by apply: f_equal. }
  move: p2_eq => [] decls1' [] decls2' eqprf.
  rewrite eqprf.
  constructor.
  move => pi piprf.
  apply: ih => //.
  rewrite -(perm_cons (Interface i (map TyRef pis) ms)).
  apply: perm_trans; [ | apply: perm_trans; [ by exact: permeq | ]].
  - rewrite /decls /=.
      by move: (perm_catCA [:: Interface i (map TyRef pis) ms] decls1 decls2) => ->.
  - rewrite eqprf.
    rewrite /decls /=.
      by move: (perm_catCA [:: Interface i (map TyRef pis) ms] decls1' decls2') => <-.
Qed.

Definition insert decl p := match p with | Decls decls => Decls [:: decl & decls] end.

Lemma ParentsWellFounded_weaken: forall p decl i,
    ParentsWellFounded i p ->
    domain_unique (insert decl p) ->
    ParentsWellFounded i (insert decl p).
Proof.
  move => p decl i.
  elim.
  move: i p => _ _ i decls1 decls2 ps ms wfprf ih uniqueprf.
  rewrite /= -cat_cons.
  constructor.
  move => p inprf.
  apply: ih => //.
  rewrite /insert /= -cat_cons.
  rewrite /domain_unique /domain map_cat cat_uniq.
  apply: (introT andP).
  move: uniqueprf.
  rewrite /domain_unique /domain /insert -cat_cons map_cat cat_uniq.
  move => /andP [] uniqueprf1 /andP [] nhasprf uniqueprf2.
  split => //.
  apply: (introT andP).
  split.
  - apply: (introN hasP).
    move => [] x xindecls2 xindecldecls1.
    move: nhasprf => /(elimN hasP) disprf.
    apply: disprf.
    exists x => //.
      by rewrite map_cons in_cons xindecls2 orbT.
  - move: uniqueprf2.
    rewrite cons_uniq.
      by move => /andP [] _ ->.
Qed.

Lemma insert_perm: forall decls1 decls2 decl,
    perm_eq (decls (insert decl (Decls (decls1 ++ decls2)))) (decls (Decls (decls1 ++ [:: decl & decls2]))).
Proof.
  move => decls1 decls2 decl.
    by rewrite /insert -cat_cons (perm_catCA [:: decl]).
Qed.

Lemma ParentsWellFounded_insert_somewhere: forall decls1 decls2 decl i,
    ParentsWellFounded i (insert decl (Decls (decls1 ++ decls2))) ->
    ParentsWellFounded i (Decls (decls1 ++ [:: decl & decls2])).
Proof.
  move => decls1 decls2 decl i /ParentsWellFounded_perm r.
  apply: r.
    by apply: insert_perm.
Qed.

Lemma ParentsWellFounded_nonempty: forall p i,
    ParentsWellFounded i p ->
    ~nilp (decls p).
Proof.
  move => p i.
  case.
  move => decls1 decls2 ps ms _.
    by rewrite /= /nilp size_cat /= -addn1 addnA addn1  (gtn_eqF (ltn0Sn _)).
Qed.


(* TODO from here... 

Lemma ParentsTrans_wf: forall decls1 decls2 decl pi,
    HasParentTrans (Decls (decls1 ++ [:: decl & decls2])) (name decl) pi ->
    types_unique (Decls (decls1 ++ [:: decl & decls2])) ->
    ParentsWellFounded (name decl) (Decls (decls1 ++ [:: decl & decls2])) ->    
    ParentsWellFounded pi (Decls (decls1 ++ decls2)).
Proof.
  move => decls1 decls2 decl pi.
  set (remdecl := fun ds => match ds with | Decls decls => Decls ((take (length decls1) decls) ++ (drop (1 + length decls1) decls)) end).
  assert (remdecl_eq: (Decls (decls1 ++ decls2) = remdecl (Decls (decls1 ++ decl :: decls2)))).
  { rewrite /remdecl.
      by rewrite take_cat ltnn subnn drop_cat (leq_gtF (leqnSn (length decls1))) (addnK (length decls1) 1) /= drop0 cats0. }
  rewrite remdecl_eq.
    - admit.
    - rewrite /= leqnSn.
    [ | rewrite /= ltnSn ]. -(ltn_predRL (length decls1) (length decls1)) ltn_pred0.
    

  elim.
  - move: pi => _ i pi ipi uniqueprf.
  - move: pi => _ i mid pi _ ih1 _ ih2 uniqueprf wfprf.
    apply: ih2 => //.
    apply: ParentsWellFounded_weaken => //.
      by apply: ih1 => //.
Qed. 



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
    { apply: (HasParentTrans_strengthen _ _ (Interface i pis ms)) => //.
      move => /(clos_trans_t1n _ _ _ _) devil.
      move: devil wfprf uniqueprf.
      clear ...
      rewrite /name.
      case.
      - move: i => _ i.
      - move => 
      move: devil => /clos_t1n_trans.
      



      move: pii piwf uniqueprf.
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

*)



