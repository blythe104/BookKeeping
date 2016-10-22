package cn.book.keeping.moudles.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.book.keeping.R;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-20
 * Time: 13:41
 */
public class BookKeepingFragment extends BaseFragment {
    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_bookkeeping);
        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("记账页面", View.GONE);
    }
}
