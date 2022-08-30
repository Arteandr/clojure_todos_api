(ns simple-http.handler
  (:require [compojure.core :refer :all]
            [simple-http.todos :refer [getAllTodos]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  (GET "/" [] getAllTodos))

(def app
  (wrap-defaults app-routes site-defaults))
