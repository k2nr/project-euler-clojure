(ns project-euler.p26
  (use project-euler.common))

(defn max-prime-factor [n]
  (apply max (prime-factors n)))

(defn divisors [n]
  (filter #(integer? (/ n %)) (range 1 (inc n))))

(defn prime? [n]
  (= 1 (count (prime-factors n))))

(defn recurring-cycle-length [n]
  (if (prime? n)
    (apply max (divisors (dec n)))
    (dec (max-prime-factor n))))

(defn solve []
  (apply max-key :len (map (fn [n] {:num n :len (recurring-cycle-length n)})
        (range 3 1000))))

(solve)
