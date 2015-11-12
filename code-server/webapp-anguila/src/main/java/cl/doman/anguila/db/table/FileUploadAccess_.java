package cl.doman.anguila.db.table;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2015-09-19T02:21:34.571-0300")
@StaticMetamodel(FileUploadAccess.class)
public class FileUploadAccess_ {
	public static volatile SingularAttribute<FileUploadAccess, Integer> id;
	public static volatile SingularAttribute<FileUploadAccess, Date> creation;
	public static volatile SingularAttribute<FileUploadAccess, String> password;
	public static volatile SingularAttribute<FileUploadAccess, Byte> used;
	public static volatile SingularAttribute<FileUploadAccess, FileUpload> fileUpload;
}
