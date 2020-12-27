CREATE VIEW v_ktp AS SELECT
    tb_ktp.no_sp AS 'no_sp',
    tb_ktp.tgl AS 'tgl',
    tb_ktp.verifikasi AS 'verifikasi',
    tb_ktp.keperluan AS 'keperluan',
    
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
    tb_ktp
LEFT JOIN tb_penduduk USING(nik)
