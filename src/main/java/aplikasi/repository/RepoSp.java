/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.SuratPengantar;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoSp extends BaseRepository<SuratPengantar, String> {

    public List<SuratPengantar> findByKategoriKode(String kode) throws SQLException;
    
    public List<SuratPengantar> findSpByTglBetween(Date awal, Date akhir) throws SQLException;
    
    public List<SuratPengantar> findByNama(String nama) throws SQLException;

    public List<SuratPengantar> findByQtyZeroByName(String nama) throws SQLException;

    public List<SuratPengantar> findByQtyOneByName(String nama) throws SQLException;

    public List<SuratPengantar> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException;


}
