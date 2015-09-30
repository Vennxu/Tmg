package com.total.tmg;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVMobilePhoneVerifyCallback;
import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.RequestMobileCodeCallback;
import com.total.tmg.utils.NetworkUtils;
import com.total.tmg.utils.ToastUtil;
import com.total.tmg.utils.Validation;


/**
 * Created on 2015/9/29.
 *
 * @author Xu wenxiang
 */
public class RegisteredActivity extends BaseActivity implements View.OnClickListener {

    private EditText mPhoneEdit;
    private EditText mVerificationEdit;
    private EditText mPasswordEdit;
    private EditText mOkPasswordEdit;

    private Button mGetCode;
    private Button mRegisterFinish;

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initContentData() {


    }

    @Override
    protected void initContentView() {
        initTitleBar();
        showLeftTitle();
        mPhoneEdit = (EditText) findViewById(R.id.register_phone);
        mVerificationEdit = (EditText) findViewById(R.id.register_verification);
        mGetCode = (Button) findViewById(R.id.register_get_code);
        mRegisterFinish = (Button) findViewById(R.id.register_finish);

        mGetCode.setOnClickListener(this);
        mRegisterFinish.setOnClickListener(this);
        setmBackClick(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_get_code:
                getVerificationCode();
                break;
            case R.id.register_finish:
                login();
                break;
            default:
                break;
        }
    }

    private void login() {
        String phone = mPhoneEdit.getText().toString();
        String code = mVerificationEdit.getText().toString();

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code)){
            ToastUtil.showToast(this, "不能为空");
            return;
        }

        if (!NetworkUtils.isNetworkAvailable(this)) {
            ToastUtil.showToast(this, "网络未连接");
            return;
        }

        if (!Validation.isMobileNO(phone)) {
            ToastUtil.showToast(this, "手机号格式不正确");
            return;
        }

        if (code.length() < 6 || code.length() > 6) {
            ToastUtil.showToast(this, "验证码格式不正确");
            return;
        }

        AVUser.signUpOrLoginByMobilePhoneInBackground(phone, code, new LogInCallback<AVUser>() {
            public void done(AVUser user, AVException e) {
                AVUser user1 = user;
                Intent intent = new Intent(mContext, MainActivity.class);
                startActivity(intent);
                Log.d("user", user.toString());
            }
        });

    }

    private void getVerificationCode() {
        String phone = mPhoneEdit.getText().toString();
        if (!NetworkUtils.isNetworkAvailable(this)) {
            ToastUtil.showToast(this, "网络未连接");
            return;
        }

        if (!Validation.isMobileNO(phone)) {
            ToastUtil.showToast(this, "手机号格式不正确");
            return;
        }

        try {
            AVOSCloud.requestSMSCode(phone, "账本", "短信验证", 10);
        } catch (AVException e) {
            e.printStackTrace();
        }
    }
}
