package com.example.register;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

class DisplayAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> names;
    ArrayList<String> emails;
    ArrayList<String> phones;
    int image;

    public DisplayAdapter(Context context, ArrayList<String> names, ArrayList<String> emails, ArrayList<String> phones, int image) {
        this.context = context;
        this.names = names;
        this.emails = emails;
        this.phones = phones;
        this.image = image;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.cell_item_listview, null);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        imageView.setImageResource(image);
        TextView email = convertView.findViewById(R.id.email);
        TextView phone = convertView.findViewById(R.id.phone);
        TextView name = convertView.findViewById(R.id.name);
        email.setText(emails.get(position));
        phone.setText(phones.get(position));
        name.setText(names.get(position));
        return convertView;
    }

}
