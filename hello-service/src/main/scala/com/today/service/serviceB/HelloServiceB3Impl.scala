package com.today.service.serviceB

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.hello.scala.domain.Hello
import com.github.dapeng.hello.scala.service.HelloServiceB
import org.slf4j.{Logger, LoggerFactory}

@ServiceVersion(version = "3.0.3")
class HelloServiceB3Impl extends HelloServiceB {
  private val logger: Logger = LoggerFactory.getLogger(classOf[HelloServiceB3Impl])

  /**
    *
    **/
  override def sayHello(hello: Hello): String = {
    s"*******************收到的消息为： ${hello} HelloServiceB3Impl version=3.0.3"
    // info.formatted("%.0f")
  }

}
