package com.example.sofi.sylcar.view;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.utils.Validation;
import com.example.sofi.sylcar.presenter.LoginFragmentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragmentView extends Fragment implements LoginFragmentPresenter.LoginPresenter{

    @BindView(R.id.email_lay) TextInputLayout layEmail;
    @BindView(R.id.email_txt) TextInputEditText txtEmail;
    @BindView(R.id.password_lay) TextInputLayout layPassword;
    @BindView(R.id.password_txt) TextInputEditText txtPassword;
    @BindView(R.id.error_lay)  LinearLayout layError;
    @BindView(R.id.back_img) ImageButton imgBack;

    private Unbinder unbinder;
    private LoginFragmentPresenter mPresenter;

    public LoginFragmentView() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     * @return object of {@link LoginFragmentView}
     */
    public static LoginFragmentView newInstance() {
        Bundle args = new Bundle();
        LoginFragmentView fragment = new LoginFragmentView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginFragmentPresenter(this);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder =  ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.proceed_btn)
    void proceedLoggingIn(){
        if (Validation.isValidEmail(txtEmail.getText().toString()) && !txtPassword.getText().toString().isEmpty()){
            mPresenter.loginUser();
        }else {
            layError.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.back_img)
    void goBack(){
        hideKeyboard(getActivity());
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, LuncherFragment.newInstance()).commit();
    }

    @Override
    public void loginUser() {
        layError.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.congratulation_msg, Toast.LENGTH_SHORT).show();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * hides the open keyboard
     * @param activity
     */
    public static void hideKeyboard(Activity activity) {
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
