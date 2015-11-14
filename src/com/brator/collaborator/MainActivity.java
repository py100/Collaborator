package com.brator.collaborator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewById(R.id.button1);
        Button questionButtonTest = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,UserRegister.class);
				startActivity(intent);
				
			}
		});
        questionButtonTest.setOnClickListener(new OnClickListener(){
        	
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,com.question.QuestionHome.class);
				startActivity(intent);
				
			}
        });
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action1:
			Intent intent = new Intent(getApplicationContext(), UserRegister.class);
			startActivity(intent);
			break;
		case R.id.action2:
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	

}
