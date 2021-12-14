package com.cos.insta_ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.data.SearchData;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private final List<SearchData> searchData;

    public SearchAdapter(List<SearchData> searchData) {
        this.searchData = searchData;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.search_item, parent, false);
        SearchViewHolder holder = new SearchViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return searchData.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_search;
        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            img_search = itemView.findViewById(R.id.search_img);

        }
    }
}
