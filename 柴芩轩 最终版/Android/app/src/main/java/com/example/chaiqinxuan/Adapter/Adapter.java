package com.example.chaiqinxuan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.chaiqinxuan.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
    @NonNull
    private Context mContext;
    private OnItemClickListener mListener;
    private List<String> mlist;
    private String[] id;
    private String[] medicineName;
    private String[] totalNumber;
    private String[] value;
    private String[] min;


    public Adapter(Context context , String[] id, String[] medicineName,String[] totalNumber,String[] value,String[] min, OnItemClickListener listener ){
        this.mContext = context;
        this.mListener = listener;
        this.id = id;
        this.medicineName = medicineName;
        this.totalNumber = totalNumber;
        this.value = value;
        this.min = min;
    }
    //Important part 1
    @Override
    public  RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //viewType可以通过这个，展示不同的item
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
        //这里需要传入每个item长什么样的布局，需要去layout中去画我们的布局
    }

    @Override
    //通过getItemViewType的返回值来选择具体的item显示
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ((LinearViewHolder)holder).mTVid.setText(id[position]);
        ((LinearViewHolder)holder).mTVMedicineName.setText(medicineName[position]);
        ((LinearViewHolder)holder).mTVTotalNumber.setText(totalNumber[position]);
        ((LinearViewHolder)holder).mTVValue.setText(value[position]);
        ((LinearViewHolder)holder).mTVMin.setText(min[position]);

        //将点击事件放到外面
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext,"click..."+position,Toast.LENGTH_SHORT).show();
                mListener.onClick(position);
            }
        });
    }

    //去控制viewType的方法，根据位置的奇偶性来区分
    @Override
    public int getItemViewType(int position) {
        if(position % 2 == 0){
            return 0;//偶数
        }else{
            return 1;
        }
    }

    //设置item个数
    @Override
    public int getItemCount() {
    return id.length;
    }


    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView mTVid;
        private TextView mTVMedicineName;
        private TextView mTVTotalNumber;
        private TextView mTVValue;
        private TextView mTVMin;


        public LinearViewHolder(View itemView){
            super(itemView);
            mTVid = itemView.findViewById(R.id.item_id);
            mTVMedicineName = itemView.findViewById(R.id.item_MedicineName);
            mTVTotalNumber = itemView.findViewById(R.id.item_TotalNumber);
            mTVValue = itemView.findViewById(R.id.item_Value);
            mTVMin= itemView.findViewById(R.id.item_Min);


        }
    }


    //接口
    public interface  OnItemClickListener{
        void onClick(int pos);
    }
}

