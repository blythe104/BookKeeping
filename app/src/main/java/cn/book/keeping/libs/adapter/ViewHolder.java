package cn.book.keeping.libs.adapter;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by  chuangtou on 16/7/1.
 * 国丞创投
 */


public class ViewHolder {
    public ViewHolder() {
    }
    public static  <T extends View> View get(View view, int id) {
        SparseArray viewHolder = (SparseArray)view.getTag();
        if(viewHolder == null) {
            viewHolder = new SparseArray();
            view.setTag(viewHolder);
        }

        View childView = (View)viewHolder.get(id);
        if(childView == null) {
            childView = view.findViewById(id);
            viewHolder.put(id, childView);
        }

        return childView;
    }
}
