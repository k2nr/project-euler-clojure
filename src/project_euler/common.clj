(ns project-euler.common)

(def fibs (lazy-cat [0 1] (map + (rest fibs) fibs)))

(def primes (lazy-cat [2 3] ((fn f [n [x & xs]]
                                 (if (some #(zero? (mod n %))
                                           (take-while #(<= (* % %) n) primes))
                                   (recur (+ n x) xs)
                                   (lazy-seq (cons n (f (+ n x) xs))))) 5 (cycle [2 4]))))

(defn prime-factors [n]
  (let [ps (filter #(= (mod n %) 0) (take-while #(<= % n) primes))]
    (if (= n 1)
      '()
      (lazy-cat ps (prime-factors (/ n (apply * ps)))))))
