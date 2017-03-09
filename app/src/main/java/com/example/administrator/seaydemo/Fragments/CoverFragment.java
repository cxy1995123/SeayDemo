package com.example.administrator.seaydemo.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.seaydemo.Entity.ImageCover;
import com.example.administrator.seaydemo.Image.CoverAdpter;
import com.example.administrator.seaydemo.Image.ImageClient;
import com.example.administrator.seaydemo.Image.UICallback;
import com.example.administrator.seaydemo.Image.ViewPagerActivity;
import com.example.administrator.seaydemo.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;
import okhttp3.Call;

/**
 * Created by duangniu000 on 2017/3/8.
 */

public class CoverFragment extends Fragment {

    private static int id = 1;
    private static int pager = 1;
    @BindView(R.id.Recyclerview)
    RecyclerView view;
    @BindView(R.id.down_up)
    PtrClassicFrameLayout downUp;
    private List<ImageCover.TngouBean> list;
    private CoverAdpter Adpter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ui_image_cover, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadImagelist(1, 1);
        init();
    }

    public void init() {
        list = new ArrayList<>();
        downUp.setLastUpdateTimeRelateObject(this);
        downUp.setDurationToClose(2000);
        downUp.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) {
                pager++;
                LoadImagelist(id, pager);
                frame.refreshComplete();
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                list.clear();
                pager = 1;
                LoadImagelist(get_Id(), pager);
                Adpter.notifyDataSetChanged();
                frame.refreshComplete();
            }
        });

        view.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        Adpter = new CoverAdpter(getActivity());
        view.setAdapter(Adpter);
        Adpter.setOnItemOnclickListener(new CoverAdpter.OnItemOnclickListener() {
            @Override
            public void OnItemClick(int pos) {
                int id = list.get(pos).getId();
                Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }

            @Override
            public void OnItemLongClick(int pos) {

            }
        });
    }

    private void LoadImagelist(int id, int pager) {
        ImageClient imageClient = ImageClient.getImageClient();
        imageClient.LoadImageTitle(id, pager).enqueue(new UICallback() {
            @Override
            public void OnFailure(Call call, IOException e) {
                Toast.makeText(getActivity(), "出错了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void OnResponse(Call call, String body) {
                ImageCover fengmian = new Gson().fromJson(body, ImageCover.class);
                list.addAll(fengmian.getTngou());
                Adpter.setList(list);
            }
        });
    }


    public static int get_Id() {
        if (id++ > 7) {
            id = 0;
        }
        return id++;
    }


    public static int getPager() {
        pager++;
        return pager;
    }
}
