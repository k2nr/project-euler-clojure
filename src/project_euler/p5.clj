(ns project-euler.p5
  (require [clojure.math.numeric-tower :as numeric])
  (use project-euler.common))

(defn solve []
  (reduce numeric/lcm (range 1 21)))
