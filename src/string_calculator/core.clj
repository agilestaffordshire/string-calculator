(ns string-calculator.core)

(defn extract-numbers [the-string]
  (map read-string
    (re-seq #"[\d]+|[-\d]+" the-string )))

(defn validate [numbers]
  (if
    (empty?
      (filter neg? numbers))
        numbers
        (throw (Exception. "Negative numbers not allowed"))))

(defn add [numbers]
  (reduce + numbers))

(defn calculate [the-string]
  (if (empty? the-string)
    0
    (add (filter #(< % 1001) (validate(extract-numbers the-string))))))
