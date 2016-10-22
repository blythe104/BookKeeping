package cn.book.keeping.moudles.main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import cn.book.keeping.R;
import cn.book.keeping.UserInfoObj;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;
import cn.book.keeping.moudles.feedbook.FeedBookActivity;
import cn.book.keeping.moudles.main.model.ItemData;
import cn.book.keeping.moudles.main.ui.CustomerMenuView;
import cn.book.keeping.moudles.register.RegisterActivity;
import cn.book.keeping.moudles.setting.SettingsActivity;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-20
 * Time: 13:41
 */
public class MineFragment extends BaseFragment {
    private SwipeRefreshLayout swipeRefreshLayout;
    private CustomerMenuView mCustomMenu;
    private ImageView userStatusIv;

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_mine);
        TitleBar titleBar = (TitleBar) findViewById(R.id.title_bar);

        titleBar.setTitle("我的界面", View.GONE);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_widget);
        userStatusIv = (ImageView) findViewById(R.id.iv_user_status);

        mCustomMenu = (CustomerMenuView) findViewById(R.id.custom_menu);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Crouton.makeText(mActivity, "update complete", Style.CONFIRM).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        UserInfoObj userInfoObj = new UserInfoObj();
        userStatusIv.setBackgroundResource(userInfoObj.isLogin ? R.mipmap.ic_user_head : R.mipmap.ic_user_unlogin);
        //不需要刷新数据时,使用如下方法
        mCustomMenu.addDivider()//
                .addItem(R.mipmap.ic_settings, "设置中心", "settings")//
                .addDivider()//
                .addItem(R.mipmap.ic_feedbackic, "意见反馈", "feedback")//
                .addDivider()//
                .addItem(R.mipmap.ic_evaluate, "给个好评", "high_praise")//
                .addDivider()//
                .addItem(R.mipmap.ic_share, "分享", "share")// .addItem(R.mipmap.img_a8f, "漂流瓶", "")//
                .build();//

        mCustomMenu.setItemClickListener(new CustomerMenuView.OnItemListener() {
            @Override
            public void itemClick(View v) {
                switch (((ItemData) v.getTag()).flag) {
                    case "settings":
                        startActivity(new Intent(mActivity, SettingsActivity.class));
                        break;
                    case "feedback":
                        startActivity(new Intent(mActivity, FeedBookActivity.class));
                        break;
                    case "high_praise":
                        Crouton.makeText(mActivity, "high_praise", Style.ALERT).show();
                        break;
                    case "share":
                        Crouton.makeText(mActivity, "share", Style.ALERT).show();
                        break;
                    default:

                        break;
                }
            }
        });
        findViewById(R.id.ll_user).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, RegisterActivity.class));
            }
        });
    }

}

