package model;

import java.sql.Date;

public class Klaim {
    private int id;
    private int polisId;
    private String namaPeserta;
    private int umur;
    private Date tanggal;
    private String status;

    public Klaim() {}

    public Klaim(int id, int polisId, String namaPeserta, int umur, Date tanggal, String status) {
        this.id = id;
        this.polisId = polisId;
        this.namaPeserta = namaPeserta;
        this.umur = umur;
        this.tanggal = tanggal;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPolisId() {
        return polisId;
    }

    public void setPolisId(int polisId) {
        this.polisId = polisId;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNamaPeserta() {
        return namaPeserta;
    }

    public void setNamaPeserta(String namaPeserta) {
        this.namaPeserta = namaPeserta;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
}
