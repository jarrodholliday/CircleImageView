package com.alexzh.circleimageviewexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alexzh.circleimageview.CircleImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.ViewHolder> {
    private Context mContext;
    private List<AndroidVersion> mList;

    public AndroidVersionAdapter(Context context, List<AndroidVersion> list) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.item_android_version, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.updateAndroidVersion(mContext, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;
        private CircleImageView mCircleImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mName = (TextView) itemView.findViewById(R.id.nameTextView);
            mCircleImageView = (CircleImageView) itemView.findViewById(R.id.logoCircleImageView);
        }

        public void updateAndroidVersion(Context context, AndroidVersion item) {
            mName.setText(item.getName());
            if (item.getLogoPath() != null) {
                Picasso.with(context)
                        .load(item.getLogoPath())
                        .centerCrop()
                        .fit()
                        .into(mCircleImageView);
            } else {
                Picasso.with(context)
                        .load(R.drawable.android_logo)
                        .centerCrop()
                        .fit()
                        .into(mCircleImageView);
            }
        }
    }
}
