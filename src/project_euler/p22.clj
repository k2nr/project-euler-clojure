(ns project-euler.p22
  (use project-euler.common))

(def names (sort (read-string (str "[" (slurp "src/project_euler/names.txt") "]"))))

(defn score [name]
  (apply + (map #(- (int %) 64) name)))

(defn solve [names]
  (apply +
         (map #(* (score %1) %2)
              names
              (range 1 (inc (count names))))))

(solve names)
