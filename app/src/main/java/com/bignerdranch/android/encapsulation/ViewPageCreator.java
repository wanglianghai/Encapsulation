package com.bignerdranch.android.encapsulation;

/**
 * Created by Administrator on 2017/8/26/026.
 */

public interface ViewPageCreator<VH extends ViewPageHolder> {
    VH createHolder();
}
