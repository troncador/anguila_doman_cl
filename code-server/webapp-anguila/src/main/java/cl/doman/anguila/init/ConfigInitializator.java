package cl.doman.anguila.init;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.google.common.io.Closeables;

import cl.doman.anguila.db.query.SystemQuery;
import cl.doman.base.initializator.BaseSystemInitializator;
import cl.doman.base.initializator.LoggerInitializator;
import cl.doman.base.initializator.StackSystemInitializator;
import cl.doman.base.initializator.SystemInitializator;
import cl.doman.base.initializator.SystemInitializatorException;
import cl.doman.db.DatabaseInitializator;

public class ConfigInitializator extends BaseSystemInitializator {
  static Logger log = LoggerFactory.getLogger(ConfigInitializator.class);
  private XMLConfiguration configuration;
  static private Properties properties;
  
  public ConfigInitializator(String configPath) throws ConfigurationException{
    configuration = new XMLConfiguration();
    configuration.setFileName(configPath);
    configuration.load();
  }
  
  static public String getProperties(String key){
    return properties.getProperty(key);
  }
  
  public void init() throws SystemInitializatorException{
    this.init(configuration);
  }
  
  @Override
  public void init(XMLConfiguration globalConfiguration) throws SystemInitializatorException {
    try {
      SystemInitializator [] configurationArray = new SystemInitializator[]{
        new LoggerInitializator(),
        new DatabaseInitializator(SystemQuery.class)
      };
    
      new StackSystemInitializator(configurationArray).init(globalConfiguration);

      //Init Shiro
      Factory<SecurityManager> factory = 
          new IniSecurityManagerFactory("classpath:shiro.ini");
      SecurityManager securityManager = factory.getInstance();
      SecurityUtils.setSecurityManager(securityManager);
      Subject currentUser = SecurityUtils.getSubject();
      
      //Init properties
      ClassPathResource resource = new ClassPathResource( "app.properties" );
      properties = new Properties();
      InputStream inputStream = null;
      try {
          inputStream = resource.getInputStream();
          properties.load( inputStream );
      } finally {
          Closeables.closeQuietly( inputStream );
      }
     
    } catch (Exception e) {
      throw new SystemInitializatorException(e.getMessage(),e);
    }
  }

  @Override
  public String getName() {
    return "Core-Anguila";
  }

}
