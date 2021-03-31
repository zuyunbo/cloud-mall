package com.cloud.cloudrabbitcomsumer.basic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ProducerBasic {


    public static void main(String[] args) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.105.35.98");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();

        // 3. 使用connection创建channel
        Channel channel = connection.createChannel();


        // 4. 声明
        String exchangeName = "test_limit_exchange";
        // Direct模式必须和消费者保持一致才能发送消息, 不然消息会被丢弃
        String routingKey = "limit.zuyunbo";

        // 5. 发送消息
        String msg = "自定义消费者";
        for (int i = 0; i < 5; i++) {
            channel.basicPublish(exchangeName, routingKey, true, null, msg.getBytes());
        }
        // 5. 关闭连接
        channel.close();
        connection.close();

    }


}
