(ns project-euler.p21
  (use project-euler.common))

(defn divisors-raw [n]
  (filter #(integer? (/ n %)) (range 1 n)))

(def divisors (memoize divisors-raw))

(defn amicable? [n m]
  (and (not (= n m))
       (= n (reduce + (divisors m)))
       (= m (reduce + (divisors n)))))

(defn amicables [ceil]
  (into #{}
        (apply concat (for [i (range 1 (inc ceil))
                            j (range 1 (inc ceil))
                            :when (and (> i j) (amicable? i j))]
                        [i j]))))

(defn solve [n]
  (reduce + (amicables n)))

(solve 10000)
