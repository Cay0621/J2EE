package org.com.cay.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class SkipBodyOrEvalBodyIncludeTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		String name = pageContext.getRequest().getParameter("name");
		if(name != null && name.equals("cay")){
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
		//return super.doStartTag();
	}

}
