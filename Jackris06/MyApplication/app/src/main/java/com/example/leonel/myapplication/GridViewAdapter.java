package com.example.leonel.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by LEONEL on 4/9/2017.
 */

public class GridViewAdapter extends BaseAdapter {

    List<String> lstSource;
    Context mContext;

    public GridViewAdapter(List<String> lstSource, Context mContext) {
        this.lstSource = lstSource;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return lstSource.size();
    }

    @Override
    public Object getItem(int position) {
        return lstSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button button;
        if(convertView == null){
            button = new Button(mContext);
            button.setLayoutParams(new GridView.LayoutParams(100,100));
            button.setPadding(0,0,0,0);
            button.setText("BAA");
            button.setBackgroundColor(Color.DKGRAY);
            button.setTextColor(Color.YELLOW);
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext,button.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
            button = (Button) convertView;
        return button;
    }
}
