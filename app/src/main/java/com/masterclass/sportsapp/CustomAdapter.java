package com.masterclass.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// THis class is an adapter class
// It's a bridge between your Data (List<Sport>) and the RecyclerView + CardView

//2. because we changed the onBindViewHOlder from Recycler.ViewHOlder to SportsViewHolder
// we need to include teh SportsView holder to the Custom Adapter.
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {

    private List<Sport> sportList;

    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    // 3. because we added the SportsView HOlder to the CustomAdapter we need to change teh below
    // to the SportsViewHOlder.
    @NonNull
    @Override
    public /*RecyclerView.ViewHolder*/ SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the layout for each item in teh recyclerView

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,
                        parent,
                        false);

        return new SportsViewHolder(itemView);
    }

    // 1. THe below RecyclerView.ViewHolder should always be your own custom viewholder which
    // in our case is teh SportsViewHOlder

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder /*RecyclerView.ViewHolder*/, int position) {
        // called for each item in teh list and is responsible for binding the data
        // from the Sport object to the views
        // within the 'SportsViewHolder'
        Sport sport = sportList.get(position);
        holder.textView.setText(sport.sportName);
        holder.imageButton.setImageResource(sport.sportImg);

        holder.imageButton.setOnClickListener(v -> {
           Toast.makeText(
                   v.getContext(),
                   "you have selected: " + sport.getSportName(),
                   Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        // returns the total number of items in teh REcylcer list.
        return sportList.size();
    }

    public static class SportsViewHolder extends RecyclerView.ViewHolder{
        // Holds the references to the Views within the item layout

        TextView textView;
        ImageButton imageButton;
        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textview);
            imageButton = itemView.findViewById(R.id.imageviewcard);

        }

    }

}
