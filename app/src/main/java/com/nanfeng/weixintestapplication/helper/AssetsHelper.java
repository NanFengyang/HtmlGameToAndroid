package com.nanfeng.weixintestapplication.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyoutao on 2016/12/1.
 */

public class AssetsHelper {
    /**
     * 读取Assets文件下的html或者文本
     *
     * @param fileName
     * @return
     */
    public static String getFromAssetsText(Activity activity, String fileName) {
        String result = "";
        try {
            InputStream in = activity.getResources().getAssets().open(fileName);
            //获取文件的字节数
            int lenght = in.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据读到byte数组中
            in.read(buffer);
            result = new String(buffer, "utf8");
        } catch (Exception e) {
            Log.e("Exception", "Exception:" + e.toString());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 返回指定路径下的文件名或者文件夹名字
     *
     * @param path
     * @return
     */
    public static List<String> getListAssets(Activity activity, String path) {
        List<String> mlist = null;
        try {
            String[] strings = activity.getResources().getAssets().list(path);
            if (null != strings && strings.length > 0) {
                mlist = new ArrayList<>();
                for (String str : strings) {
                    mlist.add(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        return mlist;
    }

    /**
     * 读取Assets文件下的html或者文本
     *
     * @param fileName
     * @return
     */
    public static Bitmap getFromAssetsBitmap(Activity activity, String fileName) {
        Bitmap resultbitmap = null;
        try {
            InputStream in = activity.getResources().getAssets().open(fileName);
            //获取文件的字节数
            resultbitmap = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultbitmap;
    }

}
