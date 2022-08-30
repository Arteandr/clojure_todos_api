(ns simple-http.todos
  (:require [clojure.data.json :as json]))

(def contentTypeHeader {"Content-Type" "text/json"})

; mutable collection
(def todos (atom []))

(defn getAllTodos [req]
  {:status 200
   :headers contentTypeHeader
   :body (json/write-str @todos)})