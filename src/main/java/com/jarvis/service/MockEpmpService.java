package com.jarvis.service;

import java.util.List;

import com.jarvis.entity.MemberInfo;

public interface MockEpmpService {
	MemberInfo save(MemberInfo memberInfo);
	
	MemberInfo updateMemberInfo(MemberInfo memberInfo);
    
    List<MemberInfo> getAllMembers();
    
    MemberInfo findByFirstNameIsLike(String Name);
}
