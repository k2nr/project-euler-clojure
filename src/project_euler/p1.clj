(ns project-euler.p1
  (use [project-euler.common]))

(defn solve []
  (apply + (filter #(or (zero? (mod % 3)) (zero? (mod % 5))) (range 1 1000))))
