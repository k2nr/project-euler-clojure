(ns project-euler.p9
  (require [clojure.tools.trace :as tr])
  (use project-euler.common))

(defn solve []
  (let [cs (for [i (range 1 1000)
                 j (range 1 1000)
                 k (range 1 1000)
                 :when (= (+ i j k) 1000)]
             [i j k])]
    (apply * (tr/trace (some (fn [[i j k :as seq]]
                      (if (= (+ (* i i) (* j j)) (* k k)) seq)) cs)))))
