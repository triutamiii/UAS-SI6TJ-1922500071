package com.example.uas;

public class Data {
    private String nidn, nama_dosen, jabatan, gol_pang, keahlian, program_studi;

    public Data() {
    }

    public Data(String nidn, String nama_dosen, String jabatan, String gol_pang, String keahlian, String program_studi){
        this.nidn = nidn;
        this.nama_dosen = nama_dosen;
        this.jabatan = jabatan;
        this.gol_pang = gol_pang;
        this.keahlian = keahlian;
        this.program_studi = program_studi;

    }

    public String getNidn() { return nidn; }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getnama_dosen() {
        return nama_dosen;
    }

    public void setnama_dosen(String nama_dosen) {
        this.nama_dosen = nama_dosen;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getgol_pang() {
        return gol_pang;
    }

    public void setgol_pang(String gol_pang) {
        this.gol_pang = gol_pang;
    }

    public String getKeahlian() {
        return keahlian;
    }

    public void setKeahlian(String keahlian) {
        this.keahlian = keahlian;
    }

    public String getprogram_studi() {
        return program_studi;
    }

    public void setprogram_studi(String program_studi) {
        this.program_studi = program_studi;
    }
}
