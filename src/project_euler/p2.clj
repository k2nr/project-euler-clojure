(ns project-euler.p2
  (use project-euler.common))

(defn solve []
  (apply + (take-while (partial >= 4000000) (filter even? fibs))))
