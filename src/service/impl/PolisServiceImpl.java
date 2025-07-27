package service.impl;

import dao.PolisDaoInterface;
import dao.impl.PolisDaoImpl;
import java.util.List;
import model.Polis;
import service.PolisServiceInterface;

public class PolisServiceImpl implements PolisServiceInterface {

    private PolisDaoInterface polisDao;

    public PolisServiceImpl() {
        this.polisDao = new PolisDaoImpl();
    }

    public PolisServiceImpl(PolisDaoInterface polisDao) {
        this.polisDao = polisDao;
    }

    @Override
    public void buatPolis(Polis polis) throws Exception {
        if (polis.getPremi() < 0) {
            throw new IllegalArgumentException("Premi tidak boleh negatif");
        }
        polisDao.save(polis);
    }

    @Override
    public Polis cariPolisById(int id) throws Exception {
        return polisDao.findById(id);
    }

    @Override
    public List<Polis> cariPolisByNasabahId(int nasabahId) throws Exception {
        return polisDao.findByNasabahId(nasabahId);
    }

    @Override
    public List<Polis> semuaPolis() throws Exception {
        return polisDao.findAll();
    }
}
