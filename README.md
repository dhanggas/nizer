# DATA DESA SARAKAN-APLIKASI

![DATA DESA SARAKAN-APLIKASI](/imgs/data-desa-sarakan.jpg)

## Hal yang harus dilakukan

* Install Java Runtime Environment
* Install Database [MySQL]
* Extract DATA DESA SARAKAN-APLIKASI
* Membuat launcher
* Jalankan aplikasi

## Install Java Runtime Environment (JRE)

* Pastikan laptop / pc sudah terintal Java

## Install Database Mysql

* Pastikan sudah menginstal data base mySQL, disini saya menggunakan XAMPP
* Aplikasi saya set menggunakan password muntuk terkoneksi dengan database, Setting Password root ```" "``` 

## Import SQL file ke MySQL database

* Membuat database dengan nama ```desa```
* kemudian kita import filenya ke database dbaset dalam MySQL
* caranya kita login dulu ke user ```root``` dan pilih database ```desa```
* pada tap import pilih \data-desa-sarakan\src\main\resources\sql\desa.sql kemudian klik go
* Setelah itu kita check sql yg telah dibuat dengan perintah sebagai berikut:
maka hasilnya seperti berikut

```bash
MariaDB [desa]> show tables;
+----------------+
| Tables_in_desa |
+----------------+
| tb_kematian    |
| tb_ktp         |
| tb_penduduk    |
| tb_user        |
| v_kelahiran    |
| v_kematian     |
| v_ktp          |
+----------------+
7 rows in set (0.00 sec)
```

* Untuk menjalankan sebenarnya ada banyak cara yaitu menggunakan terminal atau command prompt dan menggunakan cara biasa yaitu double klik (klik 2x)
* Lokasi file ada di \data-desa-sarakan\target

### Menggunakan terminal atau command promnt

* peraintah dasar

```bash
java -jar data-desa-sarakan-1.0-jar-with-dependencies.jar
```

### Menggunakan double click (klik 2x)

* Klik kanan ```data-desa-sarakan-1.0-jar-with-dependencies.jar``` -> Open with -> Java (TM) Platform SE Binary


### Username dan Password pilih salah satu pengguna / user

```bash
MariaDB [desa]> select * from tb_user;
+---------+-------+----------+----------+---------+--------+
| id_user | nama  | username | password | jabatan | status |
+---------+-------+----------+----------+---------+--------+
|       1 | Nizer | nizer    | Kepala1  | Kepala  |      1 |
|       2 | Panji | panji    | Admin1   | Admin   |      1 |
+---------+-------+----------+----------+---------+--------+
2 rows in set (0.00 sec)
```