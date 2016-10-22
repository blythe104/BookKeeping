package cn.book.keeping.libs.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by  chuangtou on 16/8/14.
 * 国丞创投
 */
public class CustomRadioGroup extends RadioGroup {
    public CustomRadioGroup(Context context) {
        super(context);
        init();
    }

    public CustomRadioGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        RadioButton radioButton = new RadioButton(getContext());
        addView(radioButton);

    }


    public static class Builder {


        public void create() {
            new Builder();
        }

    }
}
