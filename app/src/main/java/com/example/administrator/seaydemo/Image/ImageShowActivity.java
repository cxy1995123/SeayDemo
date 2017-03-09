package com.example.administrator.seaydemo.Image;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.seaydemo.Fragments.CoverFragment;
import com.example.administrator.seaydemo.R;
import com.example.administrator.seaydemo.Until.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/3/7.
 */

public class ImageShowActivity extends AppCompatActivity {
    private static List<Fragment> list = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        showFragment(new CoverFragment());
    }

    public void showFragment(Fragment fragment) {

        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            beginTransaction.add(R.id.main_fragment, fragment);
            list.add(fragment);
        }
        for (int i = 0; i < list.size(); i++) {
            beginTransaction.hide(list.get(i));
        }
        beginTransaction.show(fragment);
        beginTransaction.commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.clear();
        list = null;
    }

}
