(ns random-walker
  (:use quil.core))

(defn draw []
  (no-loop)
  (background 255)
  (with-translation [(/ (width) 4) (/ (height) 2)]
    (loop [i 0
           x 0
           y 0]
      (when (< i 10000)
        (point x y)
        (def move (floor (random 12)))
        (recur
          (inc i)
          (case (mod move 4)
            0 (dec x)
            1 x
            (2 3) (inc x))
          (cond
            (< move 4) (dec y)
            (< move 8) (inc y)
            :else y))))))

(defsketch random-walker
  :size [600 300]
  :draw draw)
