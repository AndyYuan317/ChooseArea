package com.example.choose;

import android.os.Handler;
/**
 * Created by acer-pc on 2018/5/10.
 */

public class MallApplication {
    private static Handler handler = new Handler();
    private static MallApplication application;
    private static int mainThreadId;

    /**
     * 获取到本应用的对象
     *
     * @return
     */
    public static MallApplication getApplication() {
        return application;
    }

    /**
     * 获取消息处理器
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }
}
