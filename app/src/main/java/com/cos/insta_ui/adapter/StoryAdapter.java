package com.cos.insta_ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cos.insta_ui.R;
import com.cos.insta_ui.data.StoryData;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {

    private ArrayList<StoryData> arrayList;

    public StoryAdapter(ArrayList<StoryData> arrayList) {
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public StoryAdapter.StoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        StoryViewHolder holder = new StoryViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StoryAdapter.StoryViewHolder holder, int position) {

        holder.story_username.setText(arrayList.get(position).getStory_username());
        holder.story_image.setImageResource(arrayList.get(position).getStory_image());
        holder.story_image_bg.setImageResource(arrayList.get(position).getStory_image_bg());


        holder.itemView.setTag(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.story_username.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();

            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        }
        catch (IndexOutOfBoundsException ex){
            ex.printStackTrace();
        }
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder {

        protected CircleImageView story_image;
        protected CircleImageView story_image_bg;
        protected TextView story_username;

        public StoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.story_image = (CircleImageView)itemView.findViewById(R.id.story_image);
            this.story_image_bg = (CircleImageView)itemView.findViewById(R.id.story_image_bg);
            this.story_username = (TextView)itemView.findViewById(R.id.story_username);
        }
    }
}
