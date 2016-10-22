package cn.book.keeping.moudles.setting.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.book.keeping.BuildConfig;
import cn.book.keeping.R;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;
import cn.book.keeping.libs.utils.LogUtils;
import cn.book.keeping.moudles.feedbook.FeedBookActivity;
import cn.book.keeping.moudles.main.model.ItemData;
import cn.book.keeping.moudles.main.ui.CustomerMenuView;
import cn.book.keeping.moudles.setting.model.Version;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-20
 * Time: 17:08
 */
public class SettingFragment extends BaseFragment {
    private CustomerMenuView customMenu;

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_settings);
        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("设置中心");
        customMenu = (CustomerMenuView) findViewById(R.id.custom_menu);
        customMenu.addDivider()//
                .addItem(R.mipmap.ic_safe, "密码锁", "safe", View.GONE)//
                .addDivider()//
                .addItem(R.mipmap.ic_notice, "记账提醒", "remind", View.GONE)//
                .addDivider()//
                .addItem(R.mipmap.ic_backupic, "云备份", "backUpsData", View.GONE)//
                .addDivider()//
                .addItem(R.mipmap.ic_version, "版本检查", "version", View.GONE)//
                .addDivider()//
                .addItem(R.mipmap.ic_about, "关于我", "aboutMe", View.GONE)//
                .addDivider()//
                .addItem(R.mipmap.ic_delete, "永久清除个人数据", R.color.red, "deleteData", View.GONE)//
                .build();
        customMenu.setItemClickListener(new CustomerMenuView.OnItemListener() {
            @Override
            public void itemClick(View v) {
                switch (((ItemData) v.getTag()).flag) {
                    case "safe":
                        Crouton.makeText(mActivity, "设置安全相关信息", Style.CONFIRM).show();
                        break;
                    case "remind":
                        Crouton.makeText(mActivity, "开启记账提醒", Style.CONFIRM).show();
                        break;

                    case "version":
                        checkVersion();
                        break;
                    case "feedback":
                        startActivity(new Intent(mActivity, FeedBookActivity.class));
                        break;
                    case "backUpsData":
                        Crouton.makeText(mActivity, "备份数据", Style.CONFIRM).show();
                        break;

                    case "aboutMe":
                        Crouton.makeText(mActivity, "一枚单身程序员,哈哈哈", Style.CONFIRM).show();
                        break;
                    case "deleteData":
                        deleateData();
                        break;
                    default:

                        break;
                }
            }
        });
    }

    /**
     * 版本检查
     */
    private void checkVersion() {
        BmobQuery query = new BmobQuery("Version");
        query.addWhereEqualTo("IsNewVersion", true);
        query.findObjectsObservable(Version.class)//
                .subscribe(new Subscriber<List<Version>>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LogUtils.log("throwable", throwable.toString());
                    }

                    @Override
                    public void onNext(List<Version> versions) {
                        if (!versions.isEmpty()) {
                            Number versionCode = versions.get(0).versionCode;
                            if (versionCode.intValue() > BuildConfig.VERSION_CODE) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
                                builder.setTitle("更新提示");
                                builder.setMessage(versions.get(0).updateMsg);
                                builder.setNegativeButton("取消", null);
                                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Crouton.makeText(mActivity, "用户点击更新了", Style.ALERT).show();
                                    }
                                });
                                builder.show();
                            }
                        } else {
                            Crouton.makeText(mActivity, "没有最新版本", Style.ALERT).show();
                        }
                    }
                });
    }

    /**
     * 删除个人所有消费记录
     */
    private void deleateData() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setTitle("删除");
        builder.setMessage("该操作将删除个人所有的消费记录,请谨慎操作哦!");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("确定删除", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
