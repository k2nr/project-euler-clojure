(ns project-euler.p27
  (use project-euler.common))

(defn make-f [a b]
  #(+ (* % %) (* a %) b))

(def prime? (memoize (fn [n]
                       (= (count (prime-factors n)) 1))))

(defn find-consecutive-n [f]
  (count (take-while prime? (map f (range)))))

(defn n-and-coeffs [ra rb]
  (for [i ra, j rb]
    {:n (find-consecutive-n (make-f i j))
     :coeffs [i j]}))

(defn find-max-coefficients
  ([] (find-max-coefficients (range -999 1000) (range -999 1000)))
  ([ra rb] (apply max-key :n (n-and-coeffs ra rb))))

(defn solve [ra rb]
  (let [res (find-max-coefficients ra rb)]
    (prn res)
    (apply * (:coeffs res))))

(solve (range -999 1000) (range -999 1000))
