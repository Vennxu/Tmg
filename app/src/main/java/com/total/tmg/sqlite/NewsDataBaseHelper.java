package com.total.tmg.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.total.tmg.Pojo.FishTotalPojo;
import com.total.tmg.Pojo.FishTotalUserPojo;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/7/18.
 */
public class NewsDataBaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TABLE_NAME = "medical.db";
    private static final int TABLE_VERSION = 2;

    private Map<String, Dao> daos = new HashMap<>();

    public NewsDataBaseHelper(Context context) {
        super(context, TABLE_NAME, null, TABLE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, FishTotalPojo.class);
            TableUtils.createTable(connectionSource, FishTotalUserPojo.class);
        } catch (SQLException e) {
            Log.e(NewsDataBaseHelper.class.getName(), "Unable to create datbases", e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {
        try {
            TableUtils.dropTable(connectionSource, FishTotalPojo.class, true);
            TableUtils.dropTable(connectionSource, FishTotalUserPojo.class, true);
            onCreate(sqLiteDatabase, connectionSource);
        } catch (SQLException e) {
            Log.e(NewsDataBaseHelper.class.getName(), "Unable to upgrade database from version " + i + " to new "
                    + i1, e);
        }
    }

    private static NewsDataBaseHelper instanse = null;

    private static synchronized void initInstance(Context context) {
        if (instanse == null) {
            instanse = new NewsDataBaseHelper(context.getApplicationContext());
        }
    }

    public static NewsDataBaseHelper getInstanse(Context context) {
        if (instanse == null) {
            initInstance(context);
        }
        return instanse;
    }

    public synchronized Dao getDao(Class clazz) throws SQLException {
        Dao dao = null;
        String className = clazz.getSimpleName();
        if (daos.containsKey(className)) {
            dao = daos.get(className);
        }
        if (dao == null) {
            dao = super.getDao(clazz);
            daos.put(className, dao);
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        for (String key : daos.keySet()) {
            Dao dao = daos.get(key);
            dao = null;
        }
    }
}
