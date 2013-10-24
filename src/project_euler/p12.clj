(ns project-euler.p12
  (use project-euler.common))

(def triangles (lazy-cat [0] (map + triangles (iterate inc 1))))

(defn divisors [n] (* 2 (count (filter #(zero? (rem n %))
                                       (range 1 (Math/sqrt n))))))

(defn solve []
  (first (filter #(> (divisors %) 500) triangles)))
