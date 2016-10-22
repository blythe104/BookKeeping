package cn.book.keeping.libs.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

import cn.book.keeping.R;
import cn.book.keeping.libs.adapter.FragmentAdapter;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.CustomViewPager;
import cn.book.keeping.libs.utils.LogUtils;


/**
 * Created by  chuangtou on 16/8/13.
 * 国丞创投
 */
public abstract  class ViewPagerActivity  extends BaseActivity{
    protected CustomViewPager viewPager;
    protected RadioGroup radioGroup;
    protected RadioButton radioButtonOne;
    protected RadioButton radioButtonTwo;
    protected RadioButton radioButtonThree;
    protected ImageView viewBar;

    protected int layoutWidth;
    protected int currentX = 0;
    protected int currIndex = 0;
    private int pageCount = 0;
    protected int dx = 0;
    protected long duration = 200;

    protected List<BaseFragment> fragmentList;
    protected int layoutId = R.layout.fragment_base_bottom_tab;


    @Override
    protected void initViews(Bundle savedInstanceState) {
        this.setContentView(layoutId);
        viewPager = (CustomViewPager) findViewById(R.id.view_pager);
        viewPager.setOffscreenPageLimit(3);
        radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        ((RadioButton) radioGroup.getChildAt(0)).setChecked(true);
        radioButtonOne = (RadioButton) findViewById(R.id.radio_one);
        radioButtonTwo = (RadioButton) findViewById(R.id.radio_two);
        radioButtonThree = (RadioButton) findViewById(R.id.radio_three);
        this.viewBar = (ImageView) findViewById(R.id.view_bar);
        fragmentList = new ArrayList<>();
        this.layoutWidth = this.getWindow().getWindowManager().getDefaultDisplay().getWidth();

        initFragment();
        initViewPager();
        setListener();
    }

    private void setListener() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                LogUtils.log("positionOffset", "positionOffset = " + positionOffset + "   positionOffsetPixels = " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                AnimationSet _AnimationSet = new AnimationSet(true);
                TranslateAnimation _TranslateAnimation = new TranslateAnimation((float) currentX, (float) (layoutWidth * position / pageCount + dx), 0.0F, 0.0F);
                _AnimationSet.addAnimation(_TranslateAnimation);
                _AnimationSet.setFillBefore(true);
                _AnimationSet.setFillAfter(true);
                if (Math.abs(currentX - layoutWidth * position / pageCount) > layoutWidth / pageCount) {
                    _AnimationSet.setDuration(0L);
                } else {
                    _AnimationSet.setDuration(duration);
                }
                viewBar.startAnimation(_AnimationSet);

                currentX = layoutWidth * position / pageCount + dx;
                switch (position) {
                    case 0:
                        radioButtonOne.setChecked(true);
                        break;
                    case 1:
                        radioButtonTwo.setChecked(true);
                        break;
                    case 2:
                        radioButtonThree.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_one:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.radio_two:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.radio_three:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.radio_four:
                        viewPager.setCurrentItem(3);
                        break;
                }
            }
        });
    }

    public abstract void initFragment();

    private void initViewPager() {
        List<String> tabList = new ArrayList<>();
        for (int index = 0; index < fragmentList.size(); index++) {
            tabList.add("");
        }
        pageCount = tabList.size();
        FragmentManager fragmentManager =this.getSupportFragmentManager();
        FragmentPagerAdapter pagerAdapter = new FragmentAdapter(fragmentManager, fragmentList, tabList);
        viewPager.setAdapter(pagerAdapter);
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }
}
