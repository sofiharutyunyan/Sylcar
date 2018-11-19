package com.example.sofi.sylcar.view;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sofi.sylcar.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuncherFragment extends Fragment{

    @BindView(R.id.login_btn) TextView btnLogin;
    @BindView(R.id.individual_login_btn) TextView btnIndividualLogin;
    @BindView(R.id.signup_business_btn) TextView btnSignUpBusiness;

    private Unbinder unbinder;

    public LuncherFragment() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     * @return object of {@link LuncherFragment}
     */
    public static LuncherFragment newInstance() {
        Bundle args = new Bundle();
        LuncherFragment fragment = new LuncherFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_luncher, container, false);

        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.login_btn)
    void login(){
        startLogin();
    }

    @OnClick(R.id.individual_login_btn)
    void loginAsIndividual(){
        startIndividualLogin();
    }

    @OnClick(R.id.signup_business_btn)
    void signUpAsBusiness(){
        signUpAsIndividual();
    }

    public void startLogin() {
        btnLogin.setBackgroundColor(getResources().getColor(R.color.proceed_btn_bg));
        openFragment(new LoginFragmentView());
    }

    public void startIndividualLogin() {
        btnIndividualLogin.setBackgroundColor(getResources().getColor(R.color.proceed_btn_bg));
        openFragment(new RegistrationFirstPageView());
    }

    public void signUpAsIndividual() {
        btnSignUpBusiness.setBackgroundColor(getResources().getColor(R.color.proceed_btn_bg));
        openFragment(SignUpAsBusinessFragment.newInstance());
    }

    private void openFragment(Fragment fragment){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, fragment).addToBackStack(null).commit();
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
