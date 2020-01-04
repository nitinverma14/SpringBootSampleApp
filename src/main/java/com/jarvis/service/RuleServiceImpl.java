package com.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.entity.RuleInfo;
import com.jarvis.repository.RuleRepository;


@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleRepository ruleRepository;
   

    @Override
    public void save(RuleInfo ruleInfo) {
       
    	ruleRepository.save(ruleInfo);
    }


	@Override
	public List<RuleInfo> getAllRuleInfo() {
		return ruleRepository.findAll();
	}

	@Override
    public void update(List<RuleInfo> ruleInfoList) {
       
    	ruleRepository.saveAll(ruleInfoList);
    }


}
