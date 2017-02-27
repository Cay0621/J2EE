package org.com.cay.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.com.cay.service.IEmployeeService;

import com.opensymphony.xwork2.ActionSupport;

public class EmployeeAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private InputStream inputStream;
	private IEmployeeService employeeService;
	private Map<String, Object> request;
	private Integer id;
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String list() {
		request.put("employees", employeeService.getAll());
		return "list";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		request = arg0;
	}

	public String delete() {
		try {
			employeeService.delete(id);

			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));

		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		//使用正常删除，然后提交给emp-list
		//return SUCCESS;
		
		//使用ajax删除
		return "delete";
	}
}
