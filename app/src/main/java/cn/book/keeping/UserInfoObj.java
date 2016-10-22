package cn.book.keeping;

import cn.book.keeping.libs.utils.ShareUtils;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-22
 * Time: 15:18
 */
public class UserInfoObj {
    public String userName;
    public String passWord;
    public String userId;
    public boolean isLogin;

    public UserInfoObj() {
        initData();
    }


    private void initData() {
        setLogin(ShareUtils.getBoolean("isLogin", false));
        setUserName(ShareUtils.getString("userName", ""));
        setPassWord(ShareUtils.getString("passWord", ""));
        setUserId(ShareUtils.getString("userId", ""));
    }

    public void save() {
        ShareUtils.saveBoolean("isLogin", isLogin());
        ShareUtils.saveString("userName", getUserName());
        ShareUtils.saveString("passWord", getPassWord());
        ShareUtils.saveString("userId", getUserId());
    }

    /**
     * 清除用户数据
     */
    public void clear() {
        ShareUtils.saveBoolean("isLogin", false);
        ShareUtils.saveString("userName", "");
        ShareUtils.saveString("passWord", "");
        ShareUtils.saveString("userId", "");
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
