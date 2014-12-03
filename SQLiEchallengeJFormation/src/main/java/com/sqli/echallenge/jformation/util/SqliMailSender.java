/**
 * 
 */
package com.sqli.echallenge.jformation.util;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;

/**
 * @author Mouad
 *
 */
public class SqliMailSender {

	private JavaMailSender mailSender;
	private VelocityEngine velocityEngine;
	
	public void sendMail(final String to, final String template, final SqliEmailModel model) throws Exception {
		
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
        	
            public void prepare(MimeMessage mimeMessage) throws Exception {
            	
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setSubject("NoReply");
                message.setTo(to);
                
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("model", model);
                
                @SuppressWarnings("deprecation")
				String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, map);
                message.setText(text, true);
            }
        };
        
        this.mailSender.send(preparator);
}
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}

	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
}
