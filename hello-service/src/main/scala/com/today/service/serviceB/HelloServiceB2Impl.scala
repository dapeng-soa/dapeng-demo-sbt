package com.today.service.serviceB

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.hello.scala.domain.Hello
import com.github.dapeng.hello.scala.service.HelloServiceB
import org.slf4j.{Logger, LoggerFactory}

@ServiceVersion(version = "3.0.2")
class HelloServiceB2Impl extends HelloServiceB {
  private val logger: Logger = LoggerFactory.getLogger(classOf[HelloServiceB2Impl])

  /**
    *
    **/
  override def sayHello(hello: Hello): String = {
    s"*******************收到的消息为： ${hello} HelloServiceB2Impl version=3.0.2"
    // info.formatted("%.0f")
  }

}
