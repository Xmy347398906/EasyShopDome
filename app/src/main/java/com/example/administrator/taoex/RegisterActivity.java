package com.example.administrator.taoex;

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

import com.example.administrator.taoex.components.AlertDialogFragment;
import com.example.administrator.taoex.network.EasyShopClient;
import com.example.administrator.taoex.utils.RegexUtils;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/16 0016.
 * 快速注册页面
 */

public class RegisterActivity extends AppCompatActivity {
    private Unbinder unbinder;
    private String username,password,confirmPassword;
    private EasyShopClient okHttpClient=EasyShopClient.getEasyShopClient();

    @BindViews({R.id.et_username,R.id.et_password,R.id.et_ConfirmPassword})
    EditText[] editTexts;

    @BindView(R.id.ib_return)
    ImageButton ib_return;

    @BindView(R.id.bt_register)
    Button bt_register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        unbinder= ButterKnife.bind(this);
        init();
    }

    //初始化
    private void init() {
        for (int i = 0; i < editTexts.length; i++) {
            //EditTest的焦点监听
            editTexts[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        v.setSelected(true);
                    } else {
                        v.setSelected(false);
                    }
                }
            });

            //EditTest的文本监听
            editTexts[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    username=editTexts[0].getText().toString();
                    password=editTexts[1].getText().toString();
                    confirmPassword=editTexts[2].getText().toString();
                    boolean bool=!(TextUtils.isEmpty(username)||TextUtils.isEmpty(password)||TextUtils.isEmpty(confirmPassword));
                    bt_register.setEnabled(bool);
                }

                @Override
                public void afterTextChanged(Editable s) {}
            });

        }

    }


    @OnClick({R.id.ib_return,R.id.bt_register})
    public void onClick(View view)
    {
        switch (view.getId())
        {
            //返回键监听
            case R.id.ib_return:
                finish();
                break;
            case R.id.bt_register:{
                if (RegexUtils.verifyUsername(username) != RegexUtils.VERIFY_SUCCESS) {
                    String msg = getString(R.string.username_rules);
                    showUserPasswordError(msg);
                    return;
                } else if (RegexUtils.verifyPassword(password) != RegexUtils.VERIFY_SUCCESS) {
                    String msg = getString(R.string.password_rules);
                    showUserPasswordError(msg);
                    return;
                } else if (!TextUtils.equals(password, confirmPassword)) {
                    String msg = getString(R.string.username_equal_pwd);
                    showUserPasswordError(msg);
                    return;
                }
            }
                break;
        }

    }



    //显示错误提示
    private void showUserPasswordError(String msg) {
        AlertDialogFragment fragment=AlertDialogFragment.newInstance(msg);
        fragment.show(getSupportFragmentManager(),getString(R.string.username_pwd_rule));

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
