package cl.doman.anguila.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProfileController extends BaseController{
	static Logger log =LoggerFactory.getLogger(ProfileController.class);
	

	@RequestMapping(value = {"/server/candidateportal.html"}, method = RequestMethod.GET)
	public String candidateportal(){
			return "profile/candidateportal";
	}

	@RequestMapping(value = {"/server/jobsearch.html"}, method = RequestMethod.GET)
	public String jobsearch(){
		return "profile/jobsearch";
	}
	
	@RequestMapping(value = {"/server/loggedout.html"}, method = RequestMethod.GET)
	public String loggedout(){
		return "profile/loggedout";
	}
	
	@RequestMapping(value = {"/server/registercandidate.html"}, method = RequestMethod.GET)
	public String registercandidate(){
		return "profile/registercandidate";
	}
	
	
}