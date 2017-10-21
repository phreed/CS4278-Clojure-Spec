

(def project 'phreed/CS4278-Clojure-Spec)
(def version "2017.10.20-SNAPSHOT")

(set-env! :resource-paths #{"resources"}
          :source-paths   #{"src/cljc"}
          :dependencies '[ [org.clojure/clojure "RELEASE"]
                           [org.clojure/spec.alpha "0.1.134"]
                           [org.clojure/test.check "0.9.0" :scope "test"]
                           [boot/core "RELEASE" :scope "test"]
                           [samestep/boot-refresh "0.1.0" :scope "test"]])
  
(require '(clojure [pprint :as pp])
          '(spec-sort 
              [syntax :as syn] 
              [functional :as fun]
              [messages :as msg])
          '[clojure.spec.alpha :as s]
          '[clojure.spec.gen.alpha :as gen]
          '[clojure.spec.test.alpha :as stest]
          '[samestep.boot-refresh :refer [refresh]])


(deftask live-repl 
  []
  (comp 
    (repl :server true)
    (watch)
    (refresh)))
 
