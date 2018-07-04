package com.jiji.mydemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * 创建日期：2018/6/25.
 * 描述:饼状图
 * 作者:hw
 */
public class PieView extends View {
    /**
     * 画笔
     */
    private Paint mPaint = new Paint();

    private List<PieDataBean> pieDataBeans;

    private int width, height;
    // 饼状图初始绘制角度
    private float mStartAngle = 0;

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void setData(List<PieDataBean> pieDataBeans) {
        this.pieDataBeans = pieDataBeans;
        initData();
        invalidate();
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
        if (pieDataBeans != null) {
            canvas.translate(width / 2, height / 2);
            float r = (float) (Math.min(width / 2, height / 2) * 0.9);

            RectF rectF = new RectF(-r, -r, r, r);
            float currentStartAngle = mStartAngle;

            for (int i = 0; i < pieDataBeans.size(); i++) {
                PieDataBean pieDataBean = pieDataBeans.get(i);
                mPaint.setColor(pieDataBean.getColor());
                canvas.drawArc(rectF, currentStartAngle, pieDataBean.getAngle(), true, mPaint);
                currentStartAngle = currentStartAngle + pieDataBean.getAngle();
            }
        }
    }

    private void initData() {
        if (null == pieDataBeans || pieDataBeans.size() == 0) {
            return;
        }
        float sumValue = 0;
        for (int i = 0; i < pieDataBeans.size(); i++) {
            sumValue += pieDataBeans.get(i).getValue();
        }

        for (int i = 0; i < pieDataBeans.size(); i++) {
            PieDataBean pieDataBean = pieDataBeans.get(i);
            float percentage = pieDataBean.getValue() / sumValue;

            pieDataBean.setAngle(percentage * 360);
            pieDataBean.setPercentage(percentage);
        }
    }
}
