(ns prob39)

(defn right? [a b c]
  (= (* c c) (+ (* a a) (* b b))))

(defn solution [p]
  (remove nil?
          (for [a (range 3 (int (/ p 2)))
                b (range a (int (+ 1 (/ p 2))))]
            (let [c (- p a b)]
              (when (right? a b c) [a b c])))))

(defn makemap [r]
  (reduce (fn [m p]
            (assoc m p (solution p)))
          {}  (range r)))

(defn main []
  (loop [i (makemap 1001)
         cur_max [0 0]]
    (if (not (empty? i))
      (recur (rest i)
             (if (< (first cur_max) (count (val (first i))))
               [(count (val (first i))) (first i)]
               cur_max))
      (prn "max=" (first cur_max) "triangles=" (second cur_max)))))
