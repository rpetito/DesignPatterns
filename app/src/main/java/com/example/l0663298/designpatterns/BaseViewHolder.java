package com.example.l0663298.designpatterns;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by l0663298 on 23/02/2018.
 */

public class BaseViewHolder<T> extends RecyclerView.ViewHolder implements View.OnClickListener {

    private List<T> itemList;
    private RecyclerViewItemClickListener<T> itemClickListener;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    public void setItemClickListener(RecyclerViewItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public void onClick(View v) {
        if(itemClickListener != null && itemList != null) {
            itemClickListener.onItemClick(itemList.get(getAdapterPosition()), getAdapterPosition());
        }
    }


}
