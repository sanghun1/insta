package com.cos.insta_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.cos.insta_ui.adapter.StoryAdapter;
import com.cos.insta_ui.data.StoryData;
import com.cos.insta_ui.fragment.HomeFragment;
import com.cos.insta_ui.fragment.PlayFragment;
import com.cos.insta_ui.fragment.ProfileFragment;
import com.cos.insta_ui.fragment.SearchFragment;
import com.cos.insta_ui.fragment.ShopFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton btn_home, btn_search, btn_play, btn_shop, btn_profile;
    LinearLayout nav_bar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_bar = (LinearLayout) findViewById(R.id.nav_bar);
        btn_home = (ImageButton) findViewById(R.id.btn_home);
        btn_search = (ImageButton) findViewById(R.id.btn_search);
        btn_play = (ImageButton) findViewById(R.id.btn_play);
        btn_shop = (ImageButton) findViewById(R.id.btn_shop);
        btn_profile = (ImageButton) findViewById(R.id.btn_profile);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        SearchFragment searchFragment = new SearchFragment();
        PlayFragment playFragment = new PlayFragment();
        ShopFragment shopFragment = new ShopFragment();
        ProfileFragment profileFragment = new ProfileFragment();

        transaction.replace(R.id.frame, homeFragment);
        transaction.commit();

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, homeFragment);
                nav_bar.setVisibility(View.VISIBLE);
                transaction.commit();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, searchFragment);
                nav_bar.setVisibility(View.GONE);
                transaction.commit();
            }
        });

        btn_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, playFragment);
                nav_bar.setVisibility(View.VISIBLE);
                transaction.commit();
            }
        });

        btn_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, shopFragment);
                nav_bar.setVisibility(View.VISIBLE);
                transaction.commit();
            }
        });

        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame, profileFragment);
                nav_bar.setVisibility(View.VISIBLE);
                transaction.commit();
            }
        });

    }
}