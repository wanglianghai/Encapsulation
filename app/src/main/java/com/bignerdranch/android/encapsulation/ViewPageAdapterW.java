package com.bignerdranch.android.encapsulation;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/8/26/026.
 */

public class ViewPageAdapterW<T> extends PagerAdapter {
    private static final String TAG = "ViewPageAdapterW";
    private List<T> mData;
    private ViewPageCreator<ViewPageHolder> mPageCreator;

    public ViewPageAdapterW(List<T> data, ViewPageCreator<ViewPageHolder> creator){
        mData = data;
        mPageCreator = creator;
    }

    @Override
    public int getCount() {
        return mData == null ? 0 : mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ViewPageHolder<T> viewPageHolder = mPageCreator.createHolder();
        View view = viewPageHolder.createView(container);
        viewPageHolder.bind(mData.get(position));
        container.addView(view);
        return view;
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
