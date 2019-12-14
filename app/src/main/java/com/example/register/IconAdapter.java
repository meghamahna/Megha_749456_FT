package com.example.register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

class IconAdapter extends BaseAdapter {

    Context context;
    int[] images;

    public IconAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }



    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_item, null);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);
        return convertView;
    }
}
