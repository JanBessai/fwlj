From mathcomp Require Import all_ssreflect.
Require Import Coq.Strings.Ascii.
Require Import Coq.Strings.String.
Set Bullet Behavior "Strict Subproofs".
Import EqNotations.

Record UserIdent: Set := Name { identifier: string }.

Section MathcompInstances.

  Definition string2seq (s: string) := map nat_of_ascii (list_ascii_of_string s).
  Definition seq2string (l: seq nat) := string_of_list_ascii (map ascii_of_nat l).

  Lemma can_string2seq: cancel string2seq seq2string.
  Proof.
    move => s.
    rewrite /string2seq /seq2string.
    rewrite mapK.
    - by apply: string_of_list_ascii_of_string.
    - by apply: ascii_nat_embedding.
  Qed.

  Definition string_eqMixin := CanEqMixin can_string2seq.
  Canonical string_eqType := EqType string string_eqMixin.
  Definition string_choiceMixin := CanChoiceMixin can_string2seq.
  Canonical string_choiceType := ChoiceType string string_choiceMixin.
  Definition string_countMixin := CanCountMixin can_string2seq.
  Canonical string_countType := CountType string string_countMixin.

  Definition UserIdent2string (id: UserIdent): string := (identifier id).
  Definition string2UserIdent(id: string): UserIdent := Name id.

  Lemma can_UserIdent2string: cancel UserIdent2string string2UserIdent.
  Proof.
      by case.
  Qed.

 Definition UserIdent_eqMixin := CanEqMixin can_UserIdent2string.
 Canonical UserIdent_eqType := EqType UserIdent UserIdent_eqMixin.
 Definition UserIdent_choiceMixin := CanChoiceMixin can_UserIdent2string.
 Canonical UserIdent_choiceType := ChoiceType UserIdent UserIdent_choiceMixin.
 Definition UserIdent_countMixin := CanCountMixin can_UserIdent2string.
 Canonical UserIdent_countType := CountType UserIdent UserIdent_countMixin.

End MathcompInstances.

