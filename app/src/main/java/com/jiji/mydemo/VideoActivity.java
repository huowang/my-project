package com.jiji.mydemo;

import android.app.Activity;
import android.os.Bundle;

/**
 * 创建日期：2018/5/9.
 * 描述:
 * 作者:hw
 */
public class VideoActivity extends Activity {
//    private PlayerView playerView;
//    private String url = "http://video.chuangchuang.cn/chuangchuang/cc_other/20170426/20170426_1493194591274.mp4";//http://video.chuangchuang.cn/chuangchuang/cc_other/20170426/20170426_1493194591274.mp4
//    private Context context;
//    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_activity);
    }
//        context = this;
//        playerView = (PlayerView) findViewById(R.id.player_view);
//
//// 1. Create a default TrackSelector
//        //Handler mainHandler = new Handler();
//        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
//        TrackSelection.Factory videoTrackSelectionFactory =
//                new AdaptiveTrackSelection.Factory(bandwidthMeter);
//        TrackSelector trackSelector =
//                new DefaultTrackSelector(videoTrackSelectionFactory);
//// 打印日志
//// 2. Create the player
//        player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
//// Measures bandwidth during playback. Can be null if not required.
//// Produces DataSource instances through which media data is loaded.
//        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(context,
//                Util.getUserAgent(context, "com.jiji.mydemo"), bandwidthMeter);
//// This is the MediaSource representing the media to be played.
//        MediaSource videoSource = new ExtractorMediaSource.Factory(dataSourceFactory)
//                .createMediaSource(Uri.parse(url));
//// Prepare the player with the source.
//        player.prepare(videoSource);
//
//        playerView.setPlayer(player);
//
//
//        player.addListener(new Player.EventListener() {
//            @Override
//            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
//
//            }
//
//            @Override
//            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
//
//            }
//
//            @Override
//            public void onLoadingChanged(boolean isLoading) {
//
//            }
//
//            @Override
//            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
//
//            }
//
//            @Override
//            public void onRepeatModeChanged(int repeatMode) {
//
//            }
//
//            @Override
//            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
//
//            }
//
//            @Override
//            public void onPlayerError(ExoPlaybackException error) {
//
//            }
//
//            @Override
//            public void onPositionDiscontinuity(int reason) {
//
//            }
//
//            @Override
//            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
//
//            }
//
//            @Override
//            public void onSeekProcessed() {
//
//            }
//        });
//    }
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        player.release();
//    }
}
