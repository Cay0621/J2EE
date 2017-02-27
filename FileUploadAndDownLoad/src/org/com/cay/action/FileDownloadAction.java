package org.com.cay.action;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class FileDownloadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String inputPath;
	private InputStream inputStream;
	private String fileName;
	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	
	public String execute() throws Exception{
		//下载指定的文件
		//inputStream = ServletActionContext.getServletContext().getResourceAsStream(inputPath);
		
		//根据uri传过来的文件名来下载文件
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		String filepath = path + "\\" + fileName;
		
		File file = new File(filepath);
		inputStream = FileUtils.openInputStream(file);
		return "downloadsuccess";
	}
	
	public String getDownloadFileName(){
		String name = "下载1.jpg";
		try {
			name = URLEncoder.encode(name, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
}
