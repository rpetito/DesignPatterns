package com.example.l0663298.designpatterns.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.l0663298.designpatterns.R;
import com.example.l0663298.designpatterns.adapter.PatternAdapter;
import com.example.l0663298.designpatterns.model.Pattern;
import com.example.l0663298.designpatterns.model.PatternItem;
import com.example.l0663298.designpatterns.util.RecyclerViewItemClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by l0663298 on 20/02/2018.
 */

public class PatternListActivity extends BaseActivity {

    @BindView(R.id.activity_pattern_list_toolbar)
    Toolbar toolbar;
    @BindView(R.id.activity_pattern_list_recyclerView)
    RecyclerView recyclerView;

    Pattern pattern;

    @Override
    protected int getLayout() {
        return R.layout.activity_patterns_list;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        pattern = getIntent().getExtras().getParcelable("pattern");

        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        PatternAdapter adapter = new PatternAdapter(this, pattern.getPatternItemList());
        adapter.setItemClickListener(new RecyclerViewItemClickListener<PatternItem>() {
            @Override
            public void onItemClick(PatternItem item, int position) {
                Toast.makeText(PatternListActivity.this, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

    }




}
