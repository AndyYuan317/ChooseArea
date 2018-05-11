package com.example.choose;

import android.os.Handler;


public class UIUtils {

    /**
     * 获取消息处理器
     */
    public static Handler getHandler() {
        return MallApplication.getHandler();
    }

    /**
     * 获取主线程
     */
    public static int getMainThread() {
        return MallApplication.getMainThreadId();
    }

    ///////////////////// 加载资源文件 ///////////////////////////////////////


    ////////////////////////// 判断是否运行在主线程 /////////////////////////////////////////////
    public static boolean isRunOnUiThread() {
        int myTid = android.os.Process.myTid();
        if (myTid == getMainThread()) return true;
        return false;
    }

    public static void runOnUIThread(Runnable r) {
        if (isRunOnUiThread()) {
            r.run(); // 已经是主线程，直接运行
        } else {
            getHandler().post(r); // 如果是子线程，借助handler让其运行在主线程
        }
    }
}
