package com.jarvis.user.preference;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.jarvis.constant.ErrorConstant;
import com.jarvis.constant.JarvisContant;
import com.jarvis.dto.CommunicationMessage;
import com.jarvis.entity.ActionIDInfo;
import com.jarvis.entity.MemberInfo;
import com.jarvis.service.ActionIDService;
import com.jarvis.service.UserPreferenceService;

public class UserPreference {
	
	@Autowired
	UserPreferenceService preferenceService;
	
	@Autowired
	ActionIDService actionIDService;

	public Message<CommunicationMessage> setUserPreference(Message<CommunicationMessage> message){
		
		CommunicationMessage communicationMessage=message.getPayload();
		
		ActionIDInfo actionIDInfo=actionIDService.getPreferenceByActionID(communicationMessage.getActionID());
		
		Optional<MemberInfo> memberInfos=preferenceService.getMemberInfoByID(communicationMessage.getMemberID());
		 if(memberInfos.isPresent()){
			MemberInfo memberInfo=memberInfos.get();
			String preference=memberInfo.getPreference();
			if(preference.equals(JarvisContant.NA))
				communicationMessage.setPreference(actionIDInfo.getActionIDPreference());
			else
				communicationMessage.setPreference(preference);
			
			communicationMessage.setTempletePreference(actionIDInfo.getTempletePreference());
			communicationMessage.setMemberName(memberInfo.getFirstName()+" "+memberInfo.getLastName());
			communicationMessage.setEmail(memberInfo.getEmailAddress());
			communicationMessage.setPhoneNumber(memberInfo.getPhoneNumber());
			if(null!=memberInfo.getPhoneID()){
				communicationMessage.setPhoneID(memberInfo.getPhoneID());
			}
		}
		else{
			communicationMessage.setErrorCode(ErrorConstant.ERROR_101);
			communicationMessage.setErrorMsg(ErrorConstant.ERROR_101_MSG);
		}


		return MessageBuilder.withPayload(communicationMessage).build();
		
	}
	
}
