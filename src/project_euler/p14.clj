(ns project-euler.p14
  (use project-euler.common))

(def collatz-seq (fn [start]
                   (loop [n start, res 1]
                     (cond
                      (= n 1) res
                      (even? n) (recur (/ n 2) (+ res 1))
                      :else (recur (inc (* n 3)) (+ res 1))))))

(defn solve []
  (let [max (fn max
              ([x y] (if (< (first x) (first y)) y x))
              ([x y & more]
                 (reduce max (cons (max x y) more))))]
    (apply max (map (fn [x] [(collatz-seq x) x]) (range 2 1000000)))))
