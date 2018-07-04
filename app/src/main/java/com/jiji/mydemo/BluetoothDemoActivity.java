package com.jiji.mydemo;

import android.app.Activity;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2018/6/11.
 * 描述:蓝牙
 * 作者:hw
 */
public class BluetoothDemoActivity extends Activity {
    private BluetoothAdapter bluetoothAdapter;
    private Button openBtn;
    private Button searchBtn;
    private ListView listView;
    private MyBluetoothAdapter myBluetoothAdapter;

    private List<BluetoothDevice> strings = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        openBtn = (Button) findViewById(R.id.open_btn);
        listView = (ListView) findViewById(R.id.list_view);


        searchBtn = (Button) findViewById(R.id.search_btn);


        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.enable();
//                    Intent enabler = new Intent(MyBluetoothAdapter.ACTION_REQUEST_ENABLE);
//                    startActivityForResult(enabler, REQUEST_ENABLE);
                } else {
                    Toast.makeText(BluetoothDemoActivity.this, "蓝牙已经打开", Toast.LENGTH_SHORT).show();
                }
            }
        });

        myBluetoothAdapter = new MyBluetoothAdapter(strings);
        listView.setAdapter(myBluetoothAdapter);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bluetoothAdapter.startDiscovery();

            }
        });

        // 注册BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(new MyBluetoothReceiver(), filter); // 不要忘了之后解除绑定

        IntentFilter filter1 = new IntentFilter(BluetoothDevice.ACTION_BOND_STATE_CHANGED);
        registerReceiver(new MyBluetoothReceiver(), filter1); // 不要忘了之后解除绑定


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                strings.get(position).createBond();
            }
        });
    }


    class MyBluetoothReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                strings.add(device);
                myBluetoothAdapter.notifyDataSetChanged();
            } else if (BluetoothDevice.ACTION_BOND_STATE_CHANGED.equals(action)) {
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                switch (device.getBondState()) {
                    case BluetoothDevice.BOND_BONDING:
                        Toast.makeText(BluetoothDemoActivity.this, "正在配对", Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothDevice.BOND_NONE:
                        Toast.makeText(BluetoothDemoActivity.this, "配对取消", Toast.LENGTH_SHORT).show();
                        break;
                    case BluetoothDevice.BOND_BONDED:
                        Toast.makeText(BluetoothDemoActivity.this, "配对成功", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }
}
