/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Penduduk;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoPenduduk extends BaseRepository<Penduduk, String> {

    public List<Penduduk> findByKategoriKode(String kode) throws SQLException;
    
    public List<Penduduk> findByNama(String nama) throws SQLException;
    
        public List<Penduduk> findByNik(String nik) throws SQLException;

    public List<Penduduk> findByQtyZeroByName(String nama) throws SQLException;

    public List<Penduduk> findByQtyOneByName(String nama) throws SQLException;

    public List<Penduduk> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException;


}
