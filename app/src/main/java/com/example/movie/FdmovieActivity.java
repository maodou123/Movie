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

public class FdmovieActivity extends AppCompatActivity {
    private List<Movie> movieList=new ArrayList<>();
    private MAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdmovie);
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
        for(int i=0;i<6;i++)
        {
            Movie movie1=new Movie(R.drawable.personmovie1);
            movieList.add(movie1);
            Movie movie2=new Movie(R.drawable.personmovie2);
            movieList.add(movie2);
            Movie movie3=new Movie(R.drawable.personmovie3);
            movieList.add(movie3);
            Movie movie4=new Movie(R.drawable.personmovie4);
            movieList.add(movie4);
            Movie movie5=new Movie(R.drawable.personmovie5);
            movieList.add(movie5);
        }
    }

}
