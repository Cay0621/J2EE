package org.com.cay.action;

import java.util.List;

import org.com.cay.entity.Department;
import org.com.cay.entity.Employee;
import org.com.cay.entity.PageBean;
import org.com.cay.service.DepartmentService;
import org.com.cay.service.EmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//模型驱动使用的对象
	private Employee employee = new Employee();
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String login(){
		Employee existEmployee = employeeService.login(employee);
		if(existEmployee == null){
			//登录失败
			this.addActionError("用户名或者密码错误!");
			return INPUT;
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	private Integer curPage = 1;
	
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	//分页查询员工的方法
	public String findAll(){
		PageBean<Employee> pageBean =  employeeService.findByPage(curPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		
		return "findAll";
	}
	
	public String saveUI(){
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	
	public String update(){
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		employeeService.delete(employeeService.findById(employee.getEid()));
		return "deleteSuccess";
	}
}
