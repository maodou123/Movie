package com.example.movie;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;

import java.util.List;


/**
 * Created by Administrator on 2018/5/7.
 */

public class MAdapter extends RecyclerView.Adapter<MAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> mMovieList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView movieImage;

        public ViewHolder(View view)
        {
            super(view);
            movieImage=(ImageView)view.findViewById(R.id.movie_image);
        }
    }
    public MAdapter(List<Movie> movieList)
    {
        mMovieList=movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null)
        {
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.movie_item2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie movie=mMovieList.get(position);
        Glide.with(mContext).load(movie.getImageId()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

}
