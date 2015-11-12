package cl.doman.anguila.db.table;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import cl.doman.db.model.table.StandardTable_;

@Generated(value="Dali", date="2015-09-19T02:38:31.382-0300")
@StaticMetamodel(FileUpload.class)
public class FileUpload_ extends StandardTable_{
	public static volatile SingularAttribute<FileUpload, byte[]> description;
	public static volatile SingularAttribute<FileUpload, Integer> fileStateId;
	public static volatile SingularAttribute<FileUpload, String> name;
	public static volatile SingularAttribute<FileUpload, String> path;
	public static volatile SingularAttribute<FileUpload, BigInteger> weight;
	public static volatile SingularAttribute<FileUpload, UserGroup> group;
	public static volatile ListAttribute<FileUpload, FileUploadAccess> fileUploadAccesses;
}
