package com.example.forget.newsheadlineapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class GridViewAdapter extends BaseAdapter {
    private ArrayList<GridViewItem> GridViewItemArrayList = new ArrayList<>();
    private SparseArray<WeakReference<View>> viewArray;
    private LayoutInflater inflater = null;
    private Context context;

    GridViewAdapter(Context _context){
        this.context = _context;
        this.viewArray = new SparseArray<>();
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount(){
        return GridViewItemArrayList.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if(viewArray != null && viewArray.get(position) != null) {
            convertView = viewArray.get(position).get();
            if(convertView != null)
                return convertView;
        }

        try {
            convertView = inflater.inflate(R.layout.grid_view_item, parent, false);
            AutoHeightImageView   imageView = (AutoHeightImageView) convertView.findViewById(R.id.image_view);
            TextView    textView = (TextView) convertView.findViewById(R.id.text_view);

            final GridViewItem gridViewItem = GridViewItemArrayList.get(position);

            textView.setText(gridViewItem.getTitleString());
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(context, StoryActivity.class);
                    intent.setData(Uri.parse(gridViewItem.getUrlString()));
                    context.startActivity(intent);
                }
            });

            imageView.setImageBitmap(null);
            Glide.with(parent.getContext()).load(gridViewItem.getImageUrlString()).into(imageView);
        } finally {
            viewArray.put(position, new WeakReference<>(convertView));
        }
        return convertView;
    }

    public long getItemId(int position) {
        return position ;
    }

    public GridViewItem getItem(int position) {
        return GridViewItemArrayList.get(position) ;
    }


    void setArrayList(ArrayList<GridViewItem> _GridViewItemArrayList){
        GridViewItemArrayList = _GridViewItemArrayList;
    }
}
