package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 创建日期：2018/6/28.
 * 描述:
 * 作者:hw
 */
public class PathMeasureView extends View {
    private int width,height;
    private Paint mPaint = new Paint();

    public PathMeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.STROKE);
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

//        canvas.translate(width/2,height/2);
//
//        Path path = new Path();
//
//        RectF rectF = new RectF(-200,-200,200,200);
//        path.addRect(rectF, Path.Direction.CW);
//
//        PathMeasure pathMeasure = new PathMeasure(path,false);
//        pathMeasure.getSegment(200,600,path,true);
//
//        canvas.drawPath(path,mPaint);

        canvas.translate(width / 2, height / 2);          // 平移坐标系

        Path path = new Path();                                     // 创建Path并添加了一个矩形
        path.addRect(-200, -200, 200, 200, Path.Direction.CW);

        Path dst = new Path();                                      // 创建用于存储截取后内容的 Path
        dst.lineTo(-300,-300);
        PathMeasure measure = new PathMeasure(path, true);         // 将 Path 与 PathMeasure 关联

// 截取一部分存入dst中，并使用 moveTo 保持截取得到的 Path 第一个点的位置不变
        measure.getSegment(200, 600, dst, false);

        canvas.drawPath(dst,mPaint);                        // 绘制 dst



    }
}
