(ns project-euler.p25
  (use project-euler.common))

(defn my-fibs
  ([] (concat [1N 1N] (my-fibs 1N 1N)))
  ([a b] (cons (+ a b) (lazy-seq (my-fibs b (+ a b))))))

(defn solve [digits]
  (first (filter #(<= digits (count (str (% 0))))
                 (map #(vector %1 %2) (my-fibs) (rest (range))))))

((solve 1000) 1)
