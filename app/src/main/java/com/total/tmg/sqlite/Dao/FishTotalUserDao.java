package com.total.tmg.sqlite.Dao;

import android.content.Context;


import com.j256.ormlite.dao.Dao;
import com.total.tmg.Pojo.FishTotalUserPojo;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by Administrator on 2015/7/18.
 */
public class FishTotalUserDao extends BaseDao {

    private Dao<FishTotalUserPojo, Integer> dao;

    public FishTotalUserDao(Context context) {
        super(context);
        try {
            dao = helpler.getDao(FishTotalUserPojo.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(FishTotalUserPojo classPojo) {
        try {
            dao.create(classPojo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<FishTotalUserPojo> queryAll() {
        try {
            return dao.queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteAll() {
        try {
            dao.queryRaw("delete from tb_class");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FishTotalUserPojo queryName(String username) {
        try {
            List<FishTotalUserPojo> users = dao.queryBuilder().where().eq("name", username).query();
            if (users.size() > 0) {
                return users.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
