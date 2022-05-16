package com.example.nftscmers.adapters;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;

import com.example.nftscmers.R;
import com.example.nftscmers.objectmodels.ApplicantModel;
import com.example.nftscmers.objectmodels.JobModel;
import com.example.nftscmers.objectmodels.TestModel;
import com.google.firebase.firestore.DocumentReference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApplicantAdapter extends ArrayAdapter<HashMap<String, String>> {
    private final LayoutInflater mInflater;
    private final List<HashMap<String, String>> detailsList;
    OnItemClickListener onItemClickListener;

    public ApplicantAdapter(Context context, int resource, @NonNull ArrayList<HashMap<String, String>> detailsList, OnItemClickListener onItemClickListener) {
        super(context, resource, detailsList);

        this.detailsList = detailsList;
        mInflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onResult(int position);
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        View view = mInflater.inflate(R.layout.item_in_cardview, null);

        TextView name = view.findViewById(R.id.name);
//        ImageView image = view.findViewById(R.id.thisimage);

        HashMap<String, String> details = detailsList.get(position);

        name.setText(details.get(ApplicantModel.EMAIL));
//        image.setImageURI(details.get(ApplicantModel.C));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onResult(position);
            }
        });

        return view;

    }
}
