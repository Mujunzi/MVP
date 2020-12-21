package com.example.mylibrary.base;

public abstract class BasePresenter<M extends BaseModel, V extends BaseView> {
    protected M model;
    protected V view;

    //自己抽取的P层构造方法，继承的子类直接重写构造即可。
    public BasePresenter(V view) {
        this.view = view;
        model = getModel();
    }

    //老师讲的赋值方法，在BaseV（BaseActivity，BaseFragment）中直接调用此方法即可 无需构造给M,V对象赋值，与上面两个二选其一。
    public void attach(V view) {
        this.view = view;
        model = getModel();
    }

    protected abstract M getModel();
}
