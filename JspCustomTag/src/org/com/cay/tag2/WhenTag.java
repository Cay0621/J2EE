package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport {

	private boolean test;
	
	
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		if(this.test){
			getJspBody().invoke(null);
			ChooseTag chooseTag = (ChooseTag) getParent();
			chooseTag.setFlag(true);
		}
		//super.doTag();
	}
}
