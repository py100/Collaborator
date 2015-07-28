package com.brator.collaborator;

import java.io.IOException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.StaticLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserRegister extends Activity {
	
	
	private Button submit;
	private EditText userName;
	private EditText passWord;
	static private TextView resultTextView;
	HttpClient client;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_register);
		
		
		client = new DefaultHttpClient();
		userName = (EditText)findViewById(R.id.userNameEditText);
		passWord = (EditText)findViewById(R.id.pwdEditText);
		resultTextView = (TextView)findViewById(R.id.result);
		//����ע�ᰴťִ�в���
		submit = (Button)findViewById(R.id.registrationSubmit);
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//ע��:getText()���ص�����ΪEditable
				register(getString(R.string.serverURL),userName.getText().toString(),passWord.getText().toString());
			}
		});
	}
	
	public void register(String url,String userName,String passWord){
		new AsyncTask<String, Void, String>(){
			
			@Override
			protected String doInBackground(String... params) {
				//�ֱ��ȡ�������� 1.POST�����ַ 2.�û��� 3.����
				String url = params[0];
				String userName = params[1];
				String passWord = params[2];
				
				//����POST����
				HttpPost post = new HttpPost(url);
				

				try {
					//POST������Ҫ���ձ���������List��Ϊ��
					List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
					list.add(new BasicNameValuePair("userName",userName));
					list.add(new BasicNameValuePair("passWord",passWord));
					post.setEntity(new UrlEncodedFormEntity(list,"utf-8"));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//HttpResponse
				try {
					
					HttpResponse response = client.execute(post);
					String result = EntityUtils.toString(response.getEntity());
					return result;
					
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
			}

			@Override
			protected void onPostExecute(String result) {
				resultTextView.setText(result);
			}
			
			
		}.execute(url,userName,passWord);
	}
}

