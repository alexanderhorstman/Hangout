package com.example.alexh.hangout;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends ArrayAdapter<String> {

    private boolean freeTime[][];
    private Context context;
    private String[] times;

    public GridAdapter(Context context, String[] times, boolean[][] freeTime) {
        super(context, R.layout.text_layout, times);
        this.context = context;
        this.times = times;
        this.freeTime = freeTime;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public String getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder viewHolder = new Holder();
        int column = position % 7;
        int row = (position - column) / 7;

        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.text_layout, parent, false);
            viewHolder.textView = (TextView) view.findViewById(R.id.text_view_text_layout);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) view.getTag();
        }
        if(freeTime[row][column]) {
            viewHolder.textView.setBackgroundColor(Color.GREEN);
        }
        else {
            viewHolder.textView.setBackgroundColor(Color.RED);
        }
        viewHolder.textView.setText(times[position]);

        return view;
    }

    class Holder {
        protected TextView textView;
    }
}
