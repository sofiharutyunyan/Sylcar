package com.example.sofi.sylcar.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.presenter.RegistrationFirstPagePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFirstPageView extends Fragment implements RegistrationFirstPagePresenter.IRegistrationPresenter {

    @BindView(R.id.first_name_txt) TextInputEditText mTxtFirstName;
    @BindView(R.id.last_name_txt) TextInputEditText mTxtLasttName;
    @BindView(R.id.email_txt) TextInputEditText mtxtEmail;
    @BindView(R.id.phone_num_txt) TextInputEditText mtxtPhonNum;
    @BindView(R.id.password_register_txt) TextInputEditText mtxtPassword;
    @BindView(R.id.proceed_register_btn) Button mBtnProceed;
    @BindView(R.id.back_from_register_img) ImageButton mImgBack;

    private Unbinder unbinder;
    private RegistrationFirstPagePresenter mPresenter;

    public RegistrationFirstPageView() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     *
     * @return object of {@link RegistrationFirstPageView}
     */
    public static RegistrationFirstPageView newInstance() {
        Bundle args = new Bundle();
        RegistrationFirstPageView fragment = new RegistrationFirstPageView();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.proceed_register_btn)
    void onClickProceed() {
        hideKeyboard(getActivity());
        mPresenter.validateFields();
    }

    @OnClick(R.id.back_from_register_img)
    void goBack() {
        hideKeyboard(getActivity());
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, LuncherFragment.newInstance()).commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_first_page_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new RegistrationFirstPagePresenter(this);

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public boolean areFieldsValid() {
        if (mTxtFirstName.getText().toString().isEmpty() ||
                mTxtLasttName.getText().toString().isEmpty() ||
                mtxtEmail.getText().toString().isEmpty() ||
                mtxtPhonNum.getText().toString().isEmpty() ||
                mtxtPassword.getText().toString().isEmpty()) {
            return false;
        }
            mBtnProceed.setTextColor(getResources().getColor(R.color.colorAccent));
            return true;
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

        @Override
        public void continueRegistration () {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, RegistrationSecondPageView.newInstance()).addToBackStack(null).commit();
        }

        @Override
        public void showErrorMsg () {
            Toast.makeText(getContext(), R.string.error_msg_valid_fields, Toast.LENGTH_SHORT).show();
        }
    }
