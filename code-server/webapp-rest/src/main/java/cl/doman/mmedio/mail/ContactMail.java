package cl.doman.mmedio.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.core.mail.template.AttachFile;
import cl.doman.core.mail.template.EmailTemplate;
import cl.doman.core.mail.template.EmailTemplateException;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactMessage;

public class ContactMail extends EmailTemplate{
	private static final transient Logger log = LoggerFactory.getLogger(ContactMail.class);
	private ContactMessage contactMessage;

	public ContactMail(ContactMessage contactMessage)
			throws EmailException, EmailTemplateException {
		super(new MandoMedioEmailConfig());
		this.contactMessage = contactMessage;

		construct();
	}

	@Override
	protected Map<String, ?> getVariableMap() {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("contactMessage", contactMessage);
		return variables;
	}

	@Override
	protected List<AttachFile> getAttachFiles() {
		return new ArrayList<AttachFile>();
	}

	@Override
	protected String getSubject() {
		ContactArea contactArea = contactMessage.getContactArea();
		String areaName = contactArea.getName();
		String fullname = contactMessage.getFullName();
		return String.format("[Contacto][%s] %s", areaName,fullname);
	}

	@Override
	protected String getTemplateName() {
		return "mail/contact";
	}
}
