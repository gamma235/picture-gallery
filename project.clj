(defproject picture-gallery "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]
                 [com.taoensso/timbre "3.1.6"]
                 [com.postspectacular/rotor "0.1.0"]
                 [lib-noir "0.8.1"]
                 [http-kit "2.1.12"]
                 [selmer "0.5.4"]
                 [korma "0.3.0-RC5"]
                 [log4j "1.2.15"
                  :exclusions [javax.mail/mail
                               javax.jms/jms
                               com.sun.jdmk/jmxtools
                               com.sun.jmx/jmxri]]]
  :main picture-gallery.main
  :uberjar-name "picture-gallery-0.1.0-SNAPSHOT-standalone.jar"
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler picture-gallery.handler/app
         :init picture-gallery.handler/init
         :destroy picture-gallery.handler/destroy}
  :profiles
  {:uberjar {:main picture-gallery.main, :aot :all}}
  )
