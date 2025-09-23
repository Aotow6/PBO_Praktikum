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
        if (bahan == null) throw new IllegalArgumentException("Bahan tidak boleh null.");
        String v = bahan.trim();
        if (v.isEmpty()) throw new IllegalArgumentException("Bahan tidak boleh kosong.");
        this.bahan = v;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori : Perabot");
        System.out.println("Bahan    : " + getBahan());
        System.out.println("-------------------------");
    }
}

