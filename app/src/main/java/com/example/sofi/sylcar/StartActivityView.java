package com.example.sofi.sylcar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.sofi.sylcar.R;
import com.example.sofi.sylcar.presenter.LuncherFragmentPresenter;
import com.example.sofi.sylcar.view.LuncherFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivityView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        setContentView(R.layout.activity_start);
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager().beginTransaction().replace(R.id.start_container, LuncherFragment.newInstance()).commit();
    }
}
