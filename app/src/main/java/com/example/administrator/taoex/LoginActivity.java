package com.example.administrator.taoex;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.administrator.taoex.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import butterknife.internal.Utils;

/**
 * Created by Administrator on 2016/11/16 0016.
 * 登录页面
 */

public class LoginActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private String username;
    private String password;
    private ActivityUtils activityUtils;

    //快速注册按钮
    @BindView(R.id.tv_register)
    TextView tv_register;

    //返回箭头按钮
    @BindView(R.id.ib_return)
    ImageButton ib_return;

    //用户名和密码文本框数组
    @BindViews({R.id.et_username,R.id.et_password})
    EditText[] editTexts;

    //登录按钮
    @BindView(R.id.bt_login)
    Button bt_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        unbinder= ButterKnife.bind(this);
        init();
    }

    //初始化
    private void init() {

        activityUtils=new ActivityUtils(this);
        bt_login.setEnabled(false);

        for (int i=0;i<editTexts.length;i++){

            /**
             * EdiText焦点监听
             */
            editTexts[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus){
                        v.setSelected(true);
                    }else {
                        v.setSelected(false);
                    }
                }
            });

            /**
             * EditText文本监听
             */
            editTexts[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                }

                @Override
                public void afterTextChanged(Editable s) {
                    username=editTexts[0].getText().toString();
                    password=editTexts[1].getText().toString();
                    boolean bool=!(TextUtils.isEmpty(username)||TextUtils.isEmpty(password));
                    bt_login.setEnabled(bool);
                }
            });

        }

    }

    /**
     * 添加控件监听
     * @param view
     */
    @OnClick({R.id.ib_return,R.id.tv_register,R.id.bt_login})
    public void onClick(View view){
        switch (view.getId()){
            /**
             * 返回键监听
             */
            case R.id.ib_return:
                finish();
                break;
            /**
             * 快速注册键监听
             */
            case R.id.tv_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            /**
             * 登录按钮监听
             */
            case R.id.bt_login:
                //登录验证代码
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
