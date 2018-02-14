native/testlib.so: testlib.cpp
	g++ testlib.cpp -fPIC -shared -o native/testlib.so

all: native/testlib.so
