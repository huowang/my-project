package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/27.
 * 描述:
 * 作者:hw
 */
public class ThreeBezierView extends View {
    private PointF startPoint, endPoint, controlPoint1, controlPoint2;
    private Paint mPaint = new Paint();
    private int position;
    private int centerX, centerY;

    public ThreeBezierView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(8);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        centerX = w / 2;
        centerY = h / 2;

        startPoint = new PointF(0, 0);
        endPoint = new PointF(0, 0);
        controlPoint1 = new PointF(0, 0);
        controlPoint2 = new PointF(0, 0);

        startPoint.x = centerX - 200;
        startPoint.y = centerY;

        endPoint.x = centerX + 200;
        endPoint.y = centerY;

        controlPoint1.x = centerX - 100;
        controlPoint1.y = centerY - 100;

        controlPoint2.x = centerX + 300;
        controlPoint2.y = centerY + 300;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Path path = new Path();
        path.moveTo(startPoint.x,startPoint.y);

        path.cubicTo(controlPoint1.x,controlPoint1.y,controlPoint2.x,controlPoint2.y,endPoint.x,endPoint.y);

        canvas.drawPath(path,mPaint);

    }
}
