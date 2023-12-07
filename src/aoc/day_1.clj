(ns aoc.day-1
  (:require [clojure.string :as str]))

(defn is-digit? [char]
  (let [zero (int \0)
        nine (int \9)]
    (<= zero (int char) nine)))

(defn calibration-data
  "Extract calibration values from a string.
  Calibration values are the FIRST and LAST digit in the string."
  [data]
  (let [digit-chars (filter is-digit? (seq data))]
    (->> [(first digit-chars) (last digit-chars)]
         (apply str)
         (Integer/parseInt))))

(comment
  (let [data (with-open [rdr (clojure.java.io/reader "resources/day_1_input.txt")]
               (into [] (line-seq rdr)))]
    (apply + (map calibration-data data))))
