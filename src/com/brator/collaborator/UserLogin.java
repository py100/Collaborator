package com.brator.collaborator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class UserLogin extends Activity {
	private Button loginButton;
	private EditText loginUserNameEditText;
	private EditText loginPwdEditText;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_login);
	}
}
