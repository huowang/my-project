package com.jiji.mydemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 创建日期：2018/6/8.
 * 描述:
 * 作者:hw
 */
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "收到请回答", Toast.LENGTH_SHORT).show();
    }
}
