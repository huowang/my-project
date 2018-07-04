package com.jiji.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jiji.mydemo.custom.CustomViewActivity;

public class MainActivity extends Activity {
//    private RecycleViewAdapter recycleViewAdapter;
//    private List<String> stringList = new ArrayList<>();
    private Button webBtn;
    private Button videoBtn;
    private Button gsyVideoBtn;
    private Button bluetoothBtn;
    private Button sensorBtn;
    private Button bitmapBtn;

    private Button customViewBtn;




    //http://video.chuangchuang.cn/chuangchuang/cc_other/20170426/20170426_1493194591274.mp4

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        for (int i = 0; i < 10; i++) {
//            stringList.add("我是在测试" + i);
//        }

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
//        recycleView.setLayoutManager(staggeredGridLayoutManager);
//
//        recycleViewAdapter = new RecycleViewAdapter(stringList);
//        recycleView.setAdapter(recycleViewAdapter);
//
//        recycleViewAdapter.setItemOnclickListener(new RecycleViewAdapter.ItemOnclickListener() {
//            @Override
//            public void ItemClick(int position) {
//                stringList.set(position,"我修改了"+position);
//                recycleViewAdapter.notifyItemChanged(position,"change");
//            }
//        });


        webBtn = (Button) findViewById(R.id.web_btn);
        webBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestActivity.class));
            }
        });

        videoBtn = (Button) findViewById(R.id.video_btn);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,VideoActivity.class));
            }
        });

        gsyVideoBtn = (Button) findViewById(R.id.gsy_video_btn);
        gsyVideoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,GSYVideoActivity.class));

            }
        });

        bluetoothBtn = (Button) findViewById(R.id.bluetooth_btn);
        bluetoothBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BluetoothDemoActivity.class));
            }
        });

        sensorBtn = (Button) findViewById(R.id.sensor_btn);
        sensorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SensorDemoActivity.class));
            }
        });
        bitmapBtn = (Button) findViewById(R.id.bitmap_btn);
        bitmapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BitmapDemoActivity.class));
            }
        });

        customViewBtn = (Button) findViewById(R.id.custom_view_btn);
        customViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CustomViewActivity.class));
            }
        });
    }

}
