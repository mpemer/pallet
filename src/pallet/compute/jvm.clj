(ns pallet.compute.jvm
  "Information from local jvm")

(def jvm-os-map
  {"Mac OS X" :os-x})

(defn os-name []
  (System/getProperty "os.name"))

(defn os-family []
  (or (jvm-os-map (os-name)) :ubuntu))

(defn log4j?
 "Predicate to test for log4j on the classpath."
  []
  (try
    (import org.apache.log4j.Logger)
    true
    (catch java.lang.ClassNotFoundException _
      false)))

(defn slf4j?
 "Predicate to test for slf4j on the classpath."
  []
  (try
    (import org.slf4j.LoggerFactory)
    true
    (catch java.lang.ClassNotFoundException _
      false)))
