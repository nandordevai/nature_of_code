(ns random-walker
  (:use quil.core))

(defn draw []
  (background 255)
  (with-translation [(/ (width) 2) (/ (height) 2)]
    (loop [i 0]
      (when (< i 1000)
        (point (+ x (round (random -1 1))) (+ y (round (random -1 1))))
        (recur (inc i))))))

(defsketch trigonometry
  :size [300 300]
  :draw draw)
