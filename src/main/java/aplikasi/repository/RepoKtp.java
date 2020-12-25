/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.repository;

import aplikasi.entity.Ktp;
import aplikasi.entity.Penduduk;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author dhiskar
 */
public interface RepoKtp extends BaseRepository<Ktp, String> {

    public List<Ktp> findByKategoriKode(String kode) throws SQLException;
    
    public List<Ktp> findByNama(String nama) throws SQLException;

    public List<Ktp> findByQtyZeroByName(String nama) throws SQLException;

    public List<Ktp> findByQtyOneByName(String nama) throws SQLException;

    public List<Ktp> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException;


}
