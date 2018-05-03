package com.example.interviewpractice.adapter.viewholder;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.interviewpractice.MyApplication;
import com.example.interviewpractice.R;
import com.example.interviewpractice.enity.RecomendarMovie;
import com.hymane.expandtextview.ExpandTextView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018/1/25.
 */

public class StartViewHolder extends BaseViewHolder<RecomendarMovie> {
    private JZVideoPlayerStandard jzVideo;
    private ExpandTextView dra;
    private static final String TAG = "StartViewHolder";
    private int LOCAL=1;
    private int NETWORK=0;
    private static final String SD_PATH = "/sdcard/dskqxt/pic/";
    private static final String IN_PATH = "/dskqxt/pic/";

    /**
     * 随机生产文件名
     *
     * @return
     */
    private static String generateFileName() {
        return UUID.randomUUID().toString();
    }
    public StartViewHolder(ViewGroup parent) {
        super(parent, R.layout.start_recyclerview_item);
        jzVideo=$(R.id.jzplayer);
        dra=$(R.id.des);
    }

    @Override
    public void setData(RecomendarMovie data) {
        super.setData(data);
        dra.setContent(data.getDescription());
        dra.setTitleTextSize(0);
        dra.setTitle("");
        dra.setAnimationDuration(60);

//        textView.setText("#"+data.getDescription());
//        Log.e(TAG, "setData: "+getRingDuring(data.getMovieUrl()) );
        Glide.with(getContext())
                .load(data.getImagepng())
                .centerCrop()
                .into(jzVideo.thumbImageView);
        jzVideo.setUp(data.getMovieUrl(),jzVideo.SCREEN_WINDOW_NORMAL,"");
//        jzVideo.thumbImageView.setImageBitmap(getNetVideoBitmap(data.getMovieUrl()));

        try {
            saveFile(createVideoThumbnail(data.getMovieUrl(),480,270),data.getObjectId());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Log.e(TAG, "setData: **********"+saveBitmap(MyApplication.getContext(),getNetVideoBitmap(data.getMovieUrl())));
        jzVideo.startWindowTiny();
    }

    public static String getRingDuring(String mUri){
        String duration=null;
        android.media.MediaMetadataRetriever mmr = new android.media.MediaMetadataRetriever();

        try {
            if (mUri != null) {
                HashMap<String, String> headers=null;
                if (headers == null) {
                    headers = new HashMap<String, String>();
                    headers.put("User-Agent", "Mozilla/5.0 (Linux; U; Android 4.4.2; zh-CN; MW-KW-001 Build/JRO03C) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 UCBrowser/1.0.0.001 U4/0.8.0 Mobile Safari/533.1");
                }
                mmr.setDataSource(mUri, headers);
            }

            duration = mmr.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);
        } catch (Exception ex) {
        } finally {
            mmr.release();
        }
     Log.e("ryan","duration "+duration);
        return duration;
    }

