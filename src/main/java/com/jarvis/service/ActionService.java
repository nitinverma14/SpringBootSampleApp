package com.jarvis.service;

import java.util.List;

import com.jarvis.entity.ActionIDInfo;
import com.jarvis.entity.RuleInfo;

public interface ActionService {
    void save(ActionIDInfo actionInfo);
    
    List<ActionIDInfo> getAllActionInfo();
    
    void update(List<ActionIDInfo> actionInfoList);
}
