/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.SuratKematian;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author niser
 */
public interface RepoSkm extends BaseRepository<SuratKematian , String> {

    public List<SuratKematian> findByKategoriKode(String kode) throws SQLException;
    
    public List<SuratKematian> findSpByTglBetween(Date awal, Date akhir) throws SQLException;
    
    public List<SuratKematian> findByNama(String nama) throws SQLException;

    public List<SuratKematian> findByQtyZeroByName(String nama) throws SQLException;

    public List<SuratKematian> findByQtyOneByName(String nama) throws SQLException;

    public List<SuratKematian> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException;


}
