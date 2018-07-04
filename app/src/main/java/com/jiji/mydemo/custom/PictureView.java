package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.jiji.mydemo.R;

/**
 * 创建日期：2018/6/25.
 * 描述:
 * 作者:hw
 */
public class PictureView extends View {
    private Picture mPicture = new Picture();

    public PictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        recording();
    }

    /**
     * 开始录制
     */
    private void recording() {
        // 开始录制 (接收返回值Canvas)
        Canvas canvas = mPicture.beginRecording(500, 500);
        // 创建一个画笔
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        // 在Canvas中具体操作
        // 位移
        canvas.translate(250,250);
        // 绘制一个圆
        canvas.drawCircle(0,0,100,paint);

        mPicture.endRecording();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawPicture(mPicture);

//        PictureDrawable pictureDrawable = new PictureDrawable(mPicture);
//
//        pictureDrawable.setBounds(0,0,mPicture.getWidth(),mPicture.getHeight());
//
//        pictureDrawable.draw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap,new Matrix(),new Paint());

    }
}
