package cl.doman.mmedio.configuration;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.core.mail.EmailAccount;
import cl.doman.core.mail.template.EmailTemplateException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.mmedio.db.table.ContactMessage;
import cl.doman.mmedio.mail.ContactMail;
import cl.doman.mmedio.mail.MandoMedioEmailConfig;

public class Main {
	static Logger log =LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) throws QueryException, EmailException, EmailTemplateException {
		ServletContext.init();
		
		StandardQuery<ContactMessage> query = new StandardQuery<ContactMessage>(ContactMessage.class);
		ContactMessage contactMessage = query.get(1);
		
		log.info(contactMessage.getCountry().getName());
		ContactMail mailSender = new ContactMail(contactMessage);
		EmailAccount emailAccount = new EmailAccount("benjamin.almarza@gmail.com");
		mailSender.addTo(emailAccount);
		mailSender.send();
		
		
		
		new MandoMedioEmailConfig().getEngine();
		

	}

}
