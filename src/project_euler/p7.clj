(ns project-euler.p7
  (use project-euler.common))

(defn solve []
  (map first (iterate (fn [x]
                        (let [p (first x)]
                          (filter #(not= (mod % p) 0) x)))
                      (drop 2 (range)))))
