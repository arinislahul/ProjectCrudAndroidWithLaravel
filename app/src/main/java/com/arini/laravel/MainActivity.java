package com.arini.laravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.arini.laravel.model.Mahasiswa;
import com.arini.laravel.model.MahasiswaResult;
import com.arini.laravel.network.ApiClient;
import com.arini.laravel.network.MahasiswaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mahasiswa> mahasiswaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ImageView ivCobaGambar = (ImageView)findViewById(R.id.iv_coba_gambar);

//        //muat gambar dari URL
//        int SDK_INT = Build.VERSION.SDK_INT;
//        if (SDK_INT > 8){
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//
//            try {
//                URL url = new URL("http://picsum.photos/200/300?random");
//                Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                ivCobaGambar.setImageBitmap(bmp);
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

       // Picasso.with(this).load("http://picsum.photos/200/300?random").into(ivCobaGambar);

        //1.Menyiapkan sumber data seperti string di bawah ini
        //1.a.array string
       // String[] user = new String[]{"Prayitno", "Jono", "Joko", "Joni"};
//        ArrayList<String> users=new ArrayList<>();
//        users.add("User 1");
//        users.add("User 2");
//        users.add("User 3");
//        users.add("User 4");
//        users.add("User 5");

        //1.b data berupa pojo

        //POJO(Plain Old Java Object)
//        Mahasiswa mahasiswa = new Mahasiswa();
//        mahasiswa.setNama("Arini");
//        mahasiswa.setNim("3.34.15.0.11");
//        mahasiswa.setEmail("arini@arini.com");
//        mahasiswa.setFoto("http://picsum.photos/200/300?random");
//
//        Mahasiswa mahasiswa1 = new Mahasiswa();
//        mahasiswa1.setNama("Islahul");
//        mahasiswa1.setNim("3.34.15.0.22");
//        mahasiswa1.setEmail("islahul@islahul.com");
//        mahasiswa1.setFoto("http://picsum.photos/200/300?random");
//
//        Mahasiswa mahasiswa2 = new Mahasiswa();
//        mahasiswa2.setNama("Ni'mah");
//        mahasiswa2.setNim("3.34.15.0.33");
//        mahasiswa2.setEmail("nimah@islahul.com");
//        mahasiswa2.setFoto("http://picsum.photos/200/300?random");
//
//        mahasiswaList = new ArrayList<>();
//        mahasiswaList.add(mahasiswa);
//        mahasiswaList.add(mahasiswa1);
//        mahasiswaList.add(mahasiswa2);

        //1.c SUMBER DATA DARI API/JSON PROJECT

        MahasiswaService mService = ApiClient.getmRetrofit().create(MahasiswaService.class);

        Call<MahasiswaResult> mahasiswas = mService.getMahasiswas();
        mahasiswas.enqueue(new Callback<MahasiswaResult>() {
            @Override
            public void onResponse(Call<MahasiswaResult> call, Response<MahasiswaResult> response) {
               // tampilkan(response.body().getMahasiswas());
                response.body().getMahasiswas();
                Toast.makeText(
                        getApplicationContext(),
                        "Jumlah mahasiswa: " +response.body().getMahasiswas().size(),Toast.LENGTH_LONG
                ).show();
            }

            @Override
            public void onFailure(Call<MahasiswaResult> call, Throwable t) {

            }
        });

    }
    private void tampilkan(List<Mahasiswa>mahasiswas) {
        //2.Menyiapkan adapter untuk mengkomunikasikan sumber data dgn tampilan
        MahasiswaAdapter userAdapter = new MahasiswaAdapter(MainActivity.this, 0, mahasiswas);


        //ArrayAdapter<String> userAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, user);

        //3.Inisialisasi ke tampilan aplikasi
        ListView lvUser = (ListView) findViewById(R.id.lv_user);
        lvUser.setAdapter(userAdapter);
    }
}
