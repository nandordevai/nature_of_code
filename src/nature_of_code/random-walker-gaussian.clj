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
        (def d (* 2 (random-gaussian)))
        (point x y)
        (def move (floor (random 9)))
        (recur
          (inc i)
          (case (mod move 3)
            0 (- x d)
            1 x
            2 (+ x d))
          (cond
            (< move 3) (- y d)
            (< move 6) (+ y d)
            :else y))))))

(defsketch random-walker
  :size [600 300]
  :draw draw)
