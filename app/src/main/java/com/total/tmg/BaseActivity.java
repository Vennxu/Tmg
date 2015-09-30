package com.total.tmg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CNRED002 on 2015/9/29.
 */
public abstract class BaseActivity extends Activity {

    private TextView mTitle;
    private TextView mBack;
    private TextView mRightTitle;
    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext = this;
        initContentData();
        initContentView();
    }

    protected abstract int getContentView();

    protected abstract void initContentData();

    protected abstract void initContentView();

    protected void initTitleBar(){
        mTitle = (TextView) findViewById(R.id.title_bar_title);
        mBack = (TextView) findViewById(R.id.title_bar_back);
        mRightTitle = (TextView) findViewById(R.id.title_bar_right);
    }

    protected void showRightTitle(){
        mTitle.setVisibility(View.VISIBLE);
    }

    protected void showLeftTitle(){
        mBack.setVisibility(View.VISIBLE);
    }

    protected void setTitleText(String title){
        mTitle.setText(title);
    }

    protected void setmBackClick(View.OnClickListener onClickListener){
        mBack.setOnClickListener(onClickListener);
    }

    protected void setmRightTitleClick(View.OnClickListener onClickListener){
        mRightTitle.setOnClickListener(onClickListener);
    }
}
