package com.example.administrator.taoex.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.taoex.LoginActivity;
import com.example.administrator.taoex.R;
import com.example.administrator.taoex.view.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/16 0016.
 * 我的信息页面
 */

public class MeFragment extends Fragment {

    Unbinder unbinder;

    @BindView(R.id.tv_nickname)
    TextView tv_nickname;

    @BindView(R.id.iv_headPortrait)
    RoundedImageView iv_headPortrait;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_me, container, false);
        unbinder=ButterKnife.bind(this,view);
        return view;
    }


    /**
     * 给控件添加监听
     * @param v
     */
    @OnClick({R.id.tv_nickname,R.id.iv_headPortrait,R.id.tv_userInfo,R.id.tv_myCommodity,R.id.tv_uploadingCommodity})
    public void onClick(View v) {
        //if判断是否登录再跳转
        startActivity(new Intent(getActivity(), LoginActivity.class));
//        switch (v.getId()){
//            /**
//             * 昵称文本显示区域的点击监听
//             */
//            case R.id.tv_nickname:
//                //startActivity(new Intent(getActivity(), LoginActivity.class));
//                break;
//            /**
//             * 头像显示区域的点击监听
//             */
//            case R.id.iv_headPortrait:
//                //startActivity(new Intent(getActivity(), LoginActivity.class));
//                break;
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
