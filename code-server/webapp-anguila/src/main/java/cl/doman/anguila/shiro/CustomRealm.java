package cl.doman.anguila.shiro;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.doman.anguila.db.query.UserQuery;
import cl.doman.db.QueryException;
import cl.doman.db.model.field.BooleanType;

public class CustomRealm extends AuthorizingRealm{
	static Logger log = LoggerFactory.getLogger(CustomRealm.class);
	protected boolean permissionsLookupEnabled = false;
	
	
	public CustomRealm(){}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		final UsernamePasswordToken userPassToken = (UsernamePasswordToken) principalCollection;
		String username = userPassToken.getUsername();
		if (username == null) {
			log.debug("Username is null.");
			return null;
		}
        Set<String> roleNames = null;
        Set<String> permissions = null;
           
        roleNames = getRoleNamesForUser(username);
        if (permissionsLookupEnabled) {
            permissions = getPermissions(username, roleNames);
        }

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);
        info.setStringPermissions(permissions);
		
		return  new SimpleAuthorizationInfo();
	}
    protected AuthenticationInfo buildAuthenticationInfo(String username, char[] password) {
        return new SimpleAuthenticationInfo(username, password, getName());
    }
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) 
			throws AuthenticationException {
		try {
			UsernamePasswordToken userPassToken = (UsernamePasswordToken) authenticationToken;
			
			String username = userPassToken.getUsername();
		      // Null username is invalid
	        if (username == null) {
	            throw new AccountException("Null usernames are not allowed by this realm.");
	        }
	
	        UserQuery query = new UserQuery();
			if(!query.logicalExistByUsername(username)){
				 throw new UnknownAccountException("No account found for user [" + username + "]");
			}
			String password = query.logicalGetPasswordByUsername(username);
			
			AuthenticationInfo info = 
					buildAuthenticationInfo(username, password.toCharArray());
			
 
			return info;
		} catch (QueryException e) {
			throw new AuthenticationException(e.getMessage(),e);
		}		
	
	}
    protected Set<String> getRoleNamesForUser( String username){
    	Set<String> roleNames = new LinkedHashSet<String>();
    	return roleNames;
    }
	
    protected Set<String> getPermissions(String username, Collection<String> roleNames){
    	Set<String> permissions = new LinkedHashSet<String>();
		return permissions;
    }

}
