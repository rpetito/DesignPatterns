package com.example.l0663298.designpatterns.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.l0663298.designpatterns.R;
import com.example.l0663298.designpatterns.adapter.PatternsTypeAdapter;
import com.example.l0663298.designpatterns.model.Pattern;
import com.example.l0663298.designpatterns.model.PatternData;
import com.example.l0663298.designpatterns.util.FileReader;
import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity implements RecyclerViewItemClickListener<Pattern> {

    @BindView(R.id.activity_main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_main_recyclerView)
    RecyclerView recyclerView;


    @Override
    protected int getLayout() {
        return R.layout.acitivity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        PatternData pattern = (PatternData) FileReader.readRawFile(this, R.raw.patterns, PatternData.class);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PatternsTypeAdapter adapter = new PatternsTypeAdapter(this, pattern.getPatternList());
        adapter.setItemClickListener(this);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public void onItemClick(Pattern item, int position) {
        Intent intent = new Intent(this, PatternListActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("pattern", item);
        intent.putExtras(bundle);
        startActivity(intent);
    }


}
