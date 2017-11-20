package faisal.com.motor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import faisal.com.motor.models.JenisMotor;
import faisal.com.motor.models.Pabrikan;

public class TambahJenisMotor extends AppCompatActivity {
    public EditText jenisMotor;

   public Button btnTambahJenis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_jenis_motor);
//idPabrik

        Intent i = getIntent();
        final Long idJenis = i.getLongExtra("idPabrik", 0L);
        final Pabrikan dd = Pabrikan.findById(Pabrikan.class, idJenis);

        jenisMotor = (EditText) findViewById(R.id.idTextEditJenis);
        btnTambahJenis = (Button) findViewById(R.id.BtnTambahJenis);
        jenisMotor.requestFocus();

        btnTambahJenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JenisMotor jenis = new JenisMotor(jenisMotor.getText().toString(),dd);
                jenis.save();
                Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });


    }
}
