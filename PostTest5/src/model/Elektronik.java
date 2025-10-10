package model;

public class Elektronik extends Barang {
    private int garansiBulan;

    public Elektronik(String idBarang, String namaBarang, int stok, String lokasi, int garansiBulan) {
        super(idBarang, namaBarang, stok, lokasi, "ELEKTRONIK");
        this.garansiBulan = garansiBulan;
    }

    public int getGaransiBulan() {
        return garansiBulan;
    }

    public void setGaransiBulan(int garansiBulan) {
        if (garansiBulan < 0) throw new IllegalArgumentException("Garansi tidak boleh negatif.");
        this.garansiBulan = garansiBulan;
    }

    @Override
    public String getKategori() {
        return "Elektronik";
    }

    @Override
    public void displayInfo() {
        System.out.println("ID       : " + getIdBarang());
        System.out.println("Nama     : " + getNamaBarang());
        System.out.println("Stok     : " + getStok());
        System.out.println("Lokasi   : " + getLokasi());
        System.out.println("Kategori : " + getKategori());
        System.out.println("Garansi  : " + getGaransiBulan() + " bulan");
        System.out.println("-------------------------");
    }

}
