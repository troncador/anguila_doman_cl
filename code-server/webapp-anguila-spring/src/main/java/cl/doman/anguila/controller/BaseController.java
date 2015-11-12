package cl.doman.anguila.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import cl.doman.db.QueryException;
import cl.doman.springmvc.HttpStatusErrorException;
import cl.doman.springmvc.security.AccessControlException;

@Controller
public class BaseController {
	static Logger log =LoggerFactory.getLogger(BaseController.class);
	
	
	public String getBaseURL(HttpServletRequest request) { 
		String baseURL = 
				request.getRequestURL().toString().replace(request.getRequestURI().substring(1), request.getContextPath());
		return baseURL;
		//return String.format("%s://%s:%d/tasks/",request.getScheme(),request.getServerName(),request.getServerPort());
	}
	
	
	@ExceptionHandler({QueryException.class,IOException.class})
	public String error500(HttpServletResponse response,Exception e) {
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "error/500";
	}
	
	@ExceptionHandler(HttpStatusErrorException.class)
	public String errorHandler(HttpServletResponse response,HttpStatusErrorException e) {
		
		switch (e.getStatus()) {
		case  NOT_FOUND:
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			return "error/404";

		case  INTERNAL_SERVER_ERROR:
			log.info(e.getStatus().name());
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error/500";
			
		default:
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return "error/500";
		}
		
		
	}
}
