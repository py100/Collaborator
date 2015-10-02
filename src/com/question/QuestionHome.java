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
	//���϶��м���ʾ�����ǣ����չ��ѡ���б��б���������tag�����£��������ֱ���ʾ������ҳ�棬��ҳ����ʾ��ͬ���⡣
	//1. �ҵĹ�ע����ʾ�û�ϲ�õ����⣩
	//2. �������⣨��ͬ�ʡ����������������ۺ�����
	//3. �����⣨δ���������ʱ������
    private List<String> list = new ArrayList<String>();     
    private Spinner mySpinner;    
    private ArrayAdapter<String> adapter;    
    private ImageButton settingsButton;
	@Override    
    public void onCreate(Bundle savedInstanceState) {    
        super.onCreate(savedInstanceState);    
        setContentView(R.layout.question_home);  

        //��һ�������һ�������б����list��������ӵ�����������б�Ĳ˵���    
        list.add("����");    
        list.add("������");    
        list.add("�ҵĹ�ע");           
        mySpinner = (Spinner)findViewById(R.id.questionTagSelector);    
        settingsButton = (ImageButton)findViewById(R.id.settings);
        //�ڶ�����Ϊ�����б���һ����������������õ���ǰ�涨���list��    
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);    
        //��������Ϊ���������������б�����ʱ�Ĳ˵���ʽ��    
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);    
        //���Ĳ�������������ӵ������б���    
        mySpinner.setAdapter(adapter);    
        //���岽��Ϊ�����б����ø����¼�����Ӧ���������Ӧ�˵���ѡ��    
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){    
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {    
                // TODO Auto-generated method stub    
                /* ����ѡmySpinner ��ֵ����myTextView ��*/    
                  
                /* ��mySpinner ��ʾ*/    
                arg0.setVisibility(View.VISIBLE);    
            }    
            public void onNothingSelected(AdapterView<?> arg0) {    
                // TODO Auto-generated method stub    
                   
                arg0.setVisibility(View.VISIBLE);    
            }    
        });    
        /*�����˵�����������ѡ����¼�����*/    
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener(){    
            public boolean onTouch(View v, MotionEvent event) {    
                // TODO Auto-generated method stub    
                return false;    
            }  
        });    
        /*�����˵�����������ѡ���ı��¼�����*/    
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener(){    
        public void onFocusChange(View v, boolean hasFocus) {    
            // TODO Auto-generated method stub    
  
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
    }    
}
