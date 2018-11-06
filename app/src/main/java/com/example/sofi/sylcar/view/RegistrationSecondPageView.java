package com.example.sofi.sylcar.view;

import android.content.Context;
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
import com.example.sofi.sylcar.presenter.RegistrationSecondPagePresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationSecondPageView extends Fragment implements RegistrationSecondPagePresenter.IRegistrationPresenter{

    @BindView(R.id.birthday_edt) EditText edtBirthday;
    @BindView(R.id.skip_txt) TextView mTxtSkip;
    @BindView(R.id.parent_linear_layout) LinearLayout parentLL;
    @BindView(R.id.add_field_button) ImageButton mBtnAddField;
    @BindView(R.id.delete_button) ImageButton mBtnDelete;

    private RegistrationSecondPagePresenter mPresenter;

    private Unbinder unbinder;

    public RegistrationSecondPageView() {
        // Required empty public constructor
    }

    /**
     * Instantiates current fragment
     * @return object of {@link RegistrationSecondPageView}
     */
    public static RegistrationSecondPageView newInstance() {
        Bundle args = new Bundle();
        RegistrationSecondPageView fragment = new RegistrationSecondPageView();
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.skip_txt)
    void skipCurrentFragment(){
        mPresenter.skipRegisterFragment();
    }

    @OnClick(R.id.add_field_button)
    void addNewEmail(){
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLL.addView(rowView, parentLL.getChildCount() - 1);

    }

    @OnClick(R.id.delete_button)
    void deleteEmailItem(){
        deleteEmail(getView());
    }

    /**
     * should delete added email view
     * @param v
     */
    void deleteEmail(View v){
        mPresenter.deleteAddedEmail(v);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_second_page_view, container, false);
        unbinder = ButterKnife.bind(this, view);

        mPresenter = new RegistrationSecondPagePresenter(this);

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ddd", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void skipFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.start_container, RegistrationFirstPageView.newInstance()).commit();
    }

    @Override
    public void deleteEmailItem(View v) {
        parentLL.removeView((View) v.getParent());
    }
}
