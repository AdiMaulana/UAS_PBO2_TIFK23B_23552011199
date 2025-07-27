package model;

import constant.Constant;

public class AsuransiKesehatan extends Asuransi {
    private double biayaDasar;

    public AsuransiKesehatan(double biayaDasar) {
        this.jenis = Constant.AS_KESEHATAN;
        this.biayaDasar = biayaDasar;
    }

    @Override
    public double hitungPremi() {
        premi = biayaDasar * 0.05;
        return premi;
    }
}