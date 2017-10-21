(ns spec-sort.messages 
    "a demonstration of specing the class project" 
    (:require 
        (clojure [pprint :as pp])
        #?(:clj  [clojure.spec.alpha :as s]
           :cljs [cljs.spec.alpha :as s])
        #?(:clj  [clojure.spec.gen.alpha :as gen]
           :cljs [cljs.spec.gen.alpha :as gen])
        #?(:clj  [clojure.spec.test.alpha :as test]
           :cljs [cljs.spec.test.alpha :as test])))
     
(s/def ::msg string?)
(s/def ::time int?)

(s/def ::name string?)
(s/def ::nickname string?)
; (s/def ::user (s/keys :req [::name ::nickname]))
(s/def ::user (s/keys :req-un [::name ::nickname]))

; (s/def ::message (s/keys :req [::msg ::time ::user]))
(s/def ::message (s/keys :req-un [::msg ::time ::user]))

(s/def ::thread (s/coll-of ::message :kind vector?)) 
(s/def ::thread-s (s/map-of string? ::thread)) 

(def thread-sample-s
    {"default" [{:msg "CS 4278" :time 1 
                 :user {:name "Your Name" :nickname "You"}}
                {:msg "vandy" :time 1 
                 :user {:name "Your Name" :nickname "You"}}]
     "food" [{:msg "Eat at fido" :time 1 
              :user {:name "Me" :nickname "Me"}}]
     "vandy" [{:msg "Visit the Wondr'y" :time 1 
               :user {:name "Your Name" :nickname "Bob"}}]})
