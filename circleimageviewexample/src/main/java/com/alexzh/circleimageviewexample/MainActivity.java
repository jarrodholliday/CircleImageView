package com.alexzh.circleimageviewexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;


public class MainActivity extends ActionBarActivity implements ItemSelectedListener {

    private CircleImageView mImageView;
    private LinearLayout mAdditionalLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (CircleImageView) findViewById(R.id.imageView);
        mAdditionalLayout = (LinearLayout) findViewById(R.id.additional_layout);
        mImageView.setOnItemSelectedClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelected(View view) {
        mAdditionalLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUnselected(View view) {
        mAdditionalLayout.setVisibility(View.GONE);
    }
}
