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
import java.util.Locale;

import faisal.com.motor.adapter.AdapterJenis;
import faisal.com.motor.models.JenisMotor;
import faisal.com.motor.models.Pabrikan;

public class Main2Activity extends AppCompatActivity {


    private Button BtntambahJenis;
    private AdapterJenis mAdapter;
    private List<JenisMotor>daftarMotor = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        final Long idJenis = i.getLongExtra("idPabrik", 0L);
        final Pabrikan detPa = Pabrikan.findById(Pabrikan.class, idJenis);

        daftarMotor = JenisMotor.find(JenisMotor.class, "fpabrik = ?", idJenis.toString());

        RecyclerView recycleJenis = (RecyclerView) findViewById(R.id.idRecycleJenisMotor);
        mAdapter = new AdapterJenis(getApplicationContext(), daftarMotor);
        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getApplicationContext());
        recycleJenis.setLayoutManager(mlayoutManager);
        recycleJenis.setItemAnimator(new DefaultItemAnimator());
        recycleJenis.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();


        BtntambahJenis = (Button) findViewById(R.id.idTambahJenis);
        BtntambahJenis.setOnClickListenerr(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), TambahJenisMotor.class);
                i.putExtra("idPabrik",detPa.getId());
                startActivity(i);
            }
        });


    }
}
