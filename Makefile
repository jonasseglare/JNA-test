resources/libtest.so: testlib.cpp
	g++ testlib.cpp -fPIC -shared -o resources/libtest.so

all: resources/libtest.so
