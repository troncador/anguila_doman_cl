package cl.doman.mmedio.mail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.activation.DataSource;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.core.mail.template.AttachFile;
import cl.doman.core.mail.template.EmailTemplate;
import cl.doman.core.mail.template.EmailTemplateException;
import cl.doman.mmedio.db.table.Curriculum;
import cl.doman.resource.mime.MimeTypeMapping;

public class CurriculumMail extends EmailTemplate{
	private static final transient Logger log = LoggerFactory.getLogger(CurriculumMail.class);
	private Curriculum curriculum;
	
	public CurriculumMail(Curriculum curriculum) throws EmailException, EmailTemplateException {
		super(new MandoMedioEmailConfig());
		this.curriculum = curriculum;
		construct();
	}
	
	@Override
	protected Map<String, ?> getVariableMap() {
		Map<String, Object> variableMap = new HashMap<String,Object>();
		variableMap.put("curriculum", curriculum);
		return variableMap;
	}

	@Override
	protected List<AttachFile> getAttachFiles() {
		List<AttachFile> attachFileList = new ArrayList<AttachFile>();
		byte[] byteArray = curriculum.getCurriculum();
		String extension = curriculum.getCurriculumExtension();
		
		String mime = MimeTypeMapping.getMimeType(extension);
		DataSource dataSource = new ByteArrayDataSource(byteArray,mime);

		String filename = String.format("curriculum.%s", extension);
		AttachFile attachFile= new AttachFile(dataSource, filename, "Curriculum Vitae");
		attachFileList.add(attachFile);
		
		return attachFileList;
	}

	@Override
	protected String getSubject() {
		String fullName = curriculum.getFullName();
		return String.format("[Curriculum] %s", fullName);
	}
	@Override
	protected String getTemplateName() {
		return "mail/curriculum";
	}
}
