package com.bignerdranch.android.encapsulation;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/8/26/026.
 */

public interface ViewPageHolder<T> {
    View createView(ViewGroup viewGroup);
    void bind(T data);
}
