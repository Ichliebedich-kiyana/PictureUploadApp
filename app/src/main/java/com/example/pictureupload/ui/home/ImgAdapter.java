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

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ViewHolder> {

    private ArrayList<String> lists;
    private OnItemClickListener mListener;


    public ImgAdapter(ArrayList<String> lists, OnItemClickListener mListener) {
        this.lists = lists;
        this.mListener = mListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = viewHolder.getAdapterPosition();
                    mListener.onItemClick(position);
                }
            }
        });
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
        return lists.size() == 3 ? 3 : lists.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView itemImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImg = (AppCompatImageView) itemView.findViewById(R.id.item_img);
        }
    }
}
