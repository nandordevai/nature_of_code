(ns random-walker
  (:use quil.core))

(defn draw []
  (no-loop)
  (background 255)
  (with-translation [(/ (width) 2) (/ (height) 2)]
    (loop [i 0
           x 0
           y 0]
      (when (< i 10000)
        (point x y)
        (def move (floor (random 9)))
        (recur
          (inc i)
          (case (mod move 3)
            0 (dec x)
            1 x
            2 (inc x))
          (cond
            (< move 3) (dec y)
            (> move 5) (inc y)
            :else y))))))

(defsketch random-walker
  :size [300 300]
  :draw draw)
