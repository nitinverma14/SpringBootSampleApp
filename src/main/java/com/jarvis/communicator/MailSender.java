package com.jarvis.communicator;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailSender {

	/*@Value("${mail.host}")
	private String host;

	@Value("${mail.port}")
	private Integer port;

	@Value("${mail.fromname}")
	private String name;
	
	@Value("${mail.from}")
	private String from;

	@Autowired
	private VelocityEngine velocityEngine;*/
	
	@Async
	public void sendEmail() {
		/*Email email = new Email();
		email.setFromAddress(name, from);
		
		String html = "";
		if(null != mailDTO && !mailDTO.getTemplate().equals("")){
			html = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, mailDTO.getTemplate() + ".vm", "UTF-8", mailDTO.getVariableMap());
		}
		
		email.setTextHTML(html);
		email.setSubject(mailDTO.getSubject());

		if (null != mailDTO.getTo() && mailDTO.getTo().size() > 0) {
			for (Map.Entry<String, String> entry : mailDTO.getTo().entrySet()) {
				email.addRecipient(entry.getValue(), entry.getKey(), RecipientType.TO);
			}
		}

		if (null != mailDTO.getCc() && mailDTO.getCc().size() > 0) {
			for (Map.Entry<String, String> entry : mailDTO.getCc().entrySet()) {
				email.addRecipient(entry.getValue(), entry.getKey(), RecipientType.CC);
			}
		}

		new Mailer(host, port, from, "", TransportStrategy.SMTP_TLS).sendMail(email);*/
	}
}
