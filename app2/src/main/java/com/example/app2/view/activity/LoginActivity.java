package com.example.app2.view.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app2.R;
import com.example.app2.contract.MyContract;
import com.example.app2.presenter.ImpLoginPresenter;
import com.example.mylibrary.base.BaseActivity;

public class LoginActivity extends BaseActivity<MyContract.InLoginPresenter> implements MyContract.InLoginView, View.OnClickListener {


    private EditText et_name;
    private EditText et_pwd;
    private Button btn_login;
    private ImpLoginPresenter presenter;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        et_name = findViewById(R.id.et_name);
        et_pwd = findViewById(R.id.et_pwd);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    protected MyContract.InLoginPresenter getPresenter() {
        presenter = new ImpLoginPresenter(this);
        return presenter;
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                String name = et_name.getText().toString();
                String pwd = et_pwd.getText().toString();
                presenter.login(name, pwd);
                getData();
                break;
        }
    }

    private void getData() {
        boolean isSuccess = presenter.getData();
        if (isSuccess) {
            Toast.makeText(this, "登陆成功！", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        } else {
            Toast.makeText(this, "登陆失败！", Toast.LENGTH_SHORT).show();
        }
    }
}