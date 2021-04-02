package com.revature.rkiesling.project1;

public class UserNotFoundException extends Throwable {
	UserNotFoundException () {
		super ();
	}
	UserNotFoundException (String message) {
		super (message);
	}
}
