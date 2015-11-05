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

/*问题圈*/

public class QuestionHome extends Activity {
	/** Called when the activity is first created. */    
	//最上端中间显示倒三角，点击展开选择列表，列表中有三个tag（如下），点击后分别显示三个子页面，子页面显示不同问题。
	//1. 我的关注（显示用户喜好的问题）
	//2. 热门问题（“同问”数量，评论数量综合排序）
	//3. 新问题（未被解决，按时间排序）
    private List<String> list = new ArrayList<String>();     
    private Spinner mySpinner;    
    private ArrayAdapter<String> spinnerAdapter;    
    private ImageButton settingsButton;
    private ImageButton addQuestionBtn;
    private Button testButton;
    
	private Handler handler; // 声明一个Handler对象
	private String result = ""; // 声明一个代表显示结果的字符串
	
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
        
        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项    
        list.add("热门");    
        list.add("新问题");    
        list.add("我的关注");           
        testButton = (Button)findViewById(R.id.testButton);
        mySpinner = (Spinner)findViewById(R.id.questionTagSelector);    
        settingsButton = (ImageButton)findViewById(R.id.settings);
        addQuestionBtn =  (ImageButton)findViewById(R.id.addQuestionIcon);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。    
        spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);    
        //第三步：为适配器设置下拉列表下拉时的菜单样式。    
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);      
        //第四步：将适配器添加到下拉列表上    
        mySpinner.setAdapter(spinnerAdapter);    
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中    
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
        //最上端右边显示用户头像点击进入设置界面
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
							time = Integer.toString(Calendar.getInstance().get(Calendar.YEAR)) + "年" + jsonResult.getString("time");
							location = jsonResult.getString("location");
							questionType = jsonResult.getString("type");
							questionStatus = jsonResult.getString("status");
							
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Message m = handler.obtainMessage(); // 获取一个Message
						handler.sendMessage(m); // 发送消息
					}
				}).start(); // 开启线程
				
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
		HttpClient httpclient = new DefaultHttpClient();//创建HttpClient对象
		HttpGet httpRequest = new HttpGet(CommonInfo.questionShowUrl);	//创建HttpGet连接对象
		HttpResponse httpResponse;
		try {
			httpResponse = httpclient.execute(httpRequest);	//执行HttpClient请求
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				result = EntityUtils.toString(httpResponse.getEntity());	//获取返回的字符串
				jsonResult = new JSONObject(result);
			}else{
				result="请求失败！";
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
            //根据context上下文加载布局，这里的是Demo17Activity本身，即this  
            this.mInflater = LayoutInflater.from(context);  
        }  
  
        @Override  
        public int getCount() {  
            //How many items are in the data set represented by this Adapter.  
            //在此适配器中所代表的数据集中的条目数  
            return data.size();  
        }  
  
        @Override  
        public Object getItem(int position) {  
            // Get the data item associated with the specified position in the data set.  
            //获取数据集中与指定索引对应的数据项  
            return position;  
        }  
  
        @Override  
        public long getItemId(int position) {  
            //Get the row id associated with the specified position in the list.  
            //获取在列表中与指定索引对应的行id  
            return position;  
        }  
          
        //Get a View that displays the data at the specified position in the data set.  
        //获取一个在数据集中指定索引的视图来显示数据  
        @Override  
        public View getView(int position, View convertView, ViewGroup parent) {  
            ViewHolder holder = null;  
            //如果缓存convertView为空，则需要创建View  
            if(convertView == null)  
            {  
                holder = new ViewHolder();  
                //根据自定义的Item布局加载布局  
                convertView = mInflater.inflate(R.layout.question_home_item, null);  
                holder.setTitle = (TextView)convertView.findViewById(R.id.item_title);  
                holder.setContent = (TextView)convertView.findViewById(R.id.item_content);  
                holder.setRefund = (TextView)convertView.findViewById(R.id.item_refund);
                holder.setTime = (TextView)convertView.findViewById(R.id.item_time);
                holder.setLocation = (TextView)convertView.findViewById(R.id.item_location);
                holder.setQType = (TextView)convertView.findViewById(R.id.item_type);
                holder.setStatus = (TextView)convertView.findViewById(R.id.item_status);     
                //将设置好的布局保存到缓存中，并将其设置在Tag里，以便后面方便取出Tag  
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
