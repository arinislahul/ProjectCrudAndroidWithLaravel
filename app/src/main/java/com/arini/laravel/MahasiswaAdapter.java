package com.arini.laravel;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arini.laravel.model.Mahasiswa;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MahasiswaAdapter extends ArrayAdapter<Mahasiswa>{

    List<Mahasiswa>mahasiswas;
    Context context;


    public MahasiswaAdapter(@NonNull Context context, int resource, @NonNull List<Mahasiswa> objects) {
        super(context, resource, objects);
        this.mahasiswas=objects;
        this.context=context;
    }


    public View getView(int position,
                        @NonNull View convertView,
                        @NonNull ViewGroup parent){
        if (convertView==null){
            convertView= LayoutInflater.from(getContext())
                                        .inflate(R.layout.item_mahasiswa,parent,false);
        }

        TextView tNama = convertView.findViewById(R.id.tnama);
        TextView tnim = convertView.findViewById(R.id.tnim);
        TextView temail = convertView.findViewById(R.id.temail);
        ImageView tFoto = convertView.findViewById(R.id.img);
        Picasso.with(context).load(mahasiswas.get(position).getFoto()).resize(50,50).into(tFoto);

        tNama.setText(mahasiswas.get(position).getNama());
        tnim.setText(mahasiswas.get(position).getNim());
        temail.setText(mahasiswas.get(position).getEmail());

        ImageView ivFoto = convertView.findViewById(R.id.img);
        Log.e("CRUD", "Foto:  http://192.168.43.86/laravel/LaraSort/" + mahasiswas.get(position).getFoto());
      //  Picasso.get().load(" http://172.16.92.225/laravel/LaraSort/" + mahasiswa.getFoto()).into(ivFoto);
        Picasso.with(context).load(" http://192.168.43.86/laravel/LaraSort/" +mahasiswas.get(position).getFoto()).resize(150,150).placeholder(R.mipmap.ic_launcher).into(tFoto);
        return convertView;


    }


}
