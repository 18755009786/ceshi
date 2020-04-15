package com.example.materialtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHoder> {

    private Context mContext;

    private List<Picture> mPictureList;

    static class ViewHoder extends  RecyclerView.ViewHolder {
        CardView cardView;
        ImageView pictureImage;
        TextView pictureName;

        public ViewHoder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            pictureImage = (ImageView) itemView.findViewById(R.id.picture_image);
            pictureName = (TextView) itemView.findViewById(R.id.picture_name);
        }
    }

    public PictureAdapter(List<Picture> pictureList){
        mPictureList = pictureList;
    }


    @Override
    public ViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.picture_item, parent, false);
        return new ViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoder holder, int position) {
        Picture picture = mPictureList.get(position);
        holder.pictureName.setText(picture.getName());
        Glide.with(mContext).load(picture.getImageId()).into(holder.pictureImage);
    }

    @Override
    public int getItemCount() {
        return mPictureList.size();
    }


}
