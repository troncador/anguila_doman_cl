package cl.doman.anguila.controller;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import cl.doman.anguila.configuration.ServletContext;
import cl.doman.anguila.db.i.table.Page;
import cl.doman.anguila.db.i.table.Page_;
import cl.doman.anguila.db.query.PageQuery;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.springmvc.HttpStatusErrorException;
@Controller
public class IndexController {
	static Logger log =LoggerFactory.getLogger(IndexController.class);

	
	@RequestMapping(value = {"/","/index.html","/page/index.html"}, method = RequestMethod.GET)
	public String index() {
		return "simple/home";
	}
	//------------------------------------------------------------------------
	@RequestMapping(value = {"/error/500.html"}, method = RequestMethod.GET)
	public String error500() {
		return "error/500";
	}
	@RequestMapping(value = {"/error/404.html"}, method = RequestMethod.GET)
	public String error404() {
		return "error/404";
	}
	@RequestMapping(value = {"/error/400.html"}, method = RequestMethod.GET)
	public String error400() {
		return "error/400";
	}
	//------------------------------------------------------------------------
	@RequestMapping(value = {"/page/{url}.html"}, method = RequestMethod.GET)
	public String consultingindex(@PathVariable("url") String url) throws QueryException, HttpStatusErrorException {
		PageQuery pagequery = new PageQuery();
		try{
			return pagequery.getColumn(url,Page_.file,String.class);
		} catch (QueryException e){
			switch (e.getExceptionKind()){
			case NO_RESULT:
				throw new HttpStatusErrorException(HttpStatus.NOT_FOUND);
			default:
				break;
			}
			throw e;
		}
	}
}