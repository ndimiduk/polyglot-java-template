# polyglot-java

A Leiningen template for polyglot (Clojure, Java) projects.

To learn more about Leiningen templates, check out the [documentation][0].

## Installation

In order to use it, the template must be on lein's classpath. The easiest way
to make that happen is to install it locally. Checkout the source and install
the template into your local maven cache.

    $ git clone https://github.com/ndimiduk/polyglot-java-template.git
    $ cd polyglot-java-template
    $ lein install
    Created target/lein-template-0.1.0.jar
    Wrote pom.xml
    
It won't show up in the help listing, but it's there. To confirm:

    $ ls ~/.m2/repository/polyglot-java/lein-template/
    0.1.0                      maven-metadata-local.xml   resolver-status.properties

## Usage

Start by creating your new project using this template.

    $ lein new polyglot-java foo
    Generating fresh 'lein new' polyglot-java project.
    $ cd foo

This creates a maven-compatible project structure containing some default
files.

    $ find .
    .
    ./.gitignore
    ./LICENSE
    ./project.clj
    ./README.md
    ./src
    ./src/main
    ./src/main/clj
    ./src/main/clj/foo
    ./src/main/clj/foo/world.clj
    ./src/main/java
    ./src/main/java/foo
    ./src/main/java/foo/Hello.java
    ./src/test
    ./src/test/clj
    ./src/test/clj/foo_test.clj

Compile the sample files like so.

    $ lein javac
    Compiling 1 source files to /path/to/foo/target/classes

Now you can fire up a repl and invoke your Java class `Hello` from Clojure.

    nREPL server started on port 50035 on host 127.0.0.1
    REPL-y 0.3.0
    Clojure 1.5.1
        Docs: (doc function-name-here)
              (find-doc "part-of-name-here")
      Source: (source function-name-here)
     Javadoc: (javadoc java-object-or-class-here)
        Exit: Control+D or (exit) or (quit)
     Results: Stored in vars *1, *2, *3, an exception in *e
    
    user=> (require '[foo.world :refer [intro]])
    nil
    user=> (source intro)
    (defn intro
      "invoke me from the repl to see your Java code at work!"
      []
      (println (Hello/message)))
    nil
    user=> (intro)
    Hello from foo
    nil

You also get a Clojure test to start from. It's broken by default, of course.
Go fix it.

    $ lein test
    
    lein test foo-test
    
    lein test :only foo-test/a-test
    
    FAIL in (a-test) (foo_test.clj:7)
    FIXME, I fail.
    expected: (= 0 1)
      actual: (not (= 0 1))
      
      Ran 1 tests containing 1 assertions.
      1 failures, 0 errors.
      Tests failed.

## License

Copyright © 2014 Nick Dimiduk

Distributed under the Apache License, version 2.0.

[0]: https://github.com/technomancy/leiningen/blob/master/doc/TEMPLATES.md
