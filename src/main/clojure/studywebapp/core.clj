(ns studywebapp.core
  "My first clojure servlet"
  (:import (javax.servlet.http HttpServlet
                               HttpServletRequest
                               HttpServletResponse)))

(defn handle
  [context]
  (with-open [request (.getRequest context)
              writer (.. context (getResponse) (getWriter))]
    (.print writer (.isAsyncStarted request)))
  (.complete context))

(gen-class
 :name firstweb.core.FirstServlet
 :implements [javax.servlet.Servlet])

(defn -init [this servletconfig])
(defn -destroy [this])

(defn -service
  [this request response]
  (handle (.startAsync request)))