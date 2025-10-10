package service;

import model.*;
import java.sql.*;

import java.util.*;


public class ManajemenGudang {
    // Penggunaan static final Scanner adalah praktik yang baik.
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        // Objek Conn dibuat untuk memastikan driver JDBC terinisialisasi.
        new Conn();

        while (true) {
            System.out.println("\n=== MENU MANAJEMEN GUDANG ===");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Semua Barang");
            System.out.println("3. Update Barang");
            System.out.println("4. Hapus Barang");
            System.out.println("5. Cari Barang");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");
            String pilihan = scanner.nextLine();

            try {
                switch (pilihan) {
                    case "1": tambahBarang(); break;
                    case "2": new View().showData(); break;
                    case "3": updateBarang(); break;
                    case "4": hapusBarang(); break;
                    case "5": searchBarang(); break;
                    case "6":
                        System.out.println("Keluar dari program.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan masukkan angka 1-6.");
                }
            } catch (InputMismatchException e) {
                // Menangkap kesalahan umum jika Scanner digunakan dengan nextInt/nextDouble
                System.out.println("ERROR: Input tidak valid. Pastikan Anda memasukkan tipe data yang benar.");
                scanner.nextLine(); // Membersihkan buffer scanner
            } catch (NumberFormatException e) {
                // Menangkap kesalahan saat mengkonversi String ke Integer
                System.out.println("ERROR: Input angka tidak valid. Silakan coba lagi.");
            } catch (Exception e) {
                // Menangkap kesalahan lain yang tidak terduga
                System.out.println("ERROR: Terjadi kesalahan: " + e.getMessage());
            }
        }
    }

    private static void tambahBarang() {
        new View().showData();
        System.out.println("\n--- TAMBAH BARANG ---");

        // Input ID Barang (diubah ke UPPERCASE dan divalidasi)
        System.out.print("Masukkan ID Barang: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("ERROR: ID Barang tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); // Mengubah ID menjadi UPPERCASE

        // Input Nama Barang (divalidasi)
        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("ERROR: Nama Barang tidak boleh kosong. Kembali ke menu utama.");
            return;
        }

        // Input Stok
        int stok;
        System.out.print("Masukkan Stok (angka): ");
        String stokInput = scanner.nextLine().trim();
        try {
            stok = Integer.parseInt(stokInput);
            if (stok < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Stok harus berupa angka non-negatif yang valid. Kembali ke menu utama.");
            return;
        }

        // Input Lokasi (divalidasi)
        System.out.print("Masukkan Lokasi: ");
        String lokasi = scanner.nextLine().trim();
        if (lokasi.isEmpty()) {
            System.out.println("ERROR: Lokasi tidak boleh kosong. Kembali ke menu utama.");
            return;
        }

        // Input Kategori berbasis angka (1/2)
        System.out.println("Pilih Kategori:");
        System.out.println("1. ELEKTRONIK");
        System.out.println("2. PERABOT");
        System.out.print("Pilih (1/2): ");
        String pilihanKategori = scanner.nextLine().trim();

        Barang barang = null;
        if (pilihanKategori.equals("1")) { // ELEKTRONIK
            int garansi;
            System.out.print("Masukkan Garansi (bulan, angka): ");
            String garansiInput = scanner.nextLine().trim();
            try {
                garansi = Integer.parseInt(garansiInput);
                if (garansi < 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Garansi harus berupa angka non-negatif yang valid. Kembali ke menu utama.");
                return;
            }
            barang = new Elektronik(id, nama, stok, lokasi, garansi);
        } else if (pilihanKategori.equals("2")) { // PERABOT
            System.out.print("Masukkan Bahan: ");
            String bahan = scanner.nextLine().trim();
            if (bahan.isEmpty()) {
                System.out.println("ERROR: Bahan tidak boleh kosong. Kembali ke menu utama.");
                return;
            }
            barang = new Perabot(id, nama, stok, lokasi, bahan);
        } else {
            System.out.println("ERROR: Pilihan kategori tidak valid! Kembali ke menu utama.");
            return;
        }

        barang.save(); // Panggilan ke method ORM di class Barang
    }

    private static void updateBarang() {
        new View().showData();
        System.out.println("\n--- UPDATE BARANG ---");
        System.out.print("Masukkan ID Barang yang ingin diupdate: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("ERROR: ID tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); // Mengubah ID menjadi UPPERCASE

        Barang barang = null;
        String namaUpdate = null;
        Integer stokUpdate = null;
        String lokasiUpdate = null;
        String inputSpesifik = null;

        try (Connection conn = Conn.connect();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM barang WHERE id_barang=?")) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // 1. Re-Instantiate objek dari database
                String kategoriDB = rs.getString("kategori");
                if ("ELEKTRONIK".equalsIgnoreCase(kategoriDB)) {
                    barang = new Elektronik(rs.getString("id_barang"), rs.getString("nama_barang"),
                            rs.getInt("stok"), rs.getString("lokasi"), rs.getInt("garansi_bulan"));
                } else if ("PERABOT".equalsIgnoreCase(kategoriDB)) {
                    barang = new Perabot(rs.getString("id_barang"), rs.getString("nama_barang"),
                            rs.getInt("stok"), rs.getString("lokasi"), rs.getString("bahan"));
                } else {
                    System.out.println("ERROR: Kategori barang di database tidak dikenali.");
                    return;
                }

                System.out.println("\nSilahkan isi data baru / tekan Enter untuk mempertahankan data lama.");

                // 2. Input Atribut Umum
                System.out.print("Nama baru (lama: " + barang.getNamaBarang() + "): ");
                String namaBaru = scanner.nextLine().trim();
                if (!namaBaru.isEmpty()) {
                    namaUpdate = namaBaru;
                    barang.setNamaBarang(namaBaru);
                }

                System.out.print("Stok baru (lama: " + barang.getStok() + ", Enter = tetap): ");
                String stokInput = scanner.nextLine().trim();
                if (!stokInput.isEmpty()) {
                    int stokTemp = Integer.parseInt(stokInput); // Memicu NumberFormatException
                    if (stokTemp < 0) throw new IllegalArgumentException("Stok tidak boleh negatif.");
                    stokUpdate = stokTemp;
                    barang.setStok(stokTemp);
                }

                System.out.print("Lokasi baru (lama: " + barang.getLokasi() + "): ");
                String lokasiBaru = scanner.nextLine().trim();
                if (!lokasiBaru.isEmpty()) {
                    lokasiUpdate = lokasiBaru;
                    barang.setLokasi(lokasiBaru);
                }

                // 3. Input Atribut Subclass
                if (barang instanceof Elektronik) {
                    Elektronik e = (Elektronik) barang;
                    System.out.print("Garansi baru (bulan) (lama: " + e.getGaransiBulan() + "): ");
                    inputSpesifik = scanner.nextLine().trim();
                    if (!inputSpesifik.isEmpty()) {
                        int garansiBaru = Integer.parseInt(inputSpesifik); // Memicu NumberFormatException
                        e.setGaransiBulan(garansiBaru); // Memicu IllegalArgumentException (validasi)
                    }

                } else if (barang instanceof Perabot) {
                    Perabot p = (Perabot) barang;
                    System.out.print("Bahan baru (lama: " + p.getBahan() + "): ");
                    inputSpesifik = scanner.nextLine().trim();
                    if (!inputSpesifik.isEmpty()) {
                        p.setBahan(inputSpesifik); // Memicu IllegalArgumentException (validasi)
                    }
                }

                // --- 4. Panggil ORM untuk update ke Database ---
                // Panggil method ORM update untuk atribut umum
                barang.update(namaUpdate, stokUpdate, lokasiUpdate);

                // Panggil ORM manual untuk atribut spesifik jika ada perubahan
                if (barang instanceof Elektronik && inputSpesifik != null && !inputSpesifik.isEmpty()) {
                    // Update Garansi
                    String sql = "UPDATE barang SET garansi_bulan = ? WHERE id_barang = ?";
                    try (PreparedStatement psUpdate = conn.prepareStatement(sql)) {
                        psUpdate.setInt(1, ((Elektronik) barang).getGaransiBulan());
                        psUpdate.setString(2, barang.getIdBarang());
                        psUpdate.executeUpdate();
                    }
                } else if (barang instanceof Perabot && inputSpesifik != null && !inputSpesifik.isEmpty()) {
                    // Update Bahan
                    String sql = "UPDATE barang SET bahan = ? WHERE id_barang = ?";
                    try (PreparedStatement psUpdate = conn.prepareStatement(sql)) {
                        psUpdate.setString(1, ((Perabot) barang).getBahan());
                        psUpdate.setString(2, barang.getIdBarang());
                        psUpdate.executeUpdate();
                    }
                }

                System.out.println("Data barang berhasil diperbarui!");

            } else {
                System.out.println("Barang tidak ditemukan!");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Input angka tidak valid saat update (stok/garansi harus angka). Kembali ke menu utama.");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: Validasi gagal saat update: " + e.getMessage() + ". Kembali ke menu utama.");
        } catch (RuntimeException e) {
            System.out.println("ERROR: Pembaruan data gagal di database: " + e.getMessage() + ". Kembali ke menu utama.");
        } catch (SQLException e) {
            System.out.println("ERROR: Gagal terhubung/akses database: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: Update gagal: " + e.getMessage());
        }
    }

    private static void hapusBarang() {
        new View().showData();
        System.out.println("\n--- HAPUS BARANG ---");
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        // Input ID Barang (diubah ke UPPERCASE dan divalidasi)
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("ERROR: ID tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); // Mengubah ID menjadi UPPERCASE

        // Membuat objek placeholder untuk memanggil method delete() ORM
        // ID yang digunakan adalah ID yang sudah di-UPPERCASE
        Barang dummy = new Perabot(id, "", 0, "", "");
        dummy.delete();
    }

    private static void searchBarang() {
        new View().showData();
        System.out.println("\n--- CARI BARANG ---");
        System.out.print("Masukkan ID atau Nama Barang: ");
        String keyword = scanner.nextLine().trim(); // Menerapkan trim()

        if (keyword.isEmpty()) {
            System.out.println("ERROR: Kata kunci tidak boleh kosong! Kembali ke menu utama.");
            return;
        }

        try (Connection conn = Conn.connect();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM barang WHERE id_barang LIKE ? OR nama_barang LIKE ?")) {
            // Menerapkan trim() pada keyword pencarian
            String searchPattern = "%" + keyword + "%";
            ps.setString(1, searchPattern);
            ps.setString(2, searchPattern);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            System.out.printf("%-10s %-20s %-10s %-15s %-15s %-15s %-15s%n",
                    "ID", "Nama", "Stok", "Lokasi", "Kategori", "Garansi", "Bahan");
            System.out.println("--------------------------------------------------------------------------------------------");

            while (rs.next()) {
                found = true;
                // Output tidak berubah
                System.out.printf("%-10s %-20s %-10d %-15s %-15s %-15s %-15s%n",
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("stok"),
                        rs.getString("lokasi"),
                        rs.getString("kategori"),
                        rs.getObject("garansi_bulan") != null ? rs.getInt("garansi_bulan") + " bln" : "-",
                        rs.getString("bahan") != null ? rs.getString("bahan") : "-");
            }

            if (!found) System.out.println("Barang tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("ERROR: Pencarian gagal: " + e.getMessage());
        }
    }
}