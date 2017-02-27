package org.com.cay.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextAttributeListener
 *
 */
@WebListener
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletContextAttributeListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("MyServletContextAttributeListener...");
    }

	/**
     * @see ServletContextAttributeListener#attributeAdded(ServletContextAttributeEvent)
     */
    public void attributeAdded(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletContextAttributeListener...attributeAdded: " + arg0.getName());
    }

	/**
     * @see ServletContextAttributeListener#attributeRemoved(ServletContextAttributeEvent)
     */
    public void attributeRemoved(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletContextAttributeListener...attributeRemoved: " + arg0.getName());
    }

	/**
     * @see ServletContextAttributeListener#attributeReplaced(ServletContextAttributeEvent)
     */
    public void attributeReplaced(ServletContextAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletContextAttributeListener...attributeReplaced: " + arg0.getName());
    }
	
}
