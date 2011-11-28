(def jetty-version "8.0.3.v20111011")

(defproject firstweb "1.0.0-SNAPSHOT"
  :description "web project using clojure and jetty"
  :java-source-path "src/main/java" 
  :java-fork true 
  :javac-target "1.5"
  :source-path "src/main/clojure"
  :test-path "src/test/clojure"
  :aot [studywebapp.core]
  :main studywebapp.launch
  :dependencies [[org.clojure/clojure "1.3.0"]
                 [org.eclipse.jetty/jetty-server ~jetty-version]
                 [org.eclipse.jetty/jetty-webapp ~jetty-version]
                 [org.glassfish/javax.servlet "3.0"]])