package com.example.interviewpractice.utils.update;

import android.app.DownloadManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import com.example.interviewpractice.utils.util.SpUtils;

/**
 * Created by ccc on 2017/10/30.
 */

public class UpdateManager {

    private static String TAG = "UpdateManager";

    private Context mContext;

    private long downloadID;
    private DownloadManager mManager;

    public UpdateManager(Context context){
        mContext = context;
        mManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    }

    /**
     * 开始下载
     * @param url
     */
    public void startDownload(String url){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //允许漫游
        request.setAllowedOverRoaming(false);
        //显示通知栏
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
        //允许的网络下载坏境
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("更新");
        request.setDescription("正在下载更新apk");
        //设置下载存放的路径
        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,
                "dbapp");
        //开始下载
        downloadID = mManager.enqueue(request);
        Log.e(TAG,"start download and id is " + downloadID);
        //保存下载id到本地文件
        SpUtils.getInstance(mContext).putLong("did",downloadID);
    }

    /**
     * 根据 Uri获取文件的真是路径
     * @param context
     * @param uri
     * @return
     */
    public static String getRealFilePath(final Context context, final Uri uri) {
        if (null == uri) return null;
        final String scheme = uri.getScheme();
        String data = null;
        if (scheme == null)
            data = uri.getPath();
        else if (ContentResolver.SCHEME_FILE.equals(scheme)) {
            data = uri.getPath();
        } else if (ContentResolver.SCHEME_CONTENT.equals(scheme)) {
            Cursor cursor = context.getContentResolver().query(uri, new String[]{MediaStore.Images.ImageColumns.DATA}, null, null, null);
            if (null != cursor) {
                if (cursor.moveToFirst()) {
                    int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                    if (index > -1) {
                        data = cursor.getString(index);
                    }
                }
                cursor.close();
            }
        }
        return data;
    }


}
