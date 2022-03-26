package com.nith.nimbus2k22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.nith.nimbus2k22.R;
import com.nith.nimbus2k22.modals.EventsModal;
import com.nith.nimbus2k22.modals.SponsorsModal;
//import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SponsorsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<SponsorsModal> sponsorsModalArrayList;
    private Context context;
    boolean isUsedInHome;

    public SponsorsAdapter(ArrayList<SponsorsModal> sponsorsModalArrayList, Context context, boolean isUsedInHome) {
        this.sponsorsModalArrayList = sponsorsModalArrayList;
        this.context = context;
        this.isUsedInHome = isUsedInHome;
    }

    @Override
    public int getItemViewType(int position) {
        if (isUsedInHome) {
            return 0;
        }
        return 1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;
        if (viewType == 0) {
            view = layoutInflater.inflate(R.layout.list_item_sponsors_home, parent, false);
            return new HomeSponsorsViewHolder(view);
        }
        view = layoutInflater.inflate(R.layout.list_item_sponsors, parent, false);
        return new HomeSponsorsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SponsorsModal sponsor = sponsorsModalArrayList.get(position);
        if (isUsedInHome) {
            HomeSponsorsViewHolder homeSponsorsViewHolder = (HomeSponsorsViewHolder) holder;
            homeSponsorsViewHolder.homeSponsorName.setText(sponsor.getName());
            //load img
            //on clicklistener??
        }
        if (!isUsedInHome) {
            SponsorsViewHolder sponsorsViewHolder = (SponsorsViewHolder) holder;
            sponsorsViewHolder.sponsorDes.setText(sponsor.getName());
            //??
            //load img
        }
    }

    @Override
    public int getItemCount() {
        return sponsorsModalArrayList.size();
    }
//
//    @NonNull
//    @Override
//    public SponsorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_sponsors, parent, false);
//        return new SponsorsViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull SponsorsViewHolder holder, int position) {
//        SponsorsModal sponsor = sponsorsModalArrayList.get(position);
//        if (sponsor.getImage().isEmpty()) {
////            Picasso.get().load(imgUrl.replace("http", "https")).into(holder.sponsorImage);
//        } else {
////            Picasso.get().load(sponsor.getImage()).into(holder.sponsorImage);
//        }
//        holder.sponsorDes.setText(sponsor.getName());
//    }
//
//    @Override
//    public int getItemCount() {
//        return sponsorsModalArrayList.size();
//    }

    public class SponsorsViewHolder extends RecyclerView.ViewHolder {

        private ImageView sponsorImage;
        private TextView sponsorDes;
        private ConstraintLayout sponsorItem;

        public SponsorsViewHolder(@NonNull View itemView) {
            super(itemView);

            sponsorImage = itemView.findViewById(R.id.sponsor_IV);
            sponsorDes = itemView.findViewById(R.id.sponsor_des);
            sponsorItem = itemView.findViewById(R.id.sponsor_item);
        }
    }

    public class HomeSponsorsViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout homeSponsorItem;
        private ImageView homeSponsorImg;
        private TextView homeSponsorName;

        public HomeSponsorsViewHolder(@NonNull View itemView) {
            super(itemView);
            homeSponsorItem = itemView.findViewById(R.id.home_sponsor_item);
            homeSponsorImg = itemView.findViewById(R.id.home_sponsor_img);
            homeSponsorName = itemView.findViewById(R.id.home_sponsor_name);
        }
    }

}
