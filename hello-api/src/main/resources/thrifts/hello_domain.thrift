namespace java com.github.dapeng.hello.domain

/**
* Hello请求结构体
**/
struct Hello {
/**
*姓名
**/
    1: string name,
    /**
    * 消息
    **/
    2: optional string message,
    }

/**
* 订单完成时,发送订单完成事件,库存监听后消库存,
* 创建订单, 由于需要消费者做幂等,故加上事件Id
**/
struct CreateOrderEvent {
    /**
    * 事件Id
    **/
    1: i64 id,
    /**
    * 订单编号
    **/
    2: string orderNo
}

/**
* 订单详情请求体
**/
struct CreateOrderDetailRequest {
    /**
    * 订单编号
    **/
    1: string orderNo,
    /**
     * 商品skuNo
    **/
    2: string skuNo,
    /**
    * 订单详情行号, 针对同一Sku存在多行的情况设计
    *
    **/
    3: i32 detailSeq,
    /**
     * 商品名称
    **/
    4: string skuName,
    /**
    * sku版本
    **/
    5: i32 skuVersion,
    /**
     * 商品条码(pos机扫的条码)
    **/
    6: string barcode,
    /**
    *  商品行使用的优惠券: 用于支持退某商品时退券的处理.
    **/
    7: i64 couponId,
    /**
     * 优惠金额
     * @datatype(name="bigdecimal")
    **/
    10: optional double discountAmount,
    /**
     * 购买数量
    **/
    11: i32 skuCount,
    /**
     * 小计金额
     * @datatype(name="bigdecimal")
    **/
    12: double skuAmount,
    /**
    * sku 售价金额/单价金额
    * @datatype(name="bigdecimal")
    **/
    13: double skuSellingPrice,
    /**
     * 备注
    **/
    14: optional string remark,
    /**
    * 商品促销id
    **/
    15: optional i64 promotionId

}

/**
* 创建订单请求
*
**/
struct CreateOrderRequest {
    /**
    * 订单编号
    **/
    1: string orderNo,

    /**
    *  商品项目数量，不是商品
    **/
    2: i32 productCount,

    /**
    * 订单总金额
    * @datatype(name="bigdecimal")
    **/
    3: double orderTotalAmount,
    /**
    * 订单实际付款金额
    * @datatype(name="bigdecimal")
    **/
    4: double orderActualAmount,
    /**
    * 门店编号
    **/
    5:  string storeId,
    /**
    * 会员id
    **/
    6: optional i64 memberId,
    /**
    * 优惠/折扣金额
    * @datatype(name="bigdecimal")
    **/
    7: optional double discountAmount,
    /**
    * 用户手机号
    **/
    8: optional string mobile,
    /**
    * 订单备注
    **/
    9: optional string remark,
    /**
    * 下单时间
    **/
    10: i64 createTime,
    /**
    * 收银员
    **/
    11: i64 cashierId,
    /**
    *订单详情
    **/
    12: list<CreateOrderDetailRequest> orderDetails
}