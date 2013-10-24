(ns project-euler.p6
  (use project-euler.common))

(defn solve []
  (- (Math/pow (apply + (range 1 101)) 2)
     (apply + (map #(Math/pow % 2) (range 1 101)))))
