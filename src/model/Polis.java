package model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Polis {
    private int id;
    private int nasabahId;
    private String namaNasabah;
    private String jenis;
    private double premi;

    public Polis() {}

    public Polis(int id, int nasabahId, String namaNasabah, String jenis, double premi) {
        this.id = id;
        this.nasabahId = nasabahId;
        this.namaNasabah = namaNasabah;
        this.jenis = jenis;
        this.premi = premi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNasabahId() {
        return nasabahId;
    }

    public void setNasabahId(int nasabahId) {
        this.nasabahId = nasabahId;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public double getPremi() {
        return premi;
    }

    public void setPremi(double premi) {
        this.premi = premi;
    }

    public String getNamaNasabah() {
        return namaNasabah;
    }

    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }
    
    public String getPremiFormatted() {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat df = new DecimalFormat("#,###", symbols);
        df.setGroupingUsed(true);
        df.setMaximumFractionDigits(0);
        // Optional: truncating decimal without rounding
        // df.setRoundingMode(RoundingMode.DOWN);

        return df.format(premi);
    }
}
