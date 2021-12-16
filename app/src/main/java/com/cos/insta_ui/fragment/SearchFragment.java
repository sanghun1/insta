package com.cos.insta_ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.adapter.SearchAdapter;
import com.cos.insta_ui.data.PostData;
import com.cos.insta_ui.data.SearchData;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    private SearchAdapter searchAdapter;
    private RecyclerView rv_search;
    private GridLayoutManager searchLayoutManager;

    private static final String TAG = "SearchFragment";

    public SearchFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View)inflater.inflate(R.layout.search_fragment, container, false);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();

        List<SearchData> searchdatas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            searchdatas.add(new SearchData("searchdatas"));
        }

        searchLayoutManager = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        rv_search = (RecyclerView) view.findViewById(R.id.rv_search);
        rv_search.setLayoutManager(searchLayoutManager);

        searchAdapter = new SearchAdapter(searchdatas);
        rv_search.setAdapter(searchAdapter);


        return view;
    }
}
