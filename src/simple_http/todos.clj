(ns simple-http.todos
  (:require [clojure.data.json :as json]))

; mutable collection
(def todos (atom []))
(defn- addTodo [title body]
  (swap! todos conj {:title title
                     :body body}))
(defn- validateTodo [title body]
  (or (some? title) (some? body)))

; handlers
(def contentTypeHeader {"Content-Type" "text/json"})

(defn- errorResponse [status msg]
  {:status status
   :headers contentTypeHeader
   :body (json/write-str {:error msg})})

(defn getAllTodosHandler [req]
  {:status 200
   :headers contentTypeHeader
   :body (json/write-str @todos)})

(defn addTodoHandler [req]
  (let [body (req :body)]
    (if (not (validateTodo (body :title) (body :body)))
      (errorResponse 500 "wrong title or body length")
      (addTodo (:title body) (:body body)))
    {:status 200
     :headers contentTypeHeader
     :body (json/write-str {:id (count @todos)})}))