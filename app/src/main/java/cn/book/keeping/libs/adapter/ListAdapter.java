package cn.book.keeping.libs.adapter;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yh on 16/5/25.
 * 张璐琳写的代码
 * 简化BaseAdapter
 */
public abstract class ListAdapter<T> extends BaseAdapter {

    protected List<T> mData;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected int mLayoutRes;
    protected Object mObject;

    protected Map<View, T> convertViewMap = new HashMap<>();
    protected View animateView;
    protected int viewHeight;

    public ListAdapter(Context context, List<T> data, int layoutRes) {
        this.mData = data;
        this.mContext = context;
        this.mLayoutRes = layoutRes;
        this.mInflater = LayoutInflater.from(mContext);
    }

    public void refresh(List<T> data) {
        try {
            this.mData = data;
            notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(List<T> data, Object obj) {
        mObject = obj;
        refresh(data);
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

        if (animateView != null) {
            ViewGroup.LayoutParams lp = animateView.getLayoutParams();
            lp.height = viewHeight;
            animateView.setLayoutParams(lp);
            animateView.requestLayout();
            animateView.setVisibility(View.VISIBLE);
            animateView = null;
        }
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public T getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            if (convertView == null) {
                convertView = mInflater.inflate(mLayoutRes, null);
            }

            setItem(convertView, getItem(position), position);

        } catch (Exception e) {
            e.printStackTrace();
        }
        convertViewMap.put(convertView, getItem(position));
        return convertView;
    }

    public void deleteItem(T t) {
        executeAnim(getDeleteView(t), t);
    }

    protected View getDeleteView(T t) {
        for (Map.Entry<View, T> entry : convertViewMap.entrySet()) {
            if (entry.getValue() == t) {
                return entry.getKey();
            }
        }
        return null;
    }

    protected void executeAnim(final View view, final T t) {
        animateView = view;
        if (view != null) {
            final ViewGroup.LayoutParams lp = view.getLayoutParams();
            viewHeight = view.getHeight();
            ValueAnimator animator = ValueAnimator.ofFloat(viewHeight, -viewHeight / 2);
            animator.setDuration(500);
//			animator.addListener(new Animator.AnimatorListener() {
//				@Override
//				public void onAnimationStart(Animator animation) {
//				}
//
//				@Override
//				public void onAnimationEnd(Animator animation) {
//				}
//
//				@Override
//				public void onAnimationCancel(Animator animation) {
//
//				}
//
//				@Override
//				public void onAnimationRepeat(Animator animation) {
//
//				}
//			});
            animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    int height = ((Float) animation.getAnimatedValue()).intValue();

                    lp.height = height < 0 ? 0 : height;
                    view.setLayoutParams(lp);
                    view.requestLayout();

                    //认为动画已经结束了
                    if (height <= viewHeight / 10) {
                        mData.remove(t);
                        notifyDataSetChanged();
                    }
                }
            });

            animator.start();
        }
    }

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(position, getItem(position));
    }

    protected abstract void setItem(View convertView, T data, int position);
    protected int getItemViewType(int position, T data) {
        return super.getItemViewType(position);
    }
}