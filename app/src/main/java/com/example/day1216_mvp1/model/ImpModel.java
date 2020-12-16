package com.example.day1216_mvp1.model;

import com.example.day1216_mvp1.base.BaseModel;
import com.example.day1216_mvp1.contract.MyContract;

public class ImpModel extends BaseModel implements MyContract.InModel {
    @Override
    public String getLoginDataM() {

        String data = "登陆成功！";

        return data;
    }
}
