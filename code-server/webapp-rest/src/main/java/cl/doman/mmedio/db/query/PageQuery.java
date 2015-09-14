package cl.doman.mmedio.db.query;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.db.query.dao.PrepareQuery;
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.table.ContactArea;
import cl.doman.mmedio.db.table.ContactPerson;
import cl.doman.mmedio.db.table.ContactPerson_;
import cl.doman.mmedio.db.table.Page;
import cl.doman.mmedio.db.table.Page_;

public class PageQuery extends EntityDaoCriteria<Page,String> implements Existance<Page,String>{

	public PageQuery() {
		super(Page.class);
	}

	@Override
	public String convert(String id) throws ConvertException {
		return id;
	}

	@Override
	public SingularAttribute<Page,String> getPK() {
		return Page_.url;
	}

	
	public String getFile(final String url) throws QueryException{
		PreparePredicate<Page> prepareQuery = new PreparePredicate<Page>() {
			@Override
			public Predicate getPredicate(Root<Page> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate [] predicate = new Predicate[]{
						criteriaBuilder.equal(root.get(Page_.url), url)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		return this.getColumn(prepareQuery, Page_.file, String.class);
	}
}
