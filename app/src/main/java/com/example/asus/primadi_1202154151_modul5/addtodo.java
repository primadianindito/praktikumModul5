package com.example.asus.primadi_1202154151_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class addtodo extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    EditText list, Description, Priority;
    database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodo);
        //set title menjadi add to do
        setTitle("Add To Do");

        //mengakses id edit text pada layout
        list = (EditText) findViewById(R.id.editTodo);
        Description = (EditText) findViewById(R.id.editDesc);
        Priority = (EditText) findViewById(R.id.editPriority);
        db = new database(this);
    }

    @Override
    public void onBackPressed() {
        //intent dari add to do menuju list to do
        Intent intent = new Intent(addtodo.this, todolist.class);
        //memulai intent
        startActivity(intent);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    //method yang dijalanan ketika tombol tambah to do di klik
    public void tambah(View view) {
        //apabila data todoname, deskripsi dan prioritas di isi,
        if (db.inputdata(new AddData(list.getText().toString(), Description.getText().toString(), Priority.getText().toString()))) {
            //maka akan menampilkan toast bawha data berhasil di tambahkan ke dalam list
            Toast.makeText(this, "List Ditambahkan", Toast.LENGTH_SHORT).show();
            //berpindah dari add to do ke list to do
            startActivity(new Intent(addtodo.this, todolist.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        } else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "List tidak boleh kosong", Toast.LENGTH_SHORT).show();
            //set semua edit text menjadi kosong
            list.setText(null);
            Description.setText(null);
            Priority.setText(null);

        }
    }
}
