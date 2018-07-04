package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/28.
 * 描述:
 * 作者:hw
 */
public class PaintFeaturesView extends View {
    private Paint mPaint = new Paint();
    private int width,height;

    public PaintFeaturesView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);

      //  mPaint.setAntiAlias(true);
       // mPaint.setStrokeCap(Paint.Cap.BUTT);
      //  mPaint.setStrokeJoin(Paint.Join.ROUND);
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
      //  canvas.translate(width/2,height/2);

//        canvas.drawLine(0,0,100,100,mPaint);
//        canvas.drawLine(100,100,100,0,mPaint);

        Path path = new Path();

//        path.moveTo(200,200);
//        path.lineTo(0,600);
//        path.moveTo(200,200);
//        path.lineTo(600,600);

        path.moveTo(100,600);
        path.lineTo(400,100);
        path.lineTo(700,900);

        canvas.drawPath(path,mPaint);

        mPaint.setPathEffect(new CornerPathEffect(100));

        mPaint.setColor(Color.YELLOW);
        canvas.drawPath(path,mPaint);

    }
}
