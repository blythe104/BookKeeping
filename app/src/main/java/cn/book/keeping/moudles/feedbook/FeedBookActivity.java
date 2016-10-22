package cn.book.keeping.moudles.feedbook;

import android.os.Bundle;

import cn.book.keeping.libs.activity.BaseActivity;
import cn.book.keeping.moudles.feedbook.fragment.FeedBookFragment;

public class FeedBookActivity extends BaseActivity {


    @Override
    protected void initViews(Bundle savedInstanceState) {
        setFragment(new FeedBookFragment());
    }
}
