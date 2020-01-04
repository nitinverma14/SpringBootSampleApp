
package com.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.entity.MemberInfo;
import com.jarvis.repository.MockEpmpRepository;


@Service
public class MockEpmpServiceImpl implements MockEpmpService {
    @Autowired
    private MockEpmpRepository mockEpmpRepository;
   

    @Override
    public MemberInfo save(MemberInfo memberInfo) {
       
    	return mockEpmpRepository.save(memberInfo);
    }


	@Override
	public List<MemberInfo> getAllMembers() {
		return mockEpmpRepository.findAll();
	}


	@Override
	public MemberInfo findByFirstNameIsLike(String name) {
		return mockEpmpRepository.findByFirstNameIsLike(name);
	}


	@Override
	public MemberInfo updateMemberInfo(MemberInfo memberInfo) {
		return mockEpmpRepository.save(memberInfo);
	}



}
