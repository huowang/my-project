package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/25.
 * 描述:点
 * 作者:hw
 */
public class PointView extends View {
    /**
     * 创建画笔
     */
    private Paint mPaint= new Paint();

    public PointView(Context context) {
        super(context);

    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void  initPaint(){
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10f);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawPoint(300,300,mPaint);
//        canvas.drawPoints(new float[]{400,200,400,100,400,300},mPaint);
//
//
//        canvas.drawLine(0,0,500,500,mPaint);
//        canvas.drawLines(new float[]{500,600,800,900,600,700,400,200},mPaint);
//
//        canvas.drawRect(500,500,900,1200,mPaint);
//        canvas.drawRoundRect(200,200,500,800,30,30,mPaint);

//        RectF rectF = new RectF(100,100,300,500);
//        canvas.drawOval(rectF,mPaint);
//
//        canvas.drawCircle(500,500,200,mPaint);

        RectF rectF = new RectF(0,0,300,300);
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.BLUE);
        canvas.drawArc(rectF,0,90,true,mPaint);
    }
}
