package org.com.cay.listener;

import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.com.cay.entity.User;
import org.com.cay.util.SessionUtil;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserListener implements HttpSessionListener {

	private int userCount = 0;
    /**
     * Default constructor. 
     */
    public UserListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	userCount++;
    	//便于全局中可以使用该变量，使用servletContext
    	arg0.getSession().getServletContext().setAttribute("userCount", userCount);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    @SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	userCount--;
    	arg0.getSession().getServletContext().setAttribute("userCount", userCount);
    	
    	List<User> userList = null;
    	
    	userList = (List<User>)arg0.getSession().getServletContext().getAttribute("userList");
    	
    	User user = SessionUtil.getUserBySessionId(userList, arg0.getSession().getId());
    	if(user != null)    	
    		userList.remove(user);
    }
	
}
