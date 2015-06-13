# boot java-dependent task example

This is an example of calling compiled Java code from a task in build.boot.

This doesn't work because `add` depends on Java code having been compiled:

```
$ boot add -n 1 -n 2
    clojure.lang.ExceptionInfo: java.lang.ClassNotFoundException: acme.Add, compiling:(uses_add.clj:1:1)
    data: {:file "/tmp/boot.user9093020125226622231.clj", :line 21}
```

This works because we compiled the java first:

```
alan@alanputer:/tmp/boot-javac$ boot javac add -n 1 -n 2
Compiling 1 Java source files...
Sum: 3
```
