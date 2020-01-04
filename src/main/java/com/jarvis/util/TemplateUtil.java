package com.jarvis.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.RuntimeSingleton;
import org.apache.velocity.runtime.parser.node.SimpleNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarvis.dto.TemplateIngest;
import com.jarvis.entity.Template;
import com.jarvis.enums.TemplateEnum;
import com.jarvis.repository.TemplateRepository;

@Component
public class TemplateUtil {

	@Autowired
	TemplateRepository templateRepository;
	
	@Autowired
	Crypto crypto;
	
	public String getSampleTemplate(TemplateEnum templateEnum) {
		String template = "";
		InputStream inputStream = null;
		try {
			if(templateEnum.equals(TemplateEnum.SMS)) {
				inputStream = this.getClass().getResourceAsStream("/sms_sample_template.txt");
			}else if(templateEnum.equals(TemplateEnum.EMAIL)) {
				inputStream = this.getClass().getResourceAsStream("/email_sample_template.txt");
			}
			return readFromInputStream(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
		    if (inputStream != null) {
		        try {
		            inputStream.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		}
		return template;
	}
	
	private String readFromInputStream(InputStream inputStream)
			  throws IOException {
			    StringBuilder resultStringBuilder = new StringBuilder();
			    try (BufferedReader br
			      = new BufferedReader(new InputStreamReader(inputStream))) {
			        String line;
			        while ((line = br.readLine()) != null) {
			            resultStringBuilder.append(line).append("\n");
			        }
			    }
			  return resultStringBuilder.toString();
	}

	public List<Template> getAllTemplates() {
		return templateRepository.findAllByOrderByLastModifiedDateDesc();
	}
	
	public Map<String, String> getTemplates(TemplateEnum tempType) {
		Map<String, String> smsTemplates = new LinkedHashMap<String, String>();
		try {
			List<Template> templates = templateRepository.findByTempTypeAndActiveByOrderByTitleAsc(tempType, true);
			if(null != templates){
				for(Template t : templates) {
					smsTemplates.put(crypto.encrypt(t.getId().toString()), t.getTitle());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return smsTemplates;
	}
	
	public String getMergedTemplate(String encryotedTemplateId, TemplateIngest templateIngest) {
		try {
			Template tE = templateRepository.getOne(Long.parseLong(crypto.decrypt(encryotedTemplateId)));
			RuntimeServices rs = RuntimeSingleton.getRuntimeServices();            
			StringReader sr = new StringReader(tE.getContent());
			SimpleNode sn = rs.parse(sr, tE.getTitle());
			 
			org.apache.velocity.Template t = new org.apache.velocity.Template();
			    t.setRuntimeServices(rs);
			    t.setData(sn);
			    t.initDocument();
			 
			VelocityContext vc = new VelocityContext();
			vc.put("name", templateIngest.getName());
			vc.put("email", templateIngest.getEmail());
			vc.put("phone", templateIngest.getPhone());
			 
			StringWriter sw = new StringWriter();
			t.merge(vc, sw);
			return sw.toString();
		}catch(Exception e) {
			e.printStackTrace();
			return "NA";
		}
	}
}
