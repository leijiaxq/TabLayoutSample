package com.leijiaxq.tablayoutsample;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTableLayout;

    List<String> mTitleList = new ArrayList<>();
    List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mTableLayout = (TabLayout) findViewById(R.id.tab_layout);

        initView();
    }

    private void initView() {

        //tab栏
        mTitleList.add("首页");
        mTitleList.add("选择车型");
        mTitleList.add("精美图片");
        mTitleList.add("精彩视频");

        // new Fragment实例
        for (String str : mTitleList) {
            mFragmentList.add(newFragmentInstance(str));
        }
        SamplePagerAdapter adapter = new SamplePagerAdapter(getSupportFragmentManager(), mFragmentList, mTitleList);
        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(adapter);
        mTableLayout.setupWithViewPager(mViewPager);

    }


    public SampleFragment newFragmentInstance(String str) {
        SampleFragment fragment = new SampleFragment();
        Bundle args = new Bundle();
        args.putString("params", str);
        fragment.setArguments(args);
        return fragment;
    }
}
