package com.alexzh.circleimageviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alexzh.circleimageview.CircleImageView;
import com.alexzh.circleimageview.ItemSelectedListener;


public class MainActivity extends AppCompatActivity implements ItemSelectedListener {

    private CircleImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = (CircleImageView) findViewById(R.id.imageView);

        mImageView.setOnItemSelectedClickListener(new ItemSelectedListener() {
            @Override
            public void onSelected(View view) {
                Toast.makeText(getApplicationContext(), "onSelected", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onUnselected(View view) {
                Toast.makeText(getApplicationContext(), "onUnselected", Toast.LENGTH_SHORT).show();
            }
        });
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
        //mAdditionalLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onUnselected(View view) {
        //mAdditionalLayout.setVisibility(View.GONE);
    }
}
