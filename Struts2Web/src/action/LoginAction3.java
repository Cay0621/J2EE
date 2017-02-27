package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User1;

public class LoginAction3 extends ActionSupport implements ModelDriven<User1>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User1 user1 = new User1();

	public String login(){
		System.out.println(user1.getUsername());
		return "success";
	}

	@Override
	public User1 getModel() {
		// TODO Auto-generated method stub
		return user1;
	}
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(user1.getUsername() == null || "".equals(user1.getUsername())){
			this.addFieldError("username", "用户名不能为空");
		}
	}
}
