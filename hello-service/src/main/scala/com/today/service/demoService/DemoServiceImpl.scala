package com.today.service.demoService

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.demo.scala.domain.Demo
import com.github.dapeng.demo.scala.service.DemoService
import org.slf4j.{Logger, LoggerFactory}

class DemoServiceImpl extends DemoService {
  private val logger: Logger = LoggerFactory.getLogger(classOf[DemoServiceImpl])

  /**
    *
    **/
  override def demoTest(demo: Demo): String = {
    if (demo.expectCost > 0)
      Thread.sleep(demo.expectCost)

    val sb = new StringBuilder
    if (demo.bytes > 0)
      for (a <- 1 to demo.bytes.toInt) {
        sb.append("x")
      }
    sb.toString()
  }

}
