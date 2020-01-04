package com.jarvis.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.jarvis.dto.CommunicationMessage;
import com.jarvis.dto.EventMessage;
import com.jarvis.service.RuleEngineService;

public class RuleEngineProcessor {
	
	@Autowired
	RuleEngineService engineService;
	
	public Message<CommunicationMessage> getBdayRule(Message<EventMessage> message){
		
		System.out.println("DOB :"+message.getPayload().getDob());
		
		EventMessage eventMessage=message.getPayload();
		
		CommunicationMessage communicationMessage=new CommunicationMessage();

		communicationMessage.setRuleResult(engineService.getRuleCondition(eventMessage.getEventType()));
		
		communicationMessage.setActionID(eventMessage.getActionID());
		
		communicationMessage.setMemberID(message.getPayload().getMemberID());
		
		return MessageBuilder.withPayload(communicationMessage).build();
		
	}

}
