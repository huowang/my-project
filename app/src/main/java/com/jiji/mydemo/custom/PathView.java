package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/26.
 * 描述:
 * 作者:hw
 */
public class PathView extends View {
    private int width, height;
    private Paint mPaint = new Paint();


    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);
        Path path = new Path();
        Path src = new Path();
        canvas.scale(1,-1);
//        path.lineTo(200,200);
//
//        path.setLastPoint(200,0);
//        //path.moveTo(300,300);
//
//        path.lineTo(0,200);
//        path.close();

//        path.addRect(200,200,-200,-200, Path.Direction.CCW);
//
//        path.setLastPoint(-100,100);

//        path.addRect(-200,200,200,-200, Path.Direction.CCW);
//
//        src.addCircle(0,200,100,Path.Direction.CCW);
//        path.addPath(src,0,200);
        path.lineTo(100,100);
        RectF rectF = new RectF(0,0,200,200);
      //  path.addArc(rectF,0,270);
        path.arcTo(rectF,0,270,false);
        canvas.drawPath(path,mPaint);

    }
}
