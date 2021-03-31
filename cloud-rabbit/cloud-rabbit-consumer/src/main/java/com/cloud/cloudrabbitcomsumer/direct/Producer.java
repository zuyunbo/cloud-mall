package com.cloud.cloudrabbitcomsumer.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author zuyunbo
 * @Date 2021/3/31  1:48 下午
 **/
public class Producer {

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
        String exchangeName = "test_direct_exchange";
        // Direct模式必须和消费者保持一致才能发送消息, 不然消息会被丢弃
        String routingKey = "test.direct";

        // 5. 发送消息
        String msg = "Hello RabbitMQ By Direct";
        channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());

        // 5. 关闭连接
        channel.close();
        connection.close();

    }

}
