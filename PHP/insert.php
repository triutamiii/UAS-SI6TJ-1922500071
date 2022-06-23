<?php

include "koneksi.php";

$nidn = isset($_POST['nidn']) ? $_POST['nidn'] : '';
$nama_dosen = isset($_POST['nama_dosen']) ? $_POST['nama_dosen'] : '';
$jabatan = isset($_POST['jabatan']) ? $_POST['jabatan'] : '';
$gol_pang = isset($_POST['gol_pang']) ? $_POST['gol_pang'] : '';
$keahlian = isset($_POST['keahlian']) ? $_POST['keahlian'] : '';
$program_studi = isset($_POST['program_studi']) ? $_POST['program_studi'] : '';


if (empty($nidn) || empty($nama_dosen) || empty($jabatan) || empty($gol_pang) || empty($keahlian) || empty($program_studi)) {
} else if (empty($id)) {
	$query = mysqli_query($con, "INSERT INTO lecturer (nidn, nama_dosen, jabatan, gol_pang, keahlian, program_studi) VALUES($nidn,'" . $nama_dosen . "','" . $jabatan . "','" . $gol_pang . "','" . $keahlian . "','" . $program_studi . "')");

	if ($query) {
		echo "Data berhasil di simpan";
	} else {
		echo "Error simpan Data";
	}
} else {
	$query = mysqli_query($con, "UPDATE lecturer set nama_dosen = '" . $nama_dosen . "', jabatan = '" . $alamat . "' where id = '" . $id . "'");

	if ($query) {
		echo "Data berhasil di ubah";
	} else {
		echo "Error ubah Data";
	}
}
