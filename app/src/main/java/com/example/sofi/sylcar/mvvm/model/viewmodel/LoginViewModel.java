package com.example.sofi.sylcar.mvvm.model.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.sofi.sylcar.mvvm.LoginResultCallBack;
import com.example.sofi.sylcar.mvvm.model.User;

/**
 * Created by sofi on 11/19/18.
 */

public class LoginViewModel extends ViewModel {

    private User mUser;
    private LoginResultCallBack mLoginCallback;

    public LoginViewModel(LoginResultCallBack mLoginCallback) {
        this.mLoginCallback = mLoginCallback;
        this.mUser = new User();
    }

//  Method to get Email from EditText and set to user
    public TextWatcher getEmailTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setEmail(s.toString());
            }
        };
    }

    //  Method to get Password from EditText and set to user
    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
        if (mUser.isValidData()){
            mLoginCallback.onSuccess("Login Success!");
        }else {
            mLoginCallback.onError("Login Error");
        }
    }
}
