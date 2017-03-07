package com.example.administrator.seaydemo.Image;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Administrator on 2017/3/7.
 */

public class ImageClient {
    //拦截器


    private static ImageClient imageClient = new ImageClient();

    private OkHttpClient okHttpClient;

    public static ImageClient getImageClient() {

        return imageClient;
    }

    private ImageClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
         okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }

    //获取列表
    public  Call LoadImageTitle(int id,int page)
    {
        Request request = new Request.Builder()
                .url(API.getImage_Url(id,page))
                .build();
        return okHttpClient.newCall(request);
    }

    public  Call LoadImageList(int index)
    {
        Request request = new Request.Builder()
                .url(API.Image_List+index)
                .build();
        return okHttpClient.newCall(request);
    }
}
