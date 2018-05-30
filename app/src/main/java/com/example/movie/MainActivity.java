package com.example.movie;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    BottomNavigationBar mBottomNavigationBar;
    private IndexFragment indexFragment;
    private MapFragment mapFragment;
    private LoveFragment loveFragment;
    private PersonFragment personFragment;
    private BadgeItem badgeItem;
    private DrawerLayout mDrawerLatout;
    private Button drawerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerButton=(Button)findViewById(R.id.drawerButton);
       // LayoutInflater factor=LayoutInflater.from(MainActivity.this);//这里三行代码获取其他布局文件的id，否则空指针报错
       // View layout=factor.inflate(R.layout.fragment_index,null);
        //Button tinyButton=(Button)layout.findViewById(R.id.tinyButton);
        mDrawerLatout=(DrawerLayout)findViewById(R.id.drawer_layout);
        initBadge();
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.back);
        setDefaultFragment();
        InitNavigationBar();
        drawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLatout.closeDrawers();
            }
        });

    }

    private void InitNavigationBar() {
        mBottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.setTabSelectedListener(this);
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.home,"首页").setActiveColorResource(R.color.grey))
                .addItem(new BottomNavigationItem(R.drawable.tv,"电视剧").setActiveColorResource(R.color.grey))
                .addItem(new BottomNavigationItem(R.drawable.rank,"排行版").setActiveColorResource(R.color.grey).setBadgeItem(badgeItem))
                .addItem(new BottomNavigationItem(R.drawable.people,"个人中心").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(0)
                .initialise();
    }
    public void initBadge()
    {
        badgeItem = new BadgeItem()
                .setBorderWidth(2)
                .setBorderColor("#ffffff")
                .setBackgroundColor("#ffffff")
                .setGravity(Gravity.RIGHT| Gravity.TOP)
                .setText("2")
                .setTextColor("#000000")
                .setAnimationDuration(1000)
                .setHideOnSelect(true);
    }
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        indexFragment = new IndexFragment();
        transaction.replace(R.id.fragment_container, indexFragment);
        transaction.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.delete:
                //这里写删除菜单逻辑
                break;
            case android.R.id.home:
               mDrawerLatout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
    }

    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (indexFragment == null) {
                    indexFragment = new IndexFragment();
                }
                transaction.replace(R.id.fragment_container, indexFragment);
                break;
            case 1:
                if (mapFragment== null) {
                    mapFragment = new MapFragment();
                }
                transaction.replace(R.id.fragment_container, mapFragment);
                break;
            case 2:
                if (loveFragment == null) {
                    loveFragment = new LoveFragment();
                }
                transaction.replace(R.id.fragment_container,loveFragment);
                break;
            case 3:
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                }
                transaction.replace(R.id.fragment_container,personFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {

    }
    @Override
    public void onTabReselected(int position) {

    }

}
