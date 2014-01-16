(ns project-euler.p24
  (use project-euler.common))

;; http://nayuki.eigenstate.org/page/next-lexicographical-permutation-algorithm

(defn longest-non-increasing-index [v]
  (loop [i (- (count v) 2)]
    (cond
     (neg? i) nil
     (>= (v i) (v (inc i))) (recur (dec i))
     :else i)))

(defn swap-elements [v n m]
  (if (some neg? [n m])
    v
    (assoc v n (v m) m (v n))))

(defn rightmost-succ-of [v i]
  (if (neg? i)
    0
    (loop [e (v i)
           j (dec (count v))]
      (if (> (v j) e)
        j
        (recur e (dec j))))))

(defn next-lex-permutation [v]
  (let [pivot (longest-non-increasing-index v)]
    (if (nil? pivot)
      nil
      (let [rightmost-succ (rightmost-succ-of v pivot)
            swaped-v (swap-elements v pivot rightmost-succ)
            splits (split-at (inc pivot) swaped-v)]
        (vec (concat (first splits) (reverse (second splits))))))))

(defn iterate' [f x]
  "like iterate but stops when f returns nil"
  (when x (cons x (lazy-seq (iterate' f (f x))))))

(defn solve []
  (let [perms (iterate' next-lex-permutation [0 1 2 3 4 5 6 7 8 9])
        result (nth perms 999999)]
    (apply str result)))

(solve)

