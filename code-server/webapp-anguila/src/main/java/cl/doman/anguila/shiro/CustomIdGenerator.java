package cl.doman.anguila.shiro;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

public class CustomIdGenerator implements SessionIdGenerator {
  private static final String RANDOM_NUM_GENERATOR_ALGORITHM_NAME = "SHA1PRNG";
  private SecureRandom random;
  public CustomIdGenerator() throws NoSuchAlgorithmException{
    random = java.security.SecureRandom.getInstance(RANDOM_NUM_GENERATOR_ALGORITHM_NAME);
  }
  @Override
  public Serializable generateId(Session session) {
    //ignore the argument - just call the Random:
    return random.nextInt();
  }

}
