package com.alexzh.circleimageviewexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;
import com.alexzh.circleimageviewexample.data.DummyList;


public class ProfileFragment extends Fragment implements ItemSelectedListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.imageView);
        circleImageView.setOnItemSelectedClickListener(this);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new AndroidVersionAdapter(getActivity(), DummyList.getAndroidVersionList()));

        return view;
    }

    @Override
    public void onSelected(View view) {
        Toast.makeText(getActivity(), "onSelected", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUnselected(View view) {
        Toast.makeText(getActivity(), "onUnselected", Toast.LENGTH_SHORT).show();
    }
}
