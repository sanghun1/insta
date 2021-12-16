package com.cos.insta_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cos.insta_ui.fragment.LoginFragment;
import com.cos.insta_ui.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    Button login_btn;

    private static final String TAG = "MainActivity1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        MainFragment mainFragment = new MainFragment();
        LoginFragment loginFragment = new LoginFragment();

        transaction.replace(R.id.main_frame, loginFragment);
        transaction.commit();

    }


}