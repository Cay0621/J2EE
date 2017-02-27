package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SkipPageOrEvalPage extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) ((PageContext)getJspContext()).getRequest();
		String referer = request.getHeader("referer");
		if(referer == null){
			throw new SkipPageException();
		}
			
		//super.doTag();
	}
}
