package com.jiji.mydemo;

import android.content.Context;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

/**
 * 创建日期：2018/5/22.
 * 描述:
 * 作者:hw
 */
public class MyVideoView extends StandardGSYVideoPlayer {
    public MyVideoView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    @Override
    protected void showProgressDialog(float deltaX, String seekTime, int seekTimePosition, String totalTime, int totalTimeDuration) {
        super.showProgressDialog(deltaX, seekTime, seekTimePosition, totalTime, totalTimeDuration);

    }
}
