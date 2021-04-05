package com.cloud.rabbitcoreproducer.broker;

import com.cloud.rabbitapi.api.Message;
import com.cloud.rabbitapi.api.MessageProducer;
import com.cloud.rabbitapi.api.MessageType;
import com.cloud.rabbitapi.api.SendCallback;
import com.cloud.rabbitapi.exception.MessageRunTimeException;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerClient implements MessageProducer {

    @Autowired
    private RabbitBroker rabbitBroker;

    @Override
    public void send(Message message) throws MessageRunTimeException {
        Preconditions.checkNotNull(message);
        String messageType = message.getMessageType();
        switch (messageType) {
            case MessageType.RAPID:
                rabbitBroker.rapidSend(message);
                break;
            case MessageType.CONFIRM:
                rabbitBroker.confirmSend(message);
                break;
            case MessageType.RELIANT:
                rabbitBroker.reliantSend(message);
                break;
            default:
                break;
        }


    }

    @Override
    public void send(List<Message> messages) throws MessageRunTimeException {

    }

    @Override
    public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {

    }



}
