package com.example.widgettest;

import mobileann.mafamily.widgets.LevelBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	LevelBar levelBar;
	int level = 6;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		levelBar = (LevelBar) findViewById(R.id.levelBar);
		levelBar.initLevel(level);
	}
	
	public void initLevelOnClick(View v) {
		levelBar.initLevel(level);
	}

	public void changeLevelOnClick(View v) {
		if (level > 9) level = 0;
		levelBar.setLevel(level++);
	}

}
