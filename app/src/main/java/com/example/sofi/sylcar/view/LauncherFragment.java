package com.example.sofi.sylcar.view;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.databinding.FragmentLauncherBinding;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LauncherFragment extends Fragment {

    private FragmentLauncherBinding binding;

    public LauncherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_launcher, container, false);
        binding.setLauncherFragment(this);
//        get NavController object of activity in fragment
//        NavController hf = NavHostFragment.findNavController(this);
        return binding.getRoot();
    }

    public void onLoginClicked(){
        Navigation.createNavigateOnClickListener(R.id.action_launcherFragment_to_loginFragmentView, null)
                .onClick(binding.individualLoginBtn);
    }

    public void onRegistrationClicked(){
        Navigation.createNavigateOnClickListener(R.id.action_launcherFragment_to_registrationFirstPageView, null)
                .onClick(binding.individualLoginBtn);
//    which is the same as
//        Navigation.findNavController(binding.getRoot()).navigate(R.id.action_launcherFragment_to_registrationFirstPageView);
    }

    public void onSignUpClicked(){
        Navigation.createNavigateOnClickListener(R.id.action_launcherFragment_to_signUpAsBusinessFragment, null)
                .onClick(binding.individualLoginBtn);

    }
}
