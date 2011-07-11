(ns choco-pythagorian
 (:import choco.Choco)
 (:import choco.kernel.model.variables.integer.IntegerVariable)
 (:import choco.cp.model.CPModel)
 (:import (choco.kernel.model Model
                              constraints.Constraint))
 (:import choco.kernel.solver.Solver)
 (:import choco.cp.solver.CPSolver))

(defn main []
  (let [a (Choco/makeIntVar (str "a") 3 500 (into-array [""]))
        b (Choco/makeIntVar (str "b") 4 500 (into-array [""]))
        c (Choco/makeIntVar (str "c") 5 1000 (into-array [""]))
        triple (Choco/eq (Choco/plus (Choco/mult a a) (Choco/mult b b)) (Choco/mult c c))
        m (new CPModel)]
    (.addConstraint m triple)
    (.addConstraint m (Choco/eq (Choco/minus 1000 (Choco/plus a b)) c))
    (.addConstraint m (Choco/lt a b))
    (.addConstraint m (Choco/lt b c))
    (.addConstraint m (Choco/gt (Choco/plus a b) c))
    (let [s (new CPSolver)]
      (.read s m)
      (.solve s)
      (prn (.getVal (.getVar s a)) (.getVal (.getVar s b)) (.getVal (.getVar s c))))))
  
