package com.example.sofi.sylcar.presenter;

import android.view.View;

public class RegistrationSecondPagePresenter {

    private IRegistrationPresenter mPresenter;

    public RegistrationSecondPagePresenter(IRegistrationPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void skipRegisterFragment() {
        mPresenter.skipFragment();
    }

    public void deleteAddedEmail(View v) {
        mPresenter.deleteEmailItem(v);
    }

    public interface IRegistrationPresenter{

        void skipFragment();

        void deleteEmailItem(View v);
    }
}
