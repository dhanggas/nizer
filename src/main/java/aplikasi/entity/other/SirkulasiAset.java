/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity.other;

import aplikasi.entity.Penduduk;

/**
 *
 * @author laptop
 */
public class SirkulasiAset {
    private Penduduk aset;
    private Integer stokAsetAwal;
    private Integer stokAsetKeluar;
    private Integer stokAsetMasuk;
    private Integer stokAsetSekarang;

    public Penduduk getAset() {
        return aset;
    }

    public void setAset(Penduduk aset) {
        this.aset = aset;
    }

    public Integer getStokAsetAwal() {
        return stokAsetAwal;
    }

    public void setStokAsetAwal(Integer stokAsetAwal) {
        this.stokAsetAwal = stokAsetAwal;
    }

    public Integer getStokAsetKeluar() {
        return stokAsetKeluar;
    }

    public void setStokAsetKeluar(Integer stokAsetKeluar) {
        this.stokAsetKeluar = stokAsetKeluar;
    }

    public Integer getStokAsetMasuk() {
        return stokAsetMasuk;
    }

    public void setStokAsetMasuk(Integer stokAsetMasuk) {
        this.stokAsetMasuk = stokAsetMasuk;
    }

    public Integer getStokAsetSekarang() {
        return stokAsetSekarang;
    }

    public void setStokAsetSekarang(Integer stokAsetSekarang) {
        this.stokAsetSekarang = stokAsetSekarang;
    }
    
    
    
}
