package com.wuxiaolong.androidutils.library;

import android.app.Activity;

import java.util.Stack;

/**
 * public class BaseActivity extends AppCompatActivity {
 * private ActivityManagerUtil activityManagerUtil;
 * protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_base);
 * activityManagerUtil = ActivityManagerUtil.getInstance();
 * activityManagerUtil.pushOneActivity(this);
 * }
 * protected void onDestroy() {
 * super.onDestroy();
 * activityManagerUtil.popOneActivity(this);
 * }
 * }
 * Created by WuXiaolong
 * on 2016/5/19.
 * 微信公众号：吴小龙同学
 * 个人博客：http://wuxiaolong.me/
 */
public class ActivityManagerUtil {
    private static ActivityManagerUtil instance;
    //activity栈
    private Stack<Activity> activityStack = new Stack<>();

    /**
     * 单例模式
     *
     * @return 单例
     */

    public static ActivityManagerUtil getInstance() {
        if (instance == null) {
            instance = new ActivityManagerUtil();
        }
        return instance;
    }

    /**
     * 把一个activity压入栈中
     *
     * @param actvity activity
     */
    public void pushOneActivity(Activity actvity) {
        activityStack.add(actvity);
    }


    /**
     * 移除一个activity
     *
     * @param activity activity
     */
    public void popOneActivity(Activity activity) {
        if (activityStack != null && activityStack.size() > 0) {
            if (activity != null) {
                activityStack.remove(activity);
                activity.finish();
            }
        }
    }

    /**
     * 获取栈顶的activity，先进后出原则
     *
     * @return 栈顶的activity
     */
    public Activity getLastActivity() {
        return activityStack.lastElement();
    }

    /**
     * 结束指定的Activity
     *
     * @param activity activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
        }
    }

    /**
     * 结束指定类名的Activity
     *
     * @param cls 指定的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有activity
     */
    public void finishAllActivity() {
        try {
            for (int i = 0; i < activityStack.size(); i++) {
                if (null != activityStack.get(i)) {
                    activityStack.get(i).finish();
                }
            }
            activityStack.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 退出应用程序
     */
    public void appExit() {
        try {
            finishAllActivity();
            //退出JVM(java虚拟机),释放所占内存资源,0表示正常退出(非0的都为异常退出)
            System.exit(0);
            //从操作系统中结束掉当前程序的进程
            android.os.Process.killProcess(android.os.Process.myPid());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
