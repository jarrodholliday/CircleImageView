package com.alexzh.circleimageviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;


public class MainActivity extends AppCompatActivity implements ItemSelectedListener {

    private TextView mSelectedTextView;
    private TextView mUnSelectedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSelectedTextView = (TextView) findViewById(R.id.selectedTextView);
        mUnSelectedTextView = (TextView) findViewById(R.id.unselectedTextView);

        CircleImageView circleImageView = (CircleImageView) findViewById(R.id.imageView);
        if (circleImageView != null) {
            circleImageView.setOnItemSelectedClickListener(this);
        }
    }

    @Override
    public void onSelected(View view) {
        mSelectedTextView.setVisibility(View.VISIBLE);
        mUnSelectedTextView.setVisibility(View.GONE);
    }

    @Override
    public void onUnselected(View view) {
        mSelectedTextView.setVisibility(View.GONE);
        mUnSelectedTextView.setVisibility(View.VISIBLE);
    }
}

