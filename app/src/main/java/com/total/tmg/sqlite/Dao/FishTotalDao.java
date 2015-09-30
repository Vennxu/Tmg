package com.total.tmg.sqlite.Dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.total.tmg.Pojo.FishTotalPojo;
import com.total.tmg.Pojo.FishTotalUserPojo;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Administrator on 2015/7/18.
 */
public class FishTotalDao extends BaseDao {

    private Dao<FishTotalPojo, Integer> dao;

    public FishTotalDao(Context context){
        super(context);
        try {
            dao = helpler.getDao(FishTotalPojo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(FishTotalPojo classPojo){
        try {
            dao.create(classPojo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FishTotalPojo> queryAll(){
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(FishTotalPojo fishTotalPojo){
        try {
            dao.createOrUpdate(fishTotalPojo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteAll() {
        try {
            dao.queryRaw("delete from tb_class");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
