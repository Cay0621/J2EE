package org.com.cay.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class IterationTagDemo extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String var;
	private String[] items;
	private int i = 1;
	
	public void setVar(String var) {
		this.var = var;
	}

	public void setItems(String[] items) {
		this.items = items;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		if(items != null && items.length > 0){
			pageContext.setAttribute("name", items[0]);
			return EVAL_BODY_INCLUDE;
		}else{
			return SKIP_BODY;
		}
		//return super.doStartTag();
	}
	
	@Override
	public int doAfterBody() throws JspException {
		// TODO Auto-generated method stub
		if(i < items.length){
			pageContext.setAttribute("name", items[i]);
			i++;
			return EVAL_BODY_AGAIN;
		}else{
			return SKIP_BODY;
		}
//		return super.doAfterBody();
	}

}
