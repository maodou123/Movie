package com.example.movie;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CdtvActivity extends AppCompatActivity {
    private List<Movie> movieList=new ArrayList<>();
    private MAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cdmovie);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        initMovies();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MAdapter(movieList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return true;
    }
    private void initMovies()
    {
        for(int i=0;i<5;i++)
        {
            Movie movie1=new Movie(R.drawable.cmovie1);
            movieList.add(movie1);
            Movie movie2=new Movie(R.drawable.cmovie2);
            movieList.add(movie2);
            Movie movie3=new Movie(R.drawable.cmovie3);
            movieList.add(movie3);
            Movie movie4=new Movie(R.drawable.cmovie4);
            movieList.add(movie4);
            Movie movie5=new Movie(R.drawable.cmovie5);
            movieList.add(movie5);
            Movie movie6=new Movie(R.drawable.cmovie6);
            movieList.add(movie6);
        }
    }
}