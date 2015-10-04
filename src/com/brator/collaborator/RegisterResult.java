package com.brator.collaborator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterResult extends Activity {
	TextView registerResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_result);
		Intent intent = new Intent();
		String result = intent.getExtras().get("result").toString();
		registerResult = (TextView)findViewById(R.id.registrationResult);
		registerResult.setText(result);
		
	}
	
}
