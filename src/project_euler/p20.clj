(ns project-euler.p20
  (use project-euler.common))

(defn factorial [n]
  (reduce * 1N (range 1N (inc n))))

(defn solve [n]
  (reduce + (map #(- (int %) 48)(str (factorial n)))))

(solve 100)
