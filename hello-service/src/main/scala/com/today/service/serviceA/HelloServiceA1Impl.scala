package com.today.service.serviceA

import java.text.SimpleDateFormat
import java.util.Date

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.core.timer.ScheduledTask
import com.github.dapeng.hello.scala.domain.Hello
import com.github.dapeng.hello.scala.service. HelloServiceA
import org.slf4j.{Logger, LoggerFactory}

@ServiceVersion(version = "3.0.1")
class HelloServiceA1Impl extends HelloServiceA {
  private val logger: Logger = LoggerFactory.getLogger(classOf[HelloServiceA1Impl])

  /**
    *
    **/
  override def sayHello(hello: Hello): String = {
    s"***************收到的消息为： ${hello} HelloServiceA1Impl version=3.0.1"
    // info.formatted("%.0f")
  }

}
