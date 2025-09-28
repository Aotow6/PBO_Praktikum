package model;

public class Perabot extends Barang {
    private String bahan;

    public Perabot(String idBarang, String namaBarang, int stok, String lokasi, String bahan) {
        super(idBarang, namaBarang, stok, lokasi);
        setBahan(bahan);
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        if (bahan == null || bahan.trim().isEmpty()) {
            throw new IllegalArgumentException("Bahan tidak boleh kosong.");
        }
        this.bahan = bahan;
    }

    @Override
    public String getKategori() {
        return "Perabot";
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID       : " + getIdBarang());
        System.out.println("Nama     : " + getNamaBarang());
        System.out.println("Stok     : " + getStok());
        System.out.println("Lokasi   : " + getLokasi());
        System.out.println("Kategori : " + getKategori());
        System.out.println("Bahan    : " + getBahan());
        System.out.println("-------------------------");
    }
}
