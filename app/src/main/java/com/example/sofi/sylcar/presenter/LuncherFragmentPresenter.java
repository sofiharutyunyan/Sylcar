package com.example.sofi.sylcar.presenter;


public class LuncherFragmentPresenter {

    IPresenter mPresenter;

    public LuncherFragmentPresenter(IPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void startLogin() {
        mPresenter.startLogin();
    }

    public void startIndividualLogin() {
        mPresenter.startIndividualLogin();
    }

    public void signUpAsIndividual() {
        mPresenter.signUpAsIndividual();
    }


    public interface IPresenter {

        void startLogin();

        void startIndividualLogin();

        void signUpAsIndividual();
    }
}
