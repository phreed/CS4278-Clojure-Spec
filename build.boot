

(def project 'juleswhite/clojure-spec-demo)
(def version "2017.10.20-SNAPSHOT")

(set-env! :resource-paths #{"resources"}
          :source-paths   #{"src/cljc"}
          :dependencies '[ [org.clojure/clojure "RELEASE"]
                           [org.clojure/spec.alpha "0.1.134"]
                           [org.clojure/test.check "0.9.0" :scope "test"]
                           [boot/core "RELEASE" :scope "test"]])
                            
(deftask live 
  []
  (comp 
    (watch)
    ; (run-spec)
    (target :dir #{"target"})))
    
(require '(spec-sort 
             [syntax :as syn] 
             [functional :as fun])
         '[clojure.spec.alpha :as s]
         '[clojure.spec.gen.alpha :as gen]
         '[clojure.spec.test.alpha :as stest])
