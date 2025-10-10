package service;

import model.*;
import java.sql.*;

import java.util.*;


public class ManajemenGudang {
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
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
                    case "5": menuCariBarang(); break;
                    case "6":
                        System.out.println("Keluar dari program.");
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan masukkan angka 1-6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input tidak valid. Pastikan Anda memasukkan tipe data yang benar.");
                scanner.nextLine(); 
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Input angka tidak valid. Silakan coba lagi.");
            } catch (Exception e) {
                System.out.println("ERROR: Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
        // Create
    private static void tambahBarang() {
        new View().showData();
        System.out.println("\n--- TAMBAH BARANG ---");

        System.out.print("Masukkan ID Barang: ");
        String id = scanner.nextLine().trim();
        if (id.isEmpty()) {
            System.out.println("ERROR: ID Barang tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); 

        System.out.print("Masukkan Nama Barang: ");
        String nama = scanner.nextLine().trim();
        if (nama.isEmpty()) {
            System.out.println("ERROR: Nama Barang tidak boleh kosong. Kembali ke menu utama.");
            return;
        }

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

        System.out.print("Masukkan Lokasi: ");
        String lokasi = scanner.nextLine().trim();
        if (lokasi.isEmpty()) {
            System.out.println("ERROR: Lokasi tidak boleh kosong. Kembali ke menu utama.");
            return;
        }

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
        } else if (pilihanKategori.equals("2")) { // PERABO
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

        barang.save(); 
    }
    // Update
    private static void updateBarang() {
        new View().showData();
        System.out.println("\n--- UPDATE BARANG ---");
        System.out.print("Masukkan ID Barang yang ingin diupdate: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("ERROR: ID tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); 

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

                System.out.print("Nama baru (lama: " + barang.getNamaBarang() + "): ");
                String namaBaru = scanner.nextLine().trim();
                if (!namaBaru.isEmpty()) {
                    namaUpdate = namaBaru;
                    barang.setNamaBarang(namaBaru);
                }

                System.out.print("Stok baru (lama: " + barang.getStok() + ", Enter = tetap): ");
                String stokInput = scanner.nextLine().trim();
                if (!stokInput.isEmpty()) {
                    int stokTemp = Integer.parseInt(stokInput); 
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

                if (barang instanceof Elektronik) {
                    Elektronik e = (Elektronik) barang;
                    System.out.print("Garansi baru (bulan) (lama: " + e.getGaransiBulan() + "): ");
                    inputSpesifik = scanner.nextLine().trim();
                    if (!inputSpesifik.isEmpty()) {
                        int garansiBaru = Integer.parseInt(inputSpesifik); 
                        e.setGaransiBulan(garansiBaru); 
                    }

                } else if (barang instanceof Perabot) {
                    Perabot p = (Perabot) barang;
                    System.out.print("Bahan baru (lama: " + p.getBahan() + "): ");
                    inputSpesifik = scanner.nextLine().trim();
                    if (!inputSpesifik.isEmpty()) {
                        p.setBahan(inputSpesifik); 
                    }
                }


                barang.update(namaUpdate, stokUpdate, lokasiUpdate);

                if (barang instanceof Elektronik && inputSpesifik != null && !inputSpesifik.isEmpty()) {
                    String sql = "UPDATE barang SET garansi_bulan = ? WHERE id_barang = ?";
                    try (PreparedStatement psUpdate = conn.prepareStatement(sql)) {
                        psUpdate.setInt(1, ((Elektronik) barang).getGaransiBulan());
                        psUpdate.setString(2, barang.getIdBarang());
                        psUpdate.executeUpdate();
                    }
                } else if (barang instanceof Perabot && inputSpesifik != null && !inputSpesifik.isEmpty()) {
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
    // Delete
    private static void hapusBarang() {
        new View().showData();
        System.out.println("\n--- HAPUS BARANG ---");
        System.out.print("Masukkan ID Barang yang ingin dihapus: ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("ERROR: ID tidak boleh kosong. Kembali ke menu utama.");
            return;
        }
        id = id.toUpperCase(); 


        Barang dummy = new Perabot(id, "", 0, "", "");
        dummy.delete();
    }
        // Cari
    private static void menuCariBarang() {
        System.out.println("\n--- PILIH JENIS PENCARIAN ---");
        System.out.println("1. Berdasarkan ID atau Nama (String)");
        System.out.println("2. Berdasarkan Stok Minimal (Integer)");
        System.out.print("Pilih jenis pencarian: ");
        String pilihan = scanner.nextLine().trim();

        try {
            if (pilihan.equals("1")) {
                System.out.print("Masukkan ID atau Nama: ");
                String keyword = scanner.nextLine().trim();
                cariBarang(keyword); 
            } else if (pilihan.equals("2")) {
                System.out.print("Masukkan Stok Minimal (angka): ");
                String stokInput = scanner.nextLine().trim();
                if (stokInput.isEmpty()) {
                    System.out.println("ERROR: Stok minimal tidak boleh kosong. Kembali ke menu utama.");
                    return;
                }
                int minStok = Integer.parseInt(stokInput); 
                cariBarang(minStok); 
            } else {
                System.out.println("Pilihan tidak valid.");
            }
        } catch (NumberFormatException e) {
            System.out.println("ERROR: Input stok minimal harus berupa angka. Kembali ke menu utama.");
        } catch (Exception e) {
            System.out.println("ERROR: Terjadi kesalahan: " + e.getMessage());
        }
    }
    private static void cariBarang(String keyword) {


        System.out.println("\n--- CARI BARANG BERDASARKAN ID/NAMA ---");

        if (keyword.isEmpty()) {
            System.out.println("ERROR: Kata kunci tidak boleh kosong! Kembali ke menu utama.");
            return;
        }

        try (Connection conn = Conn.connect();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT * FROM barang WHERE id_barang LIKE ? OR nama_barang LIKE ?")) {

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
                System.out.printf("%-10s %-20s %-10d %-15s %-15s %-15s %-15s%n",
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("stok"),
                        rs.getString("lokasi"),
                        rs.getString("kategori"),
                        rs.getObject("garansi_bulan") != null ? rs.getInt("garansi_bulan") + " bln" : "-",
                        rs.getString("bahan") != null ? rs.getString("bahan") : "-");
            }

            if (!found) {
                System.out.println("Barang tidak ditemukan untuk kata kunci '" + keyword + "'.");
            }
        } catch (Exception e) {
            System.out.println("ERROR: Pencarian gagal: " + e.getMessage());
        }
    }
    private static void cariBarang(int minStok) {
        System.out.println("\n--- CARI BARANG BERDASARKAN STOK MINIMAL ---");

        String sql = "SELECT id_barang, nama_barang, stok, lokasi, kategori, garansi_bulan, bahan FROM barang WHERE stok >= ?";

        try (Connection conn = Conn.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, minStok);
            ResultSet rs = ps.executeQuery();

            boolean found = false;
            System.out.printf("%-10s %-20s %-10s %-15s %-15s %-15s %-15s%n",
                    "ID", "Nama", "Stok", "Lokasi", "Kategori", "Garansi", "Bahan");
            System.out.println("--------------------------------------------------------------------------------------------");

            while (rs.next()) {
                found = true;
                System.out.printf("%-10s %-20s %-10d %-15s %-15s %-15s %-15s%n",
                        rs.getString("id_barang"),
                        rs.getString("nama_barang"),
                        rs.getInt("stok"),
                        rs.getString("lokasi"),
                        rs.getString("kategori"),
                        rs.getObject("garansi_bulan") != null ? rs.getInt("garansi_bulan") + " bln" : "-",
                        rs.getString("bahan") != null ? rs.getString("bahan") : "-");
            }

            if (!found) System.out.println("Tidak ditemukan barang dengan stok minimal " + minStok + ".");
        } catch (Exception e) {
            System.out.println("ERROR: Pencarian gagal: " + e.getMessage());
        }
    }
    }
