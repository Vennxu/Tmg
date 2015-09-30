package com.total.tmg.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2015/7/17.
 */
@DatabaseTable(tableName = "tb_class")
public class FishTotalUserPojo implements Parcelable {

    @DatabaseField(generatedId = true)
    private int _id;
    /**
     * 欠账者名称
     */
    @DatabaseField
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public FishTotalUserPojo() {

    }

    protected FishTotalUserPojo(Parcel in) {
        _id = in.readInt();
        name = in.readString();
    }

    public static final Creator<FishTotalUserPojo> CREATOR = new Creator<FishTotalUserPojo>() {
        @Override
        public FishTotalUserPojo createFromParcel(Parcel in) {
            return new FishTotalUserPojo(in);
        }

        @Override
        public FishTotalUserPojo[] newArray(int size) {
            return new FishTotalUserPojo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
    }
}
