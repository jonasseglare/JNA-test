# jna-test

Example of how to use the Clojure JNA library, with a custom library.

## Usage

Just open the jna-test.core file and look at the code there.

Regarding [Soda support](https://github.com/jonasseglare/soda-cpp) the compiled ```libsoda.so``` file must be in under the ```resources/``` directory.

### Example calls

Assumes that ```libsoda.so``` file is under ```/usr/local/lib```
```clojure
jna-test.core> (set-jna-library-path)
nil
jna-test.core> (soda-demo)
"Elapsed time: 7.869419 msecs"

[
  0
  :kattskit
]
nil
jna-test.core> 
```

or

```clojure
jna-test.core> (call-fresh-fib)
10055.0
```

## To figure out

  * ~~How to specify the path of .so files? So far, it seems like JNA will only find them if I put them under native/.~~ *Solved: We have to do it at startup, that is*
```
(defn set-jna-library-path []
  (System/setProperty "jna.library.path" "/usr/local/lib:resources/"))
```

  * ~~How to reload a JNA library?  Possible answers:~~
http://users.jna.dev.java.narkive.com/UpULGQhm/unload-and-reload-a-native-library
https://github.com/java-native-access/jna/blob/master/src/com/sun/jna/NativeLibrary.java

  *Solution: See the call-fresh function* We should not have loaded the library before that.

## License

Copyright © 2018 Jonas Östlund

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
