package cl.doman.mmedio.spring.converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import cl.doman.db.QueryException;
import cl.doman.db.model.table.StandardQuery;
import cl.doman.mmedio.db.query.BlogQuery;
import cl.doman.mmedio.db.query.CountryQuery;
import cl.doman.mmedio.db.table.Blog;
import cl.doman.mmedio.db.table.Country;

public class CountryConverter implements Converter<String, Country> {
	static Logger log =LoggerFactory.getLogger(CountryConverter.class);
	private TypeDescriptor countryDescriptor = TypeDescriptor.valueOf(Country.class);
	private TypeDescriptor stringDescriptor = TypeDescriptor.valueOf(String.class);
	
	
    @Override
    public Country convert(String id) {
    	if (id == null){
    		throw new ConversionFailedException(countryDescriptor,stringDescriptor, id, null);
	    }
    	try {
    		CountryQuery query = new CountryQuery();
    		if(!query.exist(id)){
    			throw new ConversionFailedException(countryDescriptor,stringDescriptor, id, null);
    		}
			return query.get(id);
		} catch (QueryException e) {
			throw new ConversionFailedException(countryDescriptor,stringDescriptor, id, null);
		} catch (NumberFormatException e) {
			throw new ConversionFailedException(countryDescriptor,stringDescriptor, id, null);
		}
    }
}
