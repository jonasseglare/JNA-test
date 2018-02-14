#include <iostream>

extern "C" {

  double nthFib(int n) {
    double a = 0;
    double b = 1;
    for (int i = 0; i < n; i++) {
      double c = a + b;
      a = b;
      b = c;
    }
    return b;
  }

}
