package com.example.sofi.sylcar.presenter;

public class RegistrationFirstPagePresenter {

    IRegistrationPresenter mPresenter;

    public RegistrationFirstPagePresenter(IRegistrationPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    public void validateFields(){
        if (mPresenter.areFieldsValid()){
            mPresenter.continueRegistration();
        }else {
            mPresenter.showErrorMsg();
        }
    }

    public interface IRegistrationPresenter{
        boolean areFieldsValid();
        void continueRegistration();
        void showErrorMsg();
    }
}
