package action;

import entity.User1;

public class LoginAction1 {

	private User1 user1;

	public User1 getUser1() {
		return user1;
	}

	public void setUser1(User1 user1) {
		this.user1 = user1;
	}

	public String login(){
		System.out.println(user1.getUsername());
		return "success";
	}
}
