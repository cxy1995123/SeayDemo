package com.example.administrator.seaydemo.Image;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.seaydemo.Entity.ImageCover;
import com.example.administrator.seaydemo.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 */

public class CoverAdpter extends RecyclerView.Adapter<CoverAdpter.ViewHoder> {
    private Context context;
    private List<ImageCover.TngouBean> list;
    private OnItemOnclickListener onItemOnclickListener;


    public interface OnItemOnclickListener {
        void OnItemClick(int pos);

        void OnItemLongClick(int pos);
    }

    public void setOnItemOnclickListener(OnItemOnclickListener onItemOnclickListener) {
        this.onItemOnclickListener = onItemOnclickListener;
    }

    public void setList(List<ImageCover.TngouBean> list) {
        this.list = list;
        notifyDataSetChanged();

    }

    public CoverAdpter(Context context) {
        this.context = context;
    }

    @Override
    public CoverAdpter.ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHoder(View.inflate(context, R.layout.item_image_cover, null));
    }

    @Override
    public void onBindViewHolder(final CoverAdpter.ViewHoder holder, int position) {
        int pos = holder.getAdapterPosition();
        int pos2 = holder.getLayoutPosition();
        // holder.title.setText(list.get(position).getTitle());
        holder.title.setText(list.get(pos).getSize()+"");
        ImageLoader.getInstance().displayImage(API.Host + list.get(position).getImg(), holder.image, ImageApplication.getDisplayImageOptions());
        //通过URL拿到SD卡中缓存的图片
        // ImageLoader.getInstance().getDiskCache().get()
        if (onItemOnclickListener != null) {
            holder.root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = holder.getAdapterPosition();
                    onItemOnclickListener.OnItemClick(pos);
                }
            });
        }

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
        private LinearLayout root;

        public ViewHoder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.Image_title);
            image = (ImageView) itemView.findViewById(R.id.Image_image);
            root = (LinearLayout) itemView.findViewById(R.id.Image_root);
        }
    }
}
