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

## Menu Awal
  <img width="359" height="292" alt="image" src="https://github.com/user-attachments/assets/90205372-8a02-4f58-907f-4ca622d43cee" /> 
  <img width="219" height="47" alt="image" src="https://github.com/user-attachments/assets/4aa27f2b-006a-4a3a-ac1b-a66bcb8f7c3a" /> 
  <img width="265" height="54" alt="image" src="https://github.com/user-attachments/assets/6567359c-dfca-4b77-9314-947c7c52a7c3" />
<img width="377" height="237" alt="image" src="https://github.com/user-attachments/assets/8e6d4694-db16-4a06-acad-06db3fd8b241" /> 





Program dimulai dengan tampilan menu swicth case yang mempunyai validasi input user diminta menginput pilihan angka dari 1-6 untuk navigasi.

---
## 1 / Create
<img width="482" height="569" alt="image" src="https://github.com/user-attachments/assets/e0a19106-40d1-4b3d-ba6b-ae6d7ec8f94b" />
<img width="231" height="79" alt="image" src="https://github.com/user-attachments/assets/a67ecab7-3a0f-460b-a661-b689a85a5681" />

Pada awal pada awal menu create kita akan diperlihatkan daftar barang lalu user diminta memasukan id barang lalu sistem akan mengecek apakah id barang yang di input ini sudah ada di dalam daftar barang atau tidak kalo tidak maka akan lanjut untuk mengisi nama stok dan lokasi kalau sudah ada maka akan dikembalikan ke menu awal dengan pesan id sudah ada ada juga validasi yang mencegah user untuk mengisi id dengan spasi atau kosong.

<img width="353" height="307" alt="image" src="https://github.com/user-attachments/assets/364315bd-4343-484e-a760-19190bc0618d" />
<img width="306" height="136" alt="image" src="https://github.com/user-attachments/assets/42487f9c-2303-44c0-9406-a34be607788c" />

jika id tidak ada dalam daftar barang maka user akan lanjut tahap pengisian data buat barang yaitu nama, stom dan, lokasi disini ada validasi yaitu validasi jika input kosong dan untuk stok ada validasi yang mencegah user untuk mengiput stok yang ber nilai negatif / koma 







</details>
