package com.example.app2.model;

import com.example.app2.callback.MyCallBack;
import com.example.app2.contract.MyContract;

public class ImpLoginModel implements MyContract.InLoginModel {

    @Override
    public void login(String name, String pwd, MyCallBack<Boolean> callBack) {
        if (name.equals("H2003xs") && pwd.equals("H2003")) {
//            callBack.getData(true);
            getData(true);
        } else {
//            callBack.getData(false);
            getData(false);
        }
    }

    @Override
    public boolean getData(Boolean isSuccess) {
        return isSuccess;
    }


}
