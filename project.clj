(defproject leiningen.org "1.0.0"
    :description "Generate static HTML for https://leiningen.org"
    :dependencies [[org.clojure/clojure "RELEASE"
                    [org.clojure/spec.alpha "0.1.134"]
                    [org.clojure/test.check "0.9.0"]]]
    :source-paths ["src/cljc"] 
    :repl-options 
       { :init (require '(clojure [pprint :as pp])
                        '(spec-sort 
                            [syntax :as syn] 
                            [functional :as fun]
                            [messages :as msg])
                        '[clojure.spec.alpha :as s]
                        '[clojure.spec.gen.alpha :as gen]
                        '[clojure.spec.test.alpha :as stest])})
                        
    
   


