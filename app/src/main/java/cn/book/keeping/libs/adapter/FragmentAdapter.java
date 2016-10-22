package cn.book.keeping.libs.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.book.keeping.libs.fragment.BaseFragment;


/**
 * Created by yh on 16/5/4.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    private final List<BaseFragment> fragmentList;
    private final List<String> tabList;

    private final String TAG = FragmentAdapter.this.getClass().getSimpleName();

    public FragmentAdapter(FragmentManager fm, List<BaseFragment> fragmentList, List<String> tabList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.tabList = tabList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return tabList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
