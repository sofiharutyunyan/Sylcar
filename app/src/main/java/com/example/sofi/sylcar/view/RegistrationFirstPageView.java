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

import androidx.navigation.Navigation;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFirstPageView extends Fragment implements RegistrationResultCallBack {

    private FragmentRegistrationFirstPageViewBinding viewBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration_first_page_view, container, false);
        RegistrationViewModel firstVM = ViewModelProviders.of(this).get(RegistrationViewModel.class);
        firstVM.getData().observe(this, users -> {
            Toast.makeText(getContext(), users.getFirstName(), Toast.LENGTH_SHORT).show();
        }) ;
        viewBinding.setViewModelRegistr(ViewModelProviders.of(this, new RegistrationViewModelFactory(this))
                .get(RegistrationViewModel.class));

        return viewBinding.getRoot();
    }

    @Override
    public void onSuccess(String message) {
        Navigation.findNavController(viewBinding.getRoot()).navigate(R.id.action_registrationFirstPageView_to_registrationSecondPageView4);
    }

    @Override
    public void onError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

}
