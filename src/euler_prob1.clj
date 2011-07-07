(ns prob1)

(defn main []
  (let [num (filter
             (fn [x] (or (integer? (/ x 3)) (integer? (/ x 5))))
             (range 1 1000)) ]
    (reduce
     +
     0 num)))
