package org.com.cay.tag2;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ChooseTag extends SimpleTagSupport {

	private boolean flag;

	
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}



	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		getJspBody().invoke(null);
		//super.doTag();
	}
}
