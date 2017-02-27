package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DisplayOrSkipBody extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		String name = ((PageContext) getJspContext()).getRequest().getParameter("name");
		if(name != null && name.equals("cay")){
			getJspBody().invoke(null);
		}
		super.doTag();
	}
}
