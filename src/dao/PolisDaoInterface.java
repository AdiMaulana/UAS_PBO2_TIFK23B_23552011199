package dao;

import java.util.List;
import model.Polis;

public interface PolisDaoInterface { 
    
    void save(Polis polis) throws Exception;
    
    Polis findById(int id) throws Exception;
    
    List<Polis> findByNasabahId(int nasabahId) throws Exception;
    
    List<Polis> findAll() throws Exception;
}
