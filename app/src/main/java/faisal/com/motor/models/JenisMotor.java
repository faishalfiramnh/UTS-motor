package faisal.com.motor.models;

import com.orm.SugarRecord;

/**
 * Created by Man. United on 14/11/2017.
 */

public class JenisMotor extends SugarRecord<JenisMotor>{
    public String jenisNamaMotor;
    public Pabrikan fpabrik;

    public JenisMotor(String jenisNamaMotor, Pabrikan fpabrik) {
        this.jenisNamaMotor = jenisNamaMotor;
        this.fpabrik = fpabrik;
    }

    public JenisMotor() {
    }

    public String getJenisNamaMotor() {
        return jenisNamaMotor;
    }

    public void setJenisNamaMotor(String jenisNamaMotor) {
        this.jenisNamaMotor = jenisNamaMotor;
    }

    public Pabrikan getFpabrik() {
        return fpabrik;
    }

    public void setFpabrik(Pabrikan fpabrik) {
        this.fpabrik = fpabrik;
    }
}
