package com.example.sofi.sylcar.presenter;

public class BusinessFragmentPresenter {

    IBusinessPresenter mPresenter;

    public BusinessFragmentPresenter(IBusinessPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void goPreviousFragment() {
        mPresenter.goBack();
    }

    public interface IBusinessPresenter{
        void goBack();
    }
}
