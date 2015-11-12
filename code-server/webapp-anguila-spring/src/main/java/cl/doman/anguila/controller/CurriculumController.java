package cl.doman.anguila.controller;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.doman.anguila.db.field.BooleanType;
import cl.doman.anguila.db.i.table.Country;
import cl.doman.anguila.db.i.table.Curriculum;
import cl.doman.anguila.db.query.ContactAreaQuery;
import cl.doman.anguila.db.query.CurriculumQuery;
import cl.doman.anguila.mail.CurriculumMail;
import cl.doman.core.mail.EmailAccount;
import cl.doman.core.mail.template.EmailTemplateException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.resource.validation.Formeable;
import cl.doman.resource.validation.MessageBean;
import cl.doman.resource.validation.MessageBean.MessageType;
import cl.doman.resource.validation.ParamHandler;
import cl.doman.springmvc.HttpStatusErrorException;

@Controller
public class CurriculumController extends BaseController implements Formeable{
	static Logger log =LoggerFactory.getLogger(CurriculumController.class);
	static private String formTemplate = "form/curriculum";
	static private String messageTemplate = "form/message";
	@Override
	public void validate(ParamHandler params) throws Exception {
		//me falta algún proceso de conversión posterior de variables:
		//ej: trim, si es entero convertirlo
		
		params.getValidation("name").required()
			.minlength(4)
			.maxlength(90);	
		
		params.getValidation("lastname").required()
			.minlength(4)
			.maxlength(90);
		
		params.getValidation("email").required()
			.email()
			.maxlength(100);
		
		params.getValidation("phone").required()
			.maxlength(30);
		
		params.getValidation("country").required()
			.exist(new StandardQuery<Country>(Country.class));
		
		params.getValidation("message").required()
			.maxlength(400);
		
	}
	
	
	
	@RequestMapping(value = {"/page/curriculum.html"}, method = RequestMethod.GET)
	public String formGet(ModelMap modelmap) throws QueryException {
		ContactAreaQuery query = new ContactAreaQuery();
		modelmap.put("contactAreaList", query.find());
		return formTemplate;
	}
	
	
	private Map<String, String[]> parameterMap = new HashMap<String, String[]>();
	private Map<String, FileItem> fileMap = new HashMap<String,FileItem>(); 
	
	private void init(HttpServletRequest request) throws  IOException, FileUploadException{
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//tamaño a partir del cual se escriben los archivos directamente en disco
		factory.setSizeThreshold(20000);
		factory.setRepository(new File("/tmp/"));
		ServletFileUpload upload = new ServletFileUpload(factory);
		//tamaño máximo aceptado
		upload.setSizeMax(1048576l+100000l);
		
		List<FileItem> items = upload.parseRequest(request);
		
		for(FileItem item: items){
		    if (!item.isFormField()) {
		    	String field = item.getFieldName();
		    	fileMap.put(field, item);
		    } else{
		    	String field = item.getFieldName();
		    	String content = item.getString();
		    	parameterMap.put(field,new String[]{content});
		    }
		} 
	
	}
	
	@RequestMapping(value = {"/page/curriculum.html"}, method = RequestMethod.POST)
	public String formsubmit(HttpServletRequest request,Object command, ModelMap model) throws QueryException, HttpStatusErrorException, IOException {
		
		formGet(model);
		
		try {
			init(request);
		} catch (FileUploadException e1) {
			//TODO: problema arreglar
			throw new QueryException();
		}
		
		ParamHandler paramHandler = new ParamHandler(parameterMap);
		FileItem fileItem= null;
		try {
			validate(paramHandler);
			if(fileMap.containsKey("cv")){
				fileItem = fileMap.get("cv");
				String filename = fileItem.getName();
				String extension = FilenameUtils.getExtension(filename);
				if(extension == null || !extension.matches("(pdf)|(doc)|(docx)")){
					model.addAttribute("message", new MessageBean(MessageType.FAIL, "index.html"));
					return formGet(model);
				}
			} else {
				model.addAttribute("message", new MessageBean(MessageType.FAIL, "index.html"));
				model.addAttribute("params", paramHandler);
				return formGet(model);
			}
			
		} catch (Exception e) {
			log.error(e.getMessage(),e);
			throw new HttpStatusErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "");
		}
		if(paramHandler.hasError()){
			model.addAttribute("message", new MessageBean(MessageType.FAIL, "index.html"));
			model.addAttribute("params", paramHandler);
			return formGet(model);
		}
		try{
			Curriculum curriculum = conversion(paramHandler,fileItem); 
			action(curriculum);
			model.addAttribute("message", new MessageBean(MessageType.SUCCESS, "index.html"));
		} catch(Exception e){
			log.error(e.getMessage(),e);
			throw new HttpStatusErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "");
		}
		return messageTemplate;
	}
	
	
	private Curriculum conversion(ParamHandler paramHandler,FileItem fileItem) throws QueryException, IOException {
		Curriculum curriculum = new Curriculum();
		curriculum.setDate(new Date());
		curriculum.setName(paramHandler.get("name"));
		curriculum.setLastname(paramHandler.get("lastname"));
		curriculum.setPhone(paramHandler.get("phone"));
		curriculum.setEmail(paramHandler.get("email"));
		curriculum.setMessage(paramHandler.get("message"));
		
		
		//Country country = Country.valueOf(paramHandler.get("country"));
		//curriculum.setCountry(country);
		
		
		
		String filename = fileItem.getName();
		String extension = FilenameUtils.getExtension(filename);
		curriculum.setCurriculumExtension(extension);
		curriculum.setCurriculum(fileItem.get());
		return curriculum;
	}


	private void action(Curriculum curriculum) throws EmailException, EmailTemplateException, QueryException{
		
		curriculum.setSend(BooleanType.TRUE);
		
		try{
			CurriculumMail mailSender = new CurriculumMail(curriculum);
			EmailAccount emailAccount = new EmailAccount("ctrepiana@mandomedio.com");
			mailSender.addTo(emailAccount);
			mailSender.send();
		} catch (Exception e){
			log.error(e.getMessage(),e);
			curriculum.setSend(BooleanType.FALSE);
		}
		
		CurriculumQuery query = new CurriculumQuery();
		query.save(curriculum);

	}
}

