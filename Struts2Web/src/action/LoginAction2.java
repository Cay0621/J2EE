package action;

import com.opensymphony.xwork2.ModelDriven;

import entity.User1;

public class LoginAction2 implements ModelDriven<User1>{

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
}
