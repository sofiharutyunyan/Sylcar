package com.example.sofi.sylcar.presenter;

public class LoginFragmentPresenter {

    LoginPresenter mPresenter;

    public LoginFragmentPresenter(LoginPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void loginUser(){
        mPresenter.loginUser();
    }

    public static interface LoginPresenter{

        void loginUser();
    }
}
