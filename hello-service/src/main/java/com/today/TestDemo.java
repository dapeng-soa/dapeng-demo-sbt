package com.today;

import com.github.dapeng.core.SoaException;
import com.github.dapeng.hello.HelloServiceClient;

import java.util.Optional;
import java.util.Random;

/**
 * @author huyj
 * @Created 2018/4/24 12:50
 */
public class TestDemo {

    public static void main(String[] args) throws Exception {
        testEcho();
    }


    /*  public static void  testRedis(){
          RedisUtils.set("name","dapeng");
          System.out.println("name:"+ RedisUtils.get("name"));

          Map map =  new HashMap<>();
          map.put("name","dapeng");
          map.put("age",24);
          RedisUtils.set("map",map);
          System.out.println("map:"+RedisUtils.get("map"));

          System.out.println("redis keys:"+RedisUtils.keys("*"));
      }*/
    public static void testEcho() throws Exception {
        HelloServiceClient serviceClient = new HelloServiceClient();
        serviceClient.echo();
    }

    public static void testHello() {
        com.github.dapeng.hello.domain.Hello hello = new com.github.dapeng.hello.domain.Hello();
        //默认会调到 API-version 及以上版本
        com.github.dapeng.hello.service.HelloService serviceClient = new com.github.dapeng.hello.HelloServiceClient();
        for (int i = 0; i < 1; i++) {
            new Thread(() -> {
                hello.setName("service");
                hello.setMessage(Optional.of("java  test "));
                try {
                    System.out.println(serviceClient.sayHello(hello));
                } catch (SoaException e) {
                    e.printStackTrace();
                }
            }).start();
        }


        com.github.dapeng.demo.domain.Demo demo = new com.github.dapeng.demo.domain.Demo();
        com.github.dapeng.demo.service.DemoService demoClient = new com.github.dapeng.demo.DemoServiceClient();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                demo.expectCost(new Random().nextInt(5000));
                demo.bytes(new Random(100).nextLong());
                try {
                    System.out.println(demoClient.demoTest(demo));
                } catch (SoaException e) {
                    e.printStackTrace();
                }
            }).start();
        }

       /* HelloService service1 = new HelloServiceClient("2.0.1");
        System.out.println(service1.sayHello(hello));*/

        //默认会调到 API-version 及以上版本
        /*HelloServiceA serviceA = new HelloServiceAClient();
        System.out.println(serviceA.sayHello(hello));*/
        /*HelloServiceA serviceA1 = new HelloServiceAClient("3.0.1");
        System.out.println(serviceA1.sayHello(hello));
        HelloServiceA serviceA2 = new HelloServiceAClient("3.0.2");
        System.out.println(serviceA2.sayHello(hello));*/

        //默认会调到 API-version 及以上版本
       /* HelloServiceB serviceB = new HelloServiceBClient();
        System.out.println(serviceB.sayHello(hello));*/
        /*HelloServiceB serviceB1 = new HelloServiceBClient("3.0.1");
        System.out.println(serviceB1.sayHello(hello));
        HelloServiceB serviceB2 = new HelloServiceBClient("3.0.2");
        System.out.println(serviceB2.sayHello(hello));*/
    }

}
