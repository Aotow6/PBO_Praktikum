# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program ini adalah aplikasi sederhana untuk **manajemen inventaris gudang** menggunakan bahasa pemrograman Java.  
Fungsinya untuk melakukan operasi dasar **CRUD (Create, Read, Update, Delete)** terhadap data barang.  

Program ini sudah menerapkan:
- **Encapsulation** (getter & setter untuk proteksi data)  
- **Inheritance** (superclass `Barang`, subclass `Elektronik` & `Perabot`)  
- **Overriding** (method `tampilkanInfo()` dioverride di subclass)  
- **Validasi input** (mencegah data kosong, negatif, atau duplikat)  
- **Struktur MVC sederhana** dengan pemisahan package:  
  - `model` → struktur data  
  - `service` → logika program (Controller)  
  - `main` → tampilan menu (View)

---

## 📂 Struktur Packages (MVC)
<img width="435" height="310" alt="image" src="https://github.com/user-attachments/assets/a8c5ea51-43d3-4ced-9c49-7e53f7d83468" />

## 🆕 Apa Yang Baru?
- **Inheritance & Overriding**:  
  - Subclass `Elektronik` dengan properti tambahan `garansiBulan`.  
  - Subclass `Perabot` dengan properti tambahan `bahan`.  
  - Keduanya override method `tampilkanInfo()`.  
- Menerapkan **Validasi input  di setter** → data lebih aman dari manipulasi langsung.  
- **Method bantu `cariById()`** untuk mempermudah pencarian barang saat update/hapus.  
- **Properti `totalBarang`** untuk menghitung jumlah barang di gudang.
- Penyesuaian **Tambah Barang (Create)** menambahkan kategori dan properti nya.   
- Penyesuaian **Lihat Barang (Read)** Memperlihatkan kategori dan properti nya. 
- Penyesuaian **Update Barang (Update)** dapat mengubah properti dari kategori.
- Penggunaan **Iterator pada Hapus Barang (Delete)** dalam mengantisipasi jika kedepanya akan semakin banyak data dan memerlukan method yang menghapus banyak data barang secara sekaligus.
  ---
## ✨ Fitur Utama
1. **Tambah Barang (Create)** → input ID, nama, stok, lokasi, dan kategori.  
2. **Lihat Barang (Read)** → menampilkan daftar barang + total barang.  
3. **Update Barang (Update)** → mengubah data barang tertentu.  
4. **Hapus Barang (Delete)** → menghapus barang berdasarkan ID.  
5. **Cari Barang (Search)** → mencari barang berdasarkan ID/nama.  
6. **Keluar Program** → menghentikan aplikasi.  
---

## 📂 Penjelasan Class
- **`Barang` (Superclass, package `model`)**  
  Berisi 4 properti utama: `idBarang`, `namaBarang`, `stok`, `lokasi`.  
  Dilengkapi getter, setter, constructor, dan method `tampilkanInfo()`.  

- **`Elektronik` (Subclass, package `model`)**  
  Menambahkan properti `garansiBulan`.  
  Override `tampilkanInfo()` untuk menampilkan detail garansi.  

- **`Perabot` (Subclass, package `model`)**  
  Menambahkan properti `bahan`.  
  Override `tampilkanInfo()` untuk menampilkan detail bahan.  

- **`ManajemenGudang` (Controller, package `service`)**  
  Menangani logika CRUD, search, validasi input, dan menghitung total barang.  
  Menggunakan `ArrayList<Barang>` untuk menyimpan data barang.  

- **`Main` (View, package `main`)**  
  Entry point program.  
  Menampilkan menu utama dan memanggil method dari `ManajemenGudang`.  
---

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

Pada awal pada awal menu create kita akan diperlihatkan daftar barang lalu user diminta memasukan id barang lalu sistem akan mengecek apakah id barang yang di input ini sudah ada di dalam daftar barang atau tidak kalo tidak maka akan lanjut untuk mengisi nama stok dan lokasi dan yang baru ada kategori dan properti dari kategori unstuk sekarang ada garansi buat kategori elektronik dan bahan untuk kategori perabot nah kalau sudah ada maka akan dikembalikan ke menu awal dengan pesan id sudah ada ada juga validasi yang mencegah user untuk mengisi id dengan spasi atau kosong.

<img width="353" height="307" alt="image" src="https://github.com/user-attachments/assets/364315bd-4343-484e-a760-19190bc0618d" />
  <img width="219" height="47" alt="image" src="https://github.com/user-attachments/assets/4aa27f2b-006a-4a3a-ac1b-a66bcb8f7c3a" /> 
  <img width="265" height="54" alt="image" src="https://github.com/user-attachments/assets/6567359c-dfca-4b77-9314-947c7c52a7c3" /> 
  <img width="399" height="72" alt="image" src="https://github.com/user-attachments/assets/a1a2e822-6d0c-48fe-8484-1e2f65499f43" />
<img width="257" height="49" alt="image" src="https://github.com/user-attachments/assets/993eb772-28ab-440d-9057-373185155491" />
<img width="401" height="89" alt="image" src="https://github.com/user-attachments/assets/aab7b1a5-33a8-435e-8cfe-04380a5d277b" />
  <br>
