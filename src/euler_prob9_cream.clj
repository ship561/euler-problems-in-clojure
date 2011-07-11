(ns constraint-pythagorian
  (:import [jp.ac.kobe_u.cs.cream Network
           IntVariable
           DefaultSolver
           Solution]))

(defn main []
  (let [net (new Network)
        a (new IntVariable net)
        b (new IntVariable net)
        c (new IntVariable net)
        sum (new IntVariable net)]
    (.ge a 3)
    (.le a 500)
    (.ge b 4)
    (.le b 500)
    (.ge b a)
    (.ge c b)
    (.ge (.add a b) c)
    (.equals sum 1000)
    (.equals c (.subtract sum (.add a b)))
    (.equals (.multiply c c) (.add (.multiply a a) (.multiply b b)))
    (let [solver (new DefaultSolver net)
          solution (.findFirst solver)
          av (.getIntValue solution a)
          bv (.getIntValue solution b)
          cv (.getIntValue solution c)]
      ;;(prn "net=\n"  net)
      ;;(prn "a=" av "b=" bv "c=" cv)))
      [av bv cv]))
  )
