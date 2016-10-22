package cn.book.keeping.libs.fragment;

import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cn.book.keeping.R;


/**
 * Created by yh on 16/5/25.
 */
public abstract class BaseBottomTabFragment extends BaseTabFragment {
    protected List<Integer> tabSelectedIcons = new ArrayList<>();
    protected List<Integer> tabUnSelectedIcons = new ArrayList<>();
    private TabLayout.Tab oneTab;
    private TabLayout.Tab twoTab;
    private TabLayout.Tab threeTab;
    private TabLayout.Tab fourTab;

    public BaseBottomTabFragment() {
        this.setTagAndLayout(true, R.layout.fragment_bottom_tab);
    }

    @Override
    public void initTabLayoutEvent() {
        super.initTabLayoutEvent();
        this.viewPager.setScroll(false);
        initTabIcon();
        oneTab = tabLayout.getTabAt(0);
        twoTab = tabLayout.getTabAt(1);
        threeTab = tabLayout.getTabAt(2);
        fourTab = tabLayout.getTabAt(3);
        oneTab.setIcon(tabSelectedIcons.get(0));
        twoTab.setIcon(tabUnSelectedIcons.get(1));
        threeTab.setIcon(tabUnSelectedIcons.get(2));
        fourTab.setIcon(tabUnSelectedIcons.get(3));
        initEvent();
    }

    private void initEvent() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    tabLayout.getTabAt(0).setIcon(mActivity.getResources().getDrawable(tabSelectedIcons.get(0)));
                    viewPager.setCurrentItem(0);
                } else if (tab == tabLayout.getTabAt(1)) {
                    tabLayout.getTabAt(1).setIcon(mActivity.getResources().getDrawable(tabSelectedIcons.get(1)));
                    viewPager.setCurrentItem(1);
                } else if (tab == tabLayout.getTabAt(2)) {
                    tabLayout.getTabAt(2).setIcon(mActivity.getResources().getDrawable(tabSelectedIcons.get(2)));
                    viewPager.setCurrentItem(2);
                } else if (tab == tabLayout.getTabAt(3)) {
                    tabLayout.getTabAt(3).setIcon(mActivity.getResources().getDrawable(tabSelectedIcons.get(3)));
                    viewPager.setCurrentItem(3);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab == tabLayout.getTabAt(0)) {
                    tabLayout.getTabAt(0).setIcon(mActivity.getResources().getDrawable(tabUnSelectedIcons.get(0)));
                } else if (tab == tabLayout.getTabAt(1)) {
                    tabLayout.getTabAt(1).setIcon(mActivity.getResources().getDrawable(tabUnSelectedIcons.get(1)));
                } else if (tab == tabLayout.getTabAt(2)) {
                    tabLayout.getTabAt(2).setIcon(mActivity.getResources().getDrawable(tabUnSelectedIcons.get(2)));
                } else if (tab == tabLayout.getTabAt(3)) {
                    tabLayout.getTabAt(3).setIcon(mActivity.getResources().getDrawable(tabUnSelectedIcons.get(3)));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 在该方法中,添加底部Tab图标
     */
    public abstract void initTabIcon();
}
