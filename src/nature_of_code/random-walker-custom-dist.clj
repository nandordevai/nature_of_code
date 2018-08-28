(ns random-walker
  (:use quil.core))

(defn random-step []
  (loop []
    (def r (floor (random 3)))
    (def p (floor (random 3)))
    (if (< r p)
      r
      (recur))))

(defn draw []
  (no-loop)
  (background 255)
  (with-translation [(/ (width) 2) (/ (height) 2)]
    (loop [i 0
           x 0
           y 0]
      (when (< i 100000)
        (point x y)
        (def move (floor (random 9)))
        (def step (random-step))
        (recur
          (inc i)
          (case (mod move 3)
            0 (- x step)
            1 x
            2 (+ x step))
          (cond
            (< move 3) (- y step)
            (< move 6) (+ y step)
            :else y))))))

(defsketch random-walker
  :size [600 600]
  :draw draw)
