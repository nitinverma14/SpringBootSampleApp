package com.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.constant.JarvisContant;
import com.jarvis.entity.RuleInfo;
import com.jarvis.repository.RuleRepository;

@Service
public class RuleEngineServiceImpl implements RuleEngineService {

	@Autowired
	RuleRepository ruleRepository;

	@Override
	public String getRuleCondition(String ruleName) {

		List<RuleInfo> info = ruleRepository.findByRuleName(ruleName);

		String ruleCondition = JarvisContant.NA;

		if (null != info && info.size() > 0) {
			for (RuleInfo ruleInfo : info) {
				if (ruleInfo.isActive())
					ruleCondition = ruleInfo.getRuleCondition();
			}
		}

		return ruleCondition;
	}

}
