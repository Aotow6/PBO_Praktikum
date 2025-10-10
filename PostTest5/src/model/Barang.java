package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

public abstract class Barang implements Categorizable {
    protected String idBarang;
    protected String namaBarang;
    protected int stok;
    protected String lokasi;
    protected String kategori;

    public Barang(String idBarang, String namaBarang, int stok, String lokasi, String kategori) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.stok = stok;
        this.lokasi = lokasi;
        this.kategori = kategori;
    }

    public String getIdBarang() { return idBarang; }
    public void setIdBarang(String idBarang) { this.idBarang = idBarang; }

    public String getNamaBarang() { return namaBarang; }
    public void setNamaBarang(String namaBarang) { this.namaBarang = namaBarang; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public String getLokasi() { return lokasi; }
    public void setLokasi(String lokasi) { this.lokasi = lokasi; }

    public String getKategori() { return kategori; }

    public abstract void displayInfo();

    public void save() {
        String sql = "INSERT INTO barang (id_barang, nama_barang, stok, lokasi, kategori, garansi_bulan, bahan) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conn.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idBarang);
            ps.setString(2, namaBarang);
            ps.setInt(3, stok);
            ps.setString(4, lokasi);
            ps.setString(5, kategori);
            if (this instanceof Elektronik) {
                ps.setInt(6, ((Elektronik) this).getGaransiBulan());
                ps.setNull(7, java.sql.Types.VARCHAR);
            } else if (this instanceof Perabot) {
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setString(7, ((Perabot) this).getBahan());
            } else {
                ps.setNull(6, java.sql.Types.INTEGER);
                ps.setNull(7, java.sql.Types.VARCHAR);
            }
            ps.executeUpdate();
            System.out.println(" Barang berhasil disimpan!");
        } catch (Exception e) {
            System.out.println(" Gagal menyimpan barang: " + e.getMessage());
        }
    }

    public void update(String namaBaru, Integer stokBaru, String lokasiBaru) {
        String sql = "UPDATE barang SET nama_barang = ?, stok = ?, lokasi = ? WHERE id_barang = ?";
        try (Connection conn = Conn.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, (namaBaru == null || namaBaru.isEmpty()) ? namaBarang : namaBaru);
            ps.setInt(2, (stokBaru == null) ? stok : stokBaru);
            ps.setString(3, (lokasiBaru == null || lokasiBaru.isEmpty()) ? lokasi : lokasiBaru);
            ps.setString(4, idBarang);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(" Gagal memperbarui barang umum: " + e.getMessage());
            throw new RuntimeException("Gagal update data umum."); 
        }
    }

    public void delete() {
        String sql = "DELETE FROM barang WHERE id_barang = ?";
        try (Connection conn = Conn.connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, idBarang);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Barang berhasil dihapus!");
            } else {
                System.out.println("Gagal menghapus barang: ID '" + idBarang + "' tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Gagal menghapus barang: " + e.getMessage());
        }
    }

}
