package model;

public class Barang {
    private String idBarang;
    private String namaBarang;
    private int stok;
    private String lokasi;

    public Barang(String idBarang, String namaBarang, int stok, String lokasi) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.lokasi = lokasi;
    }

    // Getter & Setter
    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}