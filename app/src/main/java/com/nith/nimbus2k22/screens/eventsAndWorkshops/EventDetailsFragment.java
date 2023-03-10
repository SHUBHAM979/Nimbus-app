package com.nith.nimbus2k22.screens.eventsAndWorkshops;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.nith.nimbus2k22.R;
import com.squareup.picasso.Picasso;


public class EventDetailsFragment extends Fragment {

    private TextView eventDetailName;
    private TextView eventDetailDes;
    private TextView eventDetailRegBtn;
    private ImageView eventDetailImage;
    private ImageView eventBackButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_event_details, container, false);

        eventDetailName=view.findViewById(R.id.event_detail_name);
        eventDetailDes=view.findViewById(R.id.event_detail_description);
        eventDetailRegBtn=view.findViewById(R.id.event_detail_reg_btn);
        eventDetailImage =view.findViewById(R.id.event_detail_IV);
        eventBackButton = view.findViewById(R.id.back_button);

        String title = getArguments().getString("Title");
        String imageUrl = getArguments().getString("ImageUrl");
        String description = getArguments().getString("description");
        String regUrl = getArguments().getString("regUrl");

        eventDetailName.setText(title);
        eventDetailDes.setText(description);

        if (!imageUrl.isEmpty()){
//            Picasso.get().load("https://media.geeksforgeeks.org/img-practice/banner/dsa-self-paced-thumbnail.png").into(eventDetailImage);
            Picasso.get().load("https://api.festnimbus.com/"+imageUrl).into(eventDetailImage);
            Log.d("IMG_URL", imageUrl);
            Log.d("REG_URL", regUrl);
        }


        eventDetailRegBtn.setOnClickListener(view1 -> {
            Uri uri = Uri.parse(regUrl);
            if (!regUrl.isEmpty()){
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        eventBackButton.setOnClickListener(view12 -> {
            Log.e("Event Details", "hey there");
            getActivity().onBackPressed();
        });

        return view;
    }
}