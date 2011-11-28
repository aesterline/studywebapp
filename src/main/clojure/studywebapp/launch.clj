(ns studywebapp.launch)

(defn -main [& args]
  (EmbeddedJetty/main (into-array String args)))