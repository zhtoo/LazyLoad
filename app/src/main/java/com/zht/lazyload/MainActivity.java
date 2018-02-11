package com.zht.lazyload;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();
    }

    /**
     * 初始化BottomNavigation
     * init BottomNavigation
     */
    private void initBottomNavigation() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_navigation);
        //禁止滑动效果  disable BottomNavigationView shift mode
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //添加监听


    }


}
