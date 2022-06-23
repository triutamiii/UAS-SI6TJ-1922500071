-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 23 Jun 2022 pada 10.09
-- Versi server: 10.4.14-MariaDB
-- Versi PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `campuss`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `lecturer`
--

CREATE TABLE `lecturer` (
  `nidn` int(10) NOT NULL,
  `nama_dosen` varchar(30) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `gol_pang` varchar(20) NOT NULL,
  `keahlian` varchar(50) NOT NULL,
  `program_studi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `lecturer`
--

INSERT INTO `lecturer` (`nidn`, `nama_dosen`, `jabatan`, `gol_pang`, `keahlian`, `program_studi`) VALUES
(201214243, 'Rahmat Sulaiman, M.Kom', 'Asisten Ahli', 'III/a Pembina Utama', 'Security', 'Teknik Informatika'),
(224129301, 'Tri Sugihartono, M.Kom', 'Asisten Ahli', 'III/b Penata Muda', 'Mobile Application', 'Teknik Informatika');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`nidn`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
