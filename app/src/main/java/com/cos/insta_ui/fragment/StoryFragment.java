package com.cos.insta_ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.adapter.StoryAdapter;
import com.cos.insta_ui.data.StoryData;

import java.util.ArrayList;

public class StoryFragment extends Fragment {

    private ArrayList<StoryData> arrayList;
    private StoryAdapter storyAdapter;
    private RecyclerView rv_story;
    private RecyclerView.LayoutManager storyLayoutManager;

    private static final String TAG = "StoryFragment";

    public StoryFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.story_fragment, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

        arrayList = new ArrayList<>();

        storyLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false);

        rv_story = (RecyclerView) view.findViewById(R.id.rv_story);
        rv_story.setLayoutManager(storyLayoutManager);

        storyAdapter = new StoryAdapter(arrayList);
        rv_story.setAdapter(storyAdapter);

        ImageButton story_btn_add = (ImageButton)view.findViewById(R.id.story_btn_add);
        story_btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StoryData storyData = new StoryData(R.drawable.profile, R.drawable.story_gra, "curiouszelda");
                arrayList.add(storyData);
                storyAdapter.notifyDataSetChanged();

            }
        });

        return view;
    }
}
