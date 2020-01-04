package com.jarvis.consumer;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jarvis.dto.EventMessage;

public class MessageConsumer {
	
	@Value("${event.kafka.topic.name}")
	private String topic;
	
	@Autowired
	EventMessageGateway eventMessageGateway;
	
	@Autowired
	BatchMessageGateway batchMessageGateway;
	
	private static final Logger LOGGER =LoggerFactory.getLogger(MessageConsumer.class);

	private CountDownLatch latch = new CountDownLatch(2);

		  public CountDownLatch getLatch() {
		    return latch;
		  }

		  @KafkaListener(topics = "${event.kafka.topic.name}")
		  public void receiveStream(String message) {
		    LOGGER.info("received Stream payload='{}'", message);
		    ObjectMapper mapper = new ObjectMapper();
		    EventMessage eventMessage = null;
			try {
				eventMessage = mapper.readValue(message, EventMessage.class);
			} catch (IOException e) {
				e.printStackTrace();
			} 
		    eventMessageGateway.send(MessageBuilder.withPayload(eventMessage).build());
		    latch.countDown();
		  }
		  
		  @KafkaListener(topics = "${batch.kafka.topic.name}")
		  public void receiveBatch(String message) {
		    LOGGER.info("received Batch payload='{}'", message);
	
		    ObjectMapper mapper = new ObjectMapper();
		    EventMessage eventMessage = null;
			try {
				eventMessage = mapper.readValue(message, EventMessage.class);
			} catch (IOException e) {
				e.printStackTrace();
			} 
			batchMessageGateway.send(MessageBuilder.withPayload(eventMessage).build());
		    latch.countDown();
		  }

}


