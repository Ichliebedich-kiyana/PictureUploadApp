package com.example.pictureupload.ui.collect;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.pictureupload.MyApplication;
import com.example.pictureupload.bean.CollectBean;
import com.example.pictureupload.databinding.FragmentCollectBinding;
import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 我的收藏
 */
public class CollectFragment extends Fragment {

    private FragmentCollectBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentCollectBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        initData();
        return root;
    }

    private void initData() {
        binding.recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        // 网络获取数据
        HttpUtil.getInstance().doGet("/collect?current=1&size=100&userId=" + MyApplication.getSp().getString("id", ""), new OkCallBack() {
            @Override
            public void onSuccess(String response) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(!jsonObject.getString("data").equals("null")){
                                Log.d("zzz", "run: " + response);
                                CollectBean collectBean = new Gson().fromJson(response, CollectBean.class);
                                binding.recycler.setAdapter(new CollectListAdapter(collectBean.getData().getRecords()));
                            }
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
            }

            @Override
            public void onFail(String response) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // 显示错误提示或其他处理
                        Toast.makeText(getActivity(), "请求失败: " + response, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}