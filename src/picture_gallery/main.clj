(ns picture-gallery.main
  (:use picture-gallery.handler
        picture-gallery.models.schema
        [org.httpkit.server :only [run-server]]
        [ring.middleware file-info file])
  (:gen-class))

(defn -main []
  (schema/migrate)
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))
