package com.javatony.config;

import com.javatony.service.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Component;

@Component
public class RedisMessagePublisher implements MessagePublisher {
    @Autowired
    private final RedisTemplate<String, Object> template;

    @Autowired
    private final ChannelTopic topic;

    public RedisMessagePublisher(RedisTemplate<String, Object> template, ChannelTopic topic) {
        this.template = template;
        this.topic = topic;
    }
    @Override
    public void publish(String message) {
        template.convertAndSend(topic.getTopic(), message);
    }
}
