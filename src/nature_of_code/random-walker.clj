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
        (def move (floor (random 4)))
        (recur
          (inc i)
          (case move
            0 (inc x)
            1 (dec x)
            x)
          (case move
            2 (inc y)
            3 (dec y)
            y))))))

(defsketch random-walker
  :size [300 300]
  :draw draw)
