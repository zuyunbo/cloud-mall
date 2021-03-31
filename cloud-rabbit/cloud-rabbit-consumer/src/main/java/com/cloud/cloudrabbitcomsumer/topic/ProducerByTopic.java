package com.cloud.cloudrabbitcomsumer.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @Author zuyunbo
 * @Date 2021/3/31  2:53 下午
 **/
public class ProducerByTopic {

    public static void main(String[] args) throws Exception{


        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.105.35.98");
        factory.setPort(5672);
        factory.setVirtualHost("/");
        factory.setUsername("admin");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();

        // 3. 使用connection创建channel
        Channel channel = connection.createChannel();

        String exchangeName = "test_topic_exchange";
        String routingKey1 = "tingxuelou.biluo";
        String routingKey2 = "tingxuelou.hongchen";
        String routingKey3 = "tingxuelou.hufa.zimo";

        String msg = "test topic By routingKey : ";
        channel.basicPublish(exchangeName, routingKey1, null, (msg + routingKey1).getBytes());
        channel.basicPublish(exchangeName, routingKey2, null, (msg + routingKey2).getBytes());
        channel.basicPublish(exchangeName, routingKey3, null, (msg + routingKey3).getBytes());

        // 关闭连接
        channel.close();
        connection.close();



    }

}
