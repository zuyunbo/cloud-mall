package com.cloud.cloudrabbitcomsumer;

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

        // 4. 通过channel发送消息
        String msg = "hello rabbitmq!";
        for (int i = 0; i < 5; i++) {
            // 不指定exchange的情况下, 使用默认的exchange, routingKey与队列名相等
            channel.basicPublish("", "test01", null, msg.getBytes());
        }

        // 5. 关闭连接
        channel.close();
        connection.close();

    }

}
