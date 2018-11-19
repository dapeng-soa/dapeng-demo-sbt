package com

import com.github.dapeng.core.ServiceVersion
import com.github.dapeng.hello.scala.domain.{CreateOrderRequest, Hello}
import com.github.dapeng.hello.scala.service.HelloService
import org.slf4j.{Logger, LoggerFactory}

class HelloServiceImpl extends HelloService {
  private val logger = LoggerFactory.getLogger(classOf[HelloServiceImpl])

  /**
    *
    **/
  override def sayHello(hello: Hello): String = {
    /*val paramRes:com.today.soa.idgen.scala.domain.GenIDRequest = new com.today.soa.idgen.scala.domain.GenIDRequest("sku_id",1)
    val idservice = new IDServiceClient
   val resultId =  idservice.genId(paramRes)
    var info:String = "201646"*/

    /*   val idService1 = new IDServiceClient
   //    val resultId1 = idService1.genId("sku_id")
       val IDRequest = new GenIDRequest()
       IDRequest.setBizTag("sku_id")
       IDRequest.setStep(1)
       s"收到的消息为：  ${hello} id:${ idService1.genId(IDRequest)}"
       s"收到的消息为：  ${hello} id:${ idService1.genId(IDRequest)}"
       s"收到的消息为：  ${hello} id:${ idService1.genId(IDRequest)}"*/


    /*  val idService2 = new IDCacheClient
      val resultId2 = idService2.getId("sku_id")
      s"收到的消息为：  ${hello} id:${resultId2}"


      val idService3 = new IDCacheClient
      val resultId3 = idService3.getId("sku_id")
      s"收到的消息为：  ${hello} id:${resultId3}"*/

    /*val echo = new EchoClient("com.github.dapeng.hello.service.HelloService", "2.4.2")
    //val info:String = TransactionContext.Factory.currentInstance.getAttribute("assdasdasd") +"" .toString
    val echoInfo = echo.echo()
    logger.info(s"收到的消息为：  ${hello} echo :${echoInfo}")
    s"收到的消息为： ${hello} echo :${echoInfo}"*/

    // Thread.sleep(200)
    s"*******************收到的消息为： ${hello} HelloServiceImpl version=2.0.1"
    // info.formatted("%.0f")
  }


//  @ScheduledTaskCron(cron = "0 0/30 * * * ? *")
//  override def sayHelloTask(): String = {
//    val now: Date = new Date()
//    val dateFormat: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//    val date = dateFormat.format(now)
//    s"收到的消息为： ${date}"
//  }
  /**
    *
    **
    * # 1. 生成订单
    * ## 业务描述
    * 生成订单
    * ## 接口依赖
    * 无
    * ## 边界异常说明
    * 无
    * ## 输入
    * CreateOrderRequest request
    * ## 数据库变更
    *1. 主单入库
    *2. 子单入库
    * ##  事务处理
    * 无
    * ## 前置检查
    *1. 判断订单是否存在, 如果订单已存在，提示异常: 订单已存在
    *2. order.discount_amount = sum(subOrder.discount_amount) + sum(coupon.discount_price)  (coupon.type = 商品券)
    *3. order.actual_amount = sum(subOrder.sku_amount - subOrder.discount_amount) - sum(coupon.discount_price) (coupon.type = 商品券)
    *4. order.orderTotalAmount = order.orderActualAmount + order.discountAmount
    **
    * ## 逻辑处理
    **
    *1. 插入订单
    *2. 插入子单
    *3. 发送CreateOrderEvent 事件通知消费者
    * ## 输出
    * 无
    *
    **/
  override def createOrder(request: CreateOrderRequest): Unit = {
    println(request)
  }
}
