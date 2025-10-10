package model;

import java.sql.*;

public class View {

    public void showData() {
        String sql = "SELECT id_barang, nama_barang, stok, lokasi, kategori, garansi_bulan, bahan FROM barang";
        String sql2 = "SELECT COUNT(*) AS total_barang FROM barang";

        try (Connection conn = Conn.connect();
             Statement stmt1 = conn.createStatement();
             Statement stmt2 = conn.createStatement();
             ResultSet rs = stmt1.executeQuery(sql);
             ResultSet rs2 = stmt2.executeQuery(sql2)) {

            System.out.println("\n=== DATA BARANG DI DATABASE ===");
            while (rs.next()) {
                System.out.println("ID          : " + rs.getString("id_barang"));
                System.out.println("Nama        : " + rs.getString("nama_barang"));
                System.out.println("Stok        : " + rs.getInt("stok"));
                System.out.println("Lokasi      : " + rs.getString("lokasi"));
                System.out.println("Kategori    : " + rs.getString("kategori"));

                if ("ELEKTRONIK".equalsIgnoreCase(rs.getString("kategori"))) {
                    System.out.println("Garansi     : " + rs.getInt("garansi_bulan") + " bulan");
                } else if ("PERABOT".equalsIgnoreCase(rs.getString("kategori"))) {
                    System.out.println("Bahan       : " + rs.getString("bahan"));
                }

                System.out.println("-------------------------");
            }

            if (rs2.next()) {
                System.out.println("Total Barang: " + rs2.getInt("total_barang"));
            }

        } catch (Exception e) {
            System.out.println("Gagal menampilkan data: " + e.getMessage());
        }
    }
}
