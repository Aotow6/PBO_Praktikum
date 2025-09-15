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
<img width="377" height="237" alt="image" src="https://github.com/user-attachments/assets/8e6d4694-db16-4a06-acad-06db3fd8b241" /> 





Program dimulai dengan tampilan menu swicth case yang mempunyai validasi input user diminta menginput pilihan angka dari 1-6 untuk navigasi.

---
## 1 / Create
<img width="482" height="569" alt="image" src="https://github.com/user-attachments/assets/e0a19106-40d1-4b3d-ba6b-ae6d7ec8f94b" />
<img width="231" height="79" alt="image" src="https://github.com/user-attachments/assets/a67ecab7-3a0f-460b-a661-b689a85a5681" />

Pada awal pada awal menu create kita akan diperlihatkan daftar barang lalu user diminta memasukan id barang lalu sistem akan mengecek apakah id barang yang di input ini sudah ada di dalam daftar barang atau tidak kalo tidak maka akan lanjut untuk mengisi nama stok dan lokasi kalau sudah ada maka akan dikembalikan ke menu awal dengan pesan id sudah ada ada juga validasi yang mencegah user untuk mengisi id dengan spasi atau kosong.

<img width="353" height="307" alt="image" src="https://github.com/user-attachments/assets/364315bd-4343-484e-a760-19190bc0618d" />
  <img width="219" height="47" alt="image" src="https://github.com/user-attachments/assets/4aa27f2b-006a-4a3a-ac1b-a66bcb8f7c3a" /> 
  <img width="265" height="54" alt="image" src="https://github.com/user-attachments/assets/6567359c-dfca-4b77-9314-947c7c52a7c3" /> <br>
<img width="306" height="136" alt="image" src="https://github.com/user-attachments/assets/42487f9c-2303-44c0-9406-a34be607788c" />

jika id tidak ada dalam daftar barang maka user akan lanjut tahap pengisian data buat barang yaitu nama, stom dan, lokasi disini ada validasi yaitu validasi jika input kosong dan untuk stok ada validasi yang mencegah user untuk mengiput stok yang ber nilai negatif / koma.
---
## 2 / Read
<img width="432" height="594" alt="image" src="https://github.com/user-attachments/assets/d24bdb78-06be-41b9-9ddf-9f68e7df578d" />
Disini tempat kita melihat daftar barang dan total barang.
---
## 3 / Update
<img width="504" height="491" alt="image" src="https://github.com/user-attachments/assets/e3d1f350-d476-41df-bef2-f1264c810d12" />
<img width="295" height="136" alt="image" src="https://github.com/user-attachments/assets/d682b910-e6eb-4e20-9fc3-a290d204fd67" />

Pada awal pada awal menu update kita akan diperlihatkan daftar barang lalu user diminta memasukan id barang lalu sistem akan mengecek apakah id barang ada di daftar barang atau tidak kalau ada nanti bakal ke tahap pengisian update baru kalau tidak user akan di kembalikan ke menu awal dengan pesan Barang dengan ID tersebut tidak ditemukan.

<img width="578" height="165" alt="image" src="https://github.com/user-attachments/assets/fe737f65-e23c-4861-9ba3-1265be5b67d6" />
<img width="269" height="49" alt="image" src="https://github.com/user-attachments/assets/af659082-c6d3-4c96-ba5b-aac58e0d6635" />
<img width="273" height="42" alt="image" src="https://github.com/user-attachments/assets/f920ccb0-131c-4168-a935-eed6feec0a77" />

Di tahap ini user diminta untuk mengisi data baru pada id yang ingin di ubah jika user tapi mengisi kosong/langsung enter maka data tidak akan berubah dan akan tetap sama seperti data lama, terdapat validasi juga disini pada stok agar user tidak bisa mengisi negatif atau koma 
---
## 4 / Delete
<img width="465" height="669" alt="image" src="https://github.com/user-attachments/assets/fd7a686a-05c8-495b-9950-8e0bbfb643fe" /> <br>         
<img width="439" height="463" alt="image" src="https://github.com/user-attachments/assets/a6e02bc7-f549-4d63-95dc-5350d87c2f1f" /> <img width="309" height="277" alt="image" src="https://github.com/user-attachments/assets/1f277fef-843c-45bd-95ae-b4425fba0f97" />



Setelah menampilkan daftar barang user diminta input id barang yang ingin dihapus dari daftar barang jika user mengisi id yang ada di daftar barang maka barang ttersebut akan di hapus dari daftar barang namun kalo user menginput sesuatu yang  id tidak ada di daftar barang user akan di kembalikan ke menu awal dengan pesan Barang tidak ditemukan.

---
## 5 / Search

<img width="382" height="248" alt="image" src="https://github.com/user-attachments/assets/d6605979-1d24-49cb-9f39-df421390ae89" /> <br>
<img width="358" height="276" alt="image" src="https://github.com/user-attachments/assets/47934252-d1d5-4844-ac92-0f9bce812573" />  <img width="377" height="171" alt="image" src="https://github.com/user-attachments/assets/66408e42-3f9d-4a60-a9da-a52655351fe9" /> <br?

<img width="345" height="93" alt="image" src="https://github.com/user-attachments/assets/07d1253c-9de6-4a39-a076-09400b90f10a" />


user diminta untuk memasukan keyword pencarian berdasarkan id/nama barang jika user meng input kosong maka user akan di kembalikan ke menu awal dengan pesan Kata kunci tidak boleh kosong. Namun jika user mengisi keyword maka sistem akan mencari barang di daftar barang yang di id / nama nya mengandung keyword dan mengembalikan hasilnya namun kalau tidak ditemukan barang yang mengandung keywoard sistem akan mengembalikan pesan barang tidak ditemukan.
 
---
## 6 / Exit
<img width="395" height="233" alt="image" src="https://github.com/user-attachments/assets/6cf874d8-7003-418b-a314-51ebff3f35ea" />
Keluar dari program.
</details>
