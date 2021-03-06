package com.example.sofi.sylcar.mvvm.model;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by sofi on 11/16/18.
 */

public class User extends BaseObservable {

    @NonNull
    private String firstName, lastName, phoneNum, email, password;
    public String avatarUri;

    public User() {
    }

    public User(@NonNull String firstName, @NonNull String lastName, @NonNull String phoneNum, @NonNull String email, @NonNull String password, String avatarUri) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.email = email;
        this.password = password;
        this.avatarUri = avatarUri;
    }

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    @NonNull
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(@NonNull String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public String getAvatarUri() {
        return avatarUri;
    }

    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }

    @BindingAdapter({"app:url", "app:errorImage"})
    public static void loadImage(ImageView view, String url, Drawable errorImage) {
        Picasso.get().load(url).error(errorImage).into(view);
    }

    /**
     * checks EditTexts validation
     * @return result code, which decides the error type
     */
    public int isValidData() {
        if (TextUtils.isEmpty(getFirstName())) {
            return 0;
        } else if (TextUtils.isEmpty(getLastName())) {
            return 1;
        }
        if (TextUtils.isEmpty(getEmail())) {
            return 2;
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
                return 3;
            }
        }
        if (TextUtils.isEmpty(getPhoneNum())) {
            return 4;
        }
        if (TextUtils.isEmpty(getPassword())) {
            return 5;
        } else if (getPassword().length() < 6) {
            return 6;
        }
        return -1;
    }
}