    public static Bitmap getNetVideoBitmap(String videoUrl) {
        Bitmap bitmap = null;
       MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //根据url获取缩略图
            retriever.setDataSource(videoUrl, new HashMap());
            //获得第一帧图片
            bitmap = retriever.getFrameAtTime();
            Log.e(TAG, "getNetVideoBitmap: "+bitmap.getByteCount() );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            retriever.release();
        }
        return bitmap;
    }
    public long getDurationLong(String url,int type){
        String duration = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //如果是网络路径
            if(type == NETWORK){
                retriever.setDataSource(url,new HashMap<String, String>());
            }else if(type == LOCAL){//如果是本地路径
                retriever.setDataSource(url);
            }
            duration = retriever.extractMetadata(android.media.MediaMetadataRetriever.METADATA_KEY_DURATION);
            Log.e(TAG, "getDurationLong: "+duration);
        } catch (Exception ex) {

            Log.d("nihao", "获取音频时长失败");
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {

                Log.d("nihao", "释放MediaMetadataRetriever资源失败");
            }
        }
        if(!TextUtils.isEmpty(duration)){
            return Long.parseLong(duration);
        }else{
            return 0;
        }
    }

    //获取视频缩略图
    private Bitmap createVideoThumbnail(String url, int type) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            //将网络文件以及本地文件区分开来设置
            if (type == NETWORK) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else if(type == LOCAL){
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime(0, MediaMetadataRetriever.OPTION_NEXT_SYNC);
        } catch (IllegalArgumentException ex) {

            Log.d("nihao", "获取视频缩略图失败");
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {

                Log.d("nihao", "释放MediaMetadataRetriever资源失败");
            }
        }
        return bitmap;
    }

    private void saveFile(Bitmap file, final String id)  throws IOException {



        String path = getSDPath() +"/";
        File dirFile = new File(path);
        if(!dirFile.exists()){
            dirFile.mkdir();
        }
        File myCaptureFile = new File(path + id+".jpg");
        if (!myCaptureFile.exists()){
            myCaptureFile.createNewFile();
        }
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myCaptureFile));
        file.compress(Bitmap.CompressFormat.PNG, 80, bos);
        bos.flush();
        bos.close();



//        File file1=new File(String.valueOf(file));
        final BmobFile bmobFile=new BmobFile(myCaptureFile);
        bmobFile.uploadblock(MyApplication.getContext(), new UploadFileListener() {
            @Override
            public void onSuccess() {
               bmobSaveAll(bmobFile,id);
            }
            @Override
            public void onFailure(int i, String s) {
                Log.e(TAG, "失败了 " +s+i);
            }
        });

//        user.setObjectId(id);

//        user.update(MyApplication.getContext(), new UpdateListener() {
//            @Override
//            public void onSuccess() {
//                Toast.makeText(MyApplication.getContext(), "1", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Toast.makeText(MyApplication.getContext(), "2", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    private void bmobSaveAll(BmobFile bmobFile, String id) {
        RecomendarMovie user=new RecomendarMovie(id);
//        user.setObjectId(id);
        user.setImageUrl(bmobFile);
        user.update(MyApplication.getContext(), new UpdateListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(MyApplication.getContext(), "1", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Log.e(TAG, "onFailure: "+s );
                Toast.makeText(MyApplication.getContext(), "2", Toast.LENGTH_SHORT).show();
            }
        });
//        user.save(MyApplication.getContext(), new SaveListener() {
//            @Override
//            public void onSuccess() {
//                Toast.makeText(MyApplication.getContext(), "1", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(int i, String s) {
//                Log.e(TAG, "onFailure: "+s );
//                Toast.makeText(MyApplication.getContext(), "2", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    private Bitmap createVideoThumbnail(String url, int width, int height) {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        int kind = MediaStore.Video.Thumbnails.MINI_KIND;
        try {
            if (Build.VERSION.SDK_INT >= 14) {
                retriever.setDataSource(url, new HashMap<String, String>());
            } else {
                retriever.setDataSource(url);
            }
            bitmap = retriever.getFrameAtTime();
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
            }
        }
        if (kind == MediaStore.Images.Thumbnails.MICRO_KIND && bitmap != null) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap, width, height,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }
    public static String getSDPath(){
        File sdDir = null;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED); //判断sd卡是否存在
        if (sdCardExist)
        {
            sdDir = Environment.getExternalStorageDirectory();//获取跟目录
        }
        return sdDir.toString();
    }
    public static String saveBitmap(Context context, Bitmap mBitmap) {
        String savePath;
        File filePic;
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            savePath = SD_PATH;
        } else {
            savePath = context.getApplicationContext().getFilesDir()
                    .getAbsolutePath()
                    + IN_PATH;
        }
        try {
            filePic = new File(savePath + generateFileName() + ".jpg");
            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(filePic);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

        return filePic.getAbsolutePath();
    }
}
