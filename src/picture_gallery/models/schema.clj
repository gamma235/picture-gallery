(ns picture-gallery.models.schema
  (:require [picture-gallery.models.db :refer :all]
            [clojure.java.jdbc :as sql]))

(def db-spec (or (System/getenv "DATABASE_URL")
             "postgresql://localhost:5432/gallery"))

(defn create-users-table []
  (sql/with-connection db-spec
    (sql/create-table
      :users
      [:id "varchar(32) PRIMARY KEY"]
      [:pass "varchar(100)"])))

(defn create-images-table []
  (sql/with-connection db-spec
    (sql/create-table
      :images
      [:userid "varchar(32)"]
      [:name "varchar(100)"])))


