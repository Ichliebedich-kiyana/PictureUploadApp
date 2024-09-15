package com.example.pictureupload.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.pictureupload.MyApplication;
import com.example.pictureupload.R;
import com.example.pictureupload.bean.PhotoListBean;
import com.example.pictureupload.databinding.FragmentHomeBinding;
import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.gson.Gson;

/*
 *   首页列表
 *  */
/* http(15.获取图片分享发现列表 /photo/share GET) */
public class HomeFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private FragmentHomeBinding binding;
    private Handler handler;
    private PhotoListAdapter photoListAdapter;
    private LinearLayoutManager layoutManager;
    private int current = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        handler = new Handler(Looper.getMainLooper());
        initData();
        return root;
    }

    private void initData() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.refresh.setColorSchemeResources(R.color.purple_200, R.color.purple_700);//设置刷新时进度条颜色，最多四种
        binding.refresh.setOnRefreshListener(this);
        photoListAdapter = new PhotoListAdapter();//自定义的适配器
        binding.recycler.setAdapter(photoListAdapter);
        layoutManager = new LinearLayoutManager(getActivity());
        binding.recycler.setLayoutManager(layoutManager);
        binding.recycler.addOnScrollListener(new OnRecyclerScrollListener());
        getPhotoList();
        // 发布
        binding.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), PhotoAddActivity.class));
            }
        });
    }

    private void getPhotoList() {
        // 网络获取数据
        HttpUtil.getInstance().doGet("/share?current=" + current + "&size=10&userId=" + MyApplication.getSp().getString("id", ""), new OkCallBack() {
            @Override
            public void onSuccess(String response) {
                handler.post(() -> {
                    Log.d("zzz", "run: " + response);
                    PhotoListBean photoListBean = new Gson().fromJson(response, PhotoListBean.class);
                    if (current == 1) {
                        photoListAdapter.clear();
                    }
                    photoListAdapter.addAll(photoListBean.getData().getRecords());
                });
            }

            @Override
            public void onFail(String response) {
                handler.post(() -> {
                    // 显示错误提示或其他处理
                    Toast.makeText(getActivity(), "请求失败: " + response, Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    /**
     * 用于上拉加载更多
     */
    public class OnRecyclerScrollListener extends RecyclerView.OnScrollListener {

        int lastVisibleItem = 0;

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);

            if (photoListAdapter != null && newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == photoListAdapter.getItemCount()) {
                //滚动到底部了，可以进行数据加载等操作
                photoListAdapter.showLoading();
                // 页数+1
                current++;
                getPhotoList();
                photoListAdapter.showLoadMore();
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            lastVisibleItem = layoutManager.findLastVisibleItemPosition();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onRefresh() {
        // 下拉刷新
        binding.refresh.setRefreshing(true);
        // 回到第一页
        current = 1;
        getPhotoList();
        binding.refresh.setRefreshing(false);
    }
}