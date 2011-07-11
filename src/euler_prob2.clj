(ns prob-2)

(def fibs (lazy-cat [1 1]
                    (map + fibs (rest fibs))))

(defn main []
  (reduce + 0 (filter even? (take-while #(< %1 4000000) fibs))))
