package com.example.administrator.seaydemo.Until;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

/**
 * Created by duangniu000 on 2017/3/8.
 */

public class BaseActivity extends AppCompatActivity {
    private static FragmentManager manager;

    private static List<String> list;



    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        manager = getFragmentManager();
    }

    public static FragmentManager getManager() {
        return manager;
    }

    public  List GatList() {
        return list;
    }

    public  void SetList(List<String> list1) {
        list = list1;
    }
}
