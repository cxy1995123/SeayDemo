package com.example.administrator.seaydemo.Activity;


import android.app.AlarmManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.seaydemo.Fragments.CoverFragment;
import com.example.administrator.seaydemo.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/3/7.
 */

public class ImageShowActivity extends AppCompatActivity {
    @BindView(R.id.title)
    TextView title;
    private Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragment = new CoverFragment();
    }


    public void showFragment(Fragment fragment) {

        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            beginTransaction.add(R.id.main_fragment, fragment);
        }
        beginTransaction.show(fragment);
        beginTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showFragment(fragment);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public class MyBroadCast extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Calendar calendar = Calendar.getInstance();
            int hours = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int s = calendar.get(Calendar.SECOND);
            title.setText(hours + ":" + min + ":" + s);
        }
    }

}
