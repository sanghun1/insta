package com.cos.insta_ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.adapter.PostAdapter;
import com.cos.insta_ui.adapter.StoryAdapter;
import com.cos.insta_ui.data.PostData;
import com.cos.insta_ui.data.StoryData;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private static final String TAG = "HomeFragment";

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = (View)inflater.inflate(R.layout.home_fragment, container, false);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        StoryFragment storyFragment = new StoryFragment();
        PostFragment postFragment = new PostFragment();

        transaction.replace(R.id.home_frame1, storyFragment);
        transaction.replace(R.id.home_frame2, postFragment);

        transaction.commit();

        return view;
    }

}
