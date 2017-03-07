package com.example.administrator.seaydemo.Image;

import android.os.Handler;
import android.os.Looper;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/3/7.
 */

public abstract class UICallback implements Callback {

    Handler handler = new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(final Call call, final IOException e) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                onFailure(call, e);
            }
        });
    }

    @Override
    public void onResponse(final Call call, Response response) throws IOException {

        if (response.isSuccessful()) {
            final String body = response.body().string();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    OnResponse(call,body);
                }
            });
        }else
        {

        }
    }

    public abstract void OnFailure(Call call, IOException e);

    public abstract void OnResponse(Call call, String body);
}
