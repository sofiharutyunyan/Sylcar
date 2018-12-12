package com.example.sofi.sylcar.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.databinding.FragmentLoginBinding;
import com.example.sofi.sylcar.mvvm.RegistrationResultCallBack;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationViewModel;
import com.example.sofi.sylcar.utils.Validation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */

public class LoginFragmentView extends Fragment implements RegistrationResultCallBack {


    @BindView(R.id.email_lay)
    TextInputLayout layEmail;
    @BindView(R.id.email_txt)
    TextInputEditText txtEmail;
    @BindView(R.id.password_lay)
    TextInputLayout layPassword;
    @BindView(R.id.password_txt)
    TextInputEditText txtPassword;
    @BindView(R.id.error_lay)
    LinearLayout layError;
    @BindView(R.id.back_img)
    ImageButton imgBack;

    private Unbinder unbinder;

    private FragmentLoginBinding binding;

    public LoginFragmentView() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     *
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
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);
        binding.setViewModel(new RegistrationViewModel(this));

        unbinder = ButterKnife.bind(this, binding.getRoot());
        return binding.getRoot();
    }

    @OnClick(R.id.proceed_btn)
    void proceedLoggingIn() {
        if (Validation.isValidEmail(txtEmail.getText().toString()) && !txtPassword.getText().toString().isEmpty()) {
            loginUser();
        } else {
            layError.setVisibility(View.VISIBLE);
        }
    }

    public void loginUser() {
        layError.setVisibility(View.GONE);
        Toast.makeText(getContext(), R.string.congratulation_msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void onError(String message) {

    }
}
