package org.com.cay.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionAttributeListener
 *
 */
@WebListener
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionAttributeListener() {
        // TODO Auto-generated constructor stub
    	System.out.println("MyHttpSessionAttributeListener...");
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyHttpSessionAttributeListener...attributeAdded: " + arg0.getName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyHttpSessionAttributeListener...attributeRemoved: " + arg0.getName());
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("MyHttpSessionAttributeListener...attributeReplaced: " + arg0.getName());
    }
	
}
