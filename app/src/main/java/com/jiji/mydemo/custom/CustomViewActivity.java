package com.jiji.mydemo.custom;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import com.jiji.mydemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2018/6/25.
 * 描述:
 * 作者:hw
 */
public class CustomViewActivity extends Activity {
    private PieView pieView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);

        pieView = (PieView) findViewById(R.id.pieView);

        List<PieDataBean> pieDataBeans = new ArrayList<>();
        PieDataBean pieDataBean1= new PieDataBean();
        pieDataBean1.setColor(Color.GRAY);
        pieDataBean1.setValue(25);


        PieDataBean pieDataBean2= new PieDataBean();
        pieDataBean2.setColor(Color.BLUE);
        pieDataBean2.setValue(25);


        PieDataBean pieDataBean3= new PieDataBean();
        pieDataBean3.setColor(Color.RED);
        pieDataBean3.setValue(25);



        PieDataBean pieDataBean4= new PieDataBean();
        pieDataBean4.setColor(Color.YELLOW);
        pieDataBean4.setValue(25);

        pieDataBeans.add(pieDataBean1);
        pieDataBeans.add(pieDataBean2);
        pieDataBeans.add(pieDataBean3);
        pieDataBeans.add(pieDataBean4);

        pieView.setData(pieDataBeans);

    }

}
