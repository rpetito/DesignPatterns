package com.example.l0663298.designpatterns.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.l0663298.designpatterns.R;
import com.example.l0663298.designpatterns.model.PatternItem;
import com.example.l0663298.designpatterns.util.ColorPicker;
import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class PatternAdapter extends RecyclerView.Adapter<PatternAdapter.ViewHolder> {

    private Context context;
    private List<PatternItem> patternItems;
    private RecyclerViewItemClickListener<PatternItem> itemClickListener;


    public PatternAdapter(Context context, List<PatternItem> patternItems) {
        this.context = context;
        this.patternItems = patternItems;
    }

    public void setItemClickListener(RecyclerViewItemClickListener<PatternItem> itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_patterns_items, parent, false);
        ViewHolder holder = new ViewHolder(v);
        v.setBackgroundColor(ColorPicker.random());
        v.setOnClickListener(holder);
        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(patternItems.get(position).getName());
        Picasso.with(context).load(patternItems.get(position).getImageURL()).into(holder.image);
    }


    @Override
    public int getItemCount() {
        return patternItems.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private AppCompatTextView name;
        private AppCompatImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (AppCompatTextView) itemView.findViewById(R.id.adapter_patterns_items_name);
            image = (AppCompatImageView) itemView.findViewById(R.id.adapter_patterns_items_image);

        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null) {
                itemClickListener.onItemClick(patternItems.get(getAdapterPosition()), getAdapterPosition());
            }
        }

    }


}
