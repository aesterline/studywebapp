(ns studywebapp.servlet
  (:gen-class :name studywebapp.servlet.DispatcherServlet
              :extends javax.servlet.http.HttpServlet
              :exposes-methods {init superInit}))

(defn helloworld [response from]
  (with-open [writer (.getWriter response)]
    (.print writer (str "Hello World from " from))))

(defn -doGet [this request response]
  (helloworld response "GET"))

(defn -doPost [this request response]
  (helloworld response "POST"))

(defn -init
  ([this] (.log this "DispatcherServlet initialized"))
  ([this config] (.superInit this config)))