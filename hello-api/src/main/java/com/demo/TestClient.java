package com.demo;

import com.github.dapeng.core.SoaException;

import java.util.Optional;

public class TestClient {
    public static void main(String[] args) throws SoaException {

        //testRedis();
        test("Client-9095");

    }


    public static void test(String clientName) throws SoaException {
        long count = 0;
        while (true) {
            com.github.dapeng.hello.service.HelloService service = new com.github.dapeng.hello.HelloServiceClient();
            com.github.dapeng.hello.domain.Hello hello = new com.github.dapeng.hello.domain.Hello();
            hello.setName("zhangsan");
            hello.setMessage(Optional.of("123"));
            hello.setMessage(Optional.of(count + ""));
            String s = service.sayHello(hello);
            System.out.println(clientName + " ： " + System.nanoTime() + " : " + s);
            count++;
            try {
                Thread.currentThread().sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    /*public static void  testRedis(){
        RedisUtils.set("name","dapeng");
        System.out.println("name:"+ RedisUtils.get("name"));

        Map map =  new HashMap<>();
        map.put("name","dapeng");
        map.put("age",24);
        RedisUtils.set("map",map);
        System.out.println("map:"+RedisUtils.get("map"));

        System.out.println("redis keys:"+RedisUtils.keys("*"));
    }*/


}
