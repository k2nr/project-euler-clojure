(ns project-euler.p10
  (use project-euler.common))

(defn solve []
  (apply + (take-while #(< % 2e6) primes)))
