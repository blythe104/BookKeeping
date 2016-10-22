package cn.book.keeping.libs.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

import com.badoo.mobile.util.WeakHandler;

/**
 * Created by  chuangtou on 16/8/9.
 * 国丞创投
 */
public class TimeCountButton extends Button {
    private int countTime = 60;
    protected int lastTime;
    protected String text = "重新获取";
    private boolean isRunning = false;
    private WeakHandler handler = new WeakHandler();
    private Runnable myRunnable = new Runnable() {
        public void run() {
            if (TimeCountButton.this.lastTime == 0) {
                TimeCountButton.this.isRunning = false;
                TimeCountButton.this.setText(TimeCountButton.this.text);
                TimeCountButton.this.setEnabled(true);
                TimeCountButton.this.lastTime = TimeCountButton.this.countTime;
            } else {
                --TimeCountButton.this.lastTime;
                TimeCountButton.this.setText("还剩" + TimeCountButton.this.lastTime + "秒");
                TimeCountButton.this.handler.postDelayed(this, 1000L);
            }

        }
    };

    public TimeCountButton(Context context, int countTime) {
        super(context);
        this.countTime = countTime;
    }

    public TimeCountButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setText("发送验证码");
    }

    public void setCountTime(int countTime) {
        this.countTime = countTime;
    }

    public void startCount() {
        this.isRunning = true;
        if (this.isEnabled()) {
            this.setEnabled(false);
            this.lastTime = this.countTime;
            this.handler.post(this.myRunnable);
        }

    }

    public void setEnabled(boolean enabled) {
        if (!this.isRunning || !enabled) {
            super.setEnabled(enabled);
        }

    }
}