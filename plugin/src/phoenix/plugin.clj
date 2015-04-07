(ns phoenix.plugin
  (:require [clojure.java.io :as io]))

(def version
  (clojure.string/trim-newline (slurp (io/resource "phoenix-version"))))

(defn project-deps [{:keys [dependencies] :as project}]
  (set (map first dependencies)))

(defn with-runtime-dep [project]
  (cond-> project
    (not (contains? (project-deps project) 'jarohen/phoenix.runtime))
    (update-in [:dependencies] conj ['jarohen/phoenix.runtime version])))

(defn select-project-keys [project]
  (select-keys project [:phoenix/config :target-path :repl-options]))

(defn middleware [project]
  (-> project
      with-runtime-dep
      (update-in [:injections]
                 concat
                 `[(require '~'phoenix)
                   (phoenix/init-phoenix! (clojure.java.io/resource ~(:phoenix/config project)))])))

