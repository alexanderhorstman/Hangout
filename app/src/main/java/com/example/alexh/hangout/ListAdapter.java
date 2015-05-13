package com.example.alexh.hangout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String>{
    Context context;
    ActivityList list;

    public ListAdapter(Context context, String[] values, ActivityList list) {
        super(context, R.layout.abc_screen_simple, values);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) convertView;
        if(textView == null) {
            textView = new TextView(context);
        }

        return textView;
    }
}
