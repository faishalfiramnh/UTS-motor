package faisal.com.motor.models;

import com.orm.SugarRecord;

/**
 * Created by Man. United on 14/11/2017.
 */

public class Pabrikan extends SugarRecord<Pabrikan>{
    public String merk,asal,pendiri;

    public Pabrikan(String merk, String asal, String pendiri) {
        this.merk = merk;
        this.asal = asal;
        this.pendiri = pendiri;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getPendiri() {
        return pendiri;
    }

    public void setPendiri(String pendiri) {
        this.pendiri = pendiri;
    }

    public Pabrikan()
    {

    }
}
