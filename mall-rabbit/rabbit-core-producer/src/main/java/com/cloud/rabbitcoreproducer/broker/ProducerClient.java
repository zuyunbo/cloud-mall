package com.cloud.rabbitcoreproducer.broker;

import com.cloud.rabbitapi.api.Message;
import com.cloud.rabbitapi.api.MessageProducer;
import com.cloud.rabbitapi.api.SendCallback;
import com.cloud.rabbitapi.exception.MessageRunTimeException;

import java.util.List;

public class ProducerClient implements MessageProducer {




    @Override
    public void send(Message message, SendCallback sendCallback) throws MessageRunTimeException {

    }

    @Override
    public void send(Message message) throws MessageRunTimeException {

    }

    @Override
    public void send(List<Message> messages) throws MessageRunTimeException {

    }
}
