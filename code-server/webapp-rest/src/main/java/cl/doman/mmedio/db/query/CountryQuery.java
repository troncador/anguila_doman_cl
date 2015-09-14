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
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.table.Blog;
import cl.doman.mmedio.db.table.Blog_;
import cl.doman.mmedio.db.table.ContactPerson;
import cl.doman.mmedio.db.table.ContactPerson_;
import cl.doman.mmedio.db.table.Country;
import cl.doman.mmedio.db.table.Country_;

public class CountryQuery extends EntityDaoCriteria<Country, Integer> implements Existance<Country,Integer>{

	public CountryQuery() {
		super(Country.class);
	}
	public boolean exist(final String safeName) throws QueryException{
		PreparePredicate<Country> preparePredicate = new PreparePredicate<Country>() {
			@Override
			public Predicate getPredicate(Root<Country> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate [] predicate = new Predicate[]{
						criteriaBuilder.equal(root.get(Country_.safeName), safeName)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		PrepareQueryAdapter<Country> prepareQuery = new PrepareQueryAdapter<Country>(preparePredicate);
		return this.exist(prepareQuery);
	}
	
	public Country get(final String safeName) throws QueryException{
		PreparePredicate<Country> preparePredicate = new PreparePredicate<Country>() {
			@Override
			public Predicate getPredicate(Root<Country> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate [] predicate = new Predicate[]{
						criteriaBuilder.equal(root.get(Country_.safeName), safeName)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		PrepareQueryAdapter<Country> prepareQuery = new PrepareQueryAdapter<Country>(preparePredicate);
		return this.get(prepareQuery);
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
	public SingularAttribute<? super Country, Integer> getPK() {
		return Country_.id;
	}



}
