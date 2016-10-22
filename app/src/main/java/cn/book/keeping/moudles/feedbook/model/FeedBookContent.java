package cn.book.keeping.moudles.feedbook.model;

import cn.bmob.v3.BmobObject;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-21
 * Time: 14:20
 */
public class FeedBookContent extends BmobObject {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
