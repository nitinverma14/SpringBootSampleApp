package com.jarvis.communicator;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.velocity.VelocityEngineUtils;

import com.jarvis.dto.CommunicationMessageDTO;
 

public class MessageComposer {
    
	@Autowired
	private VelocityEngine velocityEngine;
	
   public CommunicationMessageDTO composeCommunicationMessage(CommunicationMessageDTO communication_message){
	   
	   Map<String, Object> variableMap = new HashMap<String, Object>();
	   variableMap.put("member_name", communication_message.getMemberName());
	   
	   String message_html="";
	   if(null != communication_message && !communication_message.getTemplate_name().equals("")){
		   message_html = "";// VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, communication_message.getTemplate_name()() + ".vm", "UTF-8", variableMap);
		}
	   
	  // communication_message.setComplete_message(message_html);
	return communication_message;	
   }

}