package com.example.administrator.seaydemo.Image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.seaydemo.Entity.ImageFengmian;
import com.example.administrator.seaydemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public class FengmianAdpter extends RecyclerView.Adapter<FengmianAdpter.ViewHoder> {
    private Context context;
    private List<ImageFengmian.TngouBean> list;

    public void setList(List<ImageFengmian.TngouBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public FengmianAdpter(Context context) {
        this.context = context;
    }

    @Override
    public FengmianAdpter.ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHoder(View.inflate(context, R.layout.item_image_fengmian, null));
    }

    @Override
    public void onBindViewHolder(FengmianAdpter.ViewHoder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        //  Picasso.with(context).load(API.Host+list.get(position).getImg()).into(holder.image);
        Picasso.with(context).load(API.Host + list.get(position).getImg()).resize(100, 100).centerCrop().into(holder.image);
    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }

        return list.size();
    }

    public class ViewHoder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView image;

        public ViewHoder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.Image_title);
            image = (ImageView) itemView.findViewById(R.id.Image_image);
        }
    }
}
