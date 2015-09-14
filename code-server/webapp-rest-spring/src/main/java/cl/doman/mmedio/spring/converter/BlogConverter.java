package cl.doman.mmedio.spring.converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cl.doman.db.QueryException;
import cl.doman.mmedio.db.query.BlogQuery;
import cl.doman.mmedio.db.table.Blog;

public class BlogConverter implements Converter<String, Blog> {
	static Logger log =LoggerFactory.getLogger(BlogConverter.class);
	private TypeDescriptor campusDescriptor = TypeDescriptor.valueOf(Blog.class);
	private TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);
	
	
    @Override
    public Blog convert(String id) {
    	if (id == null){
    		throw new ConversionFailedException(campusDescriptor,stringDescriptor, id, null);
	    }
    	try {
    		BlogQuery query = new BlogQuery();
    		int integer = Integer.parseInt(id);
    		if(!query.exist(integer)){
    			throw new ConversionFailedException(campusDescriptor,stringDescriptor, id, null);
    		}
			return query.get(integer);
		} catch (QueryException e) {
			throw new ConversionFailedException(campusDescriptor,stringDescriptor, id, null);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(campusDescriptor,stringDescriptor, id, null);
		}
    }
}
