package com.jarvis.communicator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
//import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jarvis.dto.AddPhoneResponse;
import com.jarvis.dto.CommunicationMessageDTO;
import com.jarvis.dto.ReceivingMessageDTO;
import com.jarvis.dto.SecureMessagingAuthenticationResponse;
import com.jarvis.dto.SecureMessagingConfirmPhoneResponse;
import com.jarvis.dto.SecureMessagingRequest;
import com.jarvis.dto.SecureMessagingResponse;
import com.jarvis.dto.SecureMessagingSendMessageResponse;
import com.jarvis.repository.SecureMessagingTokenRepository;
 
@Service
public class SMSSender {
	private static final Logger LOGGER =LoggerFactory.getLogger(SMSSender.class);
	
	@Value("${client.id}")
	private String client_id;

	@Value("${client.secret}")
	private String client_secret;

	@Value("${adapter.id}")
	private String adapter_id;
	
	@Value("${program.id}")
	private String program_id;
	
	@Value("${grant.type}")
	private String grant_type;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	RestTemplate restTemplate;
	
	 @Autowired
	 private SecureMessagingTokenRepository secureMessagingTokenRepository;
	
	public SecureMessagingAuthenticationResponse getAuthenticationToken()
	{
		/*SecureMessagingAccessToken access_token = null; 
		
		access_token = secureMessagingTokenRepository.findByActiveFlag(true);*/
		
		SecureMessagingAuthenticationResponse response = new SecureMessagingAuthenticationResponse();
		
		/*if(access_token.getAccess_token()==null || "".equals(access_token.getAccess_token()))
		{
		response = createAuthenticationToken(client_id, client_secret,grant_type);
		}
		else
		{
			response.setAccess_token(access_token.getAccess_token());
			response.setToken_type(access_token.getToken_type());
		}*/
		
		response = createAuthenticationToken(client_id, client_secret,grant_type);
		return response;
	}
    
