
(ns spec-sort.syntax 
    "a demonstration of specing syntax
    syntax : ordered data" 
    (:require 
        (clojure [pprint :as pp])
        #?(:clj  [clojure.spec.alpha :as s]
           :cljs [cljs.spec.alpha :as s])
        #?(:clj  [clojure.spec.gen.alpha :as gen]
           :cljs [cljs.spec.gen.alpha :as gen])
        #?(:clj  [clojure.spec.test.alpha :as test]
           :cljs [cljs.spec.test.alpha :as test])))
     
(s/def ::a int?)
(s/def ::b int?)
(s/def ::c int?)
(s/def ::even? (s/and int? even?))
(s/def ::odd? (s/and int? odd?))

(s/def ::syntax 
    (s/cat
        :fourty-two #{42} 
        :odd (s/+ ::odd?)
        :m (s/keys :req-un [::a ::b ::c])
        :oes (s/& 
                (s/* (s/cat :o ::odd? :e ::even?)) 
                #(< (count %) 3))
        :ex (s/* (s/alt :o ::odd? :e ::even?))))

(def syntax-samples
    [ [42 11 13 15 {:a 1} 1 2 3 42 43 44 11]
      [42 11 13 15 {:a 1 :b 2 :c 3} 1 2 3 42 43 44 11]])

(defn check-samples [spec sample-s]
    (for [sample sample-s] 
        (if (s/valid? ::syntax sample)
            (pp/pprint (s/conform ::syntax sample))
            (s/explain ::syntax sample))))

(defn exercise-syntax [] (s/exercise ::syntax))
