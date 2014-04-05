(ns picture-gallery.models.schema
  (:require [picture-gallery.models.db :refer :all]
            [clojure.java.jdbc :as sql]))

(def spec (or (System/getenv "DATABASE_URL")
              "postgresql://localhost:5432/picture-gallery"))

(defn create-users-table []
  (sql/with-connection db
    (sql/create-table
      :users
      [:id "varchar(32) PRIMARY KEY"]
      [:pass "varchar(100)"])))

(defn create-images-table []
  (sql/with-connection db
    (sql/create-table
      :images
      [:userid "varchar(32)"]
      [:name "varchar(100)"])))

(defn migrated? []
  (-> (sql/query spec
                 [(str "select count(*) from information_schema.tables "
                       "where table_name='users'")])
      first :count pos?))

(defn migrate []
  (when (not (migrated?))
    (print "Creating database structure...") (flush)
    (sql/db-do-commands spec create-users-table)))
