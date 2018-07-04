package com.jiji.mydemo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 创建日期：2018/6/6.
 * 描述:测试Activity
 * 作者:hw
 */
public class TestActivity extends Activity {
    private TextView tvContent;
    private ImageView iv;
    private Button btn;
    private int count = 0;
    private Button btnBroadcast;
    private Button btnGetContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tvContent = (TextView) findViewById(R.id.tv_content);
        iv = (ImageView) findViewById(R.id.iv);
        btn = (Button) findViewById(R.id.btn);
        btnBroadcast = (Button) findViewById(R.id.btn_broadcast);
        btnGetContact = (Button) findViewById(R.id.btn_get_contact);

        tvContent.setText("Hello创创");
        tvContent.setTextSize(20);

        iv.setVisibility(View.VISIBLE);
        iv.setImageResource(R.mipmap.test);
        btn.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBlue));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                tvContent.setText("开始计数：" + count);
            }
        });

        btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,BroadcastDemoActivity.class));
            }
        });


        btnGetContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queryContactPhoneNumber();
            }
        });

    }

    /**
     * 查询联系人姓名和手机号
     */
    private void queryContactPhoneNumber() {
        String[] cols = {ContactsContract.PhoneLookup.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                cols, null, null, null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            // 取得联系人名字
            int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME);
            int numberFieldColumnIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String name = cursor.getString(nameFieldColumnIndex);
            String number = cursor.getString(numberFieldColumnIndex);
            Toast.makeText(this, name + " " + number, Toast.LENGTH_SHORT).show();
        }
    }
}
