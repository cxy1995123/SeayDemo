package com.example.administrator.seaydemo.Image;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.seaydemo.Entity.ImageSet;
import com.example.administrator.seaydemo.R;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


public class ViewPagerActivity extends AppCompatActivity {
    private ProgressDialog d;
    @BindView(R.id.Relativelayout)
    RelativeLayout Relativelayout;
    private int index = 0;
    private Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle b = msg.getData();
            Bitmap bitmao = b.getParcelable("bitmap");
            addview(bitmao);
            d.setMessage("正在加载,共有" + list.size() + "张，正在加载第" + index + "张");
            d.setProgress(index);

            if (index == list.size()) {
                Relativelayout.setVisibility(View.VISIBLE);
                title.setVisibility(View.VISIBLE);
                content.setVisibility(View.VISIBLE);
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
            }

        }
    };
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
        d = new ProgressDialog(this);
        viewList = new ArrayList<>();
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 1);
        init();

    }

    public void addview(Bitmap b) {
        index++;
        ImageView image = new ImageView(this);
        image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        image.setImageBitmap(b);
        viewList.add(image);
    }

    public void LoadImage(final int i) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                load(i);
            }
        }).start();
    }

    public void load(int i) {
        try {
            Looper.prepare();
            URL url = new URL(API.Host + list.get(i).getSrc());
            URLConnection connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap b = BitmapFactory.decodeStream(inputStream);
            Log.e("BitmapSize", "run: " + b.getByteCount() + "\nindex：" + index);
            Message m = h.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("bitmap", b);
            m.setData(bundle);
            h.sendMessage(m);
        } catch (Exception e) {
            e.printStackTrace();
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
                d.setMax(list.size());
                d.setMessage("正在加载,共有" + list.size() + "张，正在加载第" + index + "张");
                d.setProgress(index);
                d.show();

                for (int i = 0; i < list.size(); i++) {
                    LoadImage(i);
                }
                viewPager.addOnPageChangeListener
                        (new ViewPager.SimpleOnPageChangeListener() {
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
