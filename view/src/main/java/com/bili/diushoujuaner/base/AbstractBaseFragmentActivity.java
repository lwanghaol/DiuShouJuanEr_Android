package com.bili.diushoujuaner.base;

/**
 * Created by BiLi on 2016/2/28.
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.bili.diushoujuaner.R;
import com.bili.diushoujuaner.application.CustomApplication;
import com.bili.diushoujuaner.presenter.base.BasePresenter;
import com.bili.diushoujuaner.utils.manager.ActivityManager;
import com.bili.diushoujuaner.utils.manager.SystemBarTintManager;

import butterknife.ButterKnife;

public abstract class AbstractBaseFragmentActivity extends FragmentActivity implements IBaseActivity{

    public final String TAG = getClass().getSimpleName();
    public Context context;
    public CustomApplication customApplication;
    public SystemBarTintManager tintManager;
    protected BasePresenter basePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        context = this;
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(true);
        }
        tintStatusColor();
        ActivityManager.getInstance().addActivity(this);
        customApplication = (CustomApplication) this.getApplication();

        initIntentParam(getIntent());
        beforeInitView();
        initView();
        ButterKnife.bind(this);
        setViewStatus();
    }

    /**
     * 为状态栏着色
     */
    public void tintStatusColor() {
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setStatusBarTintResource(R.color.COLOR_THEME);
    }

    @TargetApi(19)
    private void setTranslucentStatus(boolean on) {
        Window win = getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

    @Override
    protected void onDestroy() {
        onPageDestroy();
        ButterKnife.unbind(this);
        super.onDestroy();
        basePresenter.detachView();
        ActivityManager.getInstance().removeActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        onPagePause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onPageResume();
    }

    @Override
    public void setContentView(int layout) {
        ViewGroup mainView = (ViewGroup) LayoutInflater.from(this).inflate(
                layout, null);
        setContentView(mainView);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
    }

}
