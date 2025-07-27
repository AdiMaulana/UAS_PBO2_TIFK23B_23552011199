package service;

import java.util.List;
import model.Polis;

public interface PolisServiceInterface {
    void buatPolis(Polis polis) throws Exception;
    
    Polis cariPolisById(int id) throws Exception;
    
    List<Polis> cariPolisByNasabahId(int nasabahId) throws Exception;
    
    List<Polis> semuaPolis() throws Exception;
}
