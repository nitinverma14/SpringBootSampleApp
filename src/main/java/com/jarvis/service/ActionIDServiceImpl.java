package com.jarvis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.entity.ActionIDInfo;
import com.jarvis.repository.ActionRepository;

@Service
public class ActionIDServiceImpl implements ActionIDService {

	@Autowired
	ActionRepository actionRepository;

	@Override
	public ActionIDInfo getPreferenceByActionID(String actionIDName) {

		return actionRepository.findByActionIDName(actionIDName);
	}

}
