(ns project-euler.p23
  (use project-euler.common))

(defn divisors [n]
  (filter #(integer? (/ n %)) (range 1 n)))

(defn abundant? [n]
  (< n (apply + (divisors n))))

(def abundant-numbers (filter abundant? (range 1 28124)))
(def abundant-sums (into #{} (for [n abundant-numbers
                                   m abundant-numbers]
                               (+ n m))))

(defn non-abundant-sums []
  (filter (fn [m] (not (abundant-sums m)))
          (range 1 28124)))

(apply + (non-abundant-sums))
