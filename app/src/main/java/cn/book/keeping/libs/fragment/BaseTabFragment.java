package cn.book.keeping.libs.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.book.keeping.R;
import cn.book.keeping.libs.activity.BaseActivity;
import cn.book.keeping.libs.adapter.FragmentAdapter;
import cn.book.keeping.libs.ui.CustomViewPager;


/**
 * Created by yh on 16/5/4.
 */
public abstract class BaseTabFragment extends BaseFragment {
    protected CustomViewPager viewPager;
    protected TabLayout tabLayout;

    protected FragmentAdapter adapter;
    protected List<BaseFragment> fragmentList = new ArrayList<>();

    protected List<String> tabList = new ArrayList<>();

    /**
     * false时,顶部tab;
     * true时,底部tab页
     */
    protected boolean TAB_BOTTOM = false;

    private int layoutId = R.layout.fragment_top_tab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(TAB_BOTTOM ? layoutId : R.layout.fragment_top_tab, null);
        init();
        return rootView;
    }

    protected void init() {
        tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout);
        viewPager = (CustomViewPager) rootView.findViewById(R.id.view_pager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        initFragment();
        initTitle();
        adapter = new FragmentAdapter(((BaseActivity) mActivity).getSupportFragmentManager(), fragmentList, tabList);
        viewPager.setAdapter(adapter);
        //tabLayout和ViewPager产生关联
        tabLayout.setupWithViewPager(viewPager);
        initTabLayoutEvent();
    }


    /**
     * 添加要显示的Fragment
     */
    public abstract void initFragment();

    /**
     * 向tabList集合中添加数据,
     */
    public abstract void initTitle();


    public void initTabLayoutEvent() {

    }

    protected void setTagAndLayout(boolean isBottom, int layoutId) {
        this.TAB_BOTTOM = isBottom;
        this.layoutId = layoutId;
    }

}
