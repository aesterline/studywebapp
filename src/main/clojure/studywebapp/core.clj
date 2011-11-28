(ns studywebapp.core
  "My first clojure servlet"
  (:import (javax.servlet.http HttpServlet
                               HttpServletRequest
                               HttpServletResponse)))

(gen-class
 :name firstweb.core.FirstServlet
 :implements [javax.servlet.Servlet])

(defn -init [this servletconfig])
(defn -destroy [this])

(defn -service
  [this request response]
  (with-open [writer (.getWriter response)]
    (.print writer (.getMethod request))))
