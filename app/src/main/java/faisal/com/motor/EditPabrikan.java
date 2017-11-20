package faisal.com.motor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import faisal.com.motor.models.Pabrikan;

public class EditPabrikan extends AppCompatActivity {
    public EditText edMerk,edAsal,edPendiri;
    public Button BtneditPabrik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pabrikan);

        Intent i = getIntent();
        final Long idPabrik = i.getLongExtra("idPabrik",0L);
        final Pabrikan editPabrik = Pabrikan.findById(Pabrikan.class,idPabrik);

        edMerk = (EditText) findViewById(R.id.idTeksEditMerk);
        edMerk.setText(editPabrik.getMerk());
        edAsal = (EditText) findViewById(R.id.idTeksEditAsal);
        edAsal.setText(editPabrik.getMerk());
        edPendiri = (EditText) findViewById(R.id.idTeksEditPendiri);
        edPendiri.setText(editPabrik.getAsal());

        BtneditPabrik = (Button) findViewById(R.id.idBtnSimpanEditPebrikan);
        BtneditPabrik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               editPabrik.merk = edMerk.getText().toString();
                editPabrik.asal = edAsal.getText().toString();
                editPabrik.pendiri = edPendiri.getText().toString();

                editPabrik.save();
                finish();
                Intent i = new  Intent(getApplicationContext(),MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }
}
