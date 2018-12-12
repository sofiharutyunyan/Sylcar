package com.example.sofi.sylcar.mvvm.model.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sofi.sylcar.mvvm.RegistrationResultCallBack;
import com.example.sofi.sylcar.mvvm.model.User;
import com.squareup.picasso.Picasso;

public class RegistrationSViewModel extends ViewModel{

    private User mUser;
    private RegistrationResultCallBack mLoginCallback;

    public RegistrationSViewModel(RegistrationResultCallBack mLoginCallback) {
        this.mLoginCallback = mLoginCallback;
        this.mUser = new User();
    }

    public void onSkipClicked(View view){

    }

    public void onDoneClicked(View view){

    }
}
