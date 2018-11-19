package com.example.sofi.sylcar.mvvm.model.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.sofi.sylcar.mvvm.LoginResultCallBack;


/**
 * Created by sofi on 11/19/18.
 */

public class LoginViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    LoginResultCallBack mLoginCallBack;

    public LoginViewModelFactory(LoginResultCallBack mLoginCallBack) {
        this.mLoginCallBack = mLoginCallBack;
    }

    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new LoginViewModel(mLoginCallBack);
    }
}
