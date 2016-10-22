package cn.book.keeping.moudles.register;

import cn.bmob.v3.BmobObject;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-22
 * Time: 19:45
 */
public class UserInfo extends BmobObject {

    private String phoneNumber;
    private String password;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
