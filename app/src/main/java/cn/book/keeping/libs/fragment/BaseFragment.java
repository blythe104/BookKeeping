package cn.book.keeping.libs.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.book.keeping.R;
import cn.book.keeping.libs.ui.TitleBar;


/**
 * Created by yh on 16/5/4.
 */
public abstract class BaseFragment<T> extends Fragment {
    protected TitleBar titleBar;
    protected View rootView;
    protected Activity mActivity;
    protected LayoutInflater inflater;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mActivity = activity;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        initView(inflater, container, savedInstanceState);
        return rootView;
    }

    public View setContentView(int layoutId) {
        rootView = inflater.inflate(layoutId, null);
        return rootView;
    }

    /**
     * 该方法目的是为了替换onCreateView方法
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     */
    public abstract void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    /**
     * @param viewId
     * @return
     */
    public View findViewById(int viewId) {
        //如果没有给当前的Fragment设置布局文件,
        // 那么将默认设置为fragment_void布局.防止findViewById出现异常
        if (rootView == null) {
            setContentView(R.layout.fragment_void);
        }
        return rootView.findViewById(viewId);
    }

    public String getResourceString(int stringId) {
        return mActivity.getResources().getString(stringId);
    }



}
