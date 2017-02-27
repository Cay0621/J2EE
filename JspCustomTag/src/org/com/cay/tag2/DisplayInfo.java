package org.com.cay.tag2;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class DisplayInfo extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeStr = sdf.format(new Date());
		JspWriter jspWriter = getJspContext().getOut();
		jspWriter.write(timeStr);
	}
}
