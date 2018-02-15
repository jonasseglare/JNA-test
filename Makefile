resources/libtest.so: testlib.cpp
	g++ -std=c++11 testlib.cpp -fPIC -shared -o resources/libtest.so

all: resources/libtest.so

clean:
	rm resources/libtest.so
