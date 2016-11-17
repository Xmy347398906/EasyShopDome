package com.example.administrator.taoex.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.taoex.R;

/**
 * Created by Administrator on 2016/11/16 0016.
 */

public class UnLoginFragment extends Fragment {
    public UnLoginFragment(){
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_un_login,container,false);
        return view;
    }
}
