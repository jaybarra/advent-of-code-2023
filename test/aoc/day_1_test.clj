(ns aoc.day-1-test
  (:require [aoc.day-1 :as day1]
            [clojure.java.io :as io]
            [clojure.test :refer [deftest testing is use-fixtures]]))

(def day-1-sample
  (with-open [rdr (io/reader "resources/day_1_sample.txt")]
    (into [] (line-seq rdr))))

(def day-1-input
  (with-open [rdr (io/reader "resources/day_1_input.txt")]
    (into [] (line-seq rdr))))

(deftest calibration-extraction
  (testing "simple"
    (is (= 12 (day1/calibration-data (first day-1-sample)))))

  (testing "complex"
    (is (= [12 38 15 77] (map day1/calibration-data day-1-sample)))
    (is (= 142 (apply + (map day1/calibration-data day-1-sample)))))

  (testing "live data"
    (is (= 54601 (apply + (map day1/calibration-data day-1-input))))))
