package com.example.flickrprojectv2;

import static com.example.flickrprojectv2.DataCollection.PhotoDataCollection.photoArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener;

import com.bumptech.glide.Glide;
import com.example.flickrprojectv2.model.Photo;

import java.util.ArrayList;

public class recyclerViewAdapter extends
        RecyclerView.Adapter <recyclerViewAdapter.ViewHolder> {

    Context context;
//    ArrayList<Photo> photoArrayList;


//    public recyclerViewAdapter(Context context, ArrayList<Photo> photoArrayList) {
//        this.context = context;
//        this.photoArrayList = photoArrayList;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_custom, parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(photoArrayList.get(position).getTitle());
        holder.date_taken.setText(photoArrayList.get(position).getDatetaken());
        Glide.with(holder.itemView.getContext()).load(photoArrayList.get(position).getUrl_h()).into(holder.cell_image);

        //error
//        Glide.with(this.context).load(photoArrayList.get(position).getUrl_h()).into(holder.cell_image);

    }

    @Override
    public int getItemCount() {
        return photoArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView cell_image;
        TextView title;
        TextView date_taken;

        public ViewHolder(View view) {
            super(view);

            cell_image = view.findViewById(R.id.cell_image);
            title = view.findViewById(R.id.title);
            date_taken = view.findViewById(R.id.date_taken);
        }
    }
}
