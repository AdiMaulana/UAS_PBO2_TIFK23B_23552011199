package service.impl;

import dao.KlaimDaoInterface;
import dao.PolisDaoInterface;
import dao.impl.KlaimDaoImpl;
import dao.impl.PolisDaoImpl;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Klaim;
import model.Polis;
import service.LayananAsuransi;

public class LayananAsuransiServiceImpl implements LayananAsuransi {

    private KlaimDaoInterface klaimDao = new KlaimDaoImpl();
    private PolisDaoInterface polisDao = new PolisDaoImpl();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void prosesKlaim(Klaim klaim) {
        if (klaim == null) {
            throw new IllegalArgumentException("Klaim tidak boleh null");
        }

        Polis polis;
        try {
            polis = polisDao.findById(klaim.getPolisId());
            if (polis == null) {
                throw new IllegalArgumentException("Polis dengan ID " + klaim.getPolisId() + " tidak ditemukan");
            }
            
            klaimDao.save(klaim);
            System.out.println("Klaim berhasil diproses untuk polis ID " + klaim.getPolisId());
            
        } catch (Exception ex) {
            Logger.getLogger(LayananAsuransiServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Klaim> semuaKlaim() throws Exception {
        return klaimDao.getSemuaKlaim();
    }
}
