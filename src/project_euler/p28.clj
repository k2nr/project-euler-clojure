(ns project-euler.p28
  (use project-euler.common))

(defn diagonal-seq-steps []
  (mapcat #(repeat 4 %) (iterate #(+ 2 %) 2)))

(defn diagonal-seq
  ([] (diagonal-seq 1 (diagonal-seq-steps)))
  ([sum [a & more]] (cons sum (lazy-seq (diagonal-seq (+ sum a) more)))))

(defn solve [n]
  (let [steps (dec (* n 2))]
    (reduce + (take steps (diagonal-seq)))))

(solve 1001)
