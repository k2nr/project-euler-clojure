(ns project-euler.p67
  (require [project-euler.p18 :as p18]
           [clojure.string :as s])
  (use project-euler.common))

(defn solve []
  (let [data (-> (slurp "src/project_euler/triangle.txt")
                 (s/replace #"0([1-9])" "$1")
                 (s/split #"\n"))
        pyr (for [s data] (eval (read-string (str "[" s "]"))))]
    (p18/solve-triangle pyr)))
