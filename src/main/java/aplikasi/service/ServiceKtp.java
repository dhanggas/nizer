/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Ktp;
import aplikasi.entity.Penduduk;
import aplikasi.repository.RepoKtp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author dhiskar
 */
public class ServiceKtp implements RepoKtp {

    private DataSource ds;

    public ServiceKtp(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Ktp> findByKategoriKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ktp> findByNama(String nama) throws SQLException {
        List<Ktp> list = new ArrayList<>();
        String sql = "SELECT * FROM v_ktp \n"
                + "WHERE no_sp like CONCAT('%', ?, '%') ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Ktp a = new Ktp();
            a.setNo_sp(rs.getString("no_sp"));
            a.setTgl(rs.getDate("tgl"));
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
    public List<Ktp> findByQtyZeroByName(String nama) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ktp> findByQtyOneByName(String nama) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ktp> findFilterAlll(String text, String toString, String toString0, String text0, String toString1, String toString2, String toString3, String toString4) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ktp save(Ktp value) throws SQLException {
        String sql = "INSERT INTO tb_ktp (no_sp, tgl, nik) VALUES (?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, value.getNo_sp());
        ps.setString(2, value.getTgl().toString());
        ps.setString(3, value.getPenduduk().getNik());
        
        ps.executeUpdate();

        ps.close();
        connect.close();
        return value;
    }

    @Override
    public Ktp update(Ktp a) throws SQLException {
        String sql = "UPDATE tb_ktp SET tgl = ?, nik = ? WHERE no_sp = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
         ps.setString(1, a.getTgl().toString());
        ps.setString(2, a.getPenduduk().getNik());
        ps.setString(3, a.getNo_sp());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return a;
    }

    @Override
    public List<Ktp> findAll() throws SQLException {
        String sql = "SELECT * FROM v_ktp";
        List<Ktp> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Ktp a = new Ktp();
            a.setNo_sp(rs.getString("no_sp"));
            a.setTgl(rs.getDate("tgl"));
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

        st.close();
        rs.close();
        connect.close();

        return list;
    }

    @Override
    public Ktp findOne(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM tb_ktp WHERE no_sp = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<Ktp> findMaxValue() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Ktp verifikasi(Ktp a) throws SQLException {
        String sql = "UPDATE tb_ktp SET verifikasi = ? WHERE no_sp = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setBoolean(1, a.isVerifikasi());
        ps.setString(2, a.getNo_sp());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return a;
    }

    
}
