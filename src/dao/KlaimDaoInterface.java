package dao;

import java.util.List;
import model.Klaim;

public interface KlaimDaoInterface {
    void save(Klaim klaim) throws Exception;
    
    List<Klaim> getSemuaKlaim() throws Exception;
    
    List<Klaim> findByPolisId(int polisId) throws Exception;
}
