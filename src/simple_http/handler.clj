(ns simple-http.handler
  (:require [compojure.core :refer :all]
            [simple-http.todos :refer [getAllTodosHandler addTodoHandler]]
            [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [ring.middleware.json :refer [wrap-json-body]]))

(defroutes app-routes
  (GET "/all" [] getAllTodosHandler)
  (POST "/new" [] addTodoHandler))

(def app
  (wrap-defaults (wrap-json-body app-routes {:keywords? true}) api-defaults))
