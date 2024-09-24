package com.example.pictureupload.ui.dashboard;

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
import com.example.pictureupload.bean.MySelfBean;
import com.example.pictureupload.databinding.FragmentDashboardBinding;
import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class DashboardFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private FragmentDashboardBinding binding;
    private Handler handler;
    private MySelfPhotoListAdapter mySelfPhotoListAdapter;
    private LinearLayoutManager layoutManager;
    private int current = 1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        handler = new Handler(Looper.getMainLooper());
        initData();
        return root;
    }

    private void initData() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding.refresh.setColorSchemeResources(R.color.purple_200, R.color.purple_700);//设置刷新时进度条颜色，最多四种
//        binding.refresh.setOnRefreshListener(this);
//        mySelfPhotoListAdapter = new MySelfPhotoListAdapter();//自定义的适配器
//        binding.recycler.setAdapter(mySelfPhotoListAdapter);
//        layoutManager = new LinearLayoutManager(getActivity());
//        binding.recycler.setLayoutManager(layoutManager);
//        binding.recycler.addOnScrollListener(new OnRecyclerScrollListener());
        getPhotoList();
    }

    private void getPhotoList() {
        // 网络获取数据
        HttpUtil.getInstance().doGet("/share/myself?current=" + current + "&size=10&userId=" + MyApplication.getSp().getString("id", ""), new OkCallBack() {
            @Override
            public void onSuccess(String response) {
                handler.post(() -> {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        if(!jsonObject.getString("data").equals("null")){
                            Log.d("zzz", "run: " + response);
                            MySelfBean mySelfBean = new Gson().fromJson(response, MySelfBean.class);
                            binding.recycler.setAdapter(new AddListAdapter(mySelfBean.getData().getRecords() ));
                        }
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
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

            if (mySelfPhotoListAdapter != null && newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == mySelfPhotoListAdapter.getItemCount()) {
                //滚动到底部了，可以进行数据加载等操作
                mySelfPhotoListAdapter.showLoading();
                // 页数+1
                current++;
                getPhotoList();
                mySelfPhotoListAdapter.showLoadMore();
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