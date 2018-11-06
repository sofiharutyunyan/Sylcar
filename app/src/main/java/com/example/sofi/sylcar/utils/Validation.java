package com.example.sofi.sylcar.utils;


import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

public class Validation {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public static boolean isValidEmail(String validationText) {

        if (validationText.matches(EMAIL_PATTERN) && validationText.length() > 0) {
            return true;
        }
        return false;
    }

}
