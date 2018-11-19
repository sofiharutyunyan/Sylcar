package com.example.sofi.sylcar.view;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.databinding.FragmentRegistrationFirstPageViewBinding;
import com.example.sofi.sylcar.mvvm.RegistrationResultCallBack;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationViewModel;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationViewModelFactory;
import com.example.sofi.sylcar.utils.Validation;

import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFirstPageView extends Fragment implements RegistrationResultCallBack {
//
//    @BindView(R.id.first_name_txt)
//    TextInputEditText mTxtFirstName;
//    @BindView(R.id.last_name_txt)
//    TextInputEditText mTxtLasttName;
//    @BindView(R.id.email_txt)
//    TextInputEditText mtxtEmail;
//    @BindView(R.id.phone_num_txt)
//    TextInputEditText mtxtPhonNum;
//    @BindView(R.id.password_register_txt)
//    TextInputEditText mtxtPassword;
//    @BindView(R.id.proceed_register_btn)
//    Button mBtnProceed;
//    @BindView(R.id.back_from_register_img)
//    ImageButton mImgBack;
//
//    private Unbinder unbinder;

    @OnClick(R.id.proceed_register_btn)
    void onClickProceed() {
        Validation.hideKeyboard(getActivity());
    }

    @OnClick(R.id.back_from_register_img)
    void goBack() {
        Validation.hideKeyboard(getActivity());
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, LuncherFragment.newInstance()).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_first_page_view, container, false);
        FragmentRegistrationFirstPageViewBinding viewBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_registration_first_page_view);
        viewBinding.setViewModelRegistr(ViewModelProviders.of(this, new RegistrationViewModelFactory(this))
                .get(RegistrationViewModel.class));
//        unbinder = ButterKnife.bind(this, view);

        return view;
    }


//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        unbinder.unbind();
//    }

    @Override
    public void onSuccess(String message) {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container,
                RegistrationSecondPageView.newInstance()).addToBackStack(null).commit();
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
