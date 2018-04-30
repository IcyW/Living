package com.tencent.living;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager homeViewPager;
    private BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.navigation_record:
                    homeViewPager.setCurrentItem(0);
                    break;
                case R.id.navigation_ground:
                    homeViewPager.setCurrentItem(1);
                    break;
                case R.id.navigation_message:
                    homeViewPager.setCurrentItem(2);
                    break;
                case R.id.navigation_user:
                    homeViewPager.setCurrentItem(3);
                    break;
            }

            return true;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViewPager();
        initNavigation();
    }

    private void initNavigation(){
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private void initViewPager() {
        homeViewPager = (ViewPager)findViewById(R.id.homeViewPager);
        List<Fragment> fragList = new ArrayList<>();
        fragList.add(new RecordFragment());
        fragList.add(new GroundFragment());
        fragList.add(new MessageFragment());
        fragList.add(new UserFragment());
        homeViewPager.setAdapter(new FragmentAdapter(
                this.getSupportFragmentManager(), fragList));
    }

    /* 一个内部类，只用于ViewPager处理其内部的Fragments */
    private class FragmentAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;
        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }
        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
