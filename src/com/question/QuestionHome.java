package com.question;

import com.brator.collaborator.MainActivity;
import com.brator.collaborator.R;
import com.brator.collaborator.UserRegister;

import java.util.ArrayList;  
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;  
import android.view.MotionEvent;  
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;  
import android.widget.ArrayAdapter;  
import android.widget.Spinner;  
import android.widget.ImageButton;

public class QuestionHome extends Activity {
	/** Called when the activity is first created. */    
	//最上端中间显示倒三角，点击展开选择列表，列表中有三个tag（如下），点击后分别显示三个子页面，子页面显示不同问题。
	//1. 我的关注（显示用户喜好的问题）
	//2. 热门问题（“同问”数量，评论数量综合排序）
	//3. 新问题（未被解决，按时间排序）
    private List<String> list = new ArrayList<String>();     
    private Spinner mySpinner;    
    private ArrayAdapter<String> adapter;    
    private ImageButton settingsButton;
	@Override    
    public void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.question_home);  

        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项    
        list.add("热门");    
        list.add("新问题");    
        list.add("我的关注");           
        mySpinner = (Spinner)findViewById(R.id.questionTagSelector);    
        settingsButton = (ImageButton)findViewById(R.id.settings);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。    
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);    
        //第三步：为适配器设置下拉列表下拉时的菜单样式。    
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
        //第四步：将适配器添加到下拉列表上    
        mySpinner.setAdapter(adapter);    
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中    
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
                // TODO Auto-generated method stub    
                /* 将所选mySpinner 的值带入myTextView 中*/    
                  
                /* 将mySpinner 显示*/    
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                // TODO Auto-generated method stub    
                   
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
        /*下拉菜单弹出的内容选项触屏事件处理*/    
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener(){    
            public boolean onTouch(View v, MotionEvent event) {    
                // TODO Auto-generated method stub    
                return false;    
            }  
        });    
        /*下拉菜单弹出的内容选项焦点改变事件处理*/    
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){    
        public void onFocusChange(View v, boolean hasFocus) {    
            // TODO Auto-generated method stub    
  
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
    }    
}
