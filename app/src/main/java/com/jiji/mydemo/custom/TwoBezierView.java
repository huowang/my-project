package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 创建日期：2018/6/26.
 * 描述:
 * 作者:hw
 */
public class TwoBezierView extends View {
    private Paint mPaint = new Paint();
    private PointF startPoint, endPoint, controlPoint;
    private int centerX, centerY;

    public TwoBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        startPoint = new PointF(0, 0);
        endPoint = new PointF(0, 0);
        controlPoint = new PointF(0, 0);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        startPoint.x = centerX - 300;
        startPoint.y = centerY;

        endPoint.x = centerX + 300;
        endPoint.y = centerY;

        controlPoint.x = centerX;
        controlPoint.y = centerY - 200;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        controlPoint.x = event.getX();
        controlPoint.y = event.getY();
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
       // canvas.translate(centerX, centerY);

        //画点
        mPaint.setColor(Color.BLACK);
        canvas.drawPoint(startPoint.x,startPoint.y,mPaint);
        canvas.drawPoint(endPoint.x,endPoint.y,mPaint);
        canvas.drawPoint(controlPoint.x,controlPoint.y,mPaint);

        //画辅助线
        mPaint.setColor(Color.GRAY);
        Path path = new Path();
        path.moveTo(startPoint.x,startPoint.y);
        path.lineTo(controlPoint.x,controlPoint.y);
        path.lineTo(endPoint.x,endPoint.y);
        canvas.drawPath(path,mPaint);

        //画贝塞尔曲线
        mPaint.setColor(Color.RED);
        Path path1 = new Path();
        path1.moveTo(startPoint.x,startPoint.y);
        path1.quadTo(controlPoint.x,controlPoint.y,endPoint.x,endPoint.y);
        canvas.drawPath(path1,mPaint);


    }
}
