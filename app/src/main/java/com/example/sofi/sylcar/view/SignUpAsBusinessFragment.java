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
public class SignUpAsBusinessFragment extends Fragment {

    @BindView(R.id.back_txt) TextView txtBack;
    private Unbinder unbinder;

    public SignUpAsBusinessFragment() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     * @return object of {@link SignUpAsBusinessFragment}
     */
    public static SignUpAsBusinessFragment newInstance() {
        Bundle args = new Bundle();
        SignUpAsBusinessFragment fragment = new SignUpAsBusinessFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up_as_business, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.back_txt)
    void goPreviousFragment(){
        goBack();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void goBack() {
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.nav_host_fragment, new LauncherFragment()).commit();
    }
}
