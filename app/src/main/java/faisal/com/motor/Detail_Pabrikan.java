package faisal.com.motor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import faisal.com.motor.models.Pabrikan;

public class Detail_Pabrikan extends AppCompatActivity {
    TextView tXmerk, tXasal, tXpendiri;
    Button BtnEditDetailPabrik, BtnHpusDetailPabrik, BtnTambahJenisMotor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__pabrikan);

        Intent i = getIntent();
        final Long idPabrik = i.getLongExtra("idPabrik",0L);
        final Pabrikan detailPabrik = Pabrikan.findById(Pabrikan.class,idPabrik);

        tXmerk = (TextView) findViewById(R.id.IDtektMerkDetail);
        tXmerk.setText(detailPabrik.getMerk());
        tXasal = (TextView) findViewById(R.id.IDTextasalDetail);
        tXasal.setText(detailPabrik.getAsal());
        tXpendiri = (TextView) findViewById(R.id.IDtextPendriDetial);
        tXpendiri.setText(detailPabrik.getPendiri());

        BtnEditDetailPabrik = (Button) findViewById(R.id.idBtnEditPabrikanDetail);
        BtnEditDetailPabrik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EditPabrikan.class);
                i.putExtra("idPabrik",detailPabrik.getId());
                startActivity(i);
            }
        });

        BtnHpusDetailPabrik = (Button) findViewById(R.id.idBtnHapusPabrikanDetail);
        BtnHpusDetailPabrik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Pabrikan hapusPabrik = Pabrikan.findById(Pabrikan.class,idPabrik);
                hapusPabrik.delete();
                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });

        BtnTambahJenisMotor= (Button) findViewById(R.id.idBtnTambahJenisMotor);
        BtnTambahJenisMotor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                i.putExtra("idPabrik",detailPabrik.getId());
                startActivity(i);
            }
        });



    }
}
