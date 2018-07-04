//package com.jiji.mydemo;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import java.util.List;
//
///**
// * 创建日期：2018/4/26.
// * 描述:
// * 作者:hw
// */
//public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {
//    private List<String> stringList;
//    private ItemOnclickListener itemOnclickListener;
//
//    public RecycleViewAdapter(List<String> stringList) {
//        this.stringList = stringList;
//    }
//
//    public ItemOnclickListener getItemOnclickListener() {
//        return itemOnclickListener;
//    }
//
//    public void setItemOnclickListener(ItemOnclickListener itemOnclickListener) {
//        this.itemOnclickListener = itemOnclickListener;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
//        return new MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position, List<Object> payloads) {
//        super.onBindViewHolder(holder, position, payloads);
//        if (payloads==null){
//            onBindViewHolder(holder,position);
//        }else {
//            holder.tv.setText(stringList.get(position));
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, final int position) {
//        holder.tv.setText(stringList.get(position));
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (itemOnclickListener != null) {
//                    itemOnclickListener.ItemClick(position);
//                }
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return stringList.size();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//        private ImageView iv;
//        private TextView tv;
//
//        public MyViewHolder(View itemView) {
//            super(itemView);
//            iv = (ImageView) itemView.findViewById(R.id.iv);
//            tv = (TextView) itemView.findViewById(R.id.tv);
//        }
//    }
//
//    public interface ItemOnclickListener {
//        void ItemClick(int position);
//    }
//
//}
