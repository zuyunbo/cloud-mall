package com.cloud.rabbitcoreproducer.broker;

import com.cloud.rabbitapi.api.Message;

/**
 * 具体发送消息不同类型的接口
 */
public interface RabbitBroker {

    void rapidSend(Message message);

    void confirmSend(Message message);

    void reliantSend(Message message);

    void sendMessages();


}
