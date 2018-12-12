package com.example.sofi.sylcar.view;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.databinding.FragmentRegistrationSecondPageViewBinding;
import com.example.sofi.sylcar.mvvm.RegistrationResultCallBack;
import com.example.sofi.sylcar.mvvm.model.User;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationSViewModel;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationViewModel;
import com.example.sofi.sylcar.mvvm.model.viewmodel.RegistrationViewModelFactory;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationSecondPageView extends Fragment implements RegistrationResultCallBack {

    public RegistrationSecondPageView() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     *
     * @return object of {@link RegistrationSecondPageView}
     */
    public static RegistrationSecondPageView newInstance() {
        Bundle args = new Bundle();
        RegistrationSecondPageView fragment = new RegistrationSecondPageView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        User user = new User("Jon", "Smith", "5555555", "jon.smith@ghj.com",
                "aaaaaa", "https://tempodecozimento.com.br/wp-content/uploads/2017/10/chuchu.jpg");

        FragmentRegistrationSecondPageViewBinding viewBinding =
                DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_registration_second_page_view, container, false);
        viewBinding.setViewModelRegSecond(new RegistrationSViewModel(this));
        viewBinding.setUser(user);

        return viewBinding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void skipFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, new RegistrationFirstPageView()).commit();
    }

    @Override
    public void onSuccess(String message) {

    }

    @Override
    public void onError(String message) {

    }
}
