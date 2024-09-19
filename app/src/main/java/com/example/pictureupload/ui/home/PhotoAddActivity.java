package com.example.pictureupload.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donkingliang.imageselector.utils.ImageSelector;
import com.example.pictureupload.MyApplication;
import com.example.pictureupload.R;
import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 新增图文分享（上传）
 */
/* PhotoAddActivity (http 16.新增图文分享 /photo/share/add POST PhotoAddActivity || 11.上传文件 /photo/image/upload POST) */
public class PhotoAddActivity extends AppCompatActivity implements ImgAdapter.OnItemClickListener {

    private EditText title;
    private EditText content;
    private RecyclerView recycler;
    private MaterialButton submit;
    private ArrayList<String> imgs = new ArrayList<>(); // 存放图片路径
    private boolean isAdd = true; // 是否可上传
    private String imageCode = ""; // 上传图片返回的code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_add);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("分享图文");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        initView();
        initData();
    }

    private void initData() {
        recycler.setLayoutManager(new GridLayoutManager(this, 3));
        recycler.setAdapter(new ImgAdapter(imgs, this));
        // 发布
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = title.getText().toString();
                String s2 = content.getText().toString();
                if (TextUtils.isEmpty(s1) || TextUtils.isEmpty(s2) || TextUtils.isEmpty(imageCode)) {
                    Toast.makeText(PhotoAddActivity.this, "内容填写不完整", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> bodyMap = new HashMap<>();
                bodyMap.put("content", s2);
                bodyMap.put("imageCode", imageCode);
                bodyMap.put("pUserId", MyApplication.getSp().getString("id", ""));
                bodyMap.put("title", s1);
                // 调用接口上传图文
                HttpUtil.getInstance().doPost("/share/add", bodyMap, new OkCallBack() {
                    @Override
                    public void onSuccess(String response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PhotoAddActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onFail(String response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(PhotoAddActivity.this, "发布失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        // 上传图片
        if (position == imgs.size() && isAdd) {
            //多选(最多9张)
            ImageSelector.builder()
                    .useCamera(true) // 设置是否使用拍照
                    .setSingle(false)  //设置是否单选
                    .canPreview(true) //是否点击放大图片查看,，默认为true
                    .setMaxSelectCount(9) // 图片的最大选择数量，小于等于0时，不限数量。
                    .setSelected(imgs)
                    .start(PhotoAddActivity.this, 10000); // 打开相册
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10000 && data != null) {
            //获取选择器返回的数据
            imgs = data.getStringArrayListExtra(ImageSelector.SELECT_RESULT);
            // 上传服务器
            HttpUtil.getInstance().uploadImage("/image/upload", imgs, new OkCallBack() {
                @Override
                public void onSuccess(String response) throws IOException {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                imageCode = jsonObject.getJSONObject("data").getString("imageCode");
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }

                @Override
                public void onFail(String response) {

                }
            });
            // 展示上传的图片
            recycler.setAdapter(new ImgAdapter(imgs, this));
            // 达到最大上传图片，设置不能上传
            if (imgs.size() == 3) {
                isAdd = false;
            }
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    private void initView() {
        title = (EditText) findViewById(R.id.title);
        content = (EditText) findViewById(R.id.content);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        submit = (MaterialButton) findViewById(R.id.submit);
    }
}