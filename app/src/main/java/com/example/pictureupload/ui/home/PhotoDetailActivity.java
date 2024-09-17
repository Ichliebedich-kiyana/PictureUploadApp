package com.example.pictureupload.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.pictureupload.MyApplication;
import com.example.pictureupload.R;
import com.example.pictureupload.bean.PhotoDetailBean;
import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.android.material.button.MaterialButton;
import com.google.gson.Gson;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * 图片详情(收藏，取消收藏 点赞，取消点赞)
 */
/* PhotoDetailActivity (http 2.用户对图文分享进行收藏 /photo/collect POST || 3.用户取消对图文分享的收藏 /photo/collect/cancel POST || 13.用户对图文分享进行点赞 /photo/like POST || 14.用户取消对图文分享的点赞 /photo/like/cancel POST) || 19.获取单个图文分享的详情 /photo/share/detail GET || 22.保存图文分享 /photo/share/save POST) */
public class PhotoDetailActivity extends AppCompatActivity {

    private ImageView avatar;
    private TextView username;
    private TextView createdAt;
    private TextView title;
    private TextView content;
    private RecyclerView recycler;
    private ImageView collectIcon;
    private TextView collectNum;
    private ImageView likeIcon;
    private TextView likeNum;
    private MaterialButton save;
    private boolean isLike = false;
    private boolean isCollect = false;
    //    private PhotoListBean.DataBean.RecordsBean recordsBean;
    private String likeId;
    private String collectId;
    private PhotoDetailBean.DataBean recordsBean;
    private String shareId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_detail);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("详情");
        bar.setHomeButtonEnabled(true);
        bar.setDisplayHomeAsUpEnabled(true);
        initView();
        initData();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initData() {
//        recordsBean = (PhotoListBean.DataBean.RecordsBean) getIntent().getSerializableExtra("recordsBean");
        shareId = getIntent().getStringExtra("id");
        Glide.with(PhotoDetailActivity.this)
                .load(getIntent().getStringExtra("avatar"))
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(avatar);
        showDetail();
        // 收藏
        collectIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCollect = !isCollect;
                if (isCollect) {    // 收藏
                    HttpUtil.getInstance().doPost("/collect?shareId=" + shareId + "&userId=" + MyApplication.getSp().getString("id", ""), null, new OkCallBack() {
                        @Override
                        public void onSuccess(String response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showDetail();
                                }
                            });
                        }

                        @Override
                        public void onFail(String response) {

                        }
                    });
                } else {    // 取消收藏
                    HttpUtil.getInstance().doPost("/collect/cancel?collectId=" + collectId, new HashMap<>(), new OkCallBack() {
                        @Override
                        public void onSuccess(String response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    collectIcon.setImageResource(R.drawable.not_collect);
                                    collectNum.setText(String.valueOf(Integer.parseInt(collectNum.getText().toString()) - 1));
                                }
                            });
                        }

                        @Override
                        public void onFail(String response) {

                        }
                    });
                }
            }
        });
        // 点赞
        likeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLike = !isLike;
                if (isLike) {    // 点赞
                    HttpUtil.getInstance().doPost("/like?shareId=" + shareId + "&userId=" + MyApplication.getSp().getString("id", ""), null, new OkCallBack() {
                        @Override
                        public void onSuccess(String response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showDetail();
                                }
                            });
                        }

                        @Override
                        public void onFail(String response) {

                        }
                    });
                } else {    // 取消点赞
                    HttpUtil.getInstance().doPost("/like/cancel?likeId=" + likeId, new HashMap<>(), new OkCallBack() {
                        @Override
                        public void onSuccess(String response) throws IOException {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    likeIcon.setImageResource(R.drawable.not_like);
                                    likeNum.setText(String.valueOf(Integer.parseInt(likeNum.getText().toString()) - 1));
                                }
                            });
                        }

                        @Override
                        public void onFail(String response) {

                        }
                    });
                }
            }
        });
        // 保存
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("content", recordsBean.getContent());
                bodyMap.put("imageCode", recordsBean.getImageCode());
                bodyMap.put("pUserId", MyApplication.getSp().getString("id", ""));
                bodyMap.put("title", recordsBean.getTitle());
                HttpUtil.getInstance().doPost("/share/save", bodyMap, new OkCallBack() {
                    @Override
                    public void onSuccess(String response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                save.setVisibility(View.GONE);
                                Toast.makeText(PhotoDetailActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                    @Override
                    public void onFail(String response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PhotoDetailActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    private void showDetail() {
        HttpUtil.getInstance().doGet("/share/detail?shareId=" + shareId + "&userId=" + MyApplication.getSp().getString("id", ""), new OkCallBack() {
            @Override
            public void onSuccess(String response) throws IOException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        PhotoDetailBean photoDetailBean = new Gson().fromJson(response, PhotoDetailBean.class);
                        recordsBean = photoDetailBean.getData();
                        isLike = recordsBean.isHasLike();
                        isCollect = recordsBean.isHasCollect();
                        if (isLike) {
                            likeIcon.setImageResource(R.drawable.like);
                        }
                        likeNum.setText(String.valueOf(recordsBean.getLikeNum()));
                        if (isCollect) {
                            collectIcon.setImageResource(R.drawable.collect);
                        }
                        collectNum.setText(String.valueOf(recordsBean.getCollectNum()));
                        likeId = recordsBean.getLikeId();
                        collectId = recordsBean.getCollectId();
                        if (recordsBean.isHasFocus()) {
                            save.setVisibility(View.GONE);
                        }
                        username.setText(recordsBean.getUsername());
                        Date date = new Date(Long.parseLong(recordsBean.getCreateTime()));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        createdAt.setText(sdf.format(date));
                        title.setText(recordsBean.getTitle());
                        content.setText(recordsBean.getContent());
                        recycler.setLayoutManager(new GridLayoutManager(PhotoDetailActivity.this, 3));
                        recycler.setAdapter(new PhotoImgAdapter((ArrayList<String>) recordsBean.getImageUrlList()));
                    }
                });
            }

            @Override
            public void onFail(String response) {

            }
        });
    }

    private void initView() {
        avatar = (ImageView) findViewById(R.id.avatar);
        username = (TextView) findViewById(R.id.username);
        createdAt = (TextView) findViewById(R.id.created_at);
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        collectIcon = (ImageView) findViewById(R.id.collect_icon);
        collectNum = (TextView) findViewById(R.id.collect_num);
        likeIcon = (ImageView) findViewById(R.id.like_icon);
        likeNum = (TextView) findViewById(R.id.like_num);
        save = (MaterialButton) findViewById(R.id.save);
    }
}