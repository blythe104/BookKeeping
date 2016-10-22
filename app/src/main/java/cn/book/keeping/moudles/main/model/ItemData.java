package cn.book.keeping.moudles.main.model;

import android.graphics.Bitmap;
import android.view.View;

/**
 * Created by xin on 2016/8/11.
 */
public class ItemData {
    public ItemData() {
    }

    public ItemData(int imgId, String content, String flag) {
        this.imgId = imgId;
        this.flag = flag;
        this.content = content;
    }

    public ItemData(int imgId, String content, String flag, int visible) {
        this.imgId = imgId;
        this.flag = flag;
        this.content = content;
        this.visible = visible;
    }

    public ItemData(Bitmap bitmap, String content, String flag) {
        this.bitmap = bitmap;
        this.flag = flag;
        this.content = content;
    }

    public ItemData(int imgId, String content, String flag, String desc) {
        this.imgId = imgId;
        this.flag = flag;
        this.content = content;
        this.desc = desc;
    }

    public ItemData(int imgId, String content, int textColor, String flag) {
        this.imgId = imgId;
        this.flag = flag;
        this.content = content;
        this.textColor = textColor;
    }

    public ItemData(int imgId, String content, int textColor, String flag, int visible) {
        this.imgId = imgId;
        this.flag = flag;
        this.content = content;
        this.textColor = textColor;
        this.visible = visible;
    }

    public int imgId;
    public Bitmap bitmap;
    public String flag;
    public String content;
    public String desc;
    public int textColor;
    public int visible;
}
