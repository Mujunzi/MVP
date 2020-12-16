package com.example.day1216_mvp1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.day1216_mvp1.R;
import com.example.day1216_mvp1.base.BaseActivity;
import com.example.day1216_mvp1.contract.MyContract;
import com.example.day1216_mvp1.presenter.ImpPresenter;

public class MainActivity extends BaseActivity<MyContract.InPresenter> implements MyContract.InView, View.OnClickListener {

    private EditText editText_name;
    private EditText editText_pwd;
    private Button btn_login;
    private String data;

    String getName() {
        return editText_name.getText().toString();
    }

    String getPwd() {
        return editText_pwd.getText().toString();
    }

    @Override
    public void onClick(View v) {
        if (!TextUtils.isEmpty(getName()) && !TextUtils.isEmpty(getPwd())) {
            presenter.loginP();
        }
    }

    @Override
    public void loginV() {
        data = presenter.getLoginDataP();
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        editText_name = findViewById(R.id.editText_name);
        editText_pwd = findViewById(R.id.editText_pwd);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public MyContract.InPresenter getPresenter() {
        Log.e("TAG", "getPresenter");
        return new ImpPresenter(this);
    }


}