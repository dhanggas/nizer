/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.service;

import aplikasi.entity.Penduduk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import aplikasi.repository.RepoPenduduk;

/**
 *
 * @author niser
 */
public class ServicePenduduk implements RepoPenduduk {

    private DataSource ds;

    public ServicePenduduk(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Penduduk> findByKategoriKode(String kode) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Penduduk save(Penduduk a) throws SQLException {
        String sql = "INSERT INTO tb_penduduk (nik, nama, nama_ibu, nama_ayah, tmp_lahir, tgl_lahir, kelamin, gol_darah,"
                + "alamat, rt, rw, kelurahan, kecamatan, agama, pendidikan, sts_kawin, pekerjaan, kewarganegaraan)\n"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, a.getNik());
        ps.setString(2, a.getNama());
        ps.setString(3, a.getNama_ibu());
        ps.setString(4, a.getNama_ayah());
        ps.setString(5, a.getTmp_lahir());
        ps.setDate(6, a.getTgl_lahir());
        ps.setString(7, a.getKelamin());
        ps.setString(8, a.getGol_darah());
        ps.setString(9, a.getAlamat());
        ps.setString(10, a.getRt());
        ps.setString(11, a.getRw());
        ps.setString(12, a.getKelurahan());
        ps.setString(13, a.getKecamatan());
        ps.setString(14, a.getAgama());
        ps.setString(15, a.getPendidikan());
        ps.setString(16, a.getSts_kawin());
        ps.setString(17, a.getPekerjaan());
        ps.setString(18, a.getKewarganegaraan());
        
        ps.executeUpdate();

        ps.close();
        connect.close();
        return a;
    }

    @Override
    public Penduduk update(Penduduk a) throws SQLException {
        String sql = "UPDATE tb_penduduk SET nama = ?, nama_ibu = ?, nama_ayah = ?, tmp_lahir = ?, "
                + "tgl_lahir = ?, kelamin = ?, gol_darah = ? , alamat = ?, rt =  ?, rw =  ?, kelurahan =  ?,"
                + " kecamatan =  ?, agama =  ?, pendidikan =  ?, sts_kawin =  ?, pendidikan =  ?, kewarganegaraan =  ? WHERE nik = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
         ps.setString(1, a.getNama());
        ps.setString(2, a.getNama_ibu());
        ps.setString(3, a.getNama_ayah());
        ps.setString(4, a.getTmp_lahir());
        ps.setDate(5, a.getTgl_lahir());
        ps.setString(6, a.getKelamin());
        ps.setString(7, a.getGol_darah());
        ps.setString(8, a.getAlamat());
        ps.setString(9, a.getRt());
        ps.setString(10, a.getRw());
        ps.setString(11, a.getKelurahan());
        ps.setString(12, a.getKecamatan());
        ps.setString(13, a.getAgama());
        ps.setString(14, a.getPendidikan());
        ps.setString(15, a.getSts_kawin());
        ps.setString(16, a.getPekerjaan());
        ps.setString(17, a.getKewarganegaraan());
        ps.setString(18, a.getNik());
        ps.executeUpdate();

        ps.close();
        connect.close();
        return a;
    }

    @Override
    public List<Penduduk> findAll() throws SQLException {
        String sql = "SELECT * FROM tb_penduduk";
        List<Penduduk> list = new ArrayList<>();

        Connection connect = ds.getConnection();
        Statement st = connect.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Penduduk a = new Penduduk();
            a.setNik(rs.getString("nik"));
            a.setNama(rs.getString("nama"));
            a.setNama_ibu(rs.getString("nama_ibu"));
            a.setNama_ayah(rs.getString("nama_ayah"));
            a.setTmp_lahir(rs.getString("tmp_lahir"));
            a.setTgl_lahir(rs.getDate("tgl_lahir"));
            a.setKelamin(rs.getString("kelamin"));
            a.setGol_darah(rs.getString("gol_darah"));
            a.setAlamat(rs.getString("alamat"));
            a.setRt(rs.getString("rt"));
            a.setRw(rs.getString("rw"));
            a.setKecamatan(rs.getString("kelurahan"));
            a.setKelurahan(rs.getString("kecamatan"));
            a.setAgama(rs.getString("agama"));
            a.setPendidikan(rs.getString("pendidikan"));
            a.setSts_kawin(rs.getString("sts_kawin"));
            a.setPekerjaan(rs.getString("pekerjaan"));
            a.setKewarganegaraan(rs.getString("kewarganegaraan"));

            list.add(a);
        }

