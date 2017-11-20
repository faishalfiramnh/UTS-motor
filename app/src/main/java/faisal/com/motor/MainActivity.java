package faisal.com.motor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import faisal.com.motor.adapter.AdapterPabrik;
import faisal.com.motor.models.Pabrikan;

public class MainActivity extends AppCompatActivity {

    private Button btnTambahPabrik;
    private AdapterPabrik mAdapter;
    private List<Pabrikan> DaftarPabrik = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaftarPabrik = Pabrikan.listAll(Pabrikan.class);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.IdPabrikan);
        mAdapter = new AdapterPabrik(getApplicationContext(),DaftarPabrik);
        RecyclerView.LayoutManager mlayout = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mlayout);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        btnTambahPabrik = (Button) findViewById(R.id.idTambahPabrik);
       btnTambahPabrik.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(getApplicationContext(),TambahPabrikan.class);
               startActivity(i);
           }
       });
    }
}
