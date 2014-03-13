package s2g.ast

import s2g.eval.{EvaluationState, PartialSolution}

trait Subgoal {
  def solveOn(partialSolution: PartialSolution, evaluationState: EvaluationState): Set[PartialSolution]
}
