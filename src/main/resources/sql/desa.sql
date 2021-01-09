-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 09, 2021 at 03:29 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `desa`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_kematian`
--

CREATE TABLE `tb_kematian` (
  `no_skm` varchar(20) NOT NULL,
  `tgl_kematian` date NOT NULL,
  `tmp_kematian` varchar(100) NOT NULL,
  `sebab` varchar(100) NOT NULL,
  `nik` varchar(16) NOT NULL,
  `verifikasi` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_kematian`
--

INSERT INTO `tb_kematian` (`no_skm`, `tgl_kematian`, `tmp_kematian`, `sebab`, `nik`, `verifikasi`) VALUES
('201227/SKM/001', '2020-12-20', 'TANGERANG', 'SAKIT banget', '1234567812345678', 1),
('201227/SKM/002', '2020-12-24', 'BLORA', 'KECELAKAAN', '1234567812345679', 1),
('201230/skm/001', '2020-12-30', 'Tangerang Selatan', 'sakit banget banget', '1234567812345680', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_penduduk`
--

CREATE TABLE `tb_penduduk` (
  `nik` varchar(16) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `nama_ibu` varchar(100) NOT NULL,
  `nama_ayah` varchar(100) NOT NULL,
  `tmp_lahir` varchar(100) NOT NULL,
  `tgl_lahir` date NOT NULL,
  `kelamin` varchar(10) NOT NULL,
  `gol_darah` char(3) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `rt` varchar(3) NOT NULL,
  `rw` varchar(3) NOT NULL,
  `kelurahan` varchar(20) NOT NULL,
  `kecamatan` varchar(20) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `pendidikan` varchar(20) NOT NULL,
  `sts_kawin` varchar(20) NOT NULL,
  `pekerjaan` varchar(20) NOT NULL,
  `kewarganegaraan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_penduduk`
--

INSERT INTO `tb_penduduk` (`nik`, `nama`, `nama_ibu`, `nama_ayah`, `tmp_lahir`, `tgl_lahir`, `kelamin`, `gol_darah`, `alamat`, `rt`, `rw`, `kelurahan`, `kecamatan`, `agama`, `pendidikan`, `sts_kawin`, `pekerjaan`, `kewarganegaraan`) VALUES
('1234567812345678', 'JONI', 'Parti', 'Toni9', 'Blora', '2020-12-01', 'Perempuan', 'a', 'Tangerang', '001', '002', 'Jatinegara', 'Karawaci', 'Kristen', 'Pemgusaha', 'Menikah', 'Pemgusaha', 'WNA'),
('1234567812345679', 'PAKTIR', 'Sumirah', 'Kasno', 'Blora', '2020-12-07', 'Perempuan', 'o', 'Semampir', '001', '002', 'Semampir', 'Jepon', 'Islam', 'Karyawan', 'Lajang', 'Karyawan', 'WNA'),
('1234567812345680', 'SARIP HIDAYAT', 'Jariyem', 'Parmin', 'Tangerang', '1991-12-23', 'Perempuan', 'O', 'Gembor Jaya', '001', '002', 'Jatiuwung', 'Jatiuwung', 'Islam', 'Karywan Swasta', 'Kawin', 'Karywan Swasta', 'WNA');

-- --------------------------------------------------------

--
-- Table structure for table `tb_surat_pengantar`
--

CREATE TABLE `tb_surat_pengantar` (
  `no_sp` varchar(20) NOT NULL,
  `tgl` date NOT NULL,
  `nik` varchar(16) NOT NULL,
  `keperluan` varchar(200) NOT NULL,
  `verifikasi` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_surat_pengantar`
--

INSERT INTO `tb_surat_pengantar` (`no_sp`, `tgl`, `nik`, `keperluan`, `verifikasi`) VALUES
('201221/SP/001', '2020-12-31', '1234567812345678', 'Pengurusan Kartu Keluarga', 1),
('201221/SP/002', '2020-12-27', '1234567812345679', 'Pengurusan Kartu Keluarga', 0),
('201227/SP/003', '2021-01-09', '1234567812345680', 'Pengurusan Kartu Keluarga', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(3) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `username` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `jabatan` enum('Admin','Kepala') NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `nama`, `username`, `password`, `jabatan`, `status`) VALUES
(1, 'Nizer', 'nizer', 'Kepala1', 'Kepala', 1),
(2, 'Panji', 'panji', 'Admin1', 'Admin', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_kematian`
-- (See below for the actual view)
--
CREATE TABLE `v_kematian` (
`no_skm` varchar(20)
,`tgl_kematian` date
,`tmp_kematian` varchar(100)
,`sebab` varchar(100)
,`verifikasi` tinyint(1)
,`nik` varchar(16)
,`nama` varchar(100)
,`nama_ibu` varchar(100)
,`nama_ayah` varchar(100)
,`tmp_lahir` varchar(100)
,`tgl_lahir` date
,`kelamin` varchar(10)
,`gol_darah` char(3)
,`alamat` varchar(100)
,`rt` varchar(3)
,`rw` varchar(3)
,`kelurahan` varchar(20)
,`kecamatan` varchar(20)
,`agama` varchar(20)
,`pendidikan` varchar(20)
,`sts_kawin` varchar(20)
,`pekerjaan` varchar(20)
,`kewarganegaraan` varchar(10)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_surat_pengantar`
-- (See below for the actual view)
--
CREATE TABLE `v_surat_pengantar` (
`no_sp` varchar(20)
,`tgl` date
,`verifikasi` tinyint(1)
,`keperluan` varchar(200)
,`nik` varchar(16)
,`nama` varchar(100)
,`nama_ibu` varchar(100)
,`nama_ayah` varchar(100)
,`tmp_lahir` varchar(100)
,`tgl_lahir` date
,`kelamin` varchar(10)
,`gol_darah` char(3)
,`alamat` varchar(100)
,`rt` varchar(3)
,`rw` varchar(3)
,`kelurahan` varchar(20)
,`kecamatan` varchar(20)
,`agama` varchar(20)
,`pendidikan` varchar(20)
,`sts_kawin` varchar(20)
,`pekerjaan` varchar(20)
,`kewarganegaraan` varchar(10)
);

-- --------------------------------------------------------

--
-- Structure for view `v_kematian`
--
DROP TABLE IF EXISTS `v_kematian`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_kematian`  AS  select `tb_kematian`.`no_skm` AS `no_skm`,`tb_kematian`.`tgl_kematian` AS `tgl_kematian`,`tb_kematian`.`tmp_kematian` AS `tmp_kematian`,`tb_kematian`.`sebab` AS `sebab`,`tb_kematian`.`verifikasi` AS `verifikasi`,`tb_penduduk`.`nik` AS `nik`,`tb_penduduk`.`nama` AS `nama`,`tb_penduduk`.`nama_ibu` AS `nama_ibu`,`tb_penduduk`.`nama_ayah` AS `nama_ayah`,`tb_penduduk`.`tmp_lahir` AS `tmp_lahir`,`tb_penduduk`.`tgl_lahir` AS `tgl_lahir`,`tb_penduduk`.`kelamin` AS `kelamin`,`tb_penduduk`.`gol_darah` AS `gol_darah`,`tb_penduduk`.`alamat` AS `alamat`,`tb_penduduk`.`rt` AS `rt`,`tb_penduduk`.`rw` AS `rw`,`tb_penduduk`.`kelurahan` AS `kelurahan`,`tb_penduduk`.`kecamatan` AS `kecamatan`,`tb_penduduk`.`agama` AS `agama`,`tb_penduduk`.`pendidikan` AS `pendidikan`,`tb_penduduk`.`sts_kawin` AS `sts_kawin`,`tb_penduduk`.`pekerjaan` AS `pekerjaan`,`tb_penduduk`.`kewarganegaraan` AS `kewarganegaraan` from (`tb_kematian` left join `tb_penduduk` on((`tb_kematian`.`nik` = `tb_penduduk`.`nik`))) ;

-- --------------------------------------------------------

--
-- Structure for view `v_surat_pengantar`
--
DROP TABLE IF EXISTS `v_surat_pengantar`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_surat_pengantar`  AS  select `tb_surat_pengantar`.`no_sp` AS `no_sp`,`tb_surat_pengantar`.`tgl` AS `tgl`,`tb_surat_pengantar`.`verifikasi` AS `verifikasi`,`tb_surat_pengantar`.`keperluan` AS `keperluan`,`tb_penduduk`.`nik` AS `nik`,`tb_penduduk`.`nama` AS `nama`,`tb_penduduk`.`nama_ibu` AS `nama_ibu`,`tb_penduduk`.`nama_ayah` AS `nama_ayah`,`tb_penduduk`.`tmp_lahir` AS `tmp_lahir`,`tb_penduduk`.`tgl_lahir` AS `tgl_lahir`,`tb_penduduk`.`kelamin` AS `kelamin`,`tb_penduduk`.`gol_darah` AS `gol_darah`,`tb_penduduk`.`alamat` AS `alamat`,`tb_penduduk`.`rt` AS `rt`,`tb_penduduk`.`rw` AS `rw`,`tb_penduduk`.`kelurahan` AS `kelurahan`,`tb_penduduk`.`kecamatan` AS `kecamatan`,`tb_penduduk`.`agama` AS `agama`,`tb_penduduk`.`pendidikan` AS `pendidikan`,`tb_penduduk`.`sts_kawin` AS `sts_kawin`,`tb_penduduk`.`pekerjaan` AS `pekerjaan`,`tb_penduduk`.`kewarganegaraan` AS `kewarganegaraan` from (`tb_surat_pengantar` left join `tb_penduduk` on((`tb_surat_pengantar`.`nik` = `tb_penduduk`.`nik`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_kematian`
--
ALTER TABLE `tb_kematian`
  ADD PRIMARY KEY (`no_skm`),
  ADD UNIQUE KEY `fk_mati_penduduk` (`nik`) USING BTREE;

--
-- Indexes for table `tb_penduduk`
--
ALTER TABLE `tb_penduduk`
  ADD PRIMARY KEY (`nik`);

--
-- Indexes for table `tb_surat_pengantar`
--
ALTER TABLE `tb_surat_pengantar`
  ADD PRIMARY KEY (`no_sp`),
  ADD KEY `fk_ktp_nik` (`nik`) USING BTREE;

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `uniq_username` (`username`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_kematian`
--
ALTER TABLE `tb_kematian`
  ADD CONSTRAINT `tb_kematian_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `tb_penduduk` (`nik`);

--
-- Constraints for table `tb_surat_pengantar`
--
ALTER TABLE `tb_surat_pengantar`
  ADD CONSTRAINT `tb_surat_pengantar_ibfk_1` FOREIGN KEY (`nik`) REFERENCES `tb_penduduk` (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
