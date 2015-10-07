package com.question;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.brator.collaborator.R;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.Activity;
import app.info.CommonInfo;

/*�����ύ*/

public class QuestionSubmit extends Activity{
	
	private EditText title;
	private EditText content;
	private EditText location;
	private String refund;
	private String month;
	private String userId = "";
	private String day;
	private String time;
	private String questionType;//������
	private Button submit;
	
	private String result = ""; // ����һ��������ʾ���ݵ��ַ���
	
	private List<String> listMonth = new ArrayList<String>();  
	private Spinner spinnerMonth; 
	private ArrayAdapter<String> adapterMonth; 
	private List<String> listDay = new ArrayList<String>();  
	private Spinner spinnerDay; 
	private ArrayAdapter<String> adapterDay; 
	private List<String> listTime = new ArrayList<String>();  
	private Spinner spinnerTime; 
	private ArrayAdapter<String> adapterTime; 
	private List<String> listRefund = new ArrayList<String>();  
	private Spinner spinnerRefund; 
	private ArrayAdapter<String> adapterRefund; 
	private List<String> listQType = new ArrayList<String>();  
	private Spinner spinnerQType; 
	private ArrayAdapter<String> adapterQType; 
	
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
	
	@Override    
    public void onCreate(Bundle savedInstanceState) { 
	    super.onCreate(savedInstanceState);    
	    setContentView(R.layout.question_submit); 
	    for (int i=1;i<=12;i++)
	    	listMonth.add(Integer.toString(i)+"��");
	    for (int i=1;i<31;i++)
	    	listDay.add(Integer.toString(i)+"��");
    	for (int i=0;i<24;i++)
    	{
    		if (i<10)
    		{
    			listTime.add("0"+Integer.toString(i)+":00");
    			listTime.add("0"+Integer.toString(i)+":30");
    		}
    		else
    		{
    			listTime.add(Integer.toString(i)+":00");
    			listTime.add(Integer.toString(i)+":30");
    		}
    	}
	    for (int i=0;i<101;i++)
	    	listRefund.add(Integer.toString(i));
	    //������������ڴ�
	    listQType.add("�����");
	    listQType.add("ͨ��");
	    listQType.add("���");
	    listQType.add("��������");
	    listQType.add("��");
	    //������������ڴ�
	    
	    resultTextView = (TextView) findViewById(R.id.result);
	    
	    spinnerMonth = (Spinner)findViewById(R.id.month); 
	    adapterMonth = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listMonth);
	    adapterMonth.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerMonth.setAdapter(adapterMonth);
	    spinnerDay = (Spinner)findViewById(R.id.day); 
	    adapterDay = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listDay);
	    adapterDay.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerDay.setAdapter(adapterDay);
	    spinnerTime = (Spinner)findViewById(R.id.time); 
	    adapterTime = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listTime);
	    adapterTime.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerTime.setAdapter(adapterTime);
	    spinnerRefund = (Spinner)findViewById(R.id.refund); 
	    adapterRefund = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listRefund);
	    adapterRefund.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerRefund.setAdapter(adapterRefund);
	    spinnerQType = (Spinner)findViewById(R.id.question_type); 
	    adapterQType = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, listQType);
	    adapterQType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    spinnerQType.setAdapter(adapterQType);
	    
	    spinnerMonth.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
            	month = arg0.getItemAtPosition(arg2).toString();
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
	    
	    spinnerDay.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {   
            	day = arg0.getItemAtPosition(arg2).toString();
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
	    
	    spinnerTime.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {   
            	time = arg0.getItemAtPosition(arg2).toString();
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
	    
	    spinnerRefund.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {  
            	refund = arg0.getItemAtPosition(arg2).toString();
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
	    
	    spinnerQType.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {   
            	questionType = arg0.getItemAtPosition(arg2).toString();
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
	    
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("".equals(title.getText().toString())
						|| "".equals(content.getText().toString())
						|| "".equals(location.getText().toString())) {
					Toast.makeText(QuestionSubmit.this, "�뽫��������������",
							Toast.LENGTH_SHORT).show();
					return;
				}

				// ����һ�����̣߳����ڴ������ϻ�ȡ�ļ�
				new Thread(new Runnable() {
					public void run() {
						submitQuestion();
						Message m = handler.obtainMessage(); // ��ȡһ��Message
						handler.sendMessage(m); // ������Ϣ
					}
				}).start(); // �����߳�

			}
		});
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (result != null) {
					//�ɹ�
				}
				super.handleMessage(msg);
			}
		};
	}
	
	public void submitQuestion() {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(CommonInfo.questionSubmitUrl);

		List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
		list.add(new BasicNameValuePair("title", title.getText().toString()));
		list.add(new BasicNameValuePair("detail", content.getText().toString()));
		list.add(new BasicNameValuePair("ownerId", userId));
		list.add(new BasicNameValuePair("refund", refund));
		list.add(new BasicNameValuePair("location", location.getText().toString()));
		list.add(new BasicNameValuePair("time", month+day+" "+time));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(list, "utf-8")); //���ñ��뷽ʽ
			HttpResponse httpResponse = httpClient.execute(httpPost);	//ִ��HttpClient����
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){	//�������ɹ�
				Message msg = Message.obtain();
				msg.obj = "Success";
				handler.sendMessage(msg);
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();	//����쳣��Ϣ
		} catch (ClientProtocolException e) {
			e.printStackTrace();	//����쳣��Ϣ
		} catch (IOException e) {
			e.printStackTrace();	//����쳣��Ϣ
		}

	}
}
