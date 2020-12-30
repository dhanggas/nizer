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
public class SuratKematian {
    private String no_skm;
    private Date tgl_kematian;
    private String tmp_kematian;
    private String sebab;
    private Penduduk penduduk;
    private Boolean verifikasi;

    public Boolean isVerifikasi() {
        return verifikasi;
    }

    public void setVerifikasi(Boolean verifikasi) {
        this.verifikasi = verifikasi;
    }

    public String getNo_skm() {
        return no_skm;
    }

    public void setNo_skm(String no_skm) {
        this.no_skm = no_skm;
    }

    public Date getTgl_kematian() {
        return tgl_kematian;
    }

    public void setTgl_kematian(Date tgl_kematian) {
        this.tgl_kematian = tgl_kematian;
    }

    public String getTmp_kematian() {
        return tmp_kematian;
    }

    public void setTmp_kematian(String tmp_kematian) {
        this.tmp_kematian = tmp_kematian;
    }

    public String getSebab() {
        return sebab;
    }

    public void setSebab(String sebab) {
        this.sebab = sebab;
    }

    public Penduduk getPenduduk() {
        return penduduk;
    }

    public void setPenduduk(Penduduk penduduk) {
        this.penduduk = penduduk;
    }

}
