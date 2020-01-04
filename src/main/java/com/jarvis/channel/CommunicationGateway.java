package com.jarvis.channel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

import com.jarvis.communicator.MailSender;
import com.jarvis.communicator.SMSSender;
import com.jarvis.dto.CommunicationMessage;
import com.jarvis.dto.CommunicationMessageDTO;

public class CommunicationGateway {

	@Autowired
	SMSSender sender;
	
	@Autowired
	MailSender mail_sender;

	public String sendMessageToGateway(Message<CommunicationMessage> message) {

		CommunicationMessage communicationMessage = message.getPayload();

		System.out.println("Phone Number" + communicationMessage.getPhoneNumber());
		CommunicationMessageDTO communicationMessageDTO = new CommunicationMessageDTO();
		String numberPrifix="+1";
		if(communicationMessage.getCountryID().equalsIgnoreCase("IN"))
			numberPrifix="+91";	
		communicationMessageDTO.setMember_phone(numberPrifix+communicationMessage.getPhoneNumber());
		communicationMessageDTO.setMember_phone_country_code(communicationMessage.getCountryID());
		communicationMessageDTO.setComplete_message_sms("Test SMS");
		communicationMessageDTO.setMember_phone_secure_messaging_id(communicationMessage.getPhoneID());

		if(communicationMessageDTO.getMember_phone_secure_messaging_id()!=null && !"".equals(communicationMessageDTO.getMember_phone_secure_messaging_id()))
		{
			sender.sendSMSMessage(communicationMessageDTO.getMember_phone_secure_messaging_id(),communicationMessageDTO.getComplete_message_sms() );
		}
		else
		{
			sender.sendSMSCompleteProcess(communicationMessageDTO);
		}
	

		return "SMS Send";

	}

	public String emailMessageToGateway(Message<CommunicationMessage> message) {

		CommunicationMessage communicationMessage = message.getPayload();

		System.out.println("Email" + communicationMessage.getEmail());

		if(communicationMessage!=null)
		{
			
		}
		return "Email Send";

	}

	public String bothMessageToGateway(Message<CommunicationMessage> message) {

		CommunicationMessage communicationMessage = message.getPayload();

		System.out.println("Channel" + communicationMessage.getPreference());
		emailMessageToGateway(message);

		sendMessageToGateway(message);

		return "Email Send";

	}

}
