package com.example.shinji.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private static final int StrokeWidth1 = 20;
	private static final int StrokeWidth2 = 50;

	// Canvas 中心点
	private float xc = 0.0f;
	private float yc = 0.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		// Viewクラスを継承したクラスのオブジェクトを生成してViewにセット
		NewView newView = new NewView(this);
		setContentView(newView);
    }

	class NewView extends View {
		Paint paint;

		public NewView(Context context) {
			super(context);
			paint = new Paint();
		}

		@Override
		protected void onDraw(Canvas canvas) {
			// 背景
			canvas.drawColor(Color.argb(255, 0, 0, 125));

			// Canvas 中心点
			xc = canvas.getWidth()/2;
			yc = canvas.getHeight()/2;

			// 円
			paint.setColor(Color.argb(255, 125, 125, 255));
			paint.setStrokeWidth(StrokeWidth1);
			paint.setAntiAlias(true);
			paint.setStyle(Paint.Style.STROKE);
			// (x1,y1,r,paint) 中心x1座標, 中心y1座標, r半径
			canvas.drawCircle(xc - 50, yc - 200, xc / 2, paint);

			// 矩形
			paint.setColor(Color.argb(255, 255, 0, 255));
			paint.setStyle(Paint.Style.STROKE);
			// (x1,y1,x2,y2,paint) 左上の座標(x1,y1), 右下の座標(x2,y2)
			canvas.drawRect(xc - 100, yc - 200, xc + 400, yc + 200, paint);

			// 線
			paint.setStrokeWidth(StrokeWidth1);
			paint.setColor(Color.argb(255, 0, 255, 0));
			// (x1,y1,x2,y2,paint) 始点の座標(x1,y1), 終点の座標(x2,y2)
			canvas.drawLine(xc + 100, yc - 150, xc - 250, yc + 250, paint);

			// 三角形を書く
			paint.setStrokeWidth(10);
			paint.setColor(Color.WHITE);
			Path path = new Path();
			path.moveTo(600, 1000);
			path.lineTo(1000, 1400);
			path.lineTo(240, 1400);
			path.lineTo(600, 1000);
			canvas.drawPath(path, paint);

			// 円
			paint.setColor(Color.YELLOW);
			paint.setStrokeWidth(StrokeWidth2);
			paint.setAntiAlias(true);
			paint.setStyle(Paint.Style.STROKE);
			// (x,y,r,paint) x座標, y座標, r半径
			canvas.drawCircle(650, 440, 80, paint);

		}
	}
}

