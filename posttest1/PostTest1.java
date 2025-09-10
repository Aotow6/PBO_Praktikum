/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.posttest1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author TUF
 */
public class PostTest1 {

    public static void main(String[] args) {      
Scanner input = new Scanner(System.in);

        ArrayList<String[]> daftarBarang = new ArrayList<>();

        // Data dummy awal
        daftarBarang.add(new String[]{"B001", "Laptop", "10", "Rak A"});
        daftarBarang.add(new String[]{"B002", "Printer", "5", "Rak B"});

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n+====== MENU INVENTARIS GUDANG ======+");
            System.out.println("|   1. Tambah Barang                 |");
            System.out.println("|   2. Lihat Daftar Barang           |");
            System.out.println("|   3. Update Barang                 |");
            System.out.println("|   4. Hapus Barang                  |");
            System.out.println("|   5. Keluar                        |");
            System.out.println("+====================================+");
            System.out.print("Pilih menu: ");

            if (!input.hasNextInt()) {
                System.out.println("Input menu harus berupa angka!");
                input.nextLine();
                continue;
            }
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1: // Create
                      if (daftarBarang.isEmpty()) {
                        System.out.println("Daftar barang masih kosong.");
                    } else {
                        System.out.println("\n===== DAFTAR BARANG =====");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            String[] b = daftarBarang.get(i);
                            System.out.println("ID Barang : " + b[0]);
                            System.out.println("Nama      : " + b[1]);
                            System.out.println("Stok      : " + b[2]);
                            System.out.println("Lokasi    : " + b[3]);
                            System.out.println("------------------------------");
                        }
                    }
                    System.out.print("Masukkan ID Barang   : ");
                    String id = input.nextLine();

                    boolean ada = false;
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        if (daftarBarang.get(i)[0].equalsIgnoreCase(id)) {
                            ada = true;
                            break;
                        }
                    }

                    if (ada) {
                        System.out.println("Gagal menambahkan. ID Barang \"" + id + "\" sudah ada.");
                    } else {
                        System.out.print("Masukkan Nama Barang : ");
                        String nama = input.nextLine();
                        if (nama.trim().isEmpty()) {
                            System.out.println("Nama barang tidak boleh kosong.");
                            break;
                        }

                        System.out.print("Masukkan Stok        : ");
                        if (!input.hasNextInt()) {
                            System.out.println("Stok harus berupa angka!");
                            input.nextLine();
                            break;
                        }
                        int stok = input.nextInt();
                        input.nextLine();
                        if (stok < 0) {
                            System.out.println("Stok tidak boleh negatif.");
                            break;
                        }

                        System.out.print("Masukkan Lokasi      : ");
                        String lokasi = input.nextLine();
                        if (lokasi.trim().isEmpty()) {
                            System.out.println("Lokasi tidak boleh kosong.");   
                            break;
                        }

                        String[] barang = {id, nama, String.valueOf(stok), lokasi};
                        daftarBarang.add(barang);

                        System.out.println("Barang berhasil ditambahkan.");
                    }
                    break;

                case 2: // Read
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Daftar barang masih kosong.");
                    } else {
                        System.out.println("\n===== DAFTAR BARANG =====");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            String[] b = daftarBarang.get(i);
                            System.out.println("ID Barang : " + b[0]);
                            System.out.println("Nama      : " + b[1]);
                            System.out.println("Stok      : " + b[2]);
                            System.out.println("Lokasi    : " + b[3]);
                            System.out.println("------------------------------");
                        }
                    }
                    break;

                case 3: // Update
                      if (daftarBarang.isEmpty()) {
                        System.out.println("Daftar barang masih kosong.");
                    } else {
                        System.out.println("\n===== DAFTAR BARANG =====");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            String[] b = daftarBarang.get(i);
                            System.out.println("ID Barang : " + b[0]);
                            System.out.println("Nama      : " + b[1]);
                            System.out.println("Stok      : " + b[2]);
                            System.out.println("Lokasi    : " + b[3]);
                            System.out.println("------------------------------");
                        }
                    }
                    System.out.print("Masukkan ID Barang yang akan diupdate: ");
                    String idCari = input.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < daftarBarang.size(); i++) {
                        String[] b = daftarBarang.get(i);
                        if (b[0].equalsIgnoreCase(idCari)) {
                            ditemukan = true;
                            System.out.println("Data ditemukan. Silakan masukkan data baru:");

                            System.out.print("Nama Barang baru (lama: " + b[1] + "): ");
                            String namaBaru = input.nextLine();
                            if (namaBaru.trim().isEmpty()) {
                                System.out.println("Nama barang tidak boleh kosong.");
                                break;
                            }

                            System.out.print("Stok baru (lama: " + b[2] + "): ");
                            if (!input.hasNextInt()) {
                                System.out.println("Stok harus berupa angka!");
                                input.nextLine();
                                break;
                            }
                            int stokBaru = input.nextInt();
                            input.nextLine();
                            if (stokBaru < 0) {
                                System.out.println("Stok tidak boleh negatif.");
                                break;
                            }

                            System.out.print("Lokasi baru (lama: " + b[3] + "): ");
                            String lokasiBaru = input.nextLine();
                            if (lokasiBaru.trim().isEmpty()) {
                                System.out.println("Lokasi tidak boleh kosong.");
                                break;
                            }

                            b[1] = namaBaru;
                            b[2] = String.valueOf(stokBaru);
                            b[3] = lokasiBaru;

                            System.out.println("Data barang berhasil diperbarui.");
                            break;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 4: // Delete
                      if (daftarBarang.isEmpty()) {
                        System.out.println("Daftar barang masih kosong.");
                    } else {
                        System.out.println("\n===== DAFTAR BARANG =====");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            String[] b = daftarBarang.get(i);
                            System.out.println("ID Barang : " + b[0]);
                            System.out.println("Nama      : " + b[1]);
                            System.out.println("Stok      : " + b[2]);
                            System.out.println("Lokasi    : " + b[3]);
                            System.out.println("------------------------------");
                        }
                    }
                    System.out.print("Masukkan ID Barang yang akan dihapus: ");
                    String idHapus = input.nextLine();
                    boolean terhapus = false;

                    for (int i = 0; i < daftarBarang.size(); i++) {
                        if (daftarBarang.get(i)[0].equalsIgnoreCase(idHapus)) {
                            daftarBarang.remove(i);
                            terhapus = true;
                            System.out.println("Barang berhasil dihapus.");
                            break;
                        }
                    }

                    if (!terhapus) {
                        System.out.println("Barang dengan ID tersebut tidak ditemukan.");
                    }
                    break;

                case 5: // Keluar
                    System.out.println("Terima kasih, program selesai.");
                    jalan = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        input.close();
        }
}
