package cn.book.keeping.libs.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import cn.book.keeping.R;
import cn.book.keeping.libs.fragment.BaseFragment;


public abstract class BaseActivity extends AppCompatActivity {
    protected FragmentTransaction fragmentTransaction;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root_view);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        initVariables();
        initViews(savedInstanceState);
        loadData();
    }

    protected void setFragment(BaseFragment baseFragment) {
        fragmentTransaction.replace(R.id.fl_root_view, baseFragment).commit();
    }

    /**
     * 初始化从Activity调转时传递的参数
     */
    protected void initVariables() {
    }

    /**
     * 该方法用于设置布局,实例化控件,设置监听
     *
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    protected void loadData() {
    }
}
