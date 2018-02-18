# jna-test

Example of how to use the Clojure JNA library, with a custom library.

## Usage

Just open the jna-test.core file and look at the code there.

Regarding [Soda support](https://github.com/jonasseglare/soda-cpp) the compiled ```libsoda.so``` file must be in under the ```resources/``` directory.

## To figure out

  * How to specify the path of ```.so``` files? So far, it seems like JNA will only find them if I put them under ```native/```

  * ~~How to reload a JNA library?~~ Solved: We have to do it at startup, that is 
```
(defn set-jna-library-path []
  (System/setProperty "jna.library.path" "/usr/local/lib:resources/"))
```

## License

Copyright © 2018 Jonas Östlund

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
