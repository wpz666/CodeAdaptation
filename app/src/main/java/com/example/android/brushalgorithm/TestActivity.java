package com.example.android.brushalgorithm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Created by Android on 2018/7/5.
 */

public class TestActivity extends Activity {

    private Button test_btn_return;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        initData();
    }

    private void initView() {
        test_btn_return = (Button) findViewById(R.id.test_btn_return);
    }
    private void initData() {
        test_btn_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
