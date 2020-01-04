package com.jarvis.service;

import java.util.List;

import com.jarvis.entity.RuleInfo;

public interface RuleService {
    void save(RuleInfo ruleInfo);
    
    List<RuleInfo> getAllRuleInfo();
    
    void update(List<RuleInfo> ruleInfoList);
    
}
