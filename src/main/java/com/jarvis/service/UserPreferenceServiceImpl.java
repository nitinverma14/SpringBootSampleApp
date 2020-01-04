package com.jarvis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.constant.JarvisContant;
import com.jarvis.entity.MemberInfo;
import com.jarvis.repository.MockEpmpRepository;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {

	@Autowired
	MockEpmpRepository mockEpmpRepository;

	@Override
	public String getMemberPreferenceByID(String memmerID) {

		MemberInfo memberInfo = mockEpmpRepository.getOne(Long.parseLong(memmerID));

		String preference = JarvisContant.NA;

		if (null != memberInfo) {
			preference = memberInfo.getPreference();
		}
		return preference;
	}

	@Override
	public Optional<MemberInfo> getMemberInfoByID(String memberID) {
		return mockEpmpRepository.findById(Long.parseLong(memberID));
	}

}
