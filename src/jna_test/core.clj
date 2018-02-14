(ns jna-test.core
  (:require [net.n01se.clojure-jna :as jna]))

(defn load-library []
  (System/loadLibrary "test"))

(defn invoke-it [n] 
  (jna/invoke Double test/nthFib n))

(println "Property"
         (System/getProperty "jna.library.path"))
