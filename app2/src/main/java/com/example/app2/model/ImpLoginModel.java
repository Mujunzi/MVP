package com.example.app2.model;

import com.example.app2.contract.MyContract;

public class ImpLoginModel implements MyContract.InLoginModel {

    boolean isSuccess;

    @Override
    public void login(String name, String pwd) {
        if (name.equals("H2003xs") && pwd.equals("H2003")) {
            isSuccess = true;
        } else {
            isSuccess = false;
        }
    }

    @Override
    public boolean getData() {
        return isSuccess;
    }
}
