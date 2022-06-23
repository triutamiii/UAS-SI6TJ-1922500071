package com.example.uas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DosAdapter extends BaseAdapter {
    Activity activity;
    List<Data> items;
    private LayoutInflater inflater;

    public DosAdapter(Activity activity, List<Data> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) convertView = inflater.inflate(R.layout.list, null);

        TextView nidn = (TextView) convertView.findViewById(R.id.nidn);
        TextView nama_dosen = (TextView) convertView.findViewById(R.id.nama);
        TextView jabatan = (TextView) convertView.findViewById(R.id.jabatan);
        TextView gol_pang = (TextView) convertView.findViewById(R.id.golongan);
        TextView keahlian = (TextView) convertView.findViewById(R.id.keahlian);
        TextView program_studi = (TextView) convertView.findViewById(R.id.prodi);

        Data data = items.get(position);

        nidn.setText(data.getNidn());
        nama_dosen.setText(data.getnama_dosen());
        jabatan.setText(data.getJabatan());
        gol_pang.setText(data.getgol_pang());
        keahlian.setText(data.getKeahlian());
        program_studi.setText(data.getprogram_studi());

        return convertView;
    }
}

