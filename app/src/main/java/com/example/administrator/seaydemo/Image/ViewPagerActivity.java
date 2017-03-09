package com.example.administrator.seaydemo.Image;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.seaydemo.Entity.ImageSet;
import com.example.administrator.seaydemo.R;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


public class ViewPagerActivity extends AppCompatActivity {
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.content)
    TextView content;
    private List<ImageSet.ListBean> list;
    private List<ImageView> viewList;
    private ImageSet imageSet;
    private int id;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_pager_fragment);
        ButterKnife.bind(this);
        title.setVisibility(View.GONE);
        content.setVisibility(View.GONE);
        viewList = new ArrayList<>();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        init();

    }

    public void addview() {
        for (int i = 0; i < list.size(); i++) {
            ImageView image = new ImageView(this);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewList.add(image);
            ImageLoader.getInstance().displayImage(API.Host + list.get(i).getSrc(), image, ImageApplication.getDisplayImageOptions());

        }

    }


    public void init() {
        ImageClient.getImageClient().LoadImageList(id).enqueue(new UICallback() {
            @Override
            public void OnFailure(Call call, IOException e) {
            }

            @Override
            public void OnResponse(Call call, String body) {
                imageSet = new Gson().fromJson(body, ImageSet.class);
                title.setText(imageSet.getTitle());
                list = imageSet.getList();
                title.setVisibility(View.VISIBLE);
                content.setVisibility(View.VISIBLE);
                addview();
                viewPager.setAdapter(new PagerAdapter() {
                    @Override
                    public int getCount() {
                        return list.size();
                    }

                    @Override
                    public boolean isViewFromObject(View view, Object object) {
                        return view == object;
                    }

                    @Override
                    public Object instantiateItem(ViewGroup container, int position) {
                        container.addView(viewList.get(position));
                        return viewList.get(position);
                    }

                    @Override
                    public void destroyItem(ViewGroup container, int position, Object object) {
                        container.removeView(viewList.get(position));
                        //    super.destroyItem(container, position, object);
                    }
                });
                viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                        content.setText(1 + position + "/" + imageSet.getSize());
                    }
                });

            }
        });

    }

}
