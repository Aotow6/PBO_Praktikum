package service;

import model.Barang;
import model.Elektronik;
import model.Perabot;

import java.util.*;


public class ManajemenGudang {
    private ArrayList<Barang> daftarBarang = new ArrayList<>();
    private Scanner input = new Scanner(System.in);
    private int totalBarang;

    public ManajemenGudang() {
        // Data dummy
        daftarBarang.add(new Elektronik("B001", "Laptop", 10, "Rak A", 24));
        daftarBarang.add(new Elektronik("B002", "Printer", 5, "Rak B", 12));
        daftarBarang.add(new Perabot("B003", "Meja", 7, "Rak C", "Kayu"));
        totalBarang = daftarBarang.size();
    }

    public void run() {
        boolean jalan = true;
        while (jalan) {
            tampilkanMenu();
            int pilihan = getInputMenu();
            switch (pilihan) {
                case 1 -> tambahBarang();
                case 2 -> lihatBarang();
                case 3 -> updateBarang();
                case 4 -> hapusBarang();
                case 5 -> cariBarang();
                case 6 -> {
                    System.out.println("Terima kasih, program selesai.");
                    jalan = false;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private void tampilkanMenu() {
        System.out.println("\n+====== MENU INVENTARIS GUDANG ======+");
        System.out.println("|   1. Tambah Barang                 |");
        System.out.println("|   2. Lihat Daftar Barang           |");
        System.out.println("|   3. Update Barang                 |");
        System.out.println("|   4. Hapus Barang                  |");
        System.out.println("|   5. Cari Barang                   |");
        System.out.println("|   6. Keluar                        |");
        System.out.println("+====================================+");
        System.out.print("Pilih menu: ");
    }

    private int getInputMenu() {
        String line = input.nextLine().trim();
        if (line.isEmpty()) {
            System.out.println("Input menu tidak boleh kosong!");
            return -1;
        }
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            System.out.println("Input menu harus berupa angka!");
            return -1;
        }
    }

    // CREATE
    public void tambahBarang() {
        lihatBarang();
        System.out.println("\n=== Tambah Barang ===");

        System.out.print("Masukkan ID Barang: ");
        String id = input.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("ID tidak boleh kosong.");
            return;
        }
        if (cariById(id) != null) {
            System.out.println("ID sudah ada!");
            return;
        }

        System.out.print("Masukkan Nama Barang: ");
        String nama = input.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("Nama tidak boleh kosong.");
            return;
        }

        System.out.print("Masukkan Stok: ");
        String stokStr = input.nextLine().trim();
        if (stokStr.isEmpty()) {
            System.out.println("Stok tidak boleh kosong.");
            return;
        }
        int stok;
        try {
            stok = Integer.parseInt(stokStr);
            if (stok < 0) {
                System.out.println("Stok tidak boleh negatif.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Stok harus berupa angka!");
            return;
        }

        System.out.print("Masukkan Lokasi: ");
        String lokasi = input.nextLine().trim();
        if (lokasi.isEmpty()) {
            System.out.println("Lokasi tidak boleh kosong.");
            return;
        }

        System.out.println("Pilih kategori: 1. Elektronik  2. Perabot");
        System.out.print("Masukkan pilihan kategori: ");
        String katStr = input.nextLine().trim();

        if ("1".equals(katStr)) {
            System.out.print("Masukkan garansi (bulan): ");
            String garansiStr = input.nextLine().trim();
            if (garansiStr.isEmpty()) {
                System.out.println("Garansi tidak boleh kosong.");
                return;
            }
            try {
                int garansi = Integer.parseInt(garansiStr);
                if (garansi < 0) {
                    System.out.println("Garansi tidak boleh negatif.");
                    return;
                }
                daftarBarang.add(new Elektronik(id, nama, stok, lokasi, garansi));
            } catch (NumberFormatException e) {
                System.out.println("Garansi harus berupa angka!");
                return;
            }

        } else if ("2".equals(katStr)) {
            System.out.print("Masukkan bahan: ");
            String bahan = input.nextLine().trim();
            if (bahan.isEmpty()) {
                System.out.println("Bahan tidak boleh kosong.");
                return;
            }
            daftarBarang.add(new Perabot(id, nama, stok, lokasi, bahan));
        } else {
            System.out.println("Kategori tidak valid.");
            return;
        }

        totalBarang = daftarBarang.size();
        System.out.println("Barang berhasil ditambahkan!");
    }

    // READ
    public void lihatBarang() {
        System.out.println();
        if (daftarBarang.isEmpty()) {
            System.out.println("Daftar barang kosong.");
            return;
        }
        System.out.println("\n===== DAFTAR BARANG =====");
        for (Barang b : daftarBarang) {
            b.tampilkanInfo();
        }
        System.out.println(" ");
        System.out.println("Total barang: " + totalBarang);
    }

    // UPDATE
    public void updateBarang() {
        lihatBarang();
        System.out.println("\n=== Update Barang ===");
        System.out.print("Masukkan ID Barang yang ingin diupdate: ");
        String id = input.nextLine().trim();
        Barang target = cariById(id);
        if (target == null) {
            System.out.println("Barang dengan ID tersebut tidak ditemukan.");
            return;
        }

        System.out.println("Silahkan isi data baru / tekan Enter untuk mempertahankan data lama.");
        try {
            System.out.print("Nama baru (lama: " + target.getNamaBarang() + "): ");
            String nama = input.nextLine().trim();
            if (!nama.isEmpty()) target.setNamaBarang(nama);

            System.out.print("Stok baru (lama: " + target.getStok() + "): ");
            String stokStr = input.nextLine().trim();
            if (!stokStr.isEmpty()) {
                int stok = Integer.parseInt(stokStr);
                target.setStok(stok);
            }

            System.out.print("Lokasi baru (lama: " + target.getLokasi() + "): ");
            String lokasi = input.nextLine().trim();
            if (!lokasi.isEmpty()) target.setLokasi(lokasi);

            if (target instanceof Elektronik) {
                Elektronik e = (Elektronik) target;
                System.out.print("Garansi baru (bulan) (lama: " + e.getGaransiBulan() + "): ");
                String garansiStr = input.nextLine().trim();
                if (!garansiStr.isEmpty()) {
                    int garansi = Integer.parseInt(garansiStr);
                    e.setGaransiBulan(garansi);
                }
            } else if (target instanceof Perabot) {
                Perabot p = (Perabot) target;
                System.out.print("Bahan baru (lama: " + p.getBahan() + "): ");
                String bahan = input.nextLine().trim();
                if (!bahan.isEmpty()) p.setBahan(bahan);
            }

            System.out.println("Data barang berhasil diperbarui!");
        } catch (NumberFormatException e) {
            System.out.println("Input angka tidak valid saat update (stok/garansi harus angka).");
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi gagal saat update: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    // DELETE
    public void hapusBarang() {
        lihatBarang();
        System.out.println("\n=== Hapus Barang ===");
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        String id = input.nextLine().trim();
        Iterator<Barang> it = daftarBarang.iterator();
        while (it.hasNext()) {
            Barang b = it.next();
            if (b.getIdBarang().equalsIgnoreCase(id)) {
                it.remove();
                totalBarang = daftarBarang.size();
                System.out.println("Barang berhasil dihapus!");
                return;
            }
        }
        System.out.println("Barang tidak ditemukan.");
    }

    // SEARCH
    public void cariBarang() {
        lihatBarang();
        System.out.println("\n=== Cari Barang ===");
        System.out.print("Masukkan kata kunci (ID/Nama): ");
        String keyword = input.nextLine().trim().toLowerCase();
        if (keyword.isEmpty()) {
            System.out.println("Kata kunci tidak boleh kosong.");
            return;
        }
        boolean ditemukan = false;
        System.out.println("\n=== Hasil ===");
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().toLowerCase().contains(keyword) ||
                    b.getNamaBarang().toLowerCase().contains(keyword)) {
                b.tampilkanInfo();
                ditemukan = true;
            }
        }
        if (!ditemukan) {
            System.out.println("Barang tidak ditemukan.");
        }
    }

    private Barang cariById(String id) {
        if (id == null) return null;
        String key = id.trim().toUpperCase();
        for (Barang b : daftarBarang) {
            if (b.getIdBarang().equalsIgnoreCase(key)) return b;
        }
        return null;
    }
}
