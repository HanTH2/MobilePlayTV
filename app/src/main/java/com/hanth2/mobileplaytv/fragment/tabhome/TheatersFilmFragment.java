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
public class TheatersFilmFragment extends BaseFragment {

    public TheatersFilmFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_theaters_film, container, false);
        return view;
    }
}
