CREATE VIEW v_kelahiran AS SELECT
    tb_kelahiran.no_skl AS 'no_skl',
    tb_kelahiran.nama AS 'nama',
    tb_kelahiran.tgl_lahir AS 'tgl_lahir',
    tb_kelahiran.tmp_lahir AS 'tmp_lahir',
    tb_kelahiran.kelamin AS 'kelamin',
    tb_kelahiran.verifikasi AS 'verifikasi',
    
    tb_penduduk.nik AS 'nik',
    tb_penduduk.nama as 'nama_ibu'

   FROM
    tb_kelahiran
LEFT JOIN tb_penduduk on tb_kelahiran.nik_ayah = tb_penduduk.nik
