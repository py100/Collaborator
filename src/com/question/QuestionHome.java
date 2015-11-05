package com.question;

import com.brator.collaborator.MainActivity;
import com.brator.collaborator.R;
import com.brator.collaborator.UserRegister;
import app.info.CommonInfo;

import java.io.IOException;
import java.util.ArrayList;  
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;  
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ImageButton;
import java.util.Calendar;
import java.util.HashMap;

import android.widget.ListView;  

/*����Ȧ*/

public class QuestionHome extends Activity {
	/** Called when the activity is first created. */    
	//���϶��м���ʾ�����ǣ����չ��ѡ���б��б���������tag�����£��������ֱ���ʾ������ҳ�棬��ҳ����ʾ��ͬ���⡣
	//1. �ҵĹ�ע����ʾ�û�ϲ�õ����⣩
	//2. �������⣨��ͬ�ʡ����������������ۺ�����
	//3. �����⣨δ���������ʱ������
    private List<String> list = new ArrayList<String>();     
    private Spinner mySpinner;    
    private ArrayAdapter<String> spinnerAdapter;    
    private ImageButton settingsButton;
    private ImageButton addQuestionBtn;
    private Button testButton;
    
	private Handler handler; // ����һ��Handler����
	private String result = ""; // ����һ��������ʾ������ַ���
	
    private String title = "{title}";
    private String content = "{content}";
    private String refund = "{refund}";
    private String time = "{time}";
    private String location = "{location}";
    private String questionType = "{questionType}";
    private String questionStatus = "{questionType}";
    
    JSONObject jsonResult;
    
    private ListView lv;  
    private List<Map<String, Object>> data;  
    
