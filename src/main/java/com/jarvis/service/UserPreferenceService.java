package com.jarvis.service;

import java.util.Optional;

import com.jarvis.entity.MemberInfo;

public interface UserPreferenceService {
	
	String getMemberPreferenceByID(String memmerID);
	
	 Optional<MemberInfo> getMemberInfoByID(String memmerID);

}
