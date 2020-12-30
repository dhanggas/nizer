CREATE VIEW v_kematian AS SELECT
    tb_kematian.no_skm AS 'no_skm',
    tb_kematian.tgl_kematian AS 'tgl_kematian',
    tb_kematian.tmp_kematian AS 'tmp_kematian',
    tb_kematian.sebab AS 'sebab',
    tb_kematian.verifikasi AS 'verifikasi',
    
    tb_penduduk.nik AS 'nik',
    tb_penduduk.nama as 'nama',
    tb_penduduk.nama_ibu AS 'nama_ibu',
    tb_penduduk.nama_ayah AS 'nama_ayah',
    tb_penduduk.tmp_lahir AS 'tmp_lahir',
    tb_penduduk.tgl_lahir AS 'tgl_lahir',
    tb_penduduk.kelamin AS 'kelamin',
    tb_penduduk.gol_darah AS 'gol_darah',
    tb_penduduk.alamat AS 'alamat',
    tb_penduduk.rt AS 'rt',
    tb_penduduk.rw AS 'rw',
    tb_penduduk.kelurahan AS 'kelurahan',
    tb_penduduk.kecamatan AS 'kecamatan',
    tb_penduduk.agama as 'agama',
    tb_penduduk.pendidikan as 'pendidikan',
    tb_penduduk.sts_kawin as 'sts_kawin',
    tb_penduduk.pekerjaan as 'pekerjaan',
    tb_penduduk.kewarganegaraan AS 'kewarganegaraan'

   FROM
    tb_kematian
LEFT JOIN tb_penduduk USING(nik)
