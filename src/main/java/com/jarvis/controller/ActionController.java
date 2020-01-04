package com.jarvis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis.dto.ActionInfoDTO;
import com.jarvis.dto.ActionInfoForm;
import com.jarvis.dto.RuleInfoDTO;
import com.jarvis.dto.RuleInfoForm;
import com.jarvis.entity.ActionIDInfo;
import com.jarvis.entity.RuleInfo;
import com.jarvis.enums.TemplateEnum;
import com.jarvis.service.ActionService;
import com.jarvis.util.TemplateUtil;

@Controller
public class ActionController {
	
	@Autowired
	ActionService actionService;
	
	@Autowired
	TemplateUtil templateUtil;
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	
	/*@GetMapping("/actions")
	public String mock_epmp(Map<String, Object> model) {
		model.put("actionList", actionService.getAllActionInfo());
		 
		return "actionSearch";
	}
	*/
	
	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public ModelAndView get(Map<String, Object> model) {

		ActionInfoForm actionInfoForm = new ActionInfoForm();
		List<ActionInfoDTO> actionList = new ArrayList<>();

		for (ActionIDInfo info : actionService.getAllActionInfo()) {
			actionList.add(convertActiontoActionInfoDTO(info));
		}
		actionInfoForm.setActionInfoDTO(actionList);
		
		model.put("smsPreferenceMap", templateUtil.getTemplates(TemplateEnum.SMS));
		model.put("emailPreferenceMap", templateUtil.getTemplates(TemplateEnum.EMAIL));

		return new ModelAndView("actionSearch", "actionInfoForm", actionInfoForm);
	}
	
	@RequestMapping(value = "/action_update", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("actionInfoForm") ActionInfoForm actionInfoForm,Map<String, Object> model) {

		List<ActionIDInfo> actionInfoList = new ArrayList<>();
		for (ActionInfoDTO actionInfoDTO : actionInfoForm.getActionInfoDTO()) {
			actionInfoList.add(convertActionDTOtoActionInfo(actionInfoDTO));
		}

		actionService.update(actionInfoList);
		model.put("message", "Updated Successfully");
		actionInfoForm.setActionInfoDTO(actionInfoForm.getActionInfoDTO());
		
		model.put("smsPreferenceMap", templateUtil.getTemplates(TemplateEnum.SMS));
		model.put("emailPreferenceMap", templateUtil.getTemplates(TemplateEnum.EMAIL));
		
		return new ModelAndView("actionSearch", "actionInfoForm", actionInfoForm);
	}
	
	
	ActionIDInfo convertActionDTOtoActionInfo(ActionInfoDTO actionInfoDTO) {
		ActionIDInfo info = new ActionIDInfo();
		info.setId(actionInfoDTO.getId());
		info.setActionIDName(actionInfoDTO.getActionIDName());
		info.setActionIDPreference(actionInfoDTO.getActionIDPreference());
		info.setDescription(actionInfoDTO.getDescription());
		info.setTempleteSMSPreference(actionInfoDTO.getTempleteSMSPreference());
		info.setTempleteEMAILPreference(actionInfoDTO.getTempleteEMAILPreference());
		info.setActive(actionInfoDTO.getActive() == null ? false : actionInfoDTO.getActive());
		return info;
	}

	ActionInfoDTO convertActiontoActionInfoDTO(ActionIDInfo actionInfo) {
		ActionInfoDTO info = new ActionInfoDTO();
		info.setId(actionInfo.getId());
		info.setActionIDName(actionInfo.getActionIDName());
		info.setActionIDPreference(actionInfo.getActionIDPreference());
		info.setDescription(actionInfo.getDescription());
		info.setTempleteSMSPreference(actionInfo.getTempleteSMSPreference());
		info.setTempleteEMAILPreference(actionInfo.getTempleteEMAILPreference());
		info.setActive(actionInfo.isActive());
		return info;
	}
	
}
