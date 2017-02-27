package org.com.cay.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestAttributeListener
 *
 */
@WebListener
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    /**
     * Default constructor. 
     */
    public MyServletRequestAttributeListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("MyServletRequestAttributeListener...");
    }

	/**
     * @see ServletRequestAttributeListener#attributeRemoved(ServletRequestAttributeEvent)
     */
    public void attributeRemoved(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletRequestAttributeListener...attributeRemoved: " + arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeAdded(ServletRequestAttributeEvent)
     */
    public void attributeAdded(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletRequestAttributeListener...attributeAdded: " + arg0.getName());
    }

	/**
     * @see ServletRequestAttributeListener#attributeReplaced(ServletRequestAttributeEvent)
     */
    public void attributeReplaced(ServletRequestAttributeEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyServletRequestAttributeListener...attributeReplaced: " + arg0.getName());
    }
	
}
