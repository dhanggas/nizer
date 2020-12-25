/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity;

/**
 *
 * @author laptop
 */
public class PeminjamanDetail {
    private Integer id;
    private Peminjaman peminjaman;
    private Penduduk aset;
    private Integer qty;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Peminjaman getPeminjaman() {
        return peminjaman;
    }

    public void setPeminjaman(Peminjaman peminjaman) {
        this.peminjaman = peminjaman;
    }

    public Penduduk getAset() {
        return aset;
    }

    public void setAset(Penduduk aset) {
        this.aset = aset;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    
}
