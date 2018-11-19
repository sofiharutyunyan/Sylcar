package com.example.sofi.sylcar.view;


import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.databinding.FragmentLoginBinding;
import com.example.sofi.sylcar.mvvm.LoginResultCallBack;
import com.example.sofi.sylcar.mvvm.model.viewmodel.LoginViewModel;
import com.example.sofi.sylcar.mvvm.model.viewmodel.LoginViewModelFactory;

/**
 * A simple {@link Fragment} subclass.
 */

public class LoginFragmentView extends Fragment implements LoginResultCallBack {

//
//    @BindView(R.id.email_lay) TextInputLayout layEmail;
//    @BindView(R.id.email_txt) TextInputEditText txtEmail;
//    @BindView(R.id.password_lay) TextInputLayout layPassword;
//    @BindView(R.id.password_txt) TextInputEditText txtPassword;
//    @BindView(R.id.error_lay)  LinearLayout layError;
//    @BindView(R.id.back_img) ImageButton imgBack;
//
//    private Unbinder unbinder;
//    private LoginFragmentPresenter mPresenter;
//
//    public LoginFragmentView() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Instantiates current fragment
//     * @return object of {@link LoginFragmentView}
//     */
//    public static LoginFragmentView newInstance() {
//        Bundle args = new Bundle();
//        LoginFragmentView fragment = new LoginFragmentView();
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        mPresenter = new LoginFragmentPresenter(this);
//        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_login, container, false);
//        unbinder =  ButterKnife.bind(this, view);
//        return view;
//    }
//
//    @OnClick(R.id.proceed_btn)
//    void proceedLoggingIn(){
//        if (Validation.isValidEmail(txtEmail.getText().toString()) && !txtPassword.getText().toString().isEmpty()){
//            mPresenter.loginUser();
//        }else {
//            layError.setVisibility(View.VISIBLE);
//        }
//    }
//
//    @OnClick(R.id.back_img)
//    void goBack(){
//        hideKeyboard(getActivity());
//        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, LuncherFragment.newInstance()).commit();
//
//
//    }
//
//    @Override
//    public void loginUser() {
//        layError.setVisibility(View.GONE);
//        Toast.makeText(getContext(), R.string.congratulation_msg, Toast.LENGTH_SHORT).show();
//    }
//
//    @Override public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }
//
//    /**
//     * hides the open keyboard
//     * @param activity
//     */
//    public static void hideKeyboard(Activity activity) {
//        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = activity.getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(activity);
//        }
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        FragmentLoginBinding fragmentLoginBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_login);
        fragmentLoginBinding.setViewModel(ViewModelProviders.of(this, new LoginViewModelFactory(this))
        .get(LoginViewModel.class));
        return view;
    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(getActivity(), "Login successful", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getActivity(), "Login error", Toast.LENGTH_SHORT).show();
    }
}
