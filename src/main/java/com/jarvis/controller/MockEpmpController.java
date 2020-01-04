package com.jarvis.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jarvis.dto.MemberInfoDTO;
import com.jarvis.entity.MemberInfo;
import com.jarvis.enums.CountryEnum;
import com.jarvis.service.MockEpmpService;

@Controller
public class MockEpmpController {
	
	@Autowired
	MockEpmpService mockEpmpService;
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);

	
	@GetMapping("/mock_epmp")
	public String mock_epmp(Map<String, Object> model) {
		 model.put("memberInfoList", mockEpmpService.getAllMembers());
		 
	 MemberInfo info= mockEpmpService.findByFirstNameIsLike("Nitin");
		return "mockEpmpSearch";
	}
	
	@GetMapping("/mock_epmp_add")
	public String mock_epmp_add(Model model) {
		model.addAttribute("memberInfo", new MemberInfoDTO());
		
		return "mockEpmp";
	}
	
	@PostMapping("/mock_epmp_save")
	public String mock_epmp_save(@ModelAttribute("memberInfo") MemberInfoDTO memberInfoDTO,Map<String, Object> model) {
		System.out.println("Save Member Info..");
		System.out.println(memberInfoDTO.getFirstName());
		mockEpmpService.save(convertMemberDTOtoMemberInfo(memberInfoDTO));
		
		model.put("memberInfoList", mockEpmpService.getAllMembers());
		return "mockEpmpSearch";
	}
	
	@RequestMapping(value = "/getMemberInfoByName", method = RequestMethod.GET)
	public @ResponseBody MemberInfo getMemberInfoByName(@RequestParam(required = true) String name,
			HttpServletRequest request) {
		logger.info("Filter -> " + name);
		
		MemberInfo info= mockEpmpService.findByFirstNameIsLike(name);
		
		return info;
	}
	
	MemberInfo convertMemberDTOtoMemberInfo(MemberInfoDTO memberInfoDTO){
		MemberInfo info = new MemberInfo();
		info.setFirstName(memberInfoDTO.getFirstName());
		info.setLastName(memberInfoDTO.getLastName());
		info.setDob(memberInfoDTO.getDob());
		info.setEmailAddress(memberInfoDTO.getEmailAddress());
		info.setGender(memberInfoDTO.getGender());
		info.setAddressLine1(memberInfoDTO.getAddressLine1());
		info.setPhoneNumber(memberInfoDTO.getPhoneNumber());
		info.setCity(memberInfoDTO.getCity());
		info.setCountry(memberInfoDTO.getCountry());
		if(memberInfoDTO.getCountry().equalsIgnoreCase(CountryEnum.IN.getAttribute())){
			info.setCountryCode(CountryEnum.IN.getAttribute());
		}
		else{
			info.setCountryCode(CountryEnum.US.getAttribute());
		}
		
		info.setPreference(memberInfoDTO.getPreference());
		return info;
	}
}
