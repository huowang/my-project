package com.jiji.mydemo.custom;

/**
 * 创建日期：2018/6/25.
 * 描述:
 * 作者:hw
 */
public class PieDataBean {
    private float value;
    private float percentage;
    private int color;
    private float angle = 0;    // 角度

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
