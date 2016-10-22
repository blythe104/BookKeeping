package cn.book.keeping.moudles.feedbook.fragment;

import android.os.Bundle;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.book.keeping.R;
import cn.book.keeping.libs.fragment.BaseFragment;
import cn.book.keeping.libs.ui.TitleBar;
import cn.book.keeping.libs.utils.LogUtils;
import cn.book.keeping.moudles.feedbook.model.FeedBookContent;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * User: YangHai (1454025171@qq.com)
 * Date: 2016-10-21
 * Time: 09:16
 */
public class FeedBookFragment extends BaseFragment {
    private Button feedBookBtn;
    private EditText feedBookContentEt;
    private ContentLoadingProgressBar clpb;

    @Override
    public void initView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setContentView(R.layout.fragment_feedbook);
        titleBar = (TitleBar) findViewById(R.id.title_bar);
        titleBar.setTitle("意见反馈");
        clpb = new ContentLoadingProgressBar(mActivity);
        feedBookContentEt = (EditText) findViewById(R.id.et_feed_book_content);
        feedBookBtn = (Button) findViewById(R.id.btn_submit_feedbook);

        feedBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clpb.show();
                String contentStr = feedBookContentEt.getText().toString();
                if (!contentStr.isEmpty()) {
                    FeedBookContent content = new FeedBookContent();
                    content.setContent(contentStr);
                    content.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            mActivity.finish();
                        }
                    });
                } else {
                    Crouton.makeText(getActivity(), "请输入反馈内容", Style.CONFIRM).show();
                }
            }
        });
    }
}
