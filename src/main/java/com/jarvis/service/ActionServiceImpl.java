package com.jarvis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.entity.ActionIDInfo;
import com.jarvis.repository.ActionRepository;


@Service
public class ActionServiceImpl implements ActionService {
    @Autowired
    private ActionRepository actionRepository;
   

    @Override
    public void save(ActionIDInfo actionInfo) {
       
    	actionRepository.save(actionInfo);
    }


	@Override
	public List<ActionIDInfo> getAllActionInfo() {
		return actionRepository.findAll();
	}


	@Override
	public void update(List<ActionIDInfo> actionInfoList) {
		// TODO Auto-generated method stub
		
		actionRepository.saveAll(actionInfoList);
	}

	


}
