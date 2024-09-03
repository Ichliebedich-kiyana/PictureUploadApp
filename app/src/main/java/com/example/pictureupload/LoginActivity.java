package com.example.pictureupload;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pictureupload.util.HttpUtil;
import com.example.pictureupload.util.OkCallBack;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * 登录
 */
public class LoginActivity extends AppCompatActivity {

    private TextInputEditText username;
    private TextInputEditText pwd;
    private MaterialButton login;
    private TextView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        username = (TextInputEditText) findViewById(R.id.username);
        pwd = (TextInputEditText) findViewById(R.id.pwd);
        login = (MaterialButton) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);
        // 登录
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameStr = username.getText().toString();
                String pwdStr = pwd.getText().toString();
                if (TextUtils.isEmpty(usernameStr) || TextUtils.isEmpty(pwdStr)) {
                    Toast.makeText(LoginActivity.this, "用户名或密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                HttpUtil.getInstance().doPost("/user/login?password=" + pwdStr + "&username=" + usernameStr, new HashMap<String, Object>(), new OkCallBack() {
                            @Override
                            public void onSuccess(String response) throws IOException {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            MyApplication.getEditor().putString("id", jsonObject.getJSONObject("data").getString("id")).commit();
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                        Log.d("zzz", "run: " + response);
                                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    }
                                });
                            }

                            @Override
                            public void onFail(String response) {
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                );
            }
        });
        // 注册
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

}