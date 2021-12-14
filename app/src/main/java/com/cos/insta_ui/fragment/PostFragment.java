package com.cos.insta_ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.adapter.PostAdapter;
import com.cos.insta_ui.data.PostData;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class PostFragment extends Fragment {

    private PostAdapter postAdapter;
    private RecyclerView rv_post;
    private LinearLayoutManager postLayoutManager;

    private static final String TAG = "PostFragment";

    public PostFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = (View) inflater.inflate(R.layout.post_fragment, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

        List<PostData> postdatas = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            postdatas.add(new PostData("postdatas"));
        }

        postLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);

        rv_post = (RecyclerView) view.findViewById(R.id.rv_post);
        rv_post.setLayoutManager(postLayoutManager);

        postAdapter = new PostAdapter(postdatas);
        rv_post.setAdapter(postAdapter);

        return view;


    }

}
