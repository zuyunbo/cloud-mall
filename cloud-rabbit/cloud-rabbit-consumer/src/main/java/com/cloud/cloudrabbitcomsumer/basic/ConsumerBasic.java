package com.cloud.cloudrabbitcomsumer.basic;

import com.cloud.cloudrabbitcomsumer.queuq.MyConsumer;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConsumerBasic {

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
        String exchangeType = "topic";
        // Direct模式必须和消费者保持一致才能发送消息, 不然消息会被丢弃
        String routingKey = "limit.*";
        String queueName = "test_limit_queue";
        channel.exchangeDeclare(exchangeName, exchangeType, true, false, null);

        channel.queueDeclare(queueName, true, false, false, null);
        channel.queueBind(queueName, exchangeName, routingKey);

        channel.basicQos(0, 1, false);

        channel.basicConsume(queueName, false, new MyConsumer(channel));

    }

}
