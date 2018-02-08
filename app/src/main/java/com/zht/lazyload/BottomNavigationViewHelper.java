package com.zht.lazyload;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * 作者：zhanghaitao on 2018/2/8 11:42
 * 邮箱：820159571@qq.com
 * <a href = "http://blog.csdn.net/IWantToHitRen/article/details/77338138">参考地址</a>
 * @describe:BottomNavigationView禁止3个item以上动画切换效果
 */

public class BottomNavigationViewHelper {
    /**
     * 禁用切换模式
     * @param view  BottomNavigationView
     */
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //no inspection Restricted Api
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //no inspection Restricted Api
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }
}
