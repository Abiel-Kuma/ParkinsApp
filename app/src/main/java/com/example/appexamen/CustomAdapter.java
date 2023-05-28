package com.example.appexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Eventos> lst;

    public CustomAdapter(Context context, List<Eventos> lst) {
        this.context = context;
        this.lst = lst;
    }


    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imagenViewEvento;
        TextView textViewNombreEvento;
        TextView textViewLugar;

        Eventos c=lst.get(position);

        if (convertView==null)
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_parkins,null);
        imagenViewEvento = convertView.findViewById(R.id.imagenViewEvento);
        textViewNombreEvento = convertView.findViewById(R.id.txtNombreEvento);
        textViewLugar = convertView.findViewById(R.id.txtLugar);

        imagenViewEvento.setImageResource(c.imagen);
        textViewNombreEvento.setText(c.nombreEvento);
        textViewLugar.setText(c.Lugar);

        return convertView;
    }
}
