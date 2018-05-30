package com.example.movie;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CmovieActivity extends AppCompatActivity {
    private List<Movie> movieList=new ArrayList<>();
    private MAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmovie);
        Button button1=(Button)findViewById(R.id.button1);
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CmovieActivity.this,CdmovieActivity.class);
                startActivity(intent);
            }
        });
        initMovies();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycle_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MAdapter(movieList);
        recyclerView.setAdapter(adapter);
        SliderLayout mDemoSlider = (SliderLayout) findViewById(R.id.slider);
        HashMap<String,Integer> urlMaps = new HashMap<>();
        urlMaps.put("Tiny Times", R.drawable.head3);
        urlMaps.put("Crazy Stone", R.drawable.head2);
        urlMaps.put("大话西游2",R.drawable.head1);

        for (String name : urlMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(name)//这里显示文字信息
                    .image(urlMaps.get(name))//image方法可以传入图片url、资源id、File
                    .setScaleType(BaseSliderView.ScaleType.Fit)//图片缩放类型
                    .setOnSliderClickListener(onSliderClickListener);//图片点击
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle().putString("extra", name);//传入参数
            mDemoSlider.addSlider(textSliderView);//添加一个滑动页面
        }

        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);//滑动动画
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);//默认指示器样式
        mDemoSlider.setCustomIndicator((PagerIndicator) findViewById(R.id.custom_indicator2));//自定义指示器
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());//设置图片描述显示动画
        mDemoSlider.setDuration(5000);//设置滚动时间，也是计时器时间
        mDemoSlider.addOnPageChangeListener(onPageChangeListener);
    }
    private BaseSliderView.OnSliderClickListener onSliderClickListener=new BaseSliderView.OnSliderClickListener() {
        @Override
        public void onSliderClick(BaseSliderView slider) {
            Toast.makeText(CmovieActivity.this,slider.getBundle().get("extra") + "",
                    Toast.LENGTH_SHORT).show();
        }
    };
    private ViewPagerEx.OnPageChangeListener onPageChangeListener=new ViewPagerEx.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {}
    };
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
            Movie movie1=new Movie(R.drawable.cmovie7);
            movieList.add(movie1);
            Movie movie2=new Movie(R.drawable.cmovie8);
            movieList.add(movie2);
            Movie movie3=new Movie(R.drawable.cmovie9);
            movieList.add(movie3);
            Movie movie4=new Movie(R.drawable.cmovie10);
            movieList.add(movie4);
            Movie movie5=new Movie(R.drawable.cmovie11);
            movieList.add(movie5);
            Movie movie6=new Movie(R.drawable.cmovie12);
            movieList.add(movie6);
        }
    }
}
