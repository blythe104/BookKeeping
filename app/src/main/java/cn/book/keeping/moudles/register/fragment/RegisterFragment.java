package cn.book.keeping.moudles.register.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.book.keeping.R;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;
import cn.book.keeping.libs.utils.Md5Utils;
import cn.book.keeping.moudles.register.UserInfo;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-22
 * Time: 16:03
 */
public class RegisterFragment extends BaseFragment {
    private EditText userNameEt;
    private EditText passwordEt;
    private Button registerBtn;

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_register);
        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("注册界面");

        userNameEt = (EditText) findViewById(R.id.et_user_name);
        passwordEt = (EditText) findViewById(R.id.et_password);
        registerBtn = (Button) findViewById(R.id.btn_login);


        registerBtn.setOnClickListener(new View.OnClickListener() {
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
                    checkPhone(userName, password);
                } else {
                    Crouton.makeText(mActivity, R.string.password_error, Style.ALERT).show();
                }
            }


        });
    }

    /**
     * 验证号码是否唯一
     *
     * @param userName
     * @param password
     */
    private void checkPhone(final String userName, final String password) {

        BmobQuery query = new BmobQuery("UserInfo");
        query.addWhereEqualTo("phoneNumber", userName);
        query.findObjectsByTable(new QueryListener<JSONArray>() {
            @Override
            public void done(JSONArray jsonArray, BmobException e) {
                if (jsonArray.length() != 0) {
                    Crouton.makeText(mActivity, R.string.user_exist, Style.ALERT).show();
                } else {
                    registerUser(userName, password);
                }
            }
        });
    }

    private void registerUser(final String userName, final String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPhoneNumber(userName);
        userInfo.setPassword(Md5Utils.GetMD5Code(password));
        userInfo.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e != null) {
                    Crouton.makeText(mActivity, R.string.open_error, Style.ALERT).show();
                } else {
                    Crouton.makeText(mActivity, R.string.register_success, Style.CONFIRM).show();
                    mActivity.finish();
                }

            }
        });
    }
}
