package kn.tools;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.brator.collaborator.RegisterResult;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * @author KNCX
 * 
 * @param url
 *            POST请求网址
 * @param userName
 *            用户名
 * @param passWord
 *            密码
 * @param ID
 *            控件ID
 * @param category
 *            传入控件类型：0.TextView 1.Button
 */
public class MyPost extends Activity {

	private String url;
	private String userName;
	private String passWord;
	private HttpClient httpClient = new DefaultHttpClient();
	private HttpPost httpPost;
	private int responseCode;

	HttpResponse response;
	String result;

	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(MyPost.this,
				RegisterResult.class);
		intent.putExtra("result", result);
		startActivity(intent);
	}

	public void register(String url, String userName, String passWord) {
		this.url = url;
		this.userName = userName;
		this.passWord = passWord;
	}

	public void post() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				httpPost = new HttpPost(url);
				try {
					// POST请求需要接收表单，所以用List作为表单
					List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
					list.add(new BasicNameValuePair("userName", userName));
					list.add(new BasicNameValuePair("passWord", passWord));
					httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				// HttpResponse
				try {

					response = httpClient.execute(httpPost);
					responseCode = response.getStatusLine().getStatusCode();
					if (200 == responseCode) {
						result = EntityUtils.toString(response.getEntity());
						System.out.println(result);
					} else {
						result = "Failed";
						System.out.println(result);
					}

				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			
		}).start();

	}
		
}
