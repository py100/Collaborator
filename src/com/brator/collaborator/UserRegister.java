package com.brator.collaborator;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import app.info.CommonInfo;

public class UserRegister extends Activity {

	private Button submit;
	private EditText userName;
	private EditText passWord;
	private String resultString;

	static private TextView resultTextView;

	HttpClient client;

	@SuppressLint("HandlerLeak")
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			System.out.println(msg.obj.toString());
			resultTextView.setText(msg.obj.toString());
		}

	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.user_register);

		String result;
		resultTextView = (TextView) findViewById(R.id.result);
		client = new DefaultHttpClient();
		userName = (EditText) findViewById(R.id.userNameEditText);
		passWord = (EditText) findViewById(R.id.pwdEditText);
		resultTextView = (TextView) findViewById(R.id.result);
		// 单击注册按钮执行操作
		submit = (Button) findViewById(R.id.registrationSubmit);
		submit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {

					@Override
					public void run() {
						register(CommonInfo.registerUrl, userName.getText()
								.toString(), passWord.getText().toString());
					}
				}).start();
			}

		});

	}

	public void register(String registerUrl, String userName, String passWord) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(registerUrl);

		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		list.add(new BasicNameValuePair("userName", userName));
		list.add(new BasicNameValuePair("passWord", passWord));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
			HttpResponse httpResponse = httpClient.execute(httpPost);
			if (200 == httpResponse.getStatusLine().getStatusCode()) {
				switch (EntityUtils.toString(httpResponse.getEntity())) {
				case "Success":
					Message msg = Message.obtain();
					msg.obj = "Success";
					handler.sendMessage(msg);
					break;

				default:
					break;
				}
			} else {

			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
