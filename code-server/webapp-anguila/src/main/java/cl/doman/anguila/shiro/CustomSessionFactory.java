package cl.doman.anguila.shiro;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import cl.doman.anguila.db.table.UserSession;

public class CustomSessionFactory implements SessionFactory{

  @Override
  public Session createSession(SessionContext initData) {
    UserSession session = new UserSession();
    session.setStartTimestamp(new Date());
    session.setLastAccessTime(new Date());
    if (initData != null && initData instanceof WebSessionContext) {
        WebSessionContext sessionContext = (WebSessionContext) initData;
        HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
        if (request != null) {
            session.setHost(getIpAddr(request));
            session.setAgent(request.getHeader("User-Agent"));
            //session.setSystemHost(request.getLocalAddr() + ":" + request.getLocalPort());
        }
    }
    return session;
  }

  public static String getIpAddr(HttpServletRequest request) {
    if (request == null) {
        return "unknown";
    }
    String ip = request.getHeader("x-forwarded-for");
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("X-Forwarded-For");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getHeader("X-Real-IP");
    }

    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
        ip = request.getRemoteAddr();
    }
    return ip;
}
}
