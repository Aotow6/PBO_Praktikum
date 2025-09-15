package main;

import service.ManajemenGudang;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ManajemenGudang gudang = new ManajemenGudang();
        boolean jalan = true;

        while (jalan) {
            System.out.println("\n+====== MENU INVENTARIS GUDANG ======+");
            System.out.println("|   1. Tambah Barang                 |");
            System.out.println("|   2. Lihat Daftar Barang           |");
            System.out.println("|   3. Update Barang                 |");
            System.out.println("|   4. Hapus Barang                  |");
            System.out.println("|   5. Cari Barang                   |");
            System.out.println("|   6. Keluar                        |");
            System.out.println("+====================================+");

            System.out.print("Pilih menu: ");
            String pilihanStr = input.nextLine().trim();

            if (pilihanStr.isEmpty()) {
                System.out.println("Input tidak boleh kosong!");
                continue; // balik ke menu
            }

            try {
                int pilihan = Integer.parseInt(pilihanStr); // convert ke int
                switch (pilihan) {
                    case 1 -> gudang.tambahBarang();
                    case 2 -> gudang.lihatBarang();
                    case 3 -> gudang.updateBarang();
                    case 4 -> gudang.hapusBarang();
                    case 5 -> gudang.cariBarang();
                    case 6 -> {
                        System.out.println("Terima kasih, program selesai.");
                        jalan = false;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input menu harus berupa angka!");
            }
        }

        input.close();
    }
}
