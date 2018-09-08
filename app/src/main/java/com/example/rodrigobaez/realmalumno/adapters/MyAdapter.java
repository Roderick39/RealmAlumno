package com.example.rodrigobaez.realmalumno.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.rodrigobaez.realmalumno.models.Alumno;
import com.example.rodrigobaez.realmalumno.R;

import java.util.List;

import io.realm.RealmResults;

public class MyAdapter extends BaseAdapter {

    private List<Alumno> list;
    private int layout;
    private Context context;

    public MyAdapter(RealmResults<Alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Alumno getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textViewId);
            vh.Alumno = (TextView) convertView.findViewById(R.id.textViewAlumno);
            convertView.setTag(vh);


        } else {
            vh = (ViewHolder) convertView.getTag();

        }
        Alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.Alumno.setText(p.getRut()+ " "+  p.getNombre()+" "+ p.getApellido()+ " "+ p.getEdad()+ " "+ p.getCarrera()+ " "+ p.getAno()+ " "+p.getSemestre());

        return convertView;
    }
    public class ViewHolder {
        TextView id;
        TextView Alumno;

    }
}