package com.example.sofi.sylcar.utils;


import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Validation {

    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    public static boolean isValidEmail(String validationText) {

        if (validationText.matches(EMAIL_PATTERN) && validationText.length() > 0) {
            return true;
        }
        return false;
    }

    /**
     * hides the open keyboard
     * @param activity
     */
    public static void hideKeyboard (Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
