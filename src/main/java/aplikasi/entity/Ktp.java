/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasi.entity;

import java.sql.Date;

/**
 *
 * @author dhang
 */
public class Ktp {
    private String no_sp;
    private Date tgl;
    private Penduduk penduduk;
    private Boolean verifikasi;

    public Boolean isVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(Boolean verifikasi) {
        this.verifikasi = verifikasi;
    }


    public String getNo_sp() {
        return no_sp;
    }

    public void setNo_sp(String no_sp) {
        this.no_sp = no_sp;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Penduduk getPenduduk() {
        return penduduk;
    }

    public void setPenduduk(Penduduk penduduk) {
        this.penduduk = penduduk;
    }
    
}
