package org.com.cay.tag2;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ModifyBodyContent extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		JspFragment jspFragment = getJspBody();
		StringWriter stringWrite = new StringWriter();
		jspFragment.invoke(stringWrite);
		String content = stringWrite.toString();
		System.out.println(content);
		
		content = "http://www.baidu.com";
		((PageContext)getJspContext()).getOut().write(content);
		
//		super.doTag();
	}
}
