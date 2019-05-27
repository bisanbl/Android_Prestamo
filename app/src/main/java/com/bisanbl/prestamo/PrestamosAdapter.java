package com.bisanbl.prestamo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class PrestamosAdapter extends BaseAdapter  {

    private Context context;
    private List<VerPrestamo> prestamos;

    public PrestamosAdapter(Context context, List<VerPrestamo> prestamos) {
        this.context = context;
        this.prestamos = prestamos;
    }

    @Override
    public int getCount() {
        return prestamos.size();
    }

    @Override
    public Object getItem(int position) {
        return prestamos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_prestamo,null);

        TextView TEXTnamep = convertView.findViewById(R.id.TEXTnamep);
        TextView TEXTmontop = convertView.findViewById(R.id.TEXTmontop);
        TextView TEXTmesesp = convertView.findViewById(R.id.TEXTmesesP);

        TEXTnamep.setText(prestamos.get(position).getName());
        TEXTmontop.setText(Float.toString(prestamos.get(position).getMonto()));
        TEXTmesesp.setText(Integer.toString(prestamos.get(position).getPlazo()));

        return convertView;
    }
}
