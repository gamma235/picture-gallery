(ns picture-gallery.main
  (:require [picture-gallery.handler :refer [app]]
            [ring.adapter.jetty :refer [run-jetty]]
            [org.httpkit.server :only [run-server]]
            [ring.middleware file-info file])
  (:gen-class))

(defn -main []
    (let [port (Integer. (or (System/getenv "PORT") "3000"))]
      (run-jetty app {:port port})))
