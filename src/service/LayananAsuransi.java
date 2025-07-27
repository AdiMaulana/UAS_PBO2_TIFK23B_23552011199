package service;

import java.util.List;
import model.Klaim;

public interface LayananAsuransi {
    void prosesKlaim(Klaim klaim);
    
    List<Klaim> semuaKlaim() throws Exception;
}
