package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/26.
 * 描述:
 * 作者:hw
 */
public class MyTextView extends View {
    private Paint mPaint = new Paint();

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = "Hello World";

        canvas.drawText(str,200,500,mPaint);

    }
}
