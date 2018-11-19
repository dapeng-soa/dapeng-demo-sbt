package com.today.service.serviceA

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.hello.scala.domain.Hello
import com.github.dapeng.hello.scala.service.HelloServiceA
import org.slf4j.{Logger, LoggerFactory}

@ServiceVersion(version = "3.0.2")
class HelloServiceA2Impl extends HelloServiceA {
  private val logger: Logger = LoggerFactory.getLogger(classOf[HelloServiceA2Impl])

  /**
    *
    **/
  override def sayHello(hello: Hello): String = {
    s"*******************收到的消息为： ${hello} HelloServiceA2Impl version=3.0.2"
    // info.formatted("%.0f")
  }

}
