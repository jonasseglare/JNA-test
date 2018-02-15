(ns jna-test.core
  (:require [net.n01se.clojure-jna :as jna]))

;;; This does not seem to be needed.
(defn load-library []
  (System/loadLibrary "test"))

(defn invoke-it [n] 
  (jna/invoke Double test/nthFib n))

(defn time-example []
  (time (dotimes [i 1000]
          (invoke-it i))))

(println "Property"
         (System/getProperty "jna.library.path"))
