package com.jarvis.converter;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarvis.dto.TemplateDto;
import com.jarvis.entity.Template;
import com.jarvis.enums.TemplateEnum;
import com.jarvis.repository.TemplateRepository;
import com.jarvis.repository.UserRepository;
import com.jarvis.util.AppUserUtil;
import com.jarvis.util.Crypto;

@Component
public class TemplateConvertor {

	@Autowired
	Crypto crypto;
	
	@Autowired
	AppUserUtil appUserUtil;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TemplateRepository templateRepository;
	
	public Template getTemplateFromDto(TemplateDto templateDto) {
		Template template = new Template();
		template.setActive(templateDto.getActive());
		template.setContent(templateDto.getTemplate());
		template.setTempNo(UUID.randomUUID().toString().toUpperCase());
		template.setTempType(TemplateEnum.SMS);
		template.setTitle(templateDto.getTitle());
		template.setCreatedBy(userRepository.findByUsername(appUserUtil.getUsername()));
		template.setCreatedDate(new Date());
		template.setLastModifiedBy(userRepository.findByUsername(appUserUtil.getUsername()));
		template.setLastModifiedDate(new Date());
		return template;
	}

	public TemplateDto getDtoFromEntity(String token) {
		TemplateDto dto = new TemplateDto();
		try {
			Template temp = templateRepository.getOne(Long.parseLong(token));
			dto.setActive(temp.isActive());
			dto.setIdr(temp.getId().toString());
			dto.setTemplate(temp.getContent());
			dto.setTitle(temp.getTitle());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
}
