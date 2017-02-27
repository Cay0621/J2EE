package org.com.cay.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("MyHttpSessionListener...");
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  {
         // TODO Auto-generated method stub
    	System.out.println("MyHttpSessionListener...sessionCreated");
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyHttpSessionListener...sessionDestroyed");
    }
	
}
