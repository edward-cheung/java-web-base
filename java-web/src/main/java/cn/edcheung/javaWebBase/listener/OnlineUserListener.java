package cn.edcheung.javaWebBase.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * OnlineUserListener
 *
 * @author Edward Cheung
 * 2019/11/3
 */
public class OnlineUserListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer num = (Integer) servletContext.getAttribute("num");
        if (num == null) {
            servletContext.setAttribute("num", 1);
        } else {
            num++;
            servletContext.setAttribute("num", num);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext servletContext = httpSessionEvent.getSession().getServletContext();
        Integer num = (Integer) httpSessionEvent.getSession().getAttribute("num");
        if (num == null) {
            servletContext.setAttribute("num", 0);
        } else {
            num--;
            servletContext.setAttribute("num", num);
        }
    }
}
