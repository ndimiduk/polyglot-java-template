(ns leiningen.new.polyglot-java
  (:require [leiningen.new.templates :refer [->files multi-segment name-to-path
                                             project-name renderer sanitize-ns
                                             year]]
            [leiningen.core.main :as main]))

(defn polyglot-java
  "A template for polyglot (Clojure, Java) projects."
  [name]
  (let [render (renderer "polyglot-java")
        main-ns (sanitize-ns name)
        world-ns (multi-segment main-ns "world")
        data {:raw-name name
              :name (project-name name)
              :namespace main-ns
              :world-ns world-ns
              :nested-dirs (name-to-path main-ns)
              :year (year)}]
    (main/info "Generating fresh 'lein new' polyglot-java project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render "gitignore" data)]
             ["src/main/java/{{nested-dirs}}/Hello.java" (render "Hello.java" data)]
             ["src/main/clj/{{nested-dirs}}/world.clj" (render "world.clj" data)]
             ["src/test/clj/{{nested-dirs}}_test.clj" (render "test.clj" data)]
             ["LICENSE" (render "LICENSE" data)])))
