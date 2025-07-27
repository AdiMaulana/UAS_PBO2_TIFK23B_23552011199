package model;

import constant.Constant;

public class AsuransiJiwa extends Asuransi {
    private double nilaiPertanggungan;

    public AsuransiJiwa(double nilaiPertanggungan) {
        this.jenis = Constant.AS_JIWA;
        this.nilaiPertanggungan = nilaiPertanggungan;
    }

    @Override
    public double hitungPremi() {
        premi = nilaiPertanggungan * 0.01;
        return premi;
    }
}
