package org.com.cay.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SkipPageOrEvalPageTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String referer = request.getHeader("referer");
		
		String url = "http://" + request.getServerName();
		
		if(referer != null && referer.startsWith(url)){
			return EVAL_PAGE;
		}else{
			try {
				pageContext.getOut().write("不能访问");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SKIP_PAGE;
		}
		//return super.doEndTag();
	}

}
