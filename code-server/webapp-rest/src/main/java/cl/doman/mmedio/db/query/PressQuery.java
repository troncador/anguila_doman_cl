package cl.doman.mmedio.db.query;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.base.ConvertException;
import cl.doman.base.Existance;
import cl.doman.db.QueryException;
import cl.doman.db.query.dao.EntityDaoCriteria;
import cl.doman.db.query.dao.PrepareLimit;
import cl.doman.db.query.dao.PrepareLimitPagination;
import cl.doman.db.query.dao.PrepareOrder;
import cl.doman.db.query.dao.PreparePredicate;
import cl.doman.db.query.dao.PrepareQuery;
import cl.doman.db.query.dao.PrepareQueryAdapter;
import cl.doman.mmedio.db.field.PressType;
import cl.doman.mmedio.db.table.Country;
import cl.doman.mmedio.db.table.Press;
import cl.doman.mmedio.db.table.Press_;

public class PressQuery extends EntityDaoCriteria<Press, Integer> implements Existance<Press,Integer>{
	static Logger log =LoggerFactory.getLogger(PressQuery.class);
	public PressQuery() {
		super(Press.class);
	}
	

	private Predicate getCountry(Country country,Root<Press> root,CriteriaBuilder criteriaBuilder){
		if(country != null){
			Predicate [] predicate = new Predicate[]{
					criteriaBuilder.equal(root.get(Press_.country), country)
					, criteriaBuilder.equal(root.get(Press_.country), Country.ALL)
			};
			return criteriaBuilder.or(predicate);
		} else {
			return criteriaBuilder.and();
		}
	}

	public List<Press> findLastEntries(final PressType type,final Country country) throws QueryException{
		PreparePredicate<Press> preparePredicate = new PreparePredicate<Press>() {
			@Override
			public Predicate getPredicate(Root<Press> root,
					CriteriaBuilder criteriaBuilder) {

				Predicate [] predicate = new Predicate[]{
						getCountry(country,root,criteriaBuilder)
						, criteriaBuilder.equal(root.get(Press_.type), type)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		PrepareOrder<Press> prepareOrder = new PrepareOrder<Press>() {
			@Override
			public Order[] getOrderArray(Root<Press> root,CriteriaBuilder criteriaBuilder) {
				Order date = criteriaBuilder.desc(root.get(Press_.date));
				Order[] orderArray = {date};
				return orderArray;
			}
		};
		
		PrepareLimit limit = new PrepareLimitPagination(4,0);
		PrepareQuery prepareQuery =new PrepareQueryAdapter<Press>(preparePredicate,prepareOrder,limit);
		return this.find(prepareQuery);
	}
	
	public List<Press> findByMonth(final Date date,final PressType type,final Country country) throws QueryException{
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		
		final int year = calendar.get(Calendar.YEAR);
		final int month = calendar.get(Calendar.MONTH) + 1;
		
		PreparePredicate<Press> preparePredicate = new PreparePredicate<Press>() {
			@Override
			public Predicate getPredicate(Root<Press> root,
					CriteriaBuilder criteriaBuilder) {
				Expression<Integer> yearExpression = 
						criteriaBuilder.function("year", Integer.class, root.get(Press_.date));
				
				Expression<Integer> monthExpression = 
						criteriaBuilder.function("month", Integer.class, root.get(Press_.date));
				
				Predicate [] predicate = new Predicate[]{
						getCountry(country,root,criteriaBuilder),
						criteriaBuilder.equal(root.get(Press_.type), type),
						criteriaBuilder.equal(yearExpression,year),
						criteriaBuilder.equal(monthExpression,month)
				};
				return  criteriaBuilder.and(predicate);
			}
		};
		PrepareOrder<Press> prepareOrder = new PrepareOrder<Press>() {	
			@Override
			public Order[] getOrderArray(Root<Press> root,
					CriteriaBuilder criteriaBuilder) {
				Order[] orders ={criteriaBuilder.desc(root.get(Press_.date))};
				return orders;
			}
		};
		return this.find(new PrepareQueryAdapter<Press>(preparePredicate,prepareOrder));
	}
	
	public List<Press> findByDay(final Date date,final PressType type,final Country country) throws  QueryException {
		PreparePredicate<Press> preparePredicate = new PreparePredicate<Press>() {
			@Override
			public Predicate getPredicate(Root<Press> root,
					CriteriaBuilder criteriaBuilder) {
				
				Predicate [] predicate = new Predicate[]{
						getCountry(country,root,criteriaBuilder),
						criteriaBuilder.equal(root.get(Press_.type), type),
						criteriaBuilder.equal(root.get(Press_.date), date)
				};
				
				return criteriaBuilder.and(predicate);
			}
		};
		return this.find(new PrepareQueryAdapter<Press>(preparePredicate));
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
	public SingularAttribute<Press, Integer> getPK() {
		return Press_.id;
	}

}
