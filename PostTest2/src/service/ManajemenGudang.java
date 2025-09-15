package service;

import model.Barang;
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenGudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private int totalBarang;

    // Data dummy
    public ManajemenGudang() {
        daftarBarang.add(new Barang("B001", "Laptop", 10, "Rak A"));
        daftarBarang.add(new Barang("B002", "Printer", 5, "Rak B"));
        totalBarang = daftarBarang.size(); // sinkron awal
    }

    // getter totalBarang
    public int getTotalBarang() {
        return totalBarang;
    }

    // Create
    public void tambahBarang() {
        lihatBarang();
        System.out.println();
        try {
            System.out.print("Masukkan ID Barang: ");
            String id = input.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("ID tidak boleh kosong.");
                return;
            }
            for (Barang b : daftarBarang) {
                if (b.getIdBarang().equalsIgnoreCase(id)) {
                    System.out.println("ID sudah ada!");
                    return;
                }
            }

            System.out.print("Masukkan Nama Barang: ");
            String nama = input.nextLine().trim();
            if (nama.isEmpty()) {
                System.out.println("Nama tidak boleh kosong.");
                return;
            }

            System.out.print("Masukkan Stok: ");
            String stokInput = input.nextLine().trim();
            if (stokInput.isEmpty()) {
                System.out.println("Input stok tidak boleh kosong!");
                return;
            }

            int stok;
            try {
                stok = Integer.parseInt(stokInput);
                if (stok < 0) {
                    System.out.println("Stok tidak boleh negatif.");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input stok harus berupa angka!");
                return;
            }

            System.out.print("Masukkan Lokasi: ");
            String lokasi = input.nextLine().trim();
            if (lokasi.isEmpty()) {
                System.out.println("Lokasi tidak boleh kosong.");
                return;
            }

            daftarBarang.add(new Barang(id.toUpperCase(), nama, stok, lokasi));
            totalBarang++; // update properti
            System.out.println("Barang berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Input stok harus berupa angka!");
            input.nextLine();
        }
    }

    // Read
    public void lihatBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
            return;
        }
        System.out.println("\n===== DAFTAR BARANG =====");
        for (Barang b : daftarBarang) {
            System.out.println("ID     : " + b.getIdBarang());
            System.out.println("Nama   : " + b.getNamaBarang());
            System.out.println("Stok   : " + b.getStok());
            System.out.println("Lokasi : " + b.getLokasi());
            System.out.println("-------------------------");
        }
        System.out.println("Total barang: " + totalBarang);
    }

    // Update
    public void updateBarang() {
        lihatBarang();
        System.out.println();
        System.out.print("Masukkan ID Barang yang ingin diupdate: ");
        String id = input.nextLine().trim();

        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equalsIgnoreCase(id)) {
                System.out.println("Silahkan isi data baru / tekan Enter untuk mempertahankan data lama.");

                System.out.print("Nama baru (Data lama: " + b.getNamaBarang() + " ): ");
                String nama = input.nextLine().trim();
                if (!nama.isEmpty()) {
                    b.setNamaBarang(nama);
                }

                System.out.print("Stok baru (Data lama: " + b.getStok() + " ): ");
                String stokInput = input.nextLine().trim();

                if (!stokInput.isEmpty()) {
                    try {
                        int stok = Integer.parseInt(stokInput);
                        if (stok < 0) {
                            System.out.println("Stok tidak boleh negatif.");
                            return;
                        }
                        b.setStok(stok);
                    } catch (NumberFormatException e) {
                        System.out.println("Input stok harus berupa angka!");
                        return;
                    }
                }
                System.out.print("Lokasi baru (Data lama: " + b.getLokasi() + " ): ");
                String lokasi = input.nextLine().trim();
                if (!lokasi.isEmpty()) {
                    b.setLokasi(lokasi);
                }

                System.out.println("Data barang berhasil diperbarui!");
                return;
            }
        }
        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
    }

    // Delete
    public void hapusBarang() {
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        String id = input.nextLine();
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equalsIgnoreCase(id)) {
                daftarBarang.remove(b);
                totalBarang--; // update properti
                System.out.println("Barang berhasil dihapus!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    // Search
    public void cariBarang() {
        System.out.print("Masukkan kata kunci (ID/Nama): ");
        String keyword = input.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Kata kunci tidak boleh kosong.");
            return;
        }
        boolean ditemukan = false;

        for (Barang b : daftarBarang) {
            if (b.getIdBarang().toLowerCase().contains(keyword) ||
                    b.getNamaBarang().toLowerCase().contains(keyword)) {
                System.out.println("ID     : " + b.getIdBarang());
                System.out.println("Nama   : " + b.getNamaBarang());
                System.out.println("Stok   : " + b.getStok());
                System.out.println("Lokasi : " + b.getLokasi());
                System.out.println("-------------------------");
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }
}
