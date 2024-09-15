package com.example.pictureupload.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.pictureupload.R;
import com.example.pictureupload.bean.PhotoListBean;
import com.king.image.imageviewer.ImageViewer;
import com.king.image.imageviewer.loader.GlideImageLoader;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PhotoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_CONTENT = 0;
    private static final int TYPE_FOOTER = 1;

    private List<PhotoListBean.DataBean.RecordsBean> dataList;

    private ProgressBar pbLoading;
    private TextView tvLoadMore;

    public PhotoListAdapter() {
        dataList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_CONTENT) {
            return new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_photo, parent, false));
        } else if (viewType == TYPE_FOOTER) {
            return new FooterViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_footer, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        int type = getItemViewType(position);
        if (type == TYPE_CONTENT) {
            PhotoListBean.DataBean.RecordsBean recordsBean = dataList.get(position);
            Glide.with(context)
                    .load(recordsBean.getAvatar())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                    .into(((ContentViewHolder) holder).avatar);
            ((ContentViewHolder) holder).username.setText(recordsBean.getUsername());
            Date date = new Date(Long.parseLong(recordsBean.getCreateTime()));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            ((ContentViewHolder) holder).createdAt.setText(sdf.format(date));
            ((ContentViewHolder) holder).title.setText(recordsBean.getTitle());
            ((ContentViewHolder) holder).content.setText(recordsBean.getContent());
            if (recordsBean.getImageUrlList().isEmpty()) {
                ((ContentViewHolder) holder).layout.setVisibility(View.GONE);
            } else {
                ImageView[] imgs = new ImageView[]{((ContentViewHolder) holder).img1, ((ContentViewHolder) holder).img2, ((ContentViewHolder) holder).img3};
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
//                ((ContentViewHolder) holder).likeNum.setText(String.valueOf(recordsBean.getLikeNum()));
//                if(recordsBean.isHasLike()){
//                    ((ContentViewHolder) holder).likeIcon.setImageResource(R.drawable.like);
//                }
            }
            // 点击进入详情
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PhotoDetailActivity.class);
//                    intent.putExtra("recordsBean", recordsBean);
                    intent.putExtra("id", recordsBean.getId());
                    intent.putExtra("avatar", recordsBean.getAvatar());
                    context.startActivity(intent);
                }
            });
        } else if (type == TYPE_FOOTER) {
            pbLoading = ((FooterViewHolder) holder).pbLoading;
            tvLoadMore = ((FooterViewHolder) holder).tvLoadMore;
        }
    }

    /**
     * 获取数据集加上一个footer的数量
     */
    @Override
    public int getItemCount() {
        return dataList.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {
            return TYPE_FOOTER;
        } else {
            return TYPE_CONTENT;
        }
    }

    /**
     * 获取数据集的大小
     */
    public int getListSize() {
        return dataList.size();
    }

    /**
     * 将新增数据集添加到尾部,一般用作加载更多F
     */
    public void addAll(List<PhotoListBean.DataBean.RecordsBean> list) {
        dataList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * 将新增数据集添加到前面，一般用作刷新
     */
    public void addFirstAll(List<PhotoListBean.DataBean.RecordsBean> list) {
        dataList.addAll(0, list);
        notifyDataSetChanged();
    }

    /**
     * 清除所有数据
     */
    public void clear() {
        dataList.clear();
        notifyDataSetChanged();
    }

    /**
     * 内容的ViewHolder
     */
    public static class ContentViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView username;
        private TextView createdAt;
        private TextView title;
        private TextView content;
        private LinearLayout layout;
        private ImageView img1;
        private ImageView img2;
        private ImageView img3;
//        private ImageView likeIcon;
//        private TextView likeNum;

        public ContentViewHolder(View itemView) {
            super(itemView);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            username = (TextView) itemView.findViewById(R.id.username);
            createdAt = (TextView) itemView.findViewById(R.id.created_at);
            title = (TextView) itemView.findViewById(R.id.title);
            content = (TextView) itemView.findViewById(R.id.content);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
            img2 = (ImageView) itemView.findViewById(R.id.img2);
            img3 = (ImageView) itemView.findViewById(R.id.img3);
//            likeIcon = (ImageView) itemView.findViewById(R.id.like_icon);
//            likeNum = (TextView) itemView.findViewById(R.id.like_num);
        }
    }

    /**
     * footer的ViewHolder
     */
    public static class FooterViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLoadMore;
        private ProgressBar pbLoading;

        public FooterViewHolder(View itemView) {
            super(itemView);
            tvLoadMore = (TextView) itemView.findViewById(R.id.tv_item_footer_load_more);
            pbLoading = (ProgressBar) itemView.findViewById(R.id.pb_item_footer_loading);
        }
    }

    /**
     * 显示正在加载的进度条
     */
    public void showLoading() {
        if (pbLoading != null && tvLoadMore != null) {
            pbLoading.setVisibility(View.VISIBLE);
            tvLoadMore.setVisibility(View.GONE);
        }
    }

    /**
     * 显示上拉加载的文字
     */
    public void showLoadMore() {
        if (pbLoading != null && tvLoadMore != null) {
            pbLoading.setVisibility(View.GONE);
            tvLoadMore.setVisibility(View.VISIBLE);
        }
    }
}
