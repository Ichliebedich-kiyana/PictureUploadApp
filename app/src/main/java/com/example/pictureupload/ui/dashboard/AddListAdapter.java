package com.example.pictureupload.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.pictureupload.R;
import com.example.pictureupload.bean.MySelfBean;
import com.example.pictureupload.ui.home.PhotoDetailActivity;
import com.king.image.imageviewer.ImageViewer;
import com.king.image.imageviewer.loader.GlideImageLoader;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddListAdapter extends RecyclerView.Adapter<AddListAdapter.ViewHolder> {

    private List<MySelfBean.DataBean.RecordsBean> lists;
    private ImageView avatar;
    private TextView username;
    private TextView createdAt;
    private TextView title;
    private TextView content;
    private LinearLayout layout;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;

    public AddListAdapter(List<MySelfBean.DataBean.RecordsBean> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_photo, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        MySelfBean.DataBean.RecordsBean recordsBean = lists.get(position);
        Glide.with(context)
                .load(recordsBean.getAvatar())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(avatar);
        username.setText(recordsBean.getUsername().toString());
        Date date = new Date(Long.parseLong(recordsBean.getCreateTime()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        createdAt.setText(sdf.format(date));
        title.setText(recordsBean.getTitle());
        content.setText(recordsBean.getContent());
        if (recordsBean.getImageUrlList().isEmpty()) {
            layout.setVisibility(View.GONE);
        } else {
            ImageView[] imgs = new ImageView[]{img1, img2, img3};
            for (int i = 0; i < Math.min(recordsBean.getImageUrlList().size(), 3); i++) {
                Glide.with(context)
                        .load(recordsBean.getImageUrlList().get(i))
                        .into(imgs[i]);
                int finalI = i;
                imgs[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageViewer.load(recordsBean.getImageUrlList().get(finalI))
                                .imageLoader(new GlideImageLoader())
                                .start((Activity) context, imgs[finalI]);
                    }
                });
            }
        }
        // 点击进入详情
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoDetailActivity.class);
                intent.putExtra("id", recordsBean.getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;

    }

    private void initView(View itemView) {
        avatar = (ImageView) itemView.findViewById(R.id.avatar);
        username = (TextView) itemView.findViewById(R.id.username);
        createdAt = (TextView) itemView.findViewById(R.id.created_at);
        title = (TextView) itemView.findViewById(R.id.title);
        content = (TextView) itemView.findViewById(R.id.content);
        layout = (LinearLayout) itemView.findViewById(R.id.layout);
        img1 = (ImageView) itemView.findViewById(R.id.img1);
        img2 = (ImageView) itemView.findViewById(R.id.img2);
        img3 = (ImageView) itemView.findViewById(R.id.img3);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            initView(itemView);
        }
    }
}