   public ReceivingMessageDTO sendSMSCompleteProcess(CommunicationMessageDTO communication_message){
	   
	   ReceivingMessageDTO receiving_message = new ReceivingMessageDTO();
	   
	   SecureMessagingResponse response = null;
	   
	  if(communication_message!=null)
	  {
		  if(!"".equals(communication_message.getMember_phone()) && !"".equals(communication_message.getComplete_message_sms())
				&&  communication_message.getMember_phone() !=null && communication_message.getComplete_message_sms()!=null)
		  {
			  SecureMessagingAuthenticationResponse  auth_response = createAuthenticationToken(client_id, client_secret,grant_type); 
			 
			 if(auth_response!=null && !"".equals(auth_response))
			 {
				 String access_token=auth_response.getAccess_token();
				 String access_type=auth_response.getToken_type();
				 AddPhoneResponse add_phone_response = new AddPhoneResponse();
				 add_phone_response = addNewPhone(auth_response.getAccess_token(), auth_response.getToken_type(), communication_message.getMember_phone(), communication_message.getMember_phone_country_code());
			 
				 if(add_phone_response!=null && !"".equals(add_phone_response))
				 {
					 if(add_phone_response.getResponse_unique_id()!=null || !"".equals(add_phone_response.getResponse_unique_id()))
						 response = subscribePhone(access_token, access_type, add_phone_response.getResponse_unique_id(), program_id);
				 
					 if(response!=null && !"".equals(response))
					 {
						 SecureMessagingConfirmPhoneResponse conf_response = null;
						 if(response.getResponse_unique_id()!=null || !"".equals(response.getResponse_unique_id()))
							 conf_response  = new SecureMessagingConfirmPhoneResponse();
							 
						 conf_response=  confirmPhone(access_token, access_type, response.getPhone_id(), program_id);
						
						 if(conf_response!=null && !"".equals(conf_response))
						 {
							 SecureMessagingSendMessageResponse send_response=null;
							 if(conf_response.getStatus()!=null || !"Confirmed".equalsIgnoreCase(conf_response.getStatus()))
								 send_response = new SecureMessagingSendMessageResponse();
							 send_response = sendSMSMessage(conf_response.getPhone_id(), communication_message.getComplete_message_sms());
						 }
					 }
				 }
			 
			 }
		  }
	  }
	return receiving_message;	
   }

private SecureMessagingAuthenticationResponse createAuthenticationToken(String client_id, String client_secret, String grant_type) {
	
	String apiUrl = environment.getRequiredProperty("base.messaging_uri");
	apiUrl = apiUrl + "oauth2/token.json";
	
	SecureMessagingAuthenticationResponse response = new SecureMessagingAuthenticationResponse();
	
	SecureMessagingRequest secureMessagingRequest = new SecureMessagingRequest(client_id,
			client_secret, grant_type);
	
	try {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		
		HttpEntity<SecureMessagingRequest> postRequest = new HttpEntity<SecureMessagingRequest>(secureMessagingRequest, headers);
		response = restTemplate.postForObject(apiUrl, postRequest, SecureMessagingAuthenticationResponse.class);
		if (null != response && !"".equals(response)) {
			LOGGER.info("Auth Token Response from Secure Messaging" + response);
		}
	}catch (Exception e) {
		LOGGER.error("Error from Authentication Token API");
		}
	
	return response;
}

private AddPhoneResponse addNewPhone(String authentication_token, String token_type, String member_phone, String member_phone_country_code) {
	String apiUrl = environment.getRequiredProperty("base.messaging_uri");
	apiUrl = apiUrl + "smsmgr/v1/phones";
	
	AddPhoneResponse response = new AddPhoneResponse();
	
	SecureMessagingRequest secureMessagingRequest = new SecureMessagingRequest(member_phone,
			member_phone_country_code);
	
	try {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", token_type+" "+authentication_token);
		
		HttpEntity<SecureMessagingRequest> postRequest = new HttpEntity<SecureMessagingRequest>(secureMessagingRequest, headers);
		response = restTemplate.postForObject(apiUrl, postRequest, AddPhoneResponse.class);
		if (null != response && !"".equals(response)) {
			LOGGER.info("Add Phone Response from Secure Messaging" + response);
			
		}
	}catch (Exception e) {
		LOGGER.error("Error from Authentication Token API");
		}
	
	return response;
}

private SecureMessagingResponse subscribePhone(String authentication_token, String token_type, String member_phone_id,
		String member_program_id) {
	
	String apiUrl = environment.getRequiredProperty("base.messaging_uri");
	apiUrl = apiUrl + "smsmgr/v1/phones/"+member_phone_id+"/subscribe";
	
	SecureMessagingResponse response = new SecureMessagingResponse();
	
	SecureMessagingRequest secureMessagingRequest = new SecureMessagingRequest();
	
	secureMessagingRequest.setPhone_id(member_phone_id);
	secureMessagingRequest.setProgram_id(member_program_id);
	
	try {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", token_type+" "+authentication_token);
		
		HttpEntity<SecureMessagingRequest> postRequest = new HttpEntity<SecureMessagingRequest>(secureMessagingRequest, headers);
		response = restTemplate.postForObject(apiUrl, postRequest, SecureMessagingResponse.class);
		if (null != response && !"".equals(response)) {
			LOGGER.info("Subscribe Phone Response from Secure Messaging" + response);
			
		}
	}catch (Exception e) {
		LOGGER.error("Error from Subscribe Phone API");
		}
	
	return response;
}

private SecureMessagingConfirmPhoneResponse confirmPhone(String authentication_token, String token_type, String member_phone_id, 
		String member_program_id) {
	
	String apiUrl = environment.getRequiredProperty("base.messaging_uri");
	apiUrl = apiUrl + "smsmgr/v1/phones/"+member_phone_id+"/confirm";
	
	SecureMessagingConfirmPhoneResponse response = new SecureMessagingConfirmPhoneResponse();
	
	SecureMessagingRequest secureMessagingRequest = new SecureMessagingRequest();
	
	secureMessagingRequest.setPhone_id(member_phone_id);
	secureMessagingRequest.setProgram_id(member_program_id);
	
	try {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", token_type+" "+authentication_token);
		
		HttpEntity<SecureMessagingRequest> postRequest = new HttpEntity<SecureMessagingRequest>(secureMessagingRequest, headers);
		response = restTemplate.postForObject(apiUrl, postRequest, SecureMessagingConfirmPhoneResponse.class);
		if (null != response && !"".equals(response)) {
			LOGGER.info("Confirm Phone Response from Secure Messaging" + response);
			
		}
	}catch (Exception e) {
		LOGGER.error("Error from Confirm Phone API");
		}
	
	return response;
}


public SecureMessagingSendMessageResponse sendSMSMessage(String member_phone_id,
		String sms_text) {
	
	SecureMessagingAuthenticationResponse authentication_response = getAuthenticationToken();

	String apiUrl = environment.getRequiredProperty("base.messaging_uri");
	apiUrl = apiUrl + "smsmgr/v1/programs/"+program_id+"/phones/"+member_phone_id+"/outbound-messages";
	
	SecureMessagingSendMessageResponse response = new SecureMessagingSendMessageResponse();
	
	SecureMessagingRequest secureMessagingRequest = new SecureMessagingRequest();
	
	secureMessagingRequest.setSms_body(sms_text);
	secureMessagingRequest.setSend_immediatly_flag("true");
	
	try {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");
		headers.set("Authorization", authentication_response.getToken_type()+" "+authentication_response.getAccess_token());
		
		HttpEntity<SecureMessagingRequest> postRequest = new HttpEntity<SecureMessagingRequest>(secureMessagingRequest, headers);
		response = restTemplate.postForObject(apiUrl, postRequest, SecureMessagingSendMessageResponse.class);
		if (null != response && !"".equals(response)) {
			if(!"5001".equalsIgnoreCase(response.getCode()) && "sent".equalsIgnoreCase(response.getStatus()))
			{
				LOGGER.info("SMS sent to" + response.getPhone_id()+" via Secure Messaging");
			}
			else if("5001".equalsIgnoreCase(response.getCode()))
			{
				//secureMessagingTokenRepository.deleteAllTokens();
				
				sendSMSMessage(member_phone_id,sms_text);
				
			}
			
		}
	}catch (Exception e) {
		LOGGER.error("Error from Send Message API");
		}
	
	return response;
}

}