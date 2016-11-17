package com.example.administrator.taoex;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.taoex.adapter.UnLoginAdapter;
import com.example.administrator.taoex.utils.ActivityUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2016/11/16 0016.
 * 主页面
 */
public class MainActivity extends AppCompatActivity {
    Unbinder unbinder;

    //下方导航菜单按钮集合
    @BindViews({R.id.tv_market,R.id.tv_msg,R.id.tv_tel,R.id.tv_my})
    List<TextView> textViews;

    //主页面视图
    @BindView(R.id.vp_pager)
    ViewPager vp_pager;

    //标题
    @BindView(R.id.tv_title)
    TextView tv_title;

    //标题栏
    @BindView(R.id.tb_toolbar)
    Toolbar toolbar;

    private boolean isExit=false;
    private ActivityUtils activityUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder=ButterKnife.bind(this);

        //Toast工具类
        activityUtils=new ActivityUtils(this);

        //添加标题栏Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        init();
    }


    /**
     * 初始化
     */
    private void init() {
        textViews.get(0).setSelected(true);
        vp_pager.setAdapter(new UnLoginAdapter(getSupportFragmentManager()));
        vp_pager.setCurrentItem(0);

        vp_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //textView选择处理
                for (TextView textView:textViews){
                    textView.setSelected(false);
                }
                tv_title.setText(textViews.get(position).getText());
                textViews.get(position).setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /**
     * 下方导航菜单栏的监听
     * @param view
     */
    @OnClick({R.id.tv_market,R.id.tv_msg,R.id.tv_tel,R.id.tv_my})
    public void onClick(TextView view){
        for (int i=0;i<textViews.size();i++)
        {
            textViews.get(i).setSelected(false);
            textViews.get(i).setTag(i);
        }
        view.setSelected(true);
        vp_pager.setCurrentItem((Integer) view.getTag(),false);
        tv_title.setText(textViews.get((Integer) view.getTag()).getText());
    }

    /**
     * 重新系统返回键--双击退出
     */
    @Override
    public void onBackPressed() {
        if (!isExit){
            isExit=true;
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            //
            vp_pager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit=false;
                }
            },2000);
        }else{
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
