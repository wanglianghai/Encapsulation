package com.bignerdranch.android.encapsulation;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int[] IMG_RES = {R.mipmap.image1, R.mipmap.image2, R.mipmap.image3, R.mipmap.image4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPageAdapterW<EntityImage> viewPageAdapterW = new ViewPageAdapterW<>(getData(), new ViewPageCreator<ViewPageHolder>() {
            @Override
            public MyHolder createHolder() {
                return new MyHolder();
            }
        });
        viewPager.setAdapter(viewPageAdapterW);
    }

    private List<EntityImage> getData() {
        List<EntityImage> images = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            EntityImage entity = new EntityImage();
            entity.imageRes = IMG_RES[i];
            images.add(entity);
        }
        return images;
    }

    class MyHolder implements ViewPageHolder<EntityImage> {

        private ImageView mImageView;

        @Override
        public View createView(ViewGroup viewGroup) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_page_item, viewGroup, false);
            mImageView = (ImageView) v.findViewById(R.id.image_view);
            return v;
        }

        @Override
        public void bind(EntityImage data) {
            mImageView.setImageResource(data.imageRes);
        }
    }
}
