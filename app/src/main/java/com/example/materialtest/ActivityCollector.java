package com.example.materialtest;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 *  集合类 对所有活动进行管理
 */
public class ActivityCollector {
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){  // 向列表中添加活动
        activities.add(activity);
    }

    public static void removeActivity(Activity activity){  // 从List中移除活动
        activities.remove(activity);
    }

    public static void finishAll(){  // 将List中存储的活动全部销毁
        for (Activity activity : activities){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
        activities.clear();
    }
}
