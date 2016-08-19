package com.hanth2.mobileplaytv.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.app.ActionBar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hanth2.mobileplaytv.R;
import com.hanth2.mobileplaytv.base.BaseFragmentActivity;
import com.hanth2.mobileplaytv.constant.AppConstants;
import com.hanth2.mobileplaytv.fragment.menu.HomeFragment;
import com.hanth2.mobileplaytv.fragment.menu.LikeFilmFragment;
import com.hanth2.mobileplaytv.fragment.menu.RecentFilmFragment;
import com.hanth2.mobileplaytv.listenners.MainActivityListener;

public class MainActivity extends BaseFragmentActivity implements View.OnClickListener, MainActivityListener{
    private RadioButton mBtnHome, mBtnRecent, mBtnLike;
    private RadioGroup mLayoutFooter;
    private AppConstants.TAG_TYPE mCurrentTab = AppConstants.TAG_TYPE.TAG_NONE;
    private Toolbar mToolbar;

    @Override
    protected Fragment onCreateMainFragment(Bundle savedInstancesState) {
        mCurrentTab = AppConstants.TAG_TYPE.TAG_HOME;
        return HomeFragment.newInstance();
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.layoutContent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        mBtnHome = (RadioButton) findViewById(R.id.btn_home);
        mBtnRecent = (RadioButton) findViewById(R.id.btn_recent);
        mBtnLike = (RadioButton) findViewById(R.id.btn_like);
        mLayoutFooter = (RadioGroup) findViewById(R.id.layoutFooter);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);

        mBtnHome.setOnClickListener(this);
        mBtnRecent.setOnClickListener(this);
        mBtnLike.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_home:
                HomeFragment homeFragment = HomeFragment.newInstance();
                showFragmentWithClearStack(homeFragment);
                mCurrentTab = AppConstants.TAG_TYPE.TAG_HOME;
                break;
            case R.id.btn_like:
                LikeFilmFragment likeFilmFragment = LikeFilmFragment.newInstance();
                showFragmentWithClearStack(likeFilmFragment);
                mCurrentTab = AppConstants.TAG_TYPE.TAG_LIKE;
                break;
            case R.id.btn_recent:
                RecentFilmFragment recentFilmFragment = RecentFilmFragment.newInstance();
                showFragmentWithClearStack(recentFilmFragment);
                mCurrentTab = AppConstants.TAG_TYPE.TAG_RECENT;
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_photo_profile:
                return true;
            case R.id.action_tilte_tab:
                return true;
            case R.id.action_more:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showFooterLayout() {
        mLayoutFooter.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideFooterLayout() {
        mLayoutFooter.setVisibility(View.GONE);
    }
}
