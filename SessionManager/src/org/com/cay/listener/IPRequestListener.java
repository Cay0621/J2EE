package org.com.cay.listener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import org.com.cay.entity.User;
import org.com.cay.util.SessionUtil;

/**
 * Application Lifecycle Listener implementation class IPRequestListener
 *
 */
@WebListener
public class IPRequestListener implements ServletRequestListener {

	private List<User> userList;
	
    /**
     * Default constructor. 
     */
    public IPRequestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
	@SuppressWarnings("unchecked")
	public void requestInitialized(ServletRequestEvent arg0)  { 
         // TODO Auto-generated method stub
    	
    	userList = (List<User>)arg0.getServletContext().getAttribute("userList");
    	
    	if(userList == null)
    		userList = new ArrayList<User>();
    	
    	HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
    	String sessionIdString = request.getSession().getId();
    	
    	if(SessionUtil.getUserBySessionId(userList, sessionIdString) == null){
    		User user = new User();
    		user.setSessionIdString(sessionIdString);
    		user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    		user.setIpString(request.getRemoteAddr());//获取ip地址
    		userList.add(user);
    	}
    	
    	arg0.getServletContext().setAttribute("userList", userList);
    }
	
}
