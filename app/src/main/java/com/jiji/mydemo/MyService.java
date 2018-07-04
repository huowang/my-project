package com.jiji.mydemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * 创建日期：2018/6/7.
 * 描述:
 * 作者:hw
 */
public class MyService extends Service {

    private LocalBinder binder = new LocalBinder();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 创建Binder对象
     */
    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
