package com.jarvis.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jarvis.converter.TemplateConvertor;
import com.jarvis.dto.TemplateDto;
import com.jarvis.enums.TemplateEnum;
import com.jarvis.repository.TemplateRepository;
import com.jarvis.util.TemplateUtil;
import com.jarvis.validator.SmsTemplateValidator;

@Controller
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	@Autowired
	TemplateUtil templateUtil;

	@GetMapping("/templates")
	public String templates(Model model) {
		model.addAttribute("templatesList", templateUtil.getAllTemplates());
		return "templates";
	}

	@GetMapping("/add_email_template")
	public String add_email_template(Model model) {
		return "au_email_template";
	}

	@GetMapping("/manage_sms_template/{ops}")
	public String manage_sms_template(@ModelAttribute TemplateDto templateDto, @PathVariable String ops, Model model, @RequestParam(required=false) String token) {
		logger.info("Rendering SMS template form");
		templateDto.setOps(ops);
		if ("a".equalsIgnoreCase(ops)) {
			templateDto.setTemplate(templateUtil.getSampleTemplate(TemplateEnum.SMS));
		} else {
			templateDto = templateConvertor.getDtoFromEntity(token);
			templateDto.setOps("u");
		}
		model.addAttribute("templateDto", templateDto);
		return "au_sms_template";
	}

	@Autowired
	SmsTemplateValidator smsTemplateValidator;

	@Autowired
	TemplateConvertor templateConvertor;

	@Autowired
	TemplateRepository templateRepository;

	@PostMapping("/au_sms_template")
	public String au_sms_template(@ModelAttribute TemplateDto templateDto, Model model, BindingResult result,
			HttpServletRequest request) {
		model.addAttribute("templateDto", templateDto);
		try {
			smsTemplateValidator.validate(templateDto, result);
			if (result.hasErrors()) {
				return "au_sms_template";
			} else {
				if (templateDto.getOps().equalsIgnoreCase("a")) {
					// ADD
					templateRepository.save(templateConvertor.getTemplateFromDto(templateDto));
				} else {
					// UPDATE
				}
				return "redirect:/templates";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "Internal Server Error");
			return "au_sms_template";
		}

	}
}