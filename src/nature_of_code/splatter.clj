(ns splatter
  (:use quil.core))

(defn setup []
  (background 255)
  (no-stroke))

(defn draw []
  (no-loop)
  (def r 20)
  (def sd 55)
  (with-translation [(/ (width) 2) (/ (height) 2)]
    (loop [i 0]
      (when (< i 200)
        (let [x (int (* sd (random-gaussian)))
              y (int (* sd (random-gaussian)))])
        (fill 120 (+ 100 x) (+ 170 y) 200)
        (ellipse x y r r)
        (recur (inc i))))))

(defsketch s
  :size [800 600]
  :draw draw
  :settings #(.pixelDensity (quil.applet/current-applet) (.displayDensity (quil.applet/current-applet)))
  :setup setup)
