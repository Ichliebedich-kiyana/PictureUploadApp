package com.example.pictureupload;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;
import java.util.HashMap;

/**
 * 注册
 */
public class RegisterActivity extends AppCompatActivity {

    private TextInputEditText username;
    private TextInputEditText pwd;
    private MaterialButton register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar bar = getSupportActionBar();
        bar.setTitle("注册");
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        initView();
    }

    private void initView() {
        username = (TextInputEditText) findViewById(R.id.username);
        pwd = (TextInputEditText) findViewById(R.id.pwd);
        register = (MaterialButton) findViewById(R.id.register);
        // 注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStr = username.getText().toString();
                String pwdStr = pwd.getText().toString();
                if (TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(pwdStr)) {
                    Toast.makeText(RegisterActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("username", usernameStr);
                map.put("password", pwdStr);
                HttpUtil.getInstance().doPost("/user/register", map, new OkCallBack() {
                    @Override
                    public void onSuccess(String response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onFail(String response) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }
}