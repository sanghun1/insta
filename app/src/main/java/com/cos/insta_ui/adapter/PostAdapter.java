package com.cos.insta_ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.data.PostData;

import org.w3c.dom.Text;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private final List<PostData> postData;

    private int count = 0;

    private static final String TAG = "PostAdapter";

    public PostAdapter(List<PostData> postData) {
        this.postData = postData;
    }


    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.post_item, parent, false);
        PostViewHolder holder = new PostViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.post_count.setText(count + "");
        holder.post_heart_Btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (compoundButton.isChecked()) {
                    count++;

                    holder.post_count.setText(count + "");
                    holder.post_heart_Btn.setBackgroundResource(R.drawable.heart_color);

                    notifyDataSetChanged();
                } else {
                    count--;

                    holder.post_count.setText(count + "");
                    holder.post_heart_Btn.setBackgroundResource(R.drawable.heart);

                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return postData.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        protected ToggleButton post_heart_Btn;
        protected TextView post_count;

        private TextView tvTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.post_id);

            this.post_heart_Btn = (ToggleButton)itemView.findViewById(R.id.post_heart_Btn);
            this.post_count = (TextView)itemView.findViewById(R.id.post_count);

        }
    }
}
