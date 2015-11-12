package cl.doman.anguila.controller;


import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.doman.anguila.configuration.ServletContext;
import cl.doman.anguila.db.field.PressType;
import cl.doman.anguila.db.i.table.Country;
import cl.doman.anguila.db.i.table.Press;
import cl.doman.anguila.db.query.PressQuery;
import cl.doman.anguila.spring.converter.CountryConverter;
import cl.doman.db.QueryException;

@Controller
public class PressController {
	static Logger log =LoggerFactory.getLogger(PressController.class);
	static Pattern pattern = Pattern.compile("^([0-9]{2}-)?[0-9]{2}-[0-9]{4}$");
	static Pattern monthPattern = Pattern.compile("^[0-9]{2}-[0-9]{4}$");
	static Pattern dayPattern = Pattern.compile("^([0-9]{2}-)[0-9]{2}-[0-9]{4}$");
	
	@RequestMapping(value = {"/prensa/centro_prensa.html"}, method = RequestMethod.GET)
	public String centro_prensa() {
		return "prensa/centro_prensa";
	}

	@RequestMapping(value = {"/prensa/comunicados.html"}, method = RequestMethod.GET)
	public String comunicados(
			@RequestParam(value = "date", required = false) String dateSTR,
			ModelMap modelmap) throws QueryException, ParseException{
		
			List<Press> pressList = function(dateSTR, null, PressType.communicate);
			modelmap.put("pressList",pressList);
			
			return "prensa/comunicados";
	}

	@RequestMapping(value = {"/prensa/videos.html"}, method = RequestMethod.GET)
	public String videos(
			@RequestParam(value = "date", required = false) String dateSTR,
			ModelMap modelmap) throws QueryException, ParseException{
		
		List<Press> pressList = function(dateSTR, null, PressType.video);
		modelmap.put("pressList",pressList);
			
		return "prensa/videos";
	}
	
	@RequestMapping(value = {"/prensa/noticias/{country}.html"}, method = RequestMethod.GET)
	public String noticias(
			@RequestParam(value = "date", required = false) String dateSTR,
			@PathVariable("country") Country country,
			ModelMap modelmap) throws QueryException, ParseException{
		log.info(country.getName());
		
		List<Press> pressList = function(dateSTR, country, PressType.news);
		modelmap.put("pressList",pressList);
		modelmap.put("country",country.getName());	
		return "prensa/noticias";
	}
	static public void main(String arg[]) throws QueryException, ParseException {
		ServletContext.init();
		CountryConverter converter = new CountryConverter();
		Country country = converter.convert("Chile");
		
		final Calendar calendar = Calendar.getInstance();
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] months = dfs.getMonths();
		
		
		//String str = "12-07-2013";
		//DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String str = "01-07-2013";
 		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
 		Date date = dateFormat.parse(str);
 		
		for (Press press:new PressController().function(str,country, PressType.news)){
			calendar.setTime(press.getDate());
			int month = calendar.get(Calendar.MONTH);
			String string = String.format("%d %d %s %s .- %s",
					calendar.get(Calendar.YEAR),
					calendar.get(Calendar.MONTH), 
					months[month],
					press.getDate(), 
					press.getTitle());
			
			log.info(string);
		}
     
// 		DateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
// 		Date date = dateFormat.parse("09-2013");
// 		log.info(date.toLocaleString());
     
}
	
	private List<Press> function(String dateSTR, Country country, PressType pressType) throws QueryException, ParseException{
		PressQuery pressQuery = new PressQuery();
		List<Press> pressList = null;
		if(dateSTR==null){
			pressList = pressQuery.findLastEntries(pressType, country);
		} else {
			try{
				//tiene forma de fecha
				if(pattern.matcher(dateSTR).matches()){
					if(monthPattern.matcher(dateSTR).matches()){
						DateFormat dateFormat = new SimpleDateFormat("MM-yyyy");
						Date date = dateFormat.parse(dateSTR);
						pressList = pressQuery.findByMonth(date,pressType , country);
					} else {
						DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
						Date date = dateFormat.parse(dateSTR);
						pressList = pressQuery.findByDay(date,pressType, country);
					}
				} else {
					pressList = new ArrayList<Press>();
				}
			} catch (ParseException  e) {
				pressList = new ArrayList<Press>();
			}
		}
		return pressList;
	}
	
	
	@ExceptionHandler({QueryException.class,ParseException.class})
	public String scErrorInternalServer(HttpServletResponse response,QueryException e) {
		log.error(e.getMessage(),e);
		response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		return "error/500";
	}
}