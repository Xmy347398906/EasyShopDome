package com.example.administrator.taoex.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.administrator.taoex.fragment.MeFragment;
import com.example.administrator.taoex.fragment.ShopFragment;
import com.example.administrator.taoex.fragment.UnLoginFragment;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class UnLoginAdapter extends FragmentStatePagerAdapter {
    public UnLoginAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            //市场
            case 0:
                return new ShopFragment();
            //消息
            case 1:
                return new UnLoginFragment();
            //通讯录
            case 2:
                return new UnLoginFragment();
            //我的
            case 3:
                return new MeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
