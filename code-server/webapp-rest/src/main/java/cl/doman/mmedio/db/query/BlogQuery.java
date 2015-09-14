package cl.doman.mmedio.db.query;

import javax.persistence.metamodel.SingularAttribute;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.mmedio.db.table.Blog;
import cl.doman.mmedio.db.table.Blog_;

public class BlogQuery extends EntityDaoCriteria<Blog, Integer> implements Existance<Blog,Integer>{

	public BlogQuery() {
		super(Blog.class);
	}

	
	@Override
	public Integer convert(String id) throws ConvertException {
		try{
			return Integer.parseInt(id);
		} catch (NumberFormatException  e){
			throw new ConvertException();
		}
	}

	@Override
	public SingularAttribute<Blog, Integer> getPK() {
		return Blog_.id;
	}



}
