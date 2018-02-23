package com.example.l0663298.designpatterns.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.l0663298.designpatterns.BaseViewHolder;
import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by l0663298 on 23/02/2018.
 */

public abstract class BaseAdapter<T, VH extends BaseViewHolder<T>> extends RecyclerView.Adapter<VH> {


    protected abstract int getLayout();
    protected abstract VH getViewHolder(View v);
    protected abstract void onChildBindViewHolder(VH holder, int position, T item);


    private Context context;
    private List<T> itemList;

    private RecyclerViewItemClickListener<T> itemClickListener;


    public BaseAdapter(Context context, List<T> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    public void setItemClickListener(RecyclerViewItemClickListener<T> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(getLayout(), parent, false);
        VH holder = getViewHolder(v);
        v.setOnClickListener(holder);
        holder.setItemClickListener(itemClickListener);
        holder.setItemList(itemList);
        return holder;
    }


    @Override
    public void onBindViewHolder(VH holder, int position) {
        onChildBindViewHolder(holder, position, itemList.get(position));
    }


    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
