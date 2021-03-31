package com.cloud.cloudrabbitcomsumer.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author zuyunbo
 * @Date 2021/3/31  3:28 下午
 **/
public class ProducerByFanout {

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
        String exchangeName = "test_fanout_exchange";
        String routingKey = "无所谓";
        for (int i = 0; i < 5; i++) {
            String msg = "Fanout 模式消息..";
            channel.basicPublish(exchangeName, routingKey, null, msg.getBytes());
        }
        // 关闭连接
        channel.close();
        connection.close();
    }

}
