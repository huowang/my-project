package com.jiji.mydemo;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 创建日期：2018/6/13.
 * 描述:传感器
 * 作者:hw
 */
public class SensorDemoActivity extends Activity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView valueTv;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        valueTv = (TextView) findViewById(R.id.value_tv);

        // 获取传感器管理对象
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // 获取传感器的类型(TYPE_ACCELEROMETER:加速度传感器)
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //注册监听
        sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_GAME);

    }

    @Override
    protected void onStop() {
        super.onStop();
        //取消监听
        sensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //当传感器数值改变时数值回调
        float[] values = event.values;
        StringBuilder sb = new StringBuilder();
        sb.append("X方向的加速度：");
        sb.append(values[0]);
        sb.append("\nY方向的加速度：");
        sb.append(values[1]);
        sb.append("\nZ方向的加速度：");
        sb.append(values[2]);
        valueTv.setText(sb.toString());

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
