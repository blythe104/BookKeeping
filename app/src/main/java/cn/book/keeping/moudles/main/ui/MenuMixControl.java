package cn.book.keeping.moudles.main.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.book.keeping.R;
import cn.book.keeping.moudles.main.model.ItemData;


public class MenuMixControl extends LinearLayout implements CustomerInterface {

    private ImageView ivnext;
    private TextView tvmenuname;
    private ImageView ivicon;
    private TextView tvdesc;


    public MenuMixControl(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    public MenuMixControl(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MenuMixControl(Context context) {
        super(context);
        initView(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void initView(Context context) {
        View.inflate(context, R.layout.menu_mix_item, this);
        ivnext = (ImageView) findViewById(R.id.iv_next);
        tvmenuname = (TextView) findViewById(R.id.tv_menu_name);
        ivicon = (ImageView) findViewById(R.id.iv_icon);
        tvdesc = (TextView) findViewById(R.id.tv_desc);
    }

    //设置图标和内容
    @Override
    public void setMenuName(String menuName) {
        tvmenuname.setText(menuName);
    }

    @Override
    public void setMenuNameColor(int textColor) {
        if (textColor != 0) {
            tvmenuname.setTextColor(getResources().getColor(textColor));
        }
    }

    @Override
    public void setIcon(int rid) {
        ivicon.setImageResource(rid);
    }

    @Override
    public void setNext(int rid) {
        ivnext.setImageResource(rid);
    }

    @Override
    public void setDesc(String desc) {
        tvdesc.setText(desc);
    }

    @Override
    public void setRightIconVisible(int visible) {
        ivnext.setVisibility(visible);
    }

    public void setData(ItemData data) {
        setIcon(data.imgId);
        setMenuName(data.content);
        setMenuNameColor(data.textColor);
        setDesc(data.desc == null ? "" : data.desc);
        setRightIconVisible(data.visible);
    }

}
