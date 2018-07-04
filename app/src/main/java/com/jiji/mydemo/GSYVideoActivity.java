package com.jiji.mydemo;

import android.app.Activity;
import android.os.Bundle;
import com.shuyu.gsyvideoplayer.video.NormalGSYVideoPlayer;

/**
 * 创建日期：2018/5/10.
 * 描述:
 * 作者:hw
 */
public class GSYVideoActivity extends Activity {
    private NormalGSYVideoPlayer playerView;
    private String url = "http://video.chuangchuang.cn/chuangchuang/cc_other/20170426/20170426_1493194591274.mp4";//http://video.chuangchuang.cn/chuangchuang/cc_other/20170426/20170426_1493194591274.mp4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gsy_video);
        playerView = (NormalGSYVideoPlayer) findViewById(R.id.player_view);

        playerView.setNeedShowWifiTip(true);
        playerView.setDialogProgressColor(getResources().getColor(R.color.colorBlue),getResources().getColor(R.color.colorBlack));

        playerView.setUp(url,true,"测试视频");
    }
}
