(ns spec-sort.functional 
   "a demonstration of specing functions" 
    (:require 
        (clojure [pprint :as pp])
        #?(:clj  [clojure.spec.alpha :as s]
           :cljs [cljs.spec.alpha :as s])
        #?(:clj  [clojure.spec.gen.alpha :as gen]
           :cljs [cljs.spec.gen.alpha :as gen])
        #?(:clj  [clojure.spec.test.alpha :as stest]
           :cljs [cljs.spec.test.alpha :as stest])))  

(defn ranged-rand 
    "returns a random int in the range start <= val < end"
    [start end]
    (+ start (long (rand (- end start)))))

;; args are typically regex because they are syntactic
(s/fdef ranged-rand 
    :args (s/and 
            (s/cat :start int? :end int?)
            #(< (:start %) (:end %)))
    :ret int? 
    :fn (s/and
            #(>= (:ret %) (-> % :args :start)) 
            #(< (:ret %) (-> % :args :end))))


(defn exercise [] 
    ; (pp/pprint 
        (s/exercise-fn `ranged-rand))              

;; 1K test.checks you do not have to write
;; with SHRINKING
(defn run-check [] 
    (-> `ranged-rand stest/check stest/summarize-results))

(stest/instrument `ranged-rand)

