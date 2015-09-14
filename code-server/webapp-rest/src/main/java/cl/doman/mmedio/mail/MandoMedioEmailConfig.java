package cl.doman.mmedio.mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;

import org.apache.commons.mail.DefaultAuthenticator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.base.template.TemplateComposer;
import cl.doman.base.template.ThymeleafTemplateComposer;
import cl.doman.core.mail.EmailAccount;
import cl.doman.core.mail.config.EmailCustomConfig;

public class MandoMedioEmailConfig extends EmailCustomConfig{
	static Logger log =LoggerFactory.getLogger(MandoMedioEmailConfig.class);
	static final private String PROPERTIES_FILE =  "/etc/troncador/mandomedio/mail.properties";
	
	static private String basePATH = "/opt/html/troncador/mandomedio/templates/"; 
	
	static final private EmailAccount emailAccount = 
			new EmailAccount("webmmedio@mandomedio.com", "Mando Medio");
	static final private Authenticator authenticator = 
			new DefaultAuthenticator("webmmedio@mandomedio.com","Lunes2013");
	
	@Override
	public TemplateComposer getEngine() {
		return new ThymeleafTemplateComposer(basePATH,false);
	}
	
	@Override
	public Properties getProperties() {
		Properties properties = new Properties();
		try {
			InputStream fileInputStream = new FileInputStream(PROPERTIES_FILE);
			properties.load(fileInputStream);
			
		} catch (FileNotFoundException e) {
			log.error(e.getMessage(),e);
		} catch (IOException e) {
			log.error(e.getMessage(),e);
		}
		return properties;
	}

	@Override
	public EmailAccount getSenderEmailAccount() {
		return emailAccount;
	}

	@Override
	public Authenticator getAuthenticator() {
		return authenticator;
	}
}
