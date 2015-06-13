(set-env! :source-paths #{"src/java"}
          :resource-paths #{"src/clj"})

(deftask add
  [n numbers NUMBER [int] "Numbers to add together and print using Java called from Clojure."]
  (with-pre-wrap fs
    (require 'uses-add :reload)
    (let [sum (apply (resolve 'uses-add/add) numbers)]
      (boot.util/info "Sum: %s\n" sum)
      fs)))
