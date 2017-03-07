package com.example.administrator.seaydemo.Image;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.TextView;

import com.example.administrator.seaydemo.Entity.ImageFengmian;
import com.example.administrator.seaydemo.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;

/**
 * Created by Administrator on 2017/3/7.
 */

public class ImageLoadActivity extends AppCompatActivity {

    private List<ImageFengmian.TngouBean> list;

    private FengmianAdpter Adpter;

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.Recyclerview)
    RecyclerView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_imageload);
        ButterKnife.bind(this);
        LoadImagelist();
         init();
    }


    public  void init()
    {
        view.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        Adpter = new FengmianAdpter(this);
        view.setAdapter(Adpter);
    }

    private void LoadImagelist() {
        ImageClient imageClient = ImageClient.getImageClient();
        imageClient.LoadImageTitle(1, 10).enqueue(new UICallback() {
            @Override
            public void OnFailure(Call call, IOException e) {

            }

            @Override
            public void OnResponse(Call call, String body) {
                ImageFengmian fengmian = new Gson().fromJson(body, ImageFengmian.class);
                list = fengmian.getTngou();
                Adpter.setList(list);
            }
        });
    }


}
