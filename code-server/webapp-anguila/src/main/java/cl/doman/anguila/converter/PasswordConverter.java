package cl.doman.anguila.converter;

import org.eclipse.persistence.mappings.DatabaseMapping;
import org.eclipse.persistence.mappings.converters.Converter;
import org.eclipse.persistence.sessions.Session;

public class PasswordConverter implements Converter {
  private static final long serialVersionUID = 1L;

  @Override
  public Object convertDataValueToObjectValue(Object arg0, Session arg1) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object convertObjectValueToDataValue(Object arg0, Session arg1) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void initialize(DatabaseMapping arg0, Session arg1) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean isMutable() {
    // TODO Auto-generated method stub
    return false;
  }

}
