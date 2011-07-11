(ns pythagorian
  (:use clojure.contrib.math))

(defn pythagorian-triple [a b c]
  (= (* c c) (+ (expt a 2) (expt b 2))))

(defn calc []
  (for [a (range 3 497)
        b (range (+ a 1) 498)]
    (let [c (- 1000 a b)]
      (when (and (pythagorian-triple a b c ) (< a b c))
        [a b c]))
    ))

(remove nil? (calc))

