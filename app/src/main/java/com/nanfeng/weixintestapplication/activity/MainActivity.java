package com.nanfeng.weixintestapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.nanfeng.weixintestapplication.helper.AssetsHelper;
import com.nanfeng.weixintestapplication.bean.GameBean;
import com.nanfeng.weixintestapplication.GameListAdapter;
import com.nanfeng.weixintestapplication.helper.HtmlAnalysis;
import com.nanfeng.weixintestapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private GameListAdapter mGameListAdapter;
    private List<GameBean> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mList = HtmlAnalysis.analysisMenuList(AssetsHelper.getFromAssetsText(this, "game/index3.html"));
        mGameListAdapter = new GameListAdapter(this, mList);
        mListView.setAdapter(mGameListAdapter);
        mListView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this, HtmlGameActivity.class);
        intent.putExtra(HtmlGameActivity.GAME_PATH_KEY, mGameListAdapter.getItem(i).filePath);
        startActivity(intent);
    }
}
