(ns gaussian-dist
  (:use quil.core))

(defn setup []
  (background 255))

(defn draw []
  (no-loop)
  (loop [i 0]
    (when (< i 1000)
      (def x (random-gaussian))
      (no-stroke)
      (fill-float 0 10)
      (ellipse (int (+ 320 (* 60 x))) 180 16 16)
      (recur (inc i)))))

(defsketch s
  :size [640 360]
  :draw draw
  :setup setup)
