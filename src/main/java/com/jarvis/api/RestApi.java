package com.jarvis.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.communicator.MailSender;
import com.jarvis.communicator.SMSSender;
import com.jarvis.consumer.BatchMessageGateway;
import com.jarvis.consumer.EventMessageGateway;
import com.jarvis.dto.CommunicationMessageDTO;
import com.jarvis.dto.Enroll;
import com.jarvis.dto.EventMessage;

@RequestMapping("/api")
@RestController
public class RestApi {
	
	@Autowired
	EventMessageGateway eventMessageGateway;
	
	@Autowired
	BatchMessageGateway batchMessageGateway;

	@GetMapping("/test")
	public String getTest() {
		batchMessageGateway.send(MessageBuilder.withPayload(createEnrollMessage()).build());
		eventMessageGateway.send(MessageBuilder.withPayload(createBDAYMessage()).build());
		eventMessageGateway.send(MessageBuilder.withPayload(createMemberChangeMessage()).build());
		batchMessageGateway.send(MessageBuilder.withPayload(createIDCARDMessage()).build());

		return "HELLO";
	}
	
	private EventMessage createBDAYMessage(){
		EventMessage eventMessage= new EventMessage();
		eventMessage.setActionID("BDAY1");
		eventMessage.setEventType("BDAY");
		eventMessage.setDob("10/02/2000");
		eventMessage.setMemberID("1");
		return eventMessage;
	}
	
	private EventMessage createMemberChangeMessage(){
		EventMessage eventMessage= new EventMessage();
		eventMessage.setActionID("MEMCHG1");
		eventMessage.setEventType("MEMCHG");
		eventMessage.setChangeType("ADDCHG");
		eventMessage.setMemberID("1");
		return eventMessage;
	}
	
	private EventMessage createIDCARDMessage(){
		EventMessage eventMessage= new EventMessage();
		eventMessage.setActionID("IDCARD1");
		eventMessage.setChangeType("ADDCHG");
		eventMessage.setMemberID("1");
		return eventMessage;
	}
	
	private EventMessage createEnrollMessage(){
		
		EventMessage eventMessage= new EventMessage();
		eventMessage.setActionID("ENROLL1");
		eventMessage.setEventType("ENROLL");
		
		
		Enroll enroll=new Enroll();
		enroll.setAddress_l1("Test");
		enroll.setAddress_l2("Test2");
		enroll.setCity("Delhi");
		enroll.setCountry("India");
		enroll.setDob("10/02/2016");
		enroll.setEmail("chandan_kumar50@optum.com");
		enroll.setFname("Test1");
		enroll.setGender("M");
		enroll.setLname("Kumar");
		enroll.setNamePrefix("MR");
		enroll.setMname("");
		enroll.setPhone("9650512384");
		enroll.setPostal("110092");
		enroll.setPref("BOTH");
		enroll.setState("Delhi");
		eventMessage.setEnroll(enroll);
		
		return eventMessage;
		
	}
	
	@Autowired
	SMSSender sms_sender;
	
	@Autowired
	MailSender mail_sender;
	
	@GetMapping("/sendSMS")
	public String sendSMS() {
		
		CommunicationMessageDTO communication_message = new CommunicationMessageDTO();
		communication_message.setMember_phone("+918860350824");
		communication_message.setMember_phone_country_code("IN");
		communication_message.setComplete_message_sms("Test SMS");
		
		if(communication_message!=null)
		{
			if(communication_message.getMember_phone_secure_messaging_id()!=null && !"".equals(communication_message.getMember_phone_secure_messaging_id()))
			{
				sms_sender.sendSMSMessage(communication_message.getMember_phone_secure_messaging_id(),communication_message.getComplete_message_sms() );
			}
			else
			{
				sms_sender.sendSMSCompleteProcess(communication_message);
			}
		}
		
		
		return "HELLO";
	}

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody CommunicationMessageDTO communication_message) {
		
		if(communication_message!=null)
		{
			if(communication_message.getMember_phone_secure_messaging_id()!=null || !"".equals(communication_message.getMember_phone_secure_messaging_id()))
			{
				
			}
		}
		
		
		return "HELLO";
	}

}
