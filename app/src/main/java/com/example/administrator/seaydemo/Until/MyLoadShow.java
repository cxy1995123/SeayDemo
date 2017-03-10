package com.example.administrator.seaydemo.Until;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by duangniu000 on 2017/3/10.
 */

public class MyLoadShow extends View {
    private Paint paint;
    private int progrss = 0;

    public MyLoadShow(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.argb(254, 200, 200, 200));
        paint.setAntiAlias(false);
        paint.setStrokeWidth(4);
        paint.setTypeface(Typeface.DEFAULT);
        int w = getWidth() / 2;
        int height = getHeight() / 2;
        RectF rectF = new RectF(w - 100, height - 100, w + 100, height + 100);
        canvas.drawArc(rectF, 0, progrss, true, paint);
    }

    public void setProgrss(int progrss) {
        this.progrss = progrss;
        invalidate();

    }
}
