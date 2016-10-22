package cn.book.keeping.moudles.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.book.keeping.R;
import cn.book.keeping.UserInfoObj;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;
import cn.book.keeping.libs.utils.LogUtils;
import cn.book.keeping.libs.utils.Md5Utils;
import cn.book.keeping.moudles.main.MainActivity;
import cn.book.keeping.moudles.register.RegisterActivity;
import cn.book.keeping.moudles.register.UserInfo;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import rx.Subscriber;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-22
 * Time: 23:12
 */
public class LoginFragment extends BaseFragment {
    private EditText userNameEt;
    private EditText passwordEt;
    private Button loginBtn;

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_login);
        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("登陆界面");
        userNameEt = (EditText) findViewById(R.id.et_user_name);
        passwordEt = (EditText) findViewById(R.id.et_password);
        loginBtn = (Button) findViewById(R.id.btn_login);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = userNameEt.getText().toString().trim();
                String password = passwordEt.getText().toString().trim();
                if (userName.isEmpty() || password.isEmpty()) {
                    Crouton.makeText(mActivity, R.string.username_password_no_empty, Style.ALERT).show();
                    return;
                }
                if (userName.length() != 11) {
                    Crouton.makeText(mActivity, R.string.phone_error, Style.ALERT).show();
                    return;
                }
                if (password.length() >= 6 && password.length() < 17) {
                    login(userName, password);
                } else {
                    Crouton.makeText(mActivity, R.string.password_error, Style.ALERT).show();
                }
            }

        });

        findViewById(R.id.tv_register_page).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mActivity, RegisterActivity.class));
            }
        });
    }

    /**
     * 验证号码是否唯一
     *
     * @param userName
     * @param password
     */
    private void login(final String userName, final String password) {

        BmobQuery query = new BmobQuery("UserInfo");
        query.addWhereEqualTo("phoneNumber", userName);

        query.findObjectsObservable(UserInfo.class)//
                .subscribe(new Subscriber<List<UserInfo>>() {

                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        LogUtils.log("throwable", throwable.toString());
                    }

                    @Override
                    public void onNext(List<UserInfo> userInfos) {
                        if (!userInfos.isEmpty()) {
                            UserInfo itemInfo = userInfos.get(0);
                            if (Md5Utils.GetMD5Code(password).equals(itemInfo.getPassword())) {
                                UserInfoObj userInfoObj = new UserInfoObj();
                                userInfoObj.setUserId(itemInfo.getObjectId());
                                userInfoObj.setUserName(itemInfo.getPhoneNumber());
                                userInfoObj.setLogin(true);
                                userInfoObj.save();
                                startActivity(new Intent(mActivity, MainActivity.class));
                                mActivity.finish();
                            } else {
                                Crouton.makeText(mActivity, R.string.login_failed, Style.ALERT).show();
                            }

                        } else {
                            Crouton.makeText(mActivity, R.string.user_no_exist, Style.ALERT).show();
                        }
                    }
                });
    }


}
