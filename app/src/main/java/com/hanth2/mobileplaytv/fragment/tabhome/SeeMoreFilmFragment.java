package com.hanth2.mobileplaytv.fragment.tabhome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hanth2.mobileplaytv.R;
import com.hanth2.mobileplaytv.base.BaseFragment;

/**
 * Created by HanTH2 on 8/19/2016.
 */
public class SeeMoreFilmFragment extends BaseFragment {

    public SeeMoreFilmFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_see_more_film, container, false);
    }
}
