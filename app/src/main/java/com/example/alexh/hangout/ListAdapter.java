package com.example.alexh.hangout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String>{
    Context context;
    ActivityList list;

    public ListAdapter(Context context, String[] values, ActivityList list) {
        super(context, R.layout.text_layout, values);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder viewHolder = new Holder();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.text_layout, null);
            viewHolder.textView = (TextView) view.findViewById(R.id.text_view_text_layout);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (Holder) view.getTag();
        }
        viewHolder.textView.setText(list.getActivity(position).toString());
        return view;
    }
    public void setLayoutsParams(ViewGroup.LayoutParams params) {

    }

    public void setList(ActivityList list) {
        this.list = list;
    }

    class Holder {
        TextView textView;
    }
}
