package com.total.tmg.Pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by CNRED002 on 2015/9/24.
 */
public class FishTotalPojo implements Parcelable{

    @DatabaseField(generatedId = true)
    private int _id;
    /**
     * 欠账者名称
     */
    @DatabaseField
    private String name;

    /**
     * 种类名称
     */
    @DatabaseField
    private String type;

    /**
     * 价格
     */
    @DatabaseField
    private String price;

    /**
     * 重量
     */
    @DatabaseField
    private String weight;

    /**
     * 小计
     */
    @DatabaseField
    private String subtotal;

    /**
     * time
     */
    @DatabaseField
    private String time;

    /**
     * 标志是否结清
     */
    @DatabaseField
    private boolean isDebts;

    public FishTotalPojo(){

    }

    protected FishTotalPojo(Parcel in) {
        _id = in.readInt();
        name = in.readString();
        type = in.readString();
        price = in.readString();
        weight = in.readString();
        subtotal = in.readString();
        time = in.readString();
        isDebts = in.readByte() != 0;
    }

    public static final Creator<FishTotalPojo> CREATOR = new Creator<FishTotalPojo>() {
        @Override
        public FishTotalPojo createFromParcel(Parcel in) {
            return new FishTotalPojo(in);
        }

        @Override
        public FishTotalPojo[] newArray(int size) {
            return new FishTotalPojo[size];
        }
    };

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isDebts() {
        return isDebts;
    }

    public void setIsDebts(boolean isDebts) {
        this.isDebts = isDebts;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(_id);
        dest.writeString(name);
        dest.writeString(type);
        dest.writeString(price);
        dest.writeString(weight);
        dest.writeString(subtotal);
        dest.writeString(time);
        dest.writeByte((byte) (isDebts ? 1 : 0));
    }
}
