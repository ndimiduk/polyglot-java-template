(defproject {{raw-name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :min-lein-version  "2.0.0"
  :url "http://example.com/FIXME"
  :license {:name "Apache License, Version 2.0"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]]
  :source-paths ["src/main/clj"]
  :test-paths ["src/test/clj"]
  :java-source-paths ["src/main/java"]
  :javac-options ["-target" "1.6" "-source" "1.6"])
