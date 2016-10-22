package cn.book.keeping.libs.dialog;

import android.app.Dialog;
import android.content.Context;

import cn.book.keeping.R;


/**
 * Created by yh on 16/5/25.
 */
public class BaseDialog extends Dialog {
    public BaseDialog(Context context) {
        super(context, R.style.base_dialog_theme);
    }
}
