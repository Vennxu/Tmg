package com.total.tmg;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.total.tmg.Pojo.FishTotalPojo;
import com.total.tmg.Pojo.FishTotalUserPojo;
import com.total.tmg.sqlite.Dao.FishTotalDao;
import com.total.tmg.sqlite.Dao.FishTotalUserDao;

/**
 * Created by CNRED002 on 2015/9/24.
 */
public class AddTmgActivity extends BaseActivity implements View.OnClickListener {

    private EditText mNameEdit;
    private EditText mWeightEdit;
    private EditText mTypeEdit;
    private EditText mPriceEdit;
    private EditText mTimeEdit;
    private Button mKeepBtn;

    private String mName;
    private String mType;
    private String mPrice;
    private String mTime;
    private String mWeight;

    private FishTotalDao mFishTotalDao;
    private FishTotalUserDao mFishTotalUserDao;

    @Override
    protected int getContentView() {
        return R.layout.activity_addtmg;
    }

    @Override
    protected void initContentView() {
        initTitleBar();
        setTitleText("添加");
        showLeftTitle();
        mNameEdit = (EditText) findViewById(R.id.add_name);
        mTypeEdit = (EditText) findViewById(R.id.add_type_name);
        mTimeEdit = (EditText) findViewById(R.id.add_time);
        mPriceEdit = (EditText) findViewById(R.id.add_price);
        mWeightEdit = (EditText) findViewById(R.id.add_weight);
        mKeepBtn = (Button) findViewById(R.id.add_keep);
        mKeepBtn.setOnClickListener(this);
    }

    @Override
    protected void initContentData() {
        mFishTotalDao = new FishTotalDao(this);
        mFishTotalUserDao = new FishTotalUserDao(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_keep:
                save();
                break;
            default:
                break;
        }
    }

    private void save() {
        mName = mNameEdit.getText().toString().trim().replace(" ", "");
        mType = mTypeEdit.getText().toString().trim().replace(" ", "");
        mTime = mTimeEdit.getText().toString().trim().replace(" ", "");
        mPrice = mPriceEdit.getText().toString().trim().replace(" ", "");
        mWeight = mWeightEdit.getText().toString().trim().replace(" ", "");

        if (TextUtils.isEmpty(mName) || TextUtils.isEmpty(mType) || TextUtils.isEmpty(mTime)
                || TextUtils.isEmpty(mPrice) || TextUtils.isEmpty(mWeight)) {
            return;
        }
        FishTotalUserPojo user = mFishTotalUserDao.queryName(mName);
        if (user == null) {
            user = new FishTotalUserPojo();
            user.setName(mName);
            mFishTotalUserDao.add(user);
            user =  mFishTotalUserDao.queryName(mName);
        }
        FishTotalPojo fishTotalPojo = new FishTotalPojo();
        fishTotalPojo.setName(String.valueOf(user.get_id()));
        fishTotalPojo.setPrice(mPrice);
        fishTotalPojo.setTime(mTime);
        fishTotalPojo.setWeight(mWeight);
        fishTotalPojo.setType(mType);
        float weight = Float.parseFloat(mWeight);
        float price  = Float.parseFloat(mPrice);
        float subtotal = weight * price;
        fishTotalPojo.setSubtotal(String.valueOf(subtotal));
        fishTotalPojo.setIsDebts(true);
        mFishTotalDao.add(fishTotalPojo);
        finish();
    }
}
