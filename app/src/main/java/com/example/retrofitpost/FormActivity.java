package com.example.retrofitpost;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FormActivity extends AppCompatActivity {

    private EditText editNama, editAlamat, editJk, editTelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        editNama = (EditText) findViewById(R.id.edit_nama);
        editAlamat = (EditText) findViewById(R.id.edit_alamat);
        editJk = (EditText) findViewById(R.id.edit_jk);
        editTelp =(EditText) findViewById(R.id.edit_telp);
    }

    public void submit(View view) {
        String nama = editNama.getText().toString().trim();
        String alamat = editAlamat.getText().toString().trim();
        String jenis_kelamin = editJk.getText().toString().trim();
        String no_telp = editTelp.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://retrofitmahasiswa.000webhostapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Post post = new Post(nama, alamat, jenis_kelamin, no_telp);

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    Toast.makeText(FormActivity.this, "Data berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(FormActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(FormActivity.this, "Data gagal ditambahkan", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
