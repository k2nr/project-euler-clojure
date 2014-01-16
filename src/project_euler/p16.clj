(ns project-euler.p16
  (use project-euler.common))

(defn solve [n]
  (reduce + (map (fn [c] (Integer. (str c))) (str (reduce * 1N (repeat n 2N))))))

(solve 1000)
