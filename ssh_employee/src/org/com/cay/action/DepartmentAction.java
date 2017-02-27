package org.com.cay.action;


import org.com.cay.entity.Department;
import org.com.cay.entity.PageBean;
import org.com.cay.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Department department = new Department();
	
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	private Integer curPage = 1;
	
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}


	//提供查询的方法
	public String findAll(){
		PageBean<Department> pageBean = departmentService.findByPage(curPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	//跳转到添加部门的页面
	public String saveUI(){
		return "saveUI";
	}
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	public String edit(){
		department = departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	
	public String delete(){
		//为了能够同时将部门中的员工一起删除，必须先查询部门，才能实现级联删除操作，
		//如果直接删除部门的话，该部门所在的员工就不能被删除了。
		departmentService.delete(departmentService.findById(department.getDid()));
		return "deleteSuccess";
	}

}
