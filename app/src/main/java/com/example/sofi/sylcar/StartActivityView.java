package com.example.sofi.sylcar;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.sofi.sylcar.view.LauncherFragment;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class StartActivityView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        setContentView(R.layout.activity_start);
        NavController controller = Navigation.findNavController(this, R.id.nav_host_fragment);
        controller.navigateUp();

    }
}
