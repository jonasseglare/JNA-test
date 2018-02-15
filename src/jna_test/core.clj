(ns jna-test.core
  (:import [com.sun.jna Native Pointer])
  (:require [net.n01se.clojure-jna :as jna]
            ))

;;; This does not seem to be needed.
(defn load-library []
  (System/loadLibrary "test"))

(defn invoke-it [n] 
  (jna/invoke Double test/nthFib n))

(defn time-example []
  (time (dotimes [i 1000]
          (invoke-it i))))


(defmacro jna-call [lib ;;keyword
                    func ;; string
                    ret ;; return value
                    & args ;; any types
                    ] 
  `(let [library#  (name ~lib)
         function# (com.sun.jna.Function/getFunction library# ~func)] 
     (.invoke function# ~ret (to-array [~@args]))))

  ;; https://nakkaya.com/2009/11/16/java-native-access-from-clojure/
(defmacro jna-malloc [size] 
  `(let [buffer# (java.nio.ByteBuffer/allocateDirect ~size)
         pointer# (Native/getDirectBufferPointer buffer#)]
     (.order buffer# java.nio.ByteOrder/LITTLE_ENDIAN)
     {:pointer pointer# :buffer buffer#}))

(defn get-value-pair []
  (let [struct (jna-malloc 8)
        result (jna/invoke Integer test/outputValuePairToBuffer (:pointer struct))

        ]
    (println "result=" result)
    (merge struct 
           {:x (.getInt (:buffer struct) 0)
            :y (.getFloat (:buffer struct) 4)})))

(defn get-value-pair-2 []
  (let [result (jna/invoke Pointer test/getValuePairPointer)]
    (println "result=" result)
    (.getInt result 0)))

(println "Property"
         (System/getProperty "jna.library.path"))
