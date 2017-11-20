package faisal.com.motor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import faisal.com.motor.models.Pabrikan;

public class TambahPabrikan extends AppCompatActivity {
    public EditText merk, asal, pendiri;
    public Button btntambahPabrikan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pabrikan);

        merk = (EditText) findViewById(R.id.idTeksMerk);
        asal = (EditText) findViewById(R.id.idTeksAsal);
        pendiri = (EditText) findViewById(R.id.idTeksPendiri);

        btntambahPabrikan = (Button) findViewById(R.id.idBtnTambahPebrikan);

       btntambahPabrikan.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Pabrikan mpabrik = new Pabrikan(merk.getText().toString(), asal.getText().toString(),pendiri.getText().toString());
               mpabrik.save();
               Intent i = new Intent(getApplicationContext(),MainActivity.class);
               i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
               startActivity(i);
           }
       });

    }
}