	@Override    
    public void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.question_home);  

        lv = (ListView)findViewById(R.id.listView);  
        
        data = getData();  
        MyAdapter adapter = new MyAdapter(this);  
        lv.setAdapter(adapter);  
        
        //��һ�������һ�������б����list��������ӵ�����������б�Ĳ˵���    
        list.add("����");    
        list.add("������");    
        list.add("�ҵĹ�ע");           
        testButton = (Button)findViewById(R.id.testButton);
        mySpinner = (Spinner)findViewById(R.id.questionTagSelector);    
        settingsButton = (ImageButton)findViewById(R.id.settings);
        addQuestionBtn =  (ImageButton)findViewById(R.id.addQuestionIcon);
        //�ڶ�����Ϊ�����б���һ����������������õ���ǰ�涨���list��    
        spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);    
        //��������Ϊ���������������б�����ʱ�Ĳ˵���ʽ��    
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);      
        //���Ĳ�������������ӵ������б���    
        mySpinner.setAdapter(spinnerAdapter);    
        //���岽��Ϊ�����б����ø����¼�����Ӧ���������Ӧ�˵���ѡ��    
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
                // TODO Auto-generated method stub    
            	
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                // TODO Auto-generated method stub    
                   
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
        //���϶��ұ���ʾ�û�ͷ�����������ý���
        settingsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(com.question.QuestionHome.this,com.brator.collaborator.Settings.class);
				startActivity(intent);
				
			}
		});
        addQuestionBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				startActivity(intent);
				
			}
		});
        
        testButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		        new Thread(new Runnable() {
					public void run() {
						try {
							getQuestion();
							title = jsonResult.getString("title");
							content = jsonResult.getString("content");
							refund = jsonResult.getString("refund");
							time = Integer.toString(Calendar.getInstance().get(Calendar.YEAR)) + "��" + jsonResult.getString("time");
							location = jsonResult.getString("location");
							questionType = jsonResult.getString("type");
							questionStatus = jsonResult.getString("status");
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
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
					//success
				}
				super.handleMessage(msg);
			}
		};
    }  
	
	public void getQuestion() throws JSONException {
		HttpClient httpclient = new DefaultHttpClient();//����HttpClient����
		HttpGet httpRequest = new HttpGet(CommonInfo.questionShowUrl);	//����HttpGet���Ӷ���
		HttpResponse httpResponse;
		try {
			httpResponse = httpclient.execute(httpRequest);	//ִ��HttpClient����
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				result = EntityUtils.toString(httpResponse.getEntity());	//��ȡ���ص��ַ���
				jsonResult = new JSONObject(result);
			}else{
				result="����ʧ�ܣ�";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<Map<String, Object>> getData()  
	{  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        Map<String, Object> map;  
        for(int i=0;i<10;i++)  
        {  
            map = new HashMap<String, Object>();  
            map.put("setTitle", title);  
	        map.put("setContent", content);  
	        map.put("setRefund", refund);
	        map.put("setTime", time);
	        map.put("setLocation", location);
	        map.put("setTime", time);
	        map.put("setQType", questionType);
	        map.put("setStatus", questionStatus);
	        map.put("setTime", time);
	        list.add(map);  
        }  
	    return list;  
	}  
	
    static class ViewHolder  
    {  
        public TextView setTitle;  
        public TextView setContent;  
        public TextView setRefund;
        public TextView setTime;
        public TextView setLocation;
        public TextView setQType;
        public TextView setStatus;
    }  
	
	public class MyAdapter extends BaseAdapter  
    {      
        private LayoutInflater mInflater = null;  
        private MyAdapter(Context context)  
        {  
            //����context�����ļ��ز��֣��������Demo17Activity������this  
            this.mInflater = LayoutInflater.from(context);  
        }  
  
        @Override  
        public int getCount() {  
            //How many items are in the data set represented by this Adapter.  
            //�ڴ�������������������ݼ��е���Ŀ��  
            return data.size();  
        }  
  
        @Override  
        public Object getItem(int position) {  
            // Get the data item associated with the specified position in the data set.  
            //��ȡ���ݼ�����ָ��������Ӧ��������  
            return position;  
        }  
  
        @Override  
        public long getItemId(int position) {  
            //Get the row id associated with the specified position in the list.  
            //��ȡ���б�����ָ��������Ӧ����id  
            return position;  
        }  
          
        //Get a View that displays the data at the specified position in the data set.  
        //��ȡһ�������ݼ���ָ����������ͼ����ʾ����  
        @Override  
        public View getView(int position, View convertView, ViewGroup parent) {  
            ViewHolder holder = null;  
            //�������convertViewΪ�գ�����Ҫ����View  
            if(convertView == null)  
            {  
                holder = new ViewHolder();  
                //�����Զ����Item���ּ��ز���  
                convertView = mInflater.inflate(R.layout.question_home_item, null);  
                holder.setTitle = (TextView)convertView.findViewById(R.id.item_title);  
                holder.setContent = (TextView)convertView.findViewById(R.id.item_content);  
                holder.setRefund = (TextView)convertView.findViewById(R.id.item_refund);
                holder.setTime = (TextView)convertView.findViewById(R.id.item_time);
                holder.setLocation = (TextView)convertView.findViewById(R.id.item_location);
                holder.setQType = (TextView)convertView.findViewById(R.id.item_type);
                holder.setStatus = (TextView)convertView.findViewById(R.id.item_status);     
                //�����úõĲ��ֱ��浽�����У�������������Tag��Ա���淽��ȡ��Tag  
                convertView.setTag(holder);  
            }else  
            {  
                holder = (ViewHolder)convertView.getTag();  
            }    
            holder.setTitle.setText((String)data.get(position).get("setTitle"));  
            holder.setContent.setText((String)data.get(position).get("setContent"));  
            holder.setRefund.setText((String)data.get(position).get("setRefund"));  
            holder.setTime.setText((String)data.get(position).get("setTime"));  
            holder.setLocation.setText((String)data.get(position).get("setLocation"));  
            holder.setQType.setText((String)data.get(position).get("setQType"));  
            holder.setStatus.setText((String)data.get(position).get("setStatus"));  
            return convertView;  
        }  
          
    }  
}
