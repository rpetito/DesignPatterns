package com.example.l0663298.designpatterns.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.l0663298.designpatterns.BaseViewHolder;
import com.example.l0663298.designpatterns.R;
import com.example.l0663298.designpatterns.model.Pattern;
import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;

import java.util.List;

/**
 * Created by l0663298 on 23/02/2018.
 */

public class PatternsTypeAdapter extends BaseAdapter<Pattern, PatternsTypeAdapter.ViewHolder> {


    public PatternsTypeAdapter(Context context, List<Pattern> itemList) {
        super(context, itemList);
    }


    @Override
    protected int getLayout() {
        return R.layout.adapter_patterns_type;
    }


    @Override
    protected ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }


    @Override
    protected void onChildBindViewHolder(ViewHolder holder, int position, Pattern item) {
        holder.patternButton.setText(item.getType());
    }


    public class ViewHolder extends BaseViewHolder<Pattern> {

        AppCompatButton patternButton;

        public ViewHolder(View itemView) {
            super(itemView);
            patternButton = (AppCompatButton) itemView.findViewById(R.id.adapter_pattern_type_button);
            patternButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ViewHolder.super.onClick(v);
                }
            });
        }

    }




}
