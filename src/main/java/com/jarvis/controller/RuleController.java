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

import com.jarvis.dto.RuleInfoDTO;
import com.jarvis.dto.RuleInfoForm;
import com.jarvis.entity.RuleInfo;
import com.jarvis.service.RuleService;

@Controller
public class RuleController {

	@Autowired
	RuleService ruleService;

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	/*
	 * @GetMapping("/rules") public String mock_epmp(Map<String, Object> model)
	 * { model.put("ruleList", ruleService.getAllRuleInfo());
	 * 
	 * return "ruleSearch"; }
	 */

	@RequestMapping(value = "/rules", method = RequestMethod.GET)
	public ModelAndView get(Map<String, Object> model) {

		RuleInfoForm ruleInfoForm = new RuleInfoForm();
		List<RuleInfoDTO> ruleList = new ArrayList<>();

		for (RuleInfo info : ruleService.getAllRuleInfo()) {
			ruleList.add(convertRuletoRuleInfoDTO(info));
		}
		ruleInfoForm.setRuleInfoDTO(ruleList);

		return new ModelAndView("ruleSearch", "ruleInfoForm", ruleInfoForm);
	}

	@RequestMapping(value = "/rule_update", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("ruleInfoForm") RuleInfoForm ruleInfoForm,Map<String, Object> model) {

		List<RuleInfo> ruleInfoList = new ArrayList<>();
		for (RuleInfoDTO ruleInfoDTO : ruleInfoForm.getRuleInfoDTO()) {
			ruleInfoList.add(convertRuleDTOtoRuleInfo(ruleInfoDTO));
		}

		ruleService.update(ruleInfoList);
		model.put("message", "Updated Successfully");
		ruleInfoForm.setRuleInfoDTO(ruleInfoForm.getRuleInfoDTO());
		
		return new ModelAndView("ruleSearch", "ruleInfoForm", ruleInfoForm);
	}

	RuleInfo convertRuleDTOtoRuleInfo(RuleInfoDTO ruleInfoDTO) {
		RuleInfo info = new RuleInfo();
		info.setId(ruleInfoDTO.getId());
		info.setRuleCondition(ruleInfoDTO.getRuleCondition());
		info.setRuleName(ruleInfoDTO.getRuleName());
		info.setDescription(ruleInfoDTO.getDescription());
		info.setActive(ruleInfoDTO.getActive() == null ? false : ruleInfoDTO.getActive());
		return info;
	}

	RuleInfoDTO convertRuletoRuleInfoDTO(RuleInfo ruleInfo) {
		RuleInfoDTO info = new RuleInfoDTO();
		info.setId(ruleInfo.getId());
		info.setRuleCondition(ruleInfo.getRuleCondition());
		info.setRuleName(ruleInfo.getRuleName());
		info.setDescription(ruleInfo.getDescription());
		info.setActive(ruleInfo.isActive());
		return info;
	}
}
