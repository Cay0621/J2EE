package org.com.cay.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class BodyTagSupportDemo extends BodyTagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BodyContent bodyContent;
	
	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}
	

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		
		//在处理结束标记时获取中间的内容并打印
		String content = bodyContent.getString();
		System.out.println(content);
		
		String newStr = "http://www.baidu.com";
		try {
			//修改内容
			bodyContent.getEnclosingWriter().write(newStr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return super.doEndTag();
		return EVAL_PAGE;
	}
}
