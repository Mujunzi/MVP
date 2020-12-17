package com.example.day1216_mvp1.contract;

public class MyContract {
    public interface InModel {
        String getLoginDataM();
    }
    public interface InPresenter {
        void loginP();
        String getLoginDataP();
    }
    public interface InView {
        void loginV();
    }
}
