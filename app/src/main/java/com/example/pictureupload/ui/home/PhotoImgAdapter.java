package com.example.pictureupload.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.pictureupload.R;

import java.util.ArrayList;

public class PhotoImgAdapter extends RecyclerView.Adapter<PhotoImgAdapter.ViewHolder> {

    private ArrayList<String> lists;

    public PhotoImgAdapter(ArrayList<String> lists) {
        this.lists = lists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Context context = holder.itemView.getContext();
        if (position < lists.size()) {
            Glide.with(context).load(lists.get(position)).apply(RequestOptions.bitmapTransform(new RoundedCorners(10))).into(holder.itemImg);
        }
        if (position == 3) {
            holder.itemImg.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView itemImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = (AppCompatImageView) itemView.findViewById(R.id.item_img);
        }
    }
}
