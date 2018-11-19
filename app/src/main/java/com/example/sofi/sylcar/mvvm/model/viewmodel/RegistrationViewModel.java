package com.example.sofi.sylcar.mvvm.model.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.sofi.sylcar.mvvm.RegistrationResultCallBack;
import com.example.sofi.sylcar.mvvm.model.User;

/**
 * Created by sofi on 11/19/18.
 */

public class RegistrationViewModel extends ViewModel {

    MutableLiveData<User> mutableLiveData;
    private User mUser;
    private RegistrationResultCallBack mLoginCallback;

    public RegistrationViewModel(RegistrationResultCallBack mLoginCallback) {
        this.mLoginCallback = mLoginCallback;
        this.mUser = new User();
    }

    public LiveData<User> getData(){
        if (mutableLiveData == null){
            mutableLiveData = new MutableLiveData<>();
        }
        return mutableLiveData;
    }

    //  Method to get first name from EditText and set to user
    public TextWatcher getFirstNameTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setFirstName(s.toString());
            }
        };
    }

    //  Method to get last name from EditText and set to user
    public TextWatcher getLastNameTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setLastName(s.toString());
            }
        };
    }

    //  Method to get Email from EditText and set to user
    public TextWatcher getEmailTextWatcher() {
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

    //  Method to get phone number from EditText and set to user
    public TextWatcher getPhoneNumTextWatcher() {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mUser.setPhoneNum(s.toString());
            }
        };
    }

    //  Method to get Password from EditText and set to user
    public TextWatcher getPasswordTextWatcher() {
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

    public void onRegisterClicked(View view) {
        int resultCode = mUser.isValidData();
        switch (resultCode) {
            case 0:
                mLoginCallback.onError("First name is empty, please feel in.");
                break;
            case 1:
                mLoginCallback.onError("Last name is empty, please feel in.");
                break;
            case 2:
                mLoginCallback.onError("Email is empty, please feel in.");
                break;
            case 3:
                mLoginCallback.onError("Please write valid Email address.");
                break;
            case 4:
                mLoginCallback.onError("Phone number is empty, please feel in.");
                break;
            case 5:
                mLoginCallback.onError("Password is empty, please feel in.");
                break;
            case 6:
                mLoginCallback.onError("Password must contain at least 6 characters");
                break;
            case -1:
                mLoginCallback.onSuccess("Successfully filled registration fields");
        }
    }
}
