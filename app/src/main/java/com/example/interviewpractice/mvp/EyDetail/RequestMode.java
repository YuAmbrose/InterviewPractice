package com.example.interviewpractice.mvp.EyDetail;



import android.content.Context;

import com.example.interviewpractice.app.Api;
import com.example.interviewpractice.enity.EyDetailBean;
import com.example.interviewpractice.enity.HotMovieBean;
import com.example.interviewpractice.enity.RankListBean;
import com.example.interviewpractice.http.BaseModel;
import com.example.interviewpractice.http.IBaseRequestCallBack;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @author 刘镓旗
 * @date 2017/11/17
 * @description
 */
public class RequestMode extends BaseModel {

    private Call<EyDetailBean> weatherBeanCall;
    private CompositeDisposable mcompositeDisposable;
    private Context context;
    private Api api;
    public  RequestMode(Context mContext) {
           super();
        context = mContext;
        api = retrofitManager.getService();
        mcompositeDisposable = new CompositeDisposable();
    }

    public void request(String Id, final IBaseRequestCallBack<EyDetailBean> iBaseRequestCallBack){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiService apiService = retrofit.create(ApiService.class);
//        weatherBeanCall = apiService.requestWeather(cityId);
//        weatherBeanCall.enqueue(callback);
        mcompositeDisposable.add(api.getEyDetail(Id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<EyDetailBean>() {
                    @Override
                    public void accept(EyDetailBean eyDetailBean) throws Exception {

                        iBaseRequestCallBack.requestSuccess(eyDetailBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        iBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }
    public  void  RequesetReComender(String id, final IBaseRequestCallBack<RankListBean> rankListBeanIBaseRequestCallBack){
        mcompositeDisposable.add(api.getRecomendar(id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<RankListBean>() {
                    @Override
                    public void accept(RankListBean rankListBean) throws Exception {

                        rankListBeanIBaseRequestCallBack.requestSuccess(rankListBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        rankListBeanIBaseRequestCallBack.requestError(throwable);
                    }
                }));
    }

    public void interruptHttp(){
        if(weatherBeanCall != null && !weatherBeanCall.isCanceled()){
            weatherBeanCall.cancel();
        }
    }
}
