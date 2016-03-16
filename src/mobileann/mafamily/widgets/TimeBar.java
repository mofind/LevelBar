package mobileann.mafamily.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TimeBar extends LinearLayout {

	public static final String[] TIMES = { "0:00", "3:00", "6:00", "9:00", "12:00", "15:00", "18:00", "21:00" };
	private View progressView;

	public TimeBar(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initView(context);
	}

	public TimeBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initView(context);
	}

	public TimeBar(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initView(context);
	}

	private void initView(Context context) {
		HorizontalScrollView scrollView = new HorizontalScrollView(context);
		// 刻度
		LinearLayout indexLayout = new LinearLayout(context);
		indexLayout.setOrientation(LinearLayout.HORIZONTAL);

		// 时间轴
		progressView = new View(context);
		progressView.setBackgroundColor(Color.GRAY);

		// 容器
		LinearLayout containerView = new LinearLayout(context);
		containerView.setOrientation(LinearLayout.VERTICAL);

		for (int i = 0; i < TIMES.length; i++) {
			// 时间
			TextView indexTv = new TextView(context);
			indexTv.setText(TIMES[i]);
			indexTv.setTextColor(Color.BLACK);
			indexTv.setSingleLine();
			indexLayout.addView(indexTv, 200, 80);
		}

		// 标志
		TextView flagTv = new TextView(context);
		flagTv.setText("使用时间");
		flagTv.setTextColor(Color.BLACK);
		// 方块
		TextView rectTv = new TextView(context);
		rectTv.setBackgroundColor(0xffff6600);
		LinearLayout.LayoutParams params = new LayoutParams(20, 20);
		params.setMargins(10, 0, 5, 0);
		// 水平标志容器
		LinearLayout conFlagView = new LinearLayout(context);
		conFlagView.setOrientation(LinearLayout.HORIZONTAL);
		conFlagView.setGravity(Gravity.CENTER_VERTICAL);
		conFlagView.addView(rectTv, params);
		conFlagView.addView(flagTv);

		containerView.addView(indexLayout);
		containerView.addView(progressView, -1, 30);
		scrollView.addView(containerView, -1, 150);
		scrollView.setHorizontalScrollBarEnabled(false);

		setOrientation(LinearLayout.VERTICAL);
		setBackgroundColor(0xffcccccc);
		setPadding(0, 10, 0, 10);
		addView(scrollView);
		addView(conFlagView);

		// 创建Paint
		Paint paint = new Paint();
		// 设置抗锯齿效果
		paint.setAntiAlias(true);
		// 设置画刷的颜色
		paint.setColor(0xffff6600);
		
		Canvas canvas = new Canvas();
		canvas.drawRect(new Rect(100, 70, 200, 140), paint);
	}

}
