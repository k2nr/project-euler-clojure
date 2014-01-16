(ns project-euler.p30
  (use project-euler.common))

(defn pow [a b]
  (if (zero? b)
    1
    (reduce * (repeat b (bigint a)))))

(def ceil (* 6 (pow 9 5)))

(defn each-digits-fifth-power [n]
  (map #(pow (- (int %) 48) 5) (str n)))

(defn sum-of-fifth-powers [n]
  (apply + (each-digits-fifth-power n)))

(defn same? [n]
  (= (sum-of-fifth-powers n) n))

(defn solve []
  (apply + (filter same? (range 2 (inc ceil)))))

(solve)
