# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program ini adalah aplikasi **CRUD sederhana** (Create, Read, Update, Delete) untuk mengelola data inventaris gudang.  
Aplikasi dikembangkan dengan bahasa pemrograman **Java** menggunakan konsep **OOP** dan menerapkan prinsip **MVC (Model-View-Controller)**.  

Selain operasi CRUD, program juga dilengkapi dengan:
- **Validasi input** (mencegah data kosong, stok negatif, atau format salah).
- **Fitur pencarian (Search)** berdasarkan ID atau Nama barang.
- **Perhitungan total barang** yang ditampilkan secara otomatis.

Program ini merupakan **pengembangan dari Post Test 1** dengan penerapan packages, constructor, access modifier, dan pemisahan kode sesuai arsitektur MVC.

---

## 📂 Struktur Packages (MVC)
<pre>
src/
├── main/
│   └── Main.java → Entry point program (menu utama / View)
├── service/
│   └── ManajemenGudang.java → Logika CRUD + Search + Validasi (Controller)
└── model/
    └── Barang.java → Struktur data barang (Model)
</pre>

## 💃 Model (`Barang`)**
  Berisi struktur data, atribut, dan constructor untuk merepresentasikan barang.  
  Berisi **4 properti**: `idBarang`, `namaBarang`, `stok`, `lokasi`.  
  Semua properti bersifat **private** dengan **getter & setter** serta **constructor**.  
  Contoh properti:

## 🎮 Controller (`ManajemenGudang`)  
Berada di package service. <br>
Controller bertanggung jawab mengatur logika utama program, yaitu:  
- Tambah Barang (**Create**)  
- Lihat Barang (**Read**)  
- Update Barang  
- Hapus Barang  
- Cari Barang  
- Hitung Total Barang  

### Properti utama di `ManajemenGudang`  
- `ArrayList<Barang> daftarBarang` → menyimpan data barang  
- `Scanner input` → menerima input user  
- `int totalBarang` → menghitung total barang dalam gudang  

---

## 👁️ View (`Main`)  
Berada di package main.<br>
View bertugas menampilkan **menu utama** kepada pengguna menggunakan **switch-case**,  serta menangani interaksi dengan user melalui Scanner..  

### Menu yang tersedia:  
1. Tambah Barang  
2. Lihat Barang  
3. Update Barang  
4. Hapus Barang  
5. Cari Barang  
6. Keluar  

<details>
  <summary> 🌊 #️⃣ Alur </summary>
  
</details>
