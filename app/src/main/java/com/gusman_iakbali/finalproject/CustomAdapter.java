package com.gusman_iakbali.finalproject;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by USER on 20/08/2017.
 */

public class CustomAdapter extends ArrayAdapter<Model>{
    Context context;
    int layoutResourceId;
    ArrayList<Model> data;

    public CustomAdapter(Context context, int layoutResourceId, ArrayList<Model> data) {
        super(context,layoutResourceId,data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    static class ViewHolder {
        ImageView icon;
        TextView title;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        ViewHolder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId,parent,false);

            holder = new ViewHolder();
            holder.icon = (ImageView) row.findViewById(R.id.ivIconList);
            holder.title = (TextView)row.findViewById(R.id.tvListTitle);
            row.setTag(holder);
        }else {
            holder = (ViewHolder)row.getTag();
        }
        Model model = data.get(position);
        holder.icon.setImageResource(model.icon);
        holder.title.setText(model.title);

        return row;
    }
}
