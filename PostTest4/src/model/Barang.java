package model;

public abstract class Barang implements Categorizable {
    private String idBarang;
    private String namaBarang;
    private int stok;
    private String lokasi;

    public Barang(String idBarang, String namaBarang, int stok, String lokasi) {
        setIdBarang(idBarang);
        setNamaBarang(namaBarang);
        setStok(stok);
        setLokasi(lokasi);
    }

    public String getIdBarang() {
        return idBarang;
    }

    public void setIdBarang(String idBarang) {
        if (idBarang == null || idBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("ID barang tidak boleh kosong.");
        }
        this.idBarang = idBarang.toUpperCase();
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        this.namaBarang = namaBarang;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) throw new IllegalArgumentException("Stok tidak boleh negatif.");
        this.stok = stok;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        if (lokasi == null || lokasi.trim().isEmpty()) {
            throw new IllegalArgumentException("Lokasi tidak boleh kosong.");
        }
        this.lokasi = lokasi;
    }

    // Abstract method untuk diturunkan
    public abstract void tampilkanInfo();
}
