package com.example.administrator.seaydemo.Activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.seaydemo.Entity.ImageSet;
import com.example.administrator.seaydemo.Image.API;
import com.example.administrator.seaydemo.Image.ImageApplication;
import com.example.administrator.seaydemo.Image.ImageClient;
import com.example.administrator.seaydemo.Image.UICallback;
import com.example.administrator.seaydemo.R;
import com.example.administrator.seaydemo.Until.MyLoadShow;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class ImageShow_2 extends AppCompatActivity implements ImageLoadingProgressListener, ImageLoadingListener {

    @BindView(R.id.MyLoadView)
    MyLoadShow myLoadView;
    @BindView(R.id.Image_title)
    TextView ImageTitle;
    @BindView(R.id.Imgae_show)
    ImageView ImgaeShow;
    @BindView(R.id.Image_size)
    TextView ImageSize;
    @BindView(R.id.Image_root)
    RelativeLayout ImageRoot;
    @BindView(R.id.Image_alter)
    Button ImageAlter;
    @BindView(R.id.Image_save)
    Button ImageSave;
    @BindView(R.id.Image_next)
    Button ImageNext;
    @BindView(R.id.button_root)
    LinearLayout buttonRoot;
    @BindView(R.id.activity_image_show_2)
    RelativeLayout activityImageShow2;
    private int id;
    private ImageSet imageSet;
    private List<ImageSet.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show_2);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        LoadUrl();
    }

    public void LoadUrl() {
        ImageClient.getImageClient().LoadImageList(id).enqueue(new UICallback() {
            @Override
            public void OnFailure(Call call, IOException e) {

            }

            @Override
            public void OnResponse(Call call, String body) {
                imageSet = new Gson().fromJson(body, ImageSet.class);
                list = imageSet.getList();
                ImageLoader.getInstance().displayImage(API.Host + list.get(0).getSrc(), ImgaeShow, ImageApplication.getDisplayImageOptions(), ImageShow_2.this, ImageShow_2.this);

            }
        });
    }



    @Override
    public void onProgressUpdate(String imageUri, View view, int current, int total) {
        System.out.println(current + "" + total);
    }

    @Override
    public void onLoadingStarted(String imageUri, View view) {

        myLoadView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
        myLoadView.setVisibility(View.GONE);
        Toast.makeText(this, "下载失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
        myLoadView.setVisibility(View.GONE);
    }

    @Override
    public void onLoadingCancelled(String imageUri, View view) {

    }


    @OnClick({R.id.Image_alter, R.id.Image_save, R.id.Image_next})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.Image_alter:
                break;
            case R.id.Image_save:
                break;
            case R.id.Image_next:
                break;
        }
    }
}
