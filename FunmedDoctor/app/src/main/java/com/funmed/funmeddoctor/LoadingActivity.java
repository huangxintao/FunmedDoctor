package com.funmed.funmeddoctor;

import android.content.Intent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.funmed.funmeddoctor.bean.UserBean;
import com.funmed.funmeddoctor.data.UserData;
import com.funmed.funmeddoctor.home.activity.MainTabActivity;
import com.funmed.funmeddoctor.mine.activity.LoginActivity;

import butterknife.Bind;
import me.murphy.common.base.BaseActivity;


/**
 * Created by tony on 2017/7/18.
 */

public class LoadingActivity extends BaseActivity {


    @Bind(R.id.mImageView)
    ImageView mImageView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_loading;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initVariable() {

    }

    @Override
    public void initView() {
        startanno();
        SetTranslanteBar();
    }
    public void startanno(){
        // 渐变展示启动屏
        AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
        aa.setDuration(500);
        mImageView.startAnimation(aa);
        aa.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationEnd(Animation arg0)
            {
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        super.run();
                        int time = 0;
                        while (time < 1)
                        {
                            try
                            {
                                if(isLogin())
                                {
                                    time = 1;
                                }
                                else
                                {
                                    sleep(1000);
                                    time++;
                                }
                            }
                            catch (InterruptedException e)
                            {
                                e.printStackTrace();
                            }
                        }
                        enterNextActivity();
                    }
                }.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation)
            {

            }

            @Override
            public void onAnimationStart(Animation animation)
            {

            }
        });
    }

    /**
     * 是否登录
     * @return
     */
    public boolean isLogin()
    {
        UserBean userBean = UserData.getInstance().getUserBean();
        if(userBean != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * 进入下一个界面
     */
    public void enterNextActivity()
    {
        Intent intent = null;
        if(isLogin())
        {
            intent = new Intent(LoadingActivity.this, MainTabActivity.class);
        }
        else
        {
            intent = new Intent(LoadingActivity.this, LoginActivity.class);
//            intent.putExtra("from", IConstants.StringData.LOADING);
//            intent = new Intent(LoadingActivity.this, MainTabActivity.class);
        }
        startActivity(intent);
        LoadingActivity.this.finish();
    }
}
