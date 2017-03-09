package com.example.administrator.seaydemo.Image;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
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
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


public class ViewPagerActivity extends AppCompatActivity {
    private ProgressDialog d;
    @BindView(R.id.Relativelayout)
    RelativeLayout Relativelayout;
    private int index = 0;
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

    public void addview(int index) {
        for (int i = 0; i < index; i++) {
            ImageView image = new ImageView(this);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
            viewList.add(image);
        }

        setViewpager();
    }

    public void LoadImage(final int i) {
        for (int j = 0; j < i; j++) {

            ImageLoader.getInstance().displayImage(API.Host + list.get(j).getSrc(), viewList.get(j), ImageApplication.getDisplayImageOptions());
        }

    }

    public void load(int i) {
        URLConnection connection;
//        FileOutputStream fos = null;
        try {
            URL url = new URL(API.Host + list.get(i).getSrc());
            connection = url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap b = BitmapFactory.decodeStream(inputStream);
//            String path = Environment.getExternalStorageDirectory() + "\\ImageLoad\\" + i + ".jpge";
//            fos = new FileOutputStream(path);
//            int total = 0;
//            int len;
//            byte[] buff = new byte[1024 * 8];
//            while ((len = inputStream.read(buff)) != -1) {
//                total += len;
//                fos.write(buff, 0, len);
//            }
            Message m = h.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("bitmap", b);
            m.setData(bundle);
            h.sendMessage(m);
//            fos.close();
            inputStream.close();

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
                Log.e("size", "OnResponse: " + list.size());
                addview(list.size() - 1);
                setViewpager();
                LoadImage(list.size() - 1);
            }
        });

    }

    private void setViewpager() {
        viewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
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
            }
        });

        viewPager.addOnPageChangeListener
                (new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                        super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                        content.setText(1 + position + "/" + (imageSet.getSize() - 1));
                    }
                });
    }

    private Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bundle b = msg.getData();
            Bitmap bitmao = b.getParcelable("bitmap");
            viewList.get(index).setImageBitmap(bitmao);
            index++;
            Log.e("", "handleMessage: " + index + "size:" + (bitmao.getByteCount() / 1024));
        }
    };
}
