(ns project-euler.p29
  (use project-euler.common))

(defn pow [a b]
  (reduce * (repeat b (bigint a))))

(defn solve [ra rb]
  (count (into #{} (for [i ra, j rb] (pow i j)))))

(solve (range 2 101) (range 2 101))