        st.close();
        rs.close();
        connect.close();

        return list;
    }

    @Override
    public Penduduk findOne(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean exists(String id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) throws SQLException {
        String sql = "DELETE FROM tb_penduduk WHERE nik = ?";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, id);
        ps.executeUpdate();

        ps.close();
        connect.close();
    }

    @Override
    public List<Penduduk> findMaxValue() throws SQLException {
//        String sql = "SELECT * FROM `tb_aset` order BY id_aset DESC LIMIT 1";
//
//        List<Penduduk> list = new ArrayList<>();
//
//        Connection connect = ds.getConnection();
//        PreparedStatement ps = connect.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//        Penduduk a = new Penduduk();
//        while (rs.next()) {
//            a.setNik(rs.getString("id_aset"));
//            a.setNama(rs.getString("nama_aset"));
//            a.setTgl_lahir(rs.getDate("tanggal"));
//            a.setQty(rs.getInt("id_kategori"));
//            a.setNama_ibu(rs.getString("id_status"));
//
//            a.setQty(rs.getInt("qty"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            list.add(a);
//        }
//        ps.close();
//        rs.close();
//        connect.close();
//        return list;
return null;
    }

    @Override
    public List<Penduduk> findByQtyOneByName(String nama) throws SQLException {
//        List<Penduduk> list = new ArrayList<>();
//        String sql = "SELECT * FROM v_aset \n"
//                + "WHERE nama_aset like CONCAT('%', ?, '%') AND quantity = 1";
//
//        Connection connect = ds.getConnection();
//        PreparedStatement ps = connect.prepareStatement(sql);
//        ps.setString(1, nama);
//
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            Penduduk a = new Penduduk();
//            a.setNik(rs.getString("kode_aset"));
//            a.setNama(rs.getString("nama_aset"));
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            KategoriAset k = new KategoriAset();
//            k.setId_kategori(rs.getInt("id_kategori"));
//            k.setKode(rs.getString("kode_kategori"));
//            k.setNama_kategori(rs.getString("nama_kategori"));
//            a.setKategoriAset(k);
//
//            StatusAset s = new StatusAset();
//            s.setId(rs.getInt("id_status"));
//            s.setStatus(rs.getString("status_aset"));
//            a.setStatusAset(s);
//
//            LokasiAset l = new LokasiAset();
//            l.setId_lokasi(rs.getInt("id_lokasi"));
//            l.setNama_rak(rs.getString("nama_rak"));
//            l.setLokasi(rs.getString("lokasi_aset"));
//            a.setLokasiAset(l);
//
//            Kepemilikan p = new Kepemilikan();
//            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
//            p.setNama(rs.getString("nama_kepemilikan"));
//            p.setTlp(rs.getString("tlp_kepemilikan"));
//            p.setAlamat(rs.getString("alamat_kepemilikan"));
//            p.setKet(rs.getString("ket_kepemilikan"));
//            a.setKepemilikan(p);
//
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            Users u = new Users();
//            u.setId_user(rs.getInt("id_user"));
//            u.setNama(rs.getString("nama_user"));
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
//            u.setStatus(rs.getBoolean("status_user"));
//            a.setUsers(u);
//
//            list.add(a);
//        }
//
//        ps.close();
//        rs.close();
//        connect.close();
//        return list;
return null;
    }

    @Override
    public List<Penduduk> findByQtyZeroByName(String nama) throws SQLException {
//        List<Penduduk> list = new ArrayList<>();
//        String sql = "SELECT * FROM v_aset \n"
//                + "WHERE nama_aset like CONCAT('%', ?, '%') AND quantity = 0";
//
//        Connection connect = ds.getConnection();
//        PreparedStatement ps = connect.prepareStatement(sql);
//        ps.setString(1, nama);
//
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            Penduduk a = new Penduduk();
//            a.setNik(rs.getString("kode_aset"));
//            a.setNama(rs.getString("nama_aset"));
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            KategoriAset k = new KategoriAset();
//            k.setId_kategori(rs.getInt("id_kategori"));
//            k.setKode(rs.getString("kode_kategori"));
//            k.setNama_kategori(rs.getString("nama_kategori"));
//            a.setKategoriAset(k);
//
//            StatusAset s = new StatusAset();
//            s.setId(rs.getInt("id_status"));
//            s.setStatus(rs.getString("status_aset"));
//            a.setStatusAset(s);
//
//            LokasiAset l = new LokasiAset();
//            l.setId_lokasi(rs.getInt("id_lokasi"));
//            l.setNama_rak(rs.getString("nama_rak"));
//            l.setLokasi(rs.getString("lokasi_aset"));
//            a.setLokasiAset(l);
//
//            Kepemilikan p = new Kepemilikan();
//            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
//            p.setNama(rs.getString("nama_kepemilikan"));
//            p.setTlp(rs.getString("tlp_kepemilikan"));
//            p.setAlamat(rs.getString("alamat_kepemilikan"));
//            p.setKet(rs.getString("ket_kepemilikan"));
//            a.setKepemilikan(p);
//
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            Users u = new Users();
//            u.setId_user(rs.getInt("id_user"));
//            u.setNama(rs.getString("nama_user"));
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
//            u.setStatus(rs.getBoolean("status_user"));
//            a.setUsers(u);
//
//            list.add(a);
//        }
//
//        ps.close();
//        rs.close();
//        connect.close();
//        return list;
return null;
    }

    @Override
    public List<Penduduk> findFilterAlll(String nama, String kategori, String status, String namaRak, String lokasi, String namaCus, String qty, String username) throws SQLException {
//        List<Penduduk> list = new ArrayList<>();
//
//        String sql = "SELECT * FROM v_aset \n"
//                + "WHERE nama_aset like CONCAT('%', ?, '%') \n"
//                + "AND nama_kategori LIKE ? \n"
//                + "AND status_aset LIKE ? \n"
//                + "AND nama_rak LIKE CONCAT('%', ?, '%') \n"
//                + "AND lokasi_aset LIKE ? \n"
//                + "AND nama_kepemilikan LIKE ? \n"
//                + "AND quantity >=? and quantity <= ? \n"
//                + "AND username LIKE ? order by kode_aset asc ";
//
//        Connection connect = ds.getConnection();
//        PreparedStatement ps = connect.prepareStatement(sql);
//        ps.setString(1, nama);
//        ps.setString(2, kategori);
//        ps.setString(3, status);
//        ps.setString(4, namaRak);
//        ps.setString(5, lokasi);
//        ps.setString(6, namaCus);
//        int c, b;
//        if (qty.equals("%")) {
//            c = 0;
//            b = 100;
//        } else {
//            c = Integer.valueOf(qty);
//            b = Integer.valueOf(qty);
//        }
//        ps.setInt(7, c);
//        ps.setInt(8, b);
//        ps.setString(9, username);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            Penduduk a = new Penduduk();
//            a.setNik(rs.getString("kode_aset"));
//            a.setNama(rs.getString("nama_aset"));
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            KategoriAset k = new KategoriAset();
//            k.setId_kategori(rs.getInt("id_kategori"));
//            k.setKode(rs.getString("kode_kategori"));
//            k.setNama_kategori(rs.getString("nama_kategori"));
//            a.setKategoriAset(k);
//
//            StatusAset s = new StatusAset();
//            s.setId(rs.getInt("id_status"));
//            s.setStatus(rs.getString("status_aset"));
//            a.setStatusAset(s);
//
//            LokasiAset l = new LokasiAset();
//            l.setId_lokasi(rs.getInt("id_lokasi"));
//            l.setNama_rak(rs.getString("nama_rak"));
//            l.setLokasi(rs.getString("lokasi_aset"));
//            a.setLokasiAset(l);
//
//            Kepemilikan p = new Kepemilikan();
//            p.setId_kepemilikan(rs.getInt("id_kepemilikan"));
//            p.setNama(rs.getString("nama_kepemilikan"));
//            p.setTlp(rs.getString("tlp_kepemilikan"));
//            p.setAlamat(rs.getString("alamat_kepemilikan"));
//            p.setKet(rs.getString("ket_kepemilikan"));
//            a.setKepemilikan(p);
//
//            a.setQty(rs.getInt("quantity"));
//            a.setNama_ibu(rs.getString("satuan"));
//
//            Users u = new Users();
//            u.setId_user(rs.getInt("id_user"));
//            u.setNama(rs.getString("nama_user"));
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
//            u.setStatus(rs.getBoolean("status_user"));
//            a.setUsers(u);
//
//            list.add(a);
//        }
//        ps.close();
//        rs.close();
//        connect.close();
//
//        return list;
return null;
    }

    @Override
    public List<Penduduk> findByNama(String nama) throws SQLException {
        List<Penduduk> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_penduduk \n"
                + "WHERE nama like CONCAT('%', ?, '%') ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nama);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Penduduk a = new Penduduk();
            a.setNik(rs.getString("nik"));
            a.setNama(rs.getString("nama"));
            a.setNama_ibu(rs.getString("nama_ibu"));
            a.setNama_ayah(rs.getString("nama_ayah"));
            a.setTmp_lahir(rs.getString("tmp_lahir"));
            a.setTgl_lahir(rs.getDate("tgl_lahir"));
            a.setKelamin(rs.getString("kelamin"));
            a.setGol_darah(rs.getString("gol_darah"));
            a.setAlamat(rs.getString("alamat"));
            a.setRt(rs.getString("rt"));
            a.setRw(rs.getString("rw"));
            a.setKecamatan(rs.getString("kelurahan"));
            a.setKelurahan(rs.getString("kecamatan"));
            a.setAgama(rs.getString("agama"));
            a.setPendidikan(rs.getString("pendidikan"));
            a.setSts_kawin(rs.getString("sts_kawin"));
            a.setPekerjaan(rs.getString("pekerjaan"));
            a.setKewarganegaraan(rs.getString("kewarganegaraan"));

            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public List<Penduduk> findByNik(String nik) throws SQLException {
         List<Penduduk> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_penduduk WHERE nik = ? ";

        Connection connect = ds.getConnection();
        PreparedStatement ps = connect.prepareStatement(sql);
        ps.setString(1, nik);

        ResultSet rs = ps.executeQuery();

            Penduduk a = new Penduduk();
        while (rs.next()) {
            a.setNik(rs.getString("nik"));
            a.setNama(rs.getString("nama"));
            a.setNama_ibu(rs.getString("nama_ibu"));
            a.setNama_ayah(rs.getString("nama_ayah"));
            a.setTmp_lahir(rs.getString("tmp_lahir"));
            a.setTgl_lahir(rs.getDate("tgl_lahir"));
            a.setKelamin(rs.getString("kelamin"));
            a.setGol_darah(rs.getString("gol_darah"));
            a.setAlamat(rs.getString("alamat"));
            a.setRt(rs.getString("rt"));
            a.setRw(rs.getString("rw"));
            a.setKecamatan(rs.getString("kelurahan"));
            a.setKelurahan(rs.getString("kecamatan"));
            a.setAgama(rs.getString("agama"));
            a.setPendidikan(rs.getString("pendidikan"));
            a.setSts_kawin(rs.getString("sts_kawin"));
            a.setPekerjaan(rs.getString("pekerjaan"));
            a.setKewarganegaraan(rs.getString("kewarganegaraan"));

            list.add(a);
        }

        ps.close();
        rs.close();
        connect.close();
        return list;
    }

    @Override
    public Penduduk verifikasi(Penduduk value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
