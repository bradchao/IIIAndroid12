package com.example.iiiandroid12;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private Fragment[] fs = new Fragment[5];
    private String[] titles = {"Page1", "Page2", "Page3"};
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        fs[0] = new P0(); fs[1] = new P1(); fs[2] = new P2();
        fs[3] = new P3(); fs[4] = new P4();
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        initActionBar();
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Log.v("brad", "Page = " + position);

                if (position == 0){
                    viewPager.setCurrentItem(1);
                }else if(position == 4) {
                    viewPager.setCurrentItem(3);
                }else{
                    actionBar.setSelectedNavigationItem(position-1);
                }
            }
        });
        viewPager.setCurrentItem(1);
    }

    private void initActionBar(){
        actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        MyTabListener myTabListener = new MyTabListener();
        actionBar.addTab(
                actionBar.newTab().setText("Page1")
                        .setTabListener(myTabListener));
        actionBar.addTab(
                actionBar.newTab().setText("Page2")
                        .setTabListener(myTabListener));
        actionBar.addTab(
                actionBar.newTab().setText("Page3")
                        .setTabListener(myTabListener));
    }

    private class MyTabListener implements ActionBar.TabListener {

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            viewPager.setCurrentItem(tab.getPosition()+1);
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        }
    }


    public void gotoP1(View view) {
        viewPager.setCurrentItem(1);
    }
    public void gotoP2(View view) {
        viewPager.setCurrentItem(2);
    }
    public void gotoP3(View view) {
        viewPager.setCurrentItem(3);
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fs[position];
        }

        @Override
        public int getCount() {
            return fs.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            if (position !=0 && position != 4){
                title = titles[position-1];
            }
            return title;
        }
    }
}
