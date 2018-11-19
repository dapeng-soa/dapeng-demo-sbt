namespace java com.github.dapeng.hello.service

include "hello_domain.thrift"

service HelloService {
/**
# hello接口
## 业务描述
    hello接口，仅做示范
## 接口依赖
    无
## 边界异常说明
    无
## 输入
    1.hello_domain.Hello hello
## 前置检查
    无
##  权限检查
    无
##  逻辑处理
     根据输入的Hello，打印并返回字符串
## 数据库变更
    无
##  事务处理
    无
##  输出
    String
*/
    string sayHello(1: hello_domain.Hello hello)

/**
# 生成订单
## 业务描述
    生成订单
## 接口依赖
    无
## 边界异常说明
    无
## 输入
    CreateOrderRequest request
## 数据库变更
    1. 主单入库
    2. 子单入库
##  事务处理
    无
## 前置检查
   1. 判断订单是否存在, 如果订单已存在，提示异常: 订单已存在
   2. order.discount_amount = sum(subOrder.discount_amount) + sum(coupon.discount_price)  (coupon.type = 商品券)
   3. order.actual_amount = sum(subOrder.sku_amount - subOrder.discount_amount) - sum(coupon.discount_price) (coupon.type = 商品券)
   4. order.orderTotalAmount = order.orderActualAmount + order.discountAmount

}(version="1.0.0")
## 逻辑处理

    1. 插入订单
    2. 插入子单
    3. 发送CreateOrderEvent 事件通知消费者
## 输出
    无
*/
    void createOrder(1: hello_domain.CreateOrderRequest request)
    (events="com.github.dapeng.hello.domain.CreateOrderEvent")
}