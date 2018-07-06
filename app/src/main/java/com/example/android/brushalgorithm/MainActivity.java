package com.example.android.brushalgorithm;

import android.app.Activity;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.ComponentCallbacks;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Config;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends Activity {

    public int X = -121;
    private Button mainBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Test1(X);
        initView();
        initData();

    }

    private void initData() {
        mainBtnJump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestActivity.class);
                if (getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY) != null) {
                    try {
                        startActivity(intent);
                    } catch (ActivityNotFoundException e) {
                        if (Config.LOGD) {
                            Log.d("mainactivity", "activity not found for " + "  mimeType  " + " over " + "    Uri.parse(url). getScheme()     ", e);
                        }
                    }
                }
            }
        });
    }

    private void initView() {
        mainBtnJump = (Button) findViewById(R.id.main_btn_jump);
    }

    private static float aNoncompatDensity;
    private static float aNoncompatScaledDensity;

    private static void setCustomDensity(@NonNull Activity activity, @NonNull final Application application){
        DisplayMetrics appDisplayMetrics = application.getResources().getDisplayMetrics();
        if (aNoncompatDensity == 0){
            aNoncompatDensity = appDisplayMetrics.density;
            aNoncompatScaledDensity = appDisplayMetrics.scaledDensity;
            application.registerComponentCallbacks(new ComponentCallbacks() {
                @Override
                public void onConfigurationChanged(Configuration newConfig) {
                    if (newConfig != null && newConfig.fontScale > 0){
                        aNoncompatScaledDensity = application.getResources().getDisplayMetrics().scaledDensity;
                    }
                }

                @Override
                public void onLowMemory() {

                }
            });
        }

        final float targetDensity = appDisplayMetrics.widthPixels / 360;
        final float targetScaledDensity = targetDensity * (aNoncompatScaledDensity / aNoncompatDensity);
        final int targetDensityDpi = (int) (160 * targetDensity);

        appDisplayMetrics.density = targetDensity;
        appDisplayMetrics.scaledDensity = targetScaledDensity;
        appDisplayMetrics.densityDpi = targetDensityDpi;

        final DisplayMetrics activityDisplayMetrics = activity.getResources().getDisplayMetrics();
        activityDisplayMetrics.density = targetDensity;
        activityDisplayMetrics.scaledDensity = targetScaledDensity;
        activityDisplayMetrics.densityDpi = targetDensityDpi;

    }

    private boolean Test1(int A) {
        if (A<0 || (A!=0 && A%10==0)) return false;
        int rev = 0;
        while (A>rev){
            rev = rev*10 + A%10;
            A = A/10;
        }
        return (A==rev || A==rev/10);
    }

    /**
     * 输入-951
     * 输入-159
     * @param x
     * @return
     */
    public int test(int x){
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }


}
