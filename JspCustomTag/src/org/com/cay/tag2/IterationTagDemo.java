package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;


public class IterationTagDemo extends SimpleTagSupport {

	private String[] items;
	private String name;
	
	
	
	public void setItems(String[] items) {
		this.items = items;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		if(items != null && items.length > 0){
			PageContext pageContext = (PageContext)getJspContext();
			
			for(int i = 0;i < items.length;++i){
				pageContext.setAttribute(name, items[i]);
			}
			getJspBody().invoke(null);
		}
		//super.doTag();
	}
}
