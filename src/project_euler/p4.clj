(ns project-euler.p4
  (require [clojure.string :as s])
  (use project-euler.common))

(defn solve []
  (defn- palindromic? [n]
    (let [str-n (str n)]
      (= str-n (s/reverse str-n))))

  (let [muls (for [i (range 100 1000)
                   j (range 100 1000)
                   :let [k (* i j)] :when (palindromic? k)]
               k)]
    (apply max muls)))
