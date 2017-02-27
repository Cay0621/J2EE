package org.com.cay.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class SingleFileUploadAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String result;
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String execute()throws Exception{
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		
		FileUtils.copyFile(upload, new File(file,uploadFileName));
		
		result = "success";
		return "success";
	}
	
}
