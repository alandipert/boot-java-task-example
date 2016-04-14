(set-env! :source-paths #{"src/java"}
          :resource-paths #{"src/clj"})

(require '[boot.pod :as pod]
         '[boot.util :as util])

(deftask add
  [n numbers NUMBER [int] "Numbers to add together and print using Java called from Clojure."]
  (with-pre-wrap fs
    (require 'uses-add :reload)
    (let [sum (apply (resolve 'uses-add/add) numbers)]
      (boot.util/info "Sum: %s\n" sum)
      fs)))

(deftask load-classes
  "Loads .class files on the fileset."
  []
  (with-pre-wrap [fs]
    (let [classes (by-ext ["class"] (output-files fs))]
      (doseq [c (map tmp-file classes)]
        (util/info "Adding %s to classpath" c)
        (pod/add-classpath c))
      fs)))
