package cl.doman.anguila.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cl.doman.anguila.db.i.table.Blog;
import cl.doman.anguila.db.query.BlogQuery;
import cl.doman.db.QueryException;

@Controller
public class BlogController extends BaseController {
	static Logger log =LoggerFactory.getLogger(BlogController.class);

	
	@RequestMapping(value = {"/page/blog.html"}, method = RequestMethod.GET)
	public String index(
			HttpServletRequest request,
			ModelMap modelmap,
			@RequestParam(value = "id", required = true) Blog blog) throws QueryException {

		String originalText = blog.getText();
		String text = originalText.replace("{base-url}", getBaseURL(request));
		blog.setText(text);
		modelmap.put("blog", blog);
		
		return "blog/blog";
	}
	
}