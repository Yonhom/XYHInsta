package com.xuyonghong.xyhinsta.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xuyonghong.xyhinsta.R;
import com.xuyonghong.xyhinsta.adapter.InstaFeedAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * notice that: ListXXXXXXX, like ListActivity`ListFragment, is only a convienient class
 * for fragment or activity that have only one ListView, if your fragment or activity don't
 * have a listview, just use a normal Fragment
 * Created by xuyonghong on 2017/5/30.
 */

public class FeedFragment extends Fragment {
    @BindView(R.id.feed_main_view)
    RecyclerView mFeedMainView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.feed_fragment_view, container, false);
        ButterKnife.bind(this, view);


        mFeedMainView.setHasFixedSize(true);
        LinearLayoutManager llManager = new LinearLayoutManager(getContext());
        mFeedMainView.setLayoutManager(llManager);
        // feed fragment adapter
        InstaFeedAdapter adapter = new InstaFeedAdapter(getContext());
        mFeedMainView.setAdapter(adapter);

        return view;
    }
}
