package model;

public class Barang {
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
            throw new IllegalArgumentException("ID tidak boleh kosong.");
        }
        this.idBarang = idBarang.trim().toUpperCase();
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        if (namaBarang == null || namaBarang.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama barang tidak boleh kosong.");
        }
        this.namaBarang = namaBarang.trim();
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            throw new IllegalArgumentException("Stok tidak boleh negatif.");
        }
        this.stok = stok;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        if (lokasi == null || lokasi.trim().isEmpty()) {
            throw new IllegalArgumentException("Lokasi tidak boleh kosong.");
        }
        this.lokasi = lokasi.trim();
    }

    public void tampilkanInfo() {
        System.out.println("ID       : " + idBarang);
        System.out.println("Nama     : " + namaBarang);
        System.out.println("Stok     : " + stok);
        System.out.println("Lokasi   : " + lokasi);
    }
}
