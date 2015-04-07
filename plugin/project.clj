(def version (clojure.string/trim-newline (slurp "../common/phoenix-version")))

(defproject jarohen/phoenix version
  :description "A plugin for configuring, co-ordinating and reloading Components"

  :url "https://github.com/james-henderson/phoenix"

  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :repositories {"snapshots" {:url "http://internaljars.uswitchinternal.com:8080/nexus/content/repositories/snapshots"
                              :sign-releases false}
                 "releases"  {:url "http://internaljars.uswitchinternal.com:8080/nexus/content/repositories/releases"
                             :sign-releases false}}

  :dependencies [[leinjacker "0.4.1"]]

  :resource-paths ["resources" "../common"]
  
  :eval-in-leiningen true)