<img width="377" height="228" alt="image" src="https://github.com/user-attachments/assets/f8e6a38c-be2b-4d80-ad91-e8076d2e784c" />
<img width="360" height="211" alt="image" src="https://github.com/user-attachments/assets/2859f882-4938-4d10-b19e-6e6410157f90" />


jika id tidak ada dalam daftar barang maka user akan lanjut tahap pengisian data buat barang yaitu nama, stom , lokasi, berserta kategori dan properti dari kategorinya  disini ada validasi yaitu validasi jika input kosong dan untuk yang tipe data int ada validasi yang mencegah user untuk mengiput stok yang ber nilai negatif / koma dan kosong.
    
---
## 2 / Read
<img width="345" height="803" alt="image" src="https://github.com/user-attachments/assets/222c36b2-099e-42db-ae94-89b550ff618a" />

<img width="207" height="63" alt="image" src="https://github.com/user-attachments/assets/854649c0-0943-4bca-83fc-19bb8254feaa" />


Disini tempat kita melihat daftar barang dan total barang (sekarang ada kategori nya) .

---
## 3 / Update
<img width="345" height="803" alt="image" src="https://github.com/user-attachments/assets/1e27ce59-a320-4ac7-8d3f-93a35814cb8b" />
Pada awal pada awal menu update kita akan diperlihatkan daftar barang lalu user diminta memasukan id barang lalu sistem akan mengecek apakah id barang ada di daftar barang atau tidak kalau ada nanti bakal ke tahap pengisian update baru kalau tidak user akan di kembalikan ke menu awal dengan pesan Barang dengan ID tersebut tidak ditemukan.

<img width="568" height="197" alt="image" src="https://github.com/user-attachments/assets/6feeeedd-07c9-4183-9306-d31314b49535" />
<img width="269" height="49" alt="image" src="https://github.com/user-attachments/assets/af659082-c6d3-4c96-ba5b-aac58e0d6635" />
<img width="273" height="42" alt="image" src="https://github.com/user-attachments/assets/f920ccb0-131c-4168-a935-eed6feec0a77" />
<img width="457" height="50" alt="image" src="https://github.com/user-attachments/assets/029c3c01-3710-4a1d-be08-aab4c87b8282" />
<img width="524" height="46" alt="image" src="https://github.com/user-attachments/assets/00151bcd-e057-4cb2-a49d-ffdf4faaa053" />



Di tahap ini user diminta untuk mengisi data baru pada id yang ingin di ubah jika user tapi mengisi kosong/langsung enter maka data tidak akan berubah dan akan tetap sama seperti data lama, terdapat validasi juga disini input tan dengan tipe data int  agar user tidak bisa mengisi negatif atau koma.

Hasil 
<img width="281" height="179" alt="image" src="https://github.com/user-attachments/assets/9d59354d-030f-4492-90c1-5ae7bf00dcb8" />



---
## 4 / Delete
<img width="465" height="669" alt="image" src="https://github.com/user-attachments/assets/fd7a686a-05c8-495b-9950-8e0bbfb643fe" /> <br>         
<img width="439" height="463" alt="image" src="https://github.com/user-attachments/assets/a6e02bc7-f549-4d63-95dc-5350d87c2f1f" /> <img width="309" height="277" alt="image" src="https://github.com/user-attachments/assets/1f277fef-843c-45bd-95ae-b4425fba0f97" />



Setelah menampilkan daftar barang user diminta input id barang yang ingin dihapus dari daftar barang jika user mengisi id yang ada di daftar barang maka barang ttersebut akan di hapus dari daftar barang namun kalo user menginput sesuatu yang  id tidak ada di daftar barang user akan di kembalikan ke menu awal dengan pesan Barang tidak ditemukan (belum ada perubahan di alurnya kecuali dibagagian lihat barang yang sekarang sudah kelihatan ada kateogori nya).

---
## 5 / Search

<img width="382" height="248" alt="image" src="https://github.com/user-attachments/assets/d6605979-1d24-49cb-9f39-df421390ae89" /> <br>
<img width="358" height="276" alt="image" src="https://github.com/user-attachments/assets/47934252-d1d5-4844-ac92-0f9bce812573" />  <img width="377" height="171" alt="image" src="https://github.com/user-attachments/assets/66408e42-3f9d-4a60-a9da-a52655351fe9" /> <br>

<img width="345" height="93" alt="image" src="https://github.com/user-attachments/assets/07d1253c-9de6-4a39-a076-09400b90f10a" />


user diminta untuk memasukan keyword pencarian berdasarkan id/nama barang jika user meng input kosong maka user akan di kembalikan ke menu awal dengan pesan Kata kunci tidak boleh kosong. Namun jika user mengisi keyword maka sistem akan mencari barang di daftar barang yang di id / nama nya mengandung keyword dan mengembalikan hasilnya namun kalau tidak ditemukan barang yang mengandung keywoard sistem akan mengembalikan pesan barang tidak ditemukan (belum ada perubahan di alurnya kecuali dibagagian lihat barang yang sekarang sudah kelihatan ada kateogori nya).
 
---
## 6 / Exit
<img width="395" height="233" alt="image" src="https://github.com/user-attachments/assets/6cf874d8-7003-418b-a314-51ebff3f35ea" />

Keluar dari program.
</details>
