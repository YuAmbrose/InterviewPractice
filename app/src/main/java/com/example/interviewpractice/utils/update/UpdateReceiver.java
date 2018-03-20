package com.example.interviewpractice.utils.update;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.widget.Toast;

import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.utils.SpUtils;

import java.io.File;

/**
 * Created by ccc on 2017/11/1.
 */

/**
 * 完成下载apk的监听广播
 */
public class UpdateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //下载完成
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)){
            long downloadid = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1L);
            long localid = SpUtils.getInstance(context).getLong("did",-2L);
            //比较本地保存id和下载id，相等则进入安装
            if (downloadid == localid){
                Toast.makeText(context,"下载完成",Toast.LENGTH_SHORT).show();
                Log.e("UpdateReceiver","download success!");
                installApk(context,downloadid);
            }
        }else{
            Toast.makeText(context,"下载失败",Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 安装apk
     * @param context
     * @param did
     */
    private void installApk(Context context,long did) {

        DownloadManager dm = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        //获取文件地址uri
        Uri fileUri = dm.getUriForDownloadedFile(did);
        Log.e("UpdateReceiver","fileUri = " + fileUri);
        //获取文件真实路径
        String filePath = UpdateManager.getRealFilePath(MyApplication.getContext(),fileUri);
        Log.e("UpdateReceiver","filePath = " + filePath);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //如果Android版本大于N
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            //需要用FileProvider进入安装界面
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            //构建一个文件Uri
            Uri furi = FileProvider.getUriForFile(context,"com.example.interviewpractice.fileProvider",
                    new File(filePath));
            Log.e("UpdateReceiver","fileuri = " + furi.toString());
            intent.setDataAndType(furi,"application/vnd.android.package-archive");
        }else{
            intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}
