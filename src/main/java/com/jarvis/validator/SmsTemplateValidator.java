package com.jarvis.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jarvis.dto.TemplateDto;

@Component
public class SmsTemplateValidator implements Validator {

	public boolean supports(Class clazz) {
		return TemplateDto.class.isAssignableFrom(clazz);
	}
	
	public void validate(Object target, Errors errors) 
	{
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.template.title.required", "error.template.title.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "template", "error.template.template.required", "error.template.template.required");
	}

}
