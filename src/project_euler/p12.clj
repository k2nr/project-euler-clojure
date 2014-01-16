(ns project-euler.p12
  (use project-euler.common))

(defn triangles
  ([] (triangles 1 2))
  ([n m] (cons n (lazy-seq (triangles (+ n m) (inc m))))))

(defn divisors [n] (* 2 (count (filter #(zero? (rem n %))
                                       (range 1 (Math/sqrt n))))))

(defn solve []
  (first (filter #(> (divisors %) 500) (triangles))))

(solve)
