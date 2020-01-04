package com.jarvis.epmp;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.jarvis.constant.ErrorConstant;
import com.jarvis.dto.CommunicationMessage;
import com.jarvis.dto.Enroll;
import com.jarvis.dto.EventMessage;
import com.jarvis.entity.MemberInfo;
import com.jarvis.enums.CountryEnum;
import com.jarvis.service.MockEpmpService;
import com.jarvis.service.UserPreferenceService;

public class EpmpUpdateProcessor {
	
	@Autowired
	MockEpmpService mockEpmpService;
	
	@Autowired
	UserPreferenceService preferenceService;

	public Message<CommunicationMessage> genarateIDCard(Message<EventMessage> message) {

		EventMessage eventMessage = message.getPayload();

		CommunicationMessage communicationMessage = new CommunicationMessage();
	    
	    Optional<MemberInfo> memberInfos=preferenceService.getMemberInfoByID(eventMessage.getMemberID());
	    
	    MemberInfo memberInfo;
	    Random rnd;
	    String idcardnumber;
	    if(memberInfos.isPresent()){
			memberInfo=memberInfos.get();
			rnd = new Random();
			idcardnumber = "IDCARD"+rnd.nextInt(999999);
			memberInfo.setIdcard(idcardnumber);
			mockEpmpService.updateMemberInfo(memberInfo);
			communicationMessage.setActionID(eventMessage.getActionID());
			communicationMessage.setMemberID(eventMessage.getMemberID());
			communicationMessage.setIdcard(idcardnumber);
	    }
	    else{
	    	communicationMessage.setErrorCode(ErrorConstant.ERROR_101);
			communicationMessage.setErrorMsg(ErrorConstant.ERROR_101_MSG);
	    }
	    return MessageBuilder.withPayload(communicationMessage).build();

	}

	public Message<CommunicationMessage> enrollMember(Message<EventMessage> message) {

		EventMessage eventMessage = message.getPayload();
		
		CommunicationMessage communicationMessage = new CommunicationMessage();
		
		MemberInfo info=mockEpmpService.save(convertEntolltoMemberInfo(eventMessage.getEnroll()));
		
		if(null!=info){
			communicationMessage.setActionID(eventMessage.getActionID());
			communicationMessage.setMemberID(info.getId().toString());
		}
		else{
	    	communicationMessage.setErrorCode(ErrorConstant.ERROR_101);
			communicationMessage.setErrorMsg(ErrorConstant.ERROR_101_MSG);
	    }
		return MessageBuilder.withPayload(communicationMessage).build();

	}
	
	MemberInfo convertEntolltoMemberInfo(Enroll enrollInfo){
		MemberInfo info = new MemberInfo();
		info.setFirstName(enrollInfo.getFname());
		info.setLastName(enrollInfo.getLname());
		info.setDob(enrollInfo.getDob());
		info.setEmailAddress(enrollInfo.getEmail());
		info.setGender(enrollInfo.getGender());
		info.setAddressLine1(enrollInfo.getAddress_l1());
		info.setPhoneNumber(enrollInfo.getPhone());
		info.setCity(enrollInfo.getCity());
		info.setCountry(enrollInfo.getCountry());
		if(enrollInfo.getCountry().equalsIgnoreCase(CountryEnum.IN.getAttribute())){
			info.setCountryCode(CountryEnum.IN.getAttribute());
		}
		else{
			info.setCountryCode(CountryEnum.US.getAttribute());
		}
		info.setPreference(enrollInfo.getPref());
		return info;
	}

}
