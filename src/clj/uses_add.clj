(ns uses-add
  (:import acme.Add))

(defn add [& xs]
  (reduce #(Add/add %1 %2) xs))
