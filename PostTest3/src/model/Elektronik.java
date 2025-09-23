package model;

public class Elektronik extends Barang {
    private int garansiBulan;

    public Elektronik(String idBarang, String namaBarang, int stok, String lokasi, int garansiBulan) {
        super(idBarang, namaBarang, stok, lokasi);
        setGaransiBulan(garansiBulan);
    }

    public int getGaransiBulan() {
        return garansiBulan;
    }

    public void setGaransiBulan(int garansiBulan) {
        if (garansiBulan < 0) throw new IllegalArgumentException("Garansi tidak boleh negatif.");
        this.garansiBulan = garansiBulan;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Kategori : Elektronik");
        System.out.println("Garansi  : " + getGaransiBulan() + " bulan");
        System.out.println("-------------------------");
    }
}
