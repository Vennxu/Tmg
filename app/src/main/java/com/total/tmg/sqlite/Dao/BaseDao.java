package com.total.tmg.sqlite.Dao;

import android.content.Context;

import com.total.tmg.sqlite.NewsDataBaseHelper;

/**
 * Created by Administrator on 2015/7/18.
 */
public class BaseDao {

    private Context context;
    public NewsDataBaseHelper helpler;

    public BaseDao(Context context) {
        this.context = context;
        helpler = NewsDataBaseHelper.getInstanse(context);
    }


}
