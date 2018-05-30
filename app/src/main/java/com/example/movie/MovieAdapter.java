package com.example.movie;

import android.content.Context;
import android.content.Intent;
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

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private Context mContext;
    private List<Movie> mMovieList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View movieView;
        ImageView movieImage;

        public ViewHolder(View view)
        {
            super(view);
            movieView=view;
            movieImage=(ImageView)view.findViewById(R.id.movie_image);
        }
    }
    public MovieAdapter(List<Movie> movieList)
    {
       mMovieList=movieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext==null)
        {
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.movie_item,parent,false);
        final ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       Movie movie=mMovieList.get(position);
     Glide.with(mContext).load(movie.getImageId()).into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

}
