#include <iostream>
#include <stdint.h>

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

  struct ValuePair {
    int32_t x = 119;
    float y = 14.0;
  };

  int outputValuePairToBuffer(ValuePair* p) {
    *p = ValuePair();
    return 119;
  }

  ValuePair* getValuePairPointer() {
    static ValuePair p;
    return &p;
  }
}
