package com.example.dom.mh;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList1 extends ArrayAdapter<String > {

    private final Activity context;
    private final String[] web1;
    //private final String[] web2;
    private final Integer[] imageId1;
    public CustomList1(Activity context, String[] web1, Integer[] imageId1) {
        super(context, R.layout.single_list, web1);
        this.context = context;
        this.web1 = web1;
        this.imageId1 = imageId1;
        //this.web2=web2;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.single_list, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        //TextView txtDesc=(TextView)rowView.findViewById(R.id.txt1);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web1[position]);

        imageView.setImageResource(imageId1[position]);
        return rowView;
    }

}