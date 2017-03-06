package com.example.administrator.seaydemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private ContentAdpter adpter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content)
    RecyclerView content;
    @BindView(R.id.edit_query)
    EditText editQuery;

    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.commit_me)
    Button commitMe;
    @BindView(R.id.commit_your)
    Button commitYour;

    private List<Message> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        ButterKnife.bind(this);
        adpter = new ContentAdpter(this);
        init();
    }


    private void init() {
        content.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        content.setItemAnimator(new DefaultItemAnimator());
        content.setAdapter(adpter);
        editQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.commit_me, R.id.commit_your})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_me:
                list.add(new Message(0, editQuery.getText().toString()));
                adpter.notifyItemInserted(list.size() - 1);
                editQuery.setText("");
                content.smoothScrollToPosition(list.size() - 1);
                break;
            case R.id.commit_your:
                list.add(new Message(1, editQuery.getText().toString()));
                adpter.notifyItemInserted(list.size() - 1);
                editQuery.setText("");
                content.smoothScrollToPosition(list.size() - 1);
                show_message(list.size() - 1);
                break;
        }
    }

    class ContentAdpter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private Context context;

        public ContentAdpter(Context context) {
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            if (viewType == 0) {
                Me me = new Me(View.inflate(context, R.layout.item_me, null));
                return me;
            } else if (viewType == 1) {
                your your = new your(View.inflate(context, R.layout.item_your, null));
                return your;
            }
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof Me) {
                ((Me) holder).textView.setText(list.get(position).getMes());
            } else if (holder instanceof your) {
                ((your) holder).textView.setText(list.get(position).getMes());
            }
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public int getItemViewType(int position) {
            if (list.get(position).getKey() == 0) {
                return 0;
            } else {
                return 1;
            }


        }

        class Me extends RecyclerView.ViewHolder {
            private TextView textView;

            public Me(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.list_item_me);
            }
        }

        class your extends RecyclerView.ViewHolder {
            private TextView textView;

            public your(View itemView) {
                super(itemView);
                textView = (TextView) itemView.findViewById(R.id.list_item_your);
            }
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.bind(this).unbind();
    }

    public void show_message(int i) {
        PendingIntent intent = PendingIntent.getActivity(this,1,new Intent(this,MainActivity.class),PendingIntent.FLAG_CANCEL_CURRENT);

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(this)
                .setAutoCancel(true)
                .setContentIntent(intent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setTicker("新消息")
                .setContentTitle("通知")
                .setContentText("45646")
                .build();
        manager.notify(1, notification);

    }

    public class MyReciver extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent) {
            show_message(1);
        }
    }

}
