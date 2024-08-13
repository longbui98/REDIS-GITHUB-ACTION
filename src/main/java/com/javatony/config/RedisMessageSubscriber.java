package com.javatony.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class RedisMessageSubscriber implements MessageListener{
    private List<Message> messageList = new LinkedList<>();
    @Override
    public void onMessage(Message message, byte[] pattern) {
        messageList.add(message);
        System.out.println("Message received: " + messageList);
    }
}
