package com.example.forget.newsheadlineapp;

import android.content.Context;
import android.widget.GridView;

import java.util.ArrayList;

class GridViewPresenter {
    private GridView gridView = null;
    private GridViewAdapter gridViewAdapter = null;

    GridViewPresenter(Context _context, GridView _gridView){
        gridView = _gridView;
        gridViewAdapter = new GridViewAdapter(_context);
    }

    void UpdateData(ArrayList<GridViewItem> _arrayList){
        gridViewAdapter.setArrayList(_arrayList);
        gridViewAdapter.notifyDataSetChanged();
        gridView.setAdapter(gridViewAdapter);
    }
}
