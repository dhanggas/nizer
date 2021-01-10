/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Penduduk;
import aplikasi.entity.SuratKematian;
import aplikasi.repository.RepoSkm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author niser
 */
public class ServiceSkm implements RepoSkm{
        private DataSource ds;

    public ServiceSkm(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<SuratKematian> findByKategoriKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuratKematian> findByNama(String nama) throws SQLException {
        List<SuratKematian> list = new ArrayList<>();
        String sql = "SELECT * FROM v_kematian \n"
                + "WHERE no_skm like CONCAT('%', ?, '%') ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            SuratKematian a = new SuratKematian();
            a.setNo_skm(rs.getString("no_skm"));
            a.setTgl_kematian(rs.getDate("tgl_kematian"));
            a.setTmp_kematian(rs.getString("tmp_kematian"));
            a.setSebab(rs.getString("sebab"));
            a.setVerifikasi(rs.getBoolean("verifikasi"));
            
             Penduduk p = new Penduduk();
            p.setNik(rs.getString("nik"));
            p.setNama(rs.getString("nama"));
            p.setNama_ibu(rs.getString("nama_ibu"));
            p.setNama_ayah(rs.getString("nama_ayah"));
            p.setTmp_lahir(rs.getString("tmp_lahir"));
            p.setTgl_lahir(rs.getDate("tgl_lahir"));
            p.setKelamin(rs.getString("kelamin"));
            p.setGol_darah(rs.getString("gol_darah"));
            p.setAlamat(rs.getString("alamat"));
            p.setRt(rs.getString("rt"));
            p.setRw(rs.getString("rw"));
            p.setKecamatan(rs.getString("kelurahan"));
            p.setKelurahan(rs.getString("kecamatan"));
            p.setAgama(rs.getString("agama"));
            p.setPendidikan(rs.getString("pendidikan"));
            p.setSts_kawin(rs.getString("sts_kawin"));
            p.setPekerjaan(rs.getString("pekerjaan"));
            p.setKewarganegaraan(rs.getString("kewarganegaraan"));
            
            a.setPenduduk(p);
            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<SuratKematian> findByQtyZeroByName(String nama) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuratKematian> findByQtyOneByName(String nama) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuratKematian> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuratKematian save(SuratKematian value) throws SQLException {
        String sql = "INSERT INTO tb_kematian (no_skm, tgl_kematian, tmp_kematian, sebab , nik) VALUES (?,?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getNo_skm());
        ps.setDate(2, value.getTgl_kematian());
        ps.setString(3, value.getTmp_kematian().toString());
        ps.setString(4, value.getSebab());
        ps.setString(5, value.getPenduduk().getNik());
//        ps.setBoolean(6, value.isVerifikasi());
        
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public SuratKematian update(SuratKematian value) throws SQLException {
        String sql = "Update tb_kematian SET tgl_kematian = ?,tmp_kematian = ?, sebab = ?, nik = ? WHERE no_skm = ?";
        
        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, value.getTgl_kematian());
        ps.setString(2, value.getTmp_kematian());
        ps.setString(3, value.getSebab());
        ps.setString(4, value.getPenduduk().getNik());
        ps.setString(5, value.getNo_skm());
        
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public SuratKematian verifikasi(SuratKematian value) throws SQLException {
        String sql = "UPDATE tb_kematian SET verifikasi = ? WHERE no_skm = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setBoolean(1, value.isVerifikasi());
        ps.setString(2, value.getNo_skm());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public List<SuratKematian> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SuratKematian findOne(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM tb_kematian WHERE no_skm = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<SuratKematian> findMaxValue() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SuratKematian> findSpByTglBetween(Date awal, Date akhir) throws SQLException {
        String sql = "SELECT * from v_kematian WHERE  tgl_kematian between ? AND ? ";
        List<SuratKematian> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setDate(1, awal);
        ps.setDate(2, akhir);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            SuratKematian a = new SuratKematian();
            a.setNo_skm(rs.getString("no_skm"));
            a.setTgl_kematian(rs.getDate("tgl_kematian"));
            a.setTmp_kematian(rs.getString("tmp_kematian"));
            a.setSebab(rs.getString("sebab"));
            a.setVerifikasi(rs.getBoolean("verifikasi"));
            
             Penduduk p = new Penduduk();
            p.setNik(rs.getString("nik"));
            p.setNama(rs.getString("nama"));
            p.setNama_ibu(rs.getString("nama_ibu"));
            p.setNama_ayah(rs.getString("nama_ayah"));
            p.setTmp_lahir(rs.getString("tmp_lahir"));
            p.setTgl_lahir(rs.getDate("tgl_lahir"));
            p.setKelamin(rs.getString("kelamin"));
            p.setGol_darah(rs.getString("gol_darah"));
            p.setAlamat(rs.getString("alamat"));
            p.setRt(rs.getString("rt"));
            p.setRw(rs.getString("rw"));
            p.setKecamatan(rs.getString("kelurahan"));
            p.setKelurahan(rs.getString("kecamatan"));
            p.setAgama(rs.getString("agama"));
            p.setPendidikan(rs.getString("pendidikan"));
            p.setSts_kawin(rs.getString("sts_kawin"));
            p.setPekerjaan(rs.getString("pekerjaan"));
            p.setKewarganegaraan(rs.getString("kewarganegaraan"));
            
            a.setPenduduk(p);
            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }
}
