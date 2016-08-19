package com.hanth2.mobileplaytv.fragment.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.hanth2.mobileplaytv.R;
import com.hanth2.mobileplaytv.base.BaseFragment;
import com.hanth2.mobileplaytv.fragment.tabhome.NewFilmFragment;
import com.hanth2.mobileplaytv.fragment.tabhome.OddFilmFragment;
import com.hanth2.mobileplaytv.fragment.tabhome.SeeMoreFilmFragment;
import com.hanth2.mobileplaytv.fragment.tabhome.TheatersFilmFragment;
import com.hanth2.mobileplaytv.fragment.tabhome.TopVoteFilmFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HanTH2 on 8/19/2016.
 */
public class HomeFragment extends BaseFragment {
    private static HomeFragment instance;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static HomeFragment newInstance(){
        if (instance == null){
            instance = new HomeFragment();
        }
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new SeeMoreFilmFragment(), getString(R.string.fragment_see_more_film));
        adapter.addFragment(new OddFilmFragment(), getString(R.string.fragment_odd_film_text));
        adapter.addFragment(new NewFilmFragment(), getString(R.string.fragment_new_film_text));
        adapter.addFragment(new TopVoteFilmFragment(), getString(R.string.fragment_top_vote_film));
        adapter.addFragment(new TheatersFilmFragment(), getString(R.string.fragment_theaters_film));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
