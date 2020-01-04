package com.jarvis.consumer;

import org.springframework.messaging.Message;

import com.jarvis.dto.EventMessage;

public interface EventMessageGateway {
	
	public void send(Message<EventMessage> message);  

}
