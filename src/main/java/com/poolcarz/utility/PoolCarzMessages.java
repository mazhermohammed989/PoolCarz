package com.poolcarz.utility;

public enum PoolCarzMessages {

	LOGIN_SUCCESS("login.success"),
	USER_NOT_FOUND("user.notFound"),
	LOGIN_FAIL("login.fail"),
	REGISTRATION_SUCCESS("register.success"),
	REGISTRATION_FAIL("register.fail")
	
	
	;
	
	private String message;
	private PoolCarzMessages(String message) {
		// TODO Auto-generated constructor stub
		this.message=message;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
}
