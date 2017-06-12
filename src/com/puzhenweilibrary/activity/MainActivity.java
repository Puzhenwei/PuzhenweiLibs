package com.puzhenweilibrary.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import com.puzhenweilibrary.R;
import com.puzhenweilibrary.utilsfour.Log;

public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i(TAG, "dispatchKeyEvent, event = " + event.getKeyCode());
        return true;
    }

    @Override
    public void onAttachedToWindow() {
        this.getWindow().addFlags(0x80000000);
        super.onAttachedToWindow();
    }
}
