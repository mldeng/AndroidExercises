package com.example.junyizhou.recyclerviewdemo.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.junyizhou.recyclerviewdemo.R;
import com.example.junyizhou.recyclerviewdemo.decoration.DividerGridItemDecoration;
import com.example.junyizhou.recyclerviewdemo.foundation.RecyclerListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JunyiZhou on 2016/1/4.
 */
public class StaggeredGridHorizontalListDemoFragment extends RecyclerListFragment {

    private List<String> mDataList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public ViewHolder getViewHolder(ViewGroup parent) {
        return new CharViewHolder(parent);
    }

    protected void initData() {
        mDataList = new ArrayList<>();
        for (int i = 'A'; i < 'z'; i++) {
            mDataList.add("" + (char) i);
        }
        setDataList(mDataList);
    }


    @Override
    public RecyclerView.LayoutManager createLayoutManager() {
        return new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL);
    }

    @Override
    public RecyclerView.ItemDecoration createItemDecoration() {
        return new DividerGridItemDecoration(getActivity());
    }

    @Override
    public RecyclerView.ItemAnimator createItemAnimator() {
        return null;
    }

    class CharViewHolder extends ViewHolder<String> {

        TextView tvChar;

        public CharViewHolder(ViewGroup parent) {
            this(LayoutInflater.from(getActivity()).inflate(R.layout.item_grid, parent, false));
        }

        public CharViewHolder(View view) {
            super(view);
            tvChar = (TextView) view.findViewById(R.id.tv_char);
        }

        @Override
        public void bind(String item, int position) {
            tvChar.setText(item);
        }
    }
}
