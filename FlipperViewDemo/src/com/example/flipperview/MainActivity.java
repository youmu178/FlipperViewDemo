package com.example.flipperview;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {

	private ViewFlipper mFlipper;
    private ArrayList<String> mDataList = new ArrayList<String>(); 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
		initData();
		addDataToView();
		mFlipper.setFlipInterval(1500);
		mFlipper.setInAnimation(this, R.anim.slide_top_in);
		mFlipper.setOutAnimation(this, R.anim.slide_bottom_out);
		mFlipper.setAutoStart(true);
	}
	
	private void initData () {
		for (int i = 0; i < 10; i++) {
			mDataList.add("喊起我们的口号： " + i);
		}
	}
	
	private void addDataToView () {
		for (String text : mDataList) {
			TextView tv = new TextView(this);
			tv.setGravity(Gravity.CENTER);
			tv.setTextSize(22);
			tv.setPadding(10, 10, 10, 10);
			tv.setTextColor(Color.RED);
			tv.setText(text);
			mFlipper.addView(tv);
		}
	}
}
