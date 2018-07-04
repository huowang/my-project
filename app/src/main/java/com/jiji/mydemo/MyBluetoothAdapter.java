package com.jiji.mydemo;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 创建日期：2018/6/11.
 * 描述:
 * 作者:hw
 */
public class MyBluetoothAdapter extends BaseAdapter {
    private List<BluetoothDevice> strings;

    public MyBluetoothAdapter(List<BluetoothDevice> strings) {
        this.strings = strings;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv.setText(strings.get(position).getName()+strings.get(position).getAddress());
        return convertView;
    }

    class ViewHolder {
        private TextView tv;

        public ViewHolder(View convertView) {
            tv = (TextView) convertView.findViewById(R.id.tv);
        }
    }
}
