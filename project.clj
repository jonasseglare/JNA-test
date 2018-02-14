(defproject jna-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jvm-opts [~(str "-Djava.library.path=native/:"
                   (System/getenv "LD_LIBRARY_PATH"))]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [net.n01se/clojure-jna "1.0.0"]])
