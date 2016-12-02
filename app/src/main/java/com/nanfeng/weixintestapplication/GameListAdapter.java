package com.nanfeng.weixintestapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanfeng.weixintestapplication.bean.GameBean;
import com.nanfeng.weixintestapplication.helper.AssetsHelper;

import java.util.List;

/**
 * Created by yangyoutao on 2016/12/1.
 */

public class GameListAdapter extends BaseAdapter {
    private List<GameBean> mlist;
    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public GameListAdapter(Context context, List<GameBean> list) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mlist = list;
        this.mContext = context;
    }

    public void setData(List<GameBean> list) {
        this.mlist = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.mlist.size();
    }

    @Override
    public GameBean getItem(int i) {
        return this.mlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (null == view) {
            viewHolder = new ViewHolder();
            view = mLayoutInflater.inflate(R.layout.gamelist_itemlayout, null);
            viewHolder.gameIcon = (ImageView) view.findViewById(R.id.icon);
            viewHolder.gameName = (TextView) view.findViewById(R.id.name);
            viewHolder.gameStartBtn = (TextView) view.findViewById(R.id.start);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        GameBean mGameBean = getItem(i);
        if (null != mGameBean) {
            viewHolder.gameIcon.setImageBitmap(AssetsHelper.getFromAssetsBitmap((Activity) mContext, mGameBean.iconpath));
            viewHolder.gameName.setText(mGameBean.name);
        }
        return view;
    }

    private static class ViewHolder {
        public ImageView gameIcon;
        public TextView gameName;
        public TextView gameStartBtn;

    }
}
