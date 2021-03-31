package com.cloud.cloudrabbitcomsumer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * @Author zuyunbo
 * @Date 2021/3/31  2:14 下午
 **/
public class Consumer {

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
        String queueName = "test01";
        channel.queueDeclare(queueName,true, false, false, null);

        // 5. 创建消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);

        // 6. 设置channel
        channel.basicConsume(queueName, true, consumer);
        while (true) {
            // 7. 获取消息
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.err.println(new String(delivery.getBody()));
        }

    }


}
