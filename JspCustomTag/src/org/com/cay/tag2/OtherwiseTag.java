package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		ChooseTag chooseTag = (ChooseTag) getParent();
		if(!chooseTag.isFlag()){
			getJspBody().invoke(null);
		}
//		super.doTag();
	}
}
