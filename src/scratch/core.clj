(ns scratch.core
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [incanter.stats :as stats]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(def dfa '{:states #{q0 q1 q2 q3}
           :alphabet #{a b c}
           :start q0
           :accepts #{q1 q2 q3}
           :transitions {q0 {a q1}
                         q1 {b q2}
                         q2 {c q3}}})

(def dfa2 '{:states #{q0 q1 q2 q3 q4 q5 q6 q7}
            :alphabet #{e h i l o y}
            :start q0
            :accepts #{q2 q4 q7}
            :transitions {q0 {h q1}
                          q1 {i q2, e q3}
                          q3 {l q5, y q4}
                          q5 {l q6}
                          q6 {o q7}}})

(defn enum-dfa [d]
  (loop [state (:start d)
         out #{}
         ]))

(def date-formatter (f/formatter "yyyy-MM-dd"))
(defn date-pair [start offset length]
  [(f/unparse date-formatter (t/plus start (t/days offset)))
   (f/unparse date-formatter (t/plus start (t/days (+ offset length))))])


(defn list-dates []
  (let [today (t/now)]
    (for [start-offset (range 90)
          los (range 1 4)]
      (date-pair today start-offset los))))

(defn init-rates [udicodes]
  (reduce (fn [m u] (assoc m u [])) {} udicodes))


(def rates {"123" [[1.0 1.0 2.0] [2.0 nil 3.0]] "244" [[1.0 1.2 1.3] [nil 4.0 5.0]]})


