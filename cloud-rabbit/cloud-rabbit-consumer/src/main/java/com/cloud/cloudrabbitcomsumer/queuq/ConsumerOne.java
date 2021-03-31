package com.cloud.cloudrabbitcomsumer.queuq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @Author zuyunbo
 * @Date 2021/3/31  2:14 下午
 **/
public class ConsumerOne {

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

        // 4. 声明(创建)一个队列
        String exchangeName = "test_consumer_exchange_direct";
        String exchangeType = "direct";

        // Direct模式RoutingKey必须和生产者保持一致才能消费
        String routingKey = "com.zuyunbo";
        // 表示声明了一个交换机, 后面几个参数分别为durable, autoDelete, internal, arguments
        channel.exchangeDeclare(exchangeName, exchangeType, true, false, false, null);


        String queueName = "queuezuy_direct";
        channel.queueDeclare(queueName, false, false, false, null);
        // 建立一个绑定关系
        channel.queueBind(queueName, exchangeName, routingKey);

        // 参数 : 队列名称, autoAck:是否自动确认, consumer
        channel.basicConsume(queueName, true, new MyConsumer(channel));


    }


}
