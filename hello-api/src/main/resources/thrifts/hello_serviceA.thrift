namespace java com.github.dapeng.hello.service

include "hello_domain.thrift"

service HelloServiceA {

    string sayHello(1: hello_domain.Hello hello)
}(version="3.0.0")