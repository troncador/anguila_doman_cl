package cl.doman.mmedio.controller;


import java.util.Date;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.mail.EmailException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cl.doman.core.mail.EmailAccount;
import cl.doman.core.mail.template.EmailTemplateException;
import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.field.BooleanType;
import cl.doman.mmedio.db.query.ContactAreaQuery;
import cl.doman.mmedio.db.query.ContactMessageQuery;
import cl.doman.mmedio.db.query.ContactPersonQuery;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactArea_;
import cl.doman.mmedio.db.table.ContactMessage;
import cl.doman.mmedio.db.table.ContactPerson;
import cl.doman.mmedio.db.table.Country;
import cl.doman.mmedio.db.table.Country_;
import cl.doman.mmedio.mail.ContactMail;
import cl.doman.resource.validation.Formeable;
import cl.doman.resource.validation.MessageBean;
import cl.doman.resource.validation.MessageBean.MessageType;
import cl.doman.resource.validation.ParamHandler;
import cl.doman.springmvc.HttpStatusErrorException;

@Controller
public class ContactoController extends BaseController implements Formeable{
	static Logger log =LoggerFactory.getLogger(ContactoController.class);
	static private String formTemplate = "form/contacto";
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
		
		params.getValidation("area").required()
			.exist(new ContactAreaQuery());
		
		params.getValidation("message").required()
			.maxlength(400);
	}
	
	
	@RequestMapping(value = {"/page/contacto.html"}, method = RequestMethod.GET)
	public String formGet(ModelMap modelmap) throws QueryException {
		StandardQuery<ContactArea> queryContactArea = new StandardQuery<ContactArea>(ContactArea.class);
		PreparePredicate<ContactArea> preparePredicateContactArea = new PreparePredicate<ContactArea>(){
			@Override
			public Predicate getPredicate(Root<ContactArea> arg0,
					CriteriaBuilder arg1) {
				return arg1.notEqual(arg0.get(ContactArea_.id),ContactArea.ALL.getId());
			}
			
		};
		PrepareQueryAdapter<ContactArea> prepareQueryContactArea = new PrepareQueryAdapter<ContactArea>(preparePredicateContactArea);
		
		modelmap.put("contactAreaList", queryContactArea.find(prepareQueryContactArea));
		
		StandardQuery<Country> queryCountry = new StandardQuery<Country>(Country.class);
		
		PreparePredicate<Country> preparePredicateCountry = new PreparePredicate<Country>(){
			@Override
			public Predicate getPredicate(Root<Country> arg0,
					CriteriaBuilder arg1) {
				return arg1.notEqual(arg0.get(Country_.id),Country.ALL.getId());
			}
			
		};
		PrepareQueryAdapter<Country> prepareQueryCountry = new PrepareQueryAdapter<Country>(preparePredicateCountry);
		modelmap.put("countryList", queryCountry.find(prepareQueryCountry));
		return formTemplate;
	}
	
	
	@RequestMapping(value = {"/page/contacto.html"}, method = RequestMethod.POST)
	public String formsubmit(HttpServletRequest request,ModelMap model) throws QueryException, HttpStatusErrorException {
		formGet(model);
		Map<String,String[]> parameterMap = request.getParameterMap();
		ParamHandler paramHandler = new ParamHandler(parameterMap);
		try {
			validate(paramHandler);
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
			ContactMessage contactMessage= conversion(paramHandler); 
			action(contactMessage);
			model.addAttribute("message", new MessageBean(MessageType.SUCCESS, "index.html"));
		} catch(Exception e){
			log.error(e.getMessage(),e);
			throw new HttpStatusErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "");
		}
		return messageTemplate;
	}
	
	
	private ContactMessage conversion(ParamHandler paramHandler) throws QueryException {
		ContactMessage contactMessage = new ContactMessage();
		contactMessage.setDate(new Date());
		
		contactMessage.setName(paramHandler.get("name"));
		contactMessage.setLastname(paramHandler.get("lastname"));
		contactMessage.setPhone(paramHandler.get("phone"));
		contactMessage.setEmail(paramHandler.get("email"));
		contactMessage.setMessage(paramHandler.get("message"));
		
		String areastr = paramHandler.get("area");
		int idArea = Integer.parseInt(areastr);
		ContactAreaQuery contactAreaQuery = new ContactAreaQuery();
		ContactArea contactArea = contactAreaQuery.get(idArea);
		contactMessage.setContactArea(contactArea);
		
		String countrystr = paramHandler.get("country");
		int idCountry = Integer.parseInt(countrystr);
		StandardQuery<Country> countryQuery = new StandardQuery<Country>(Country.class);
		Country country = countryQuery.get(idCountry);
		contactMessage.setCountry(country);
		
		return contactMessage;
	}


	private void action(ContactMessage contactMessage) throws EmailException, EmailTemplateException, QueryException{
		ContactPersonQuery query = new ContactPersonQuery();
		Country country = contactMessage.getCountry();
		ContactArea contactArea = contactMessage.getContactArea();
		String mail = query.getMail(country, contactArea);
		contactMessage.setSend(BooleanType.TRUE);
		
		try{
			ContactMail mailSender = new ContactMail(contactMessage);
			EmailAccount emailAccount = new EmailAccount(mail);
			mailSender.addTo(emailAccount);
			mailSender.send();
		} catch (Exception e){
			log.error(e.getMessage(),e);
			contactMessage.setSend(BooleanType.FALSE);
		}
		
		ContactMessageQuery contactMessageQuery = new ContactMessageQuery();
		contactMessageQuery.save(contactMessage);

		
	}
}

