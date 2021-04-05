package com.cloud.rabbitcoreproducer.broker;

import com.cloud.rabbitapi.api.Message;
import com.cloud.rabbitapi.api.MessageType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitBrokerImpl implements RabbitBroker{

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void rapidSend(Message message) {
        message.setMessageType(MessageType.RAPID);
        sendKernel(message);
    }

    /**
     * 发送消息的核心代码
     * @param message
     */


    private void sendKernel(Message message) {
        CorrelationData correlationData =
                new CorrelationData(String.format("%s#%s#%s",
                        message.getMessageId(),
                        System.currentTimeMillis()));
        String routingKey = message.getRoutingKey();
        rabbitTemplate.convertAndSend("exchange",routingKey,message);
        log.info("#RabbitBrokerImpl.sendKernel# send to rabbitmq, messageId: {}", message.getMessageId());
    }

    @Override
    public void confirmSend(Message message) {
    }

    @Override
    public void reliantSend(Message message) {

    }

    @Override
    public void sendMessages() {

    }
}
