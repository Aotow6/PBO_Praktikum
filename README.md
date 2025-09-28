# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program ini merupakan sistem inventaris gudang berbasis Java yang mengimplementasikan konsep **OOP (Object-Oriented Programming)** secara menyeluruh. Program memungkinkan pengguna untuk mengelola data barang melalui fitur CRUD (Create, Read, Update, Delete), pencarian, validasi input, serta penerapan konsep lanjutan seperti **Encapsulation, Inheritance, Polymorphism, Abstraction, Interface, dan Overloading.**


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
<img width="608" height="252" alt="image" src="https://github.com/user-attachments/assets/a0d33761-01ef-47ac-b90c-b2d70e4cbec3" />

## 🆕 Apa Yang Baru?
- **Abstraction**  
  - `Barang` kini menjadi **abstract class** yang tidak bisa di-instantiate langsung.  
  - Memastikan setiap subclass wajib mengimplementasikan method `tampilkanInfo()`.  

- **Interface**  
  - Interface `Categorizable` digunakan untuk menampilkan kategori barang secara konsisten.

- **Polymorphism**  
  - **Overriding**: Method `tampilkanInfo()` dioverride di `Elektronik` & `Perabot`.  
  - **Overloading**:  
    - `cariBarang(String keyword)` → mencari berdasarkan ID atau nama.  
    - `cariBarang(int minStok)` → mencari berdasarkan minimal stok.
- **Cari** Method cari diperbarui dalam penerapan overload cariBarang(String keyword) dan cariBarang(int ).
  ---
## ✨ Fitur Utama
1. **Tambah Barang (Create)** → input ID, nama, stok, lokasi, dan kategori.  
2. **Lihat Barang (Read)** → menampilkan daftar barang + total barang.  
3. **Update Barang (Update)** → mengubah data barang tertentu.  
4. **Hapus Barang (Delete)** → menghapus barang berdasarkan ID.  
5. **Cari Barang (Search)** → Mencari berdasarkan ID/nama atau berdasarkan minimal stok (**Overloading**).    
6. **Keluar Program** → menghentikan aplikasi.  
---

## 📂 Penjelasan Class

### 🧱 `Barang` *(Abstract Class)*  
- Superclass dari semua jenis barang.  
- Memiliki properti dasar:  
  - `idBarang`, `namaBarang`, `stok`, `lokasi`  
- Menerapkan **Encapsulation** (getter & setter) dan mendefinisikan `tampilkanInfo()` sebagai abstract method.

### ⚡ `Elektronik` *(Subclass)*  
- Mewarisi `Barang` dan menambahkan properti: `garansiBulan`.  
- Override `tampilkanInfo()` untuk menampilkan detail elektronik.  
- Mengimplementasikan interface `Categorizable`.

### 🪑 `Perabot` *(Subclass)*  
- Mewarisi `Barang` dan menambahkan properti: `bahan`.  
- Override `tampilkanInfo()` untuk menampilkan detail perabot.  
- Mengimplementasikan interface `Categorizable`.

### 🔎 `ManajemenGudang` *(Controller)*  
- Berisi seluruh logika CRUD dan pencarian barang.  
- Menangani validasi input, total barang, serta pencarian dengan **Overloading**.  

### 🖥️ `Main` *(View)*  
- Menyediakan tampilan menu utama dan menghubungkan pengguna dengan controller.  
- Menggunakan `switch-case` untuk navigasi fitur.

### 🏷️ `Categorizable` *(Interface)*  
- Interface sederhana yang mendefinisikan method `getKategori()`.  
- Dipakai oleh subclass (`Elektronik`, `Perabot`) untuk menampilkan kategori masing-masing.  
- Membantu menjaga konsistensi informasi kategori antar jenis barang.
---

<details>
  <summary> 🌊 #️⃣ Alur </summary>

## Menu Awal
  <img width="359" height="292" alt="image" src="https://github.com/user-attachments/assets/90205372-8a02-4f58-907f-4ca622d43cee" /> 
<img width="377" height="237" alt="image" src="https://github.com/user-attachments/assets/8e6d4694-db16-4a06-acad-06db3fd8b241" /> 





Program dimulai dengan tampilan menu swicth case yang mempunyai validasi input user diminta menginput pilihan angka dari 1-6 untuk navigasi.

---
##  Create
Pada menu **Create**, pertama-tama akan ditampilkan daftar barang.  
User diminta memasukkan **ID barang** → sistem akan mengecek apakah ID sudah ada atau belum.  

- Jika **ID sudah ada** → kembali ke menu awal dengan pesan *"ID sudah ada"*.  
- Jika **ID belum ada** → lanjut mengisi `nama`, `stok`, `lokasi`, `kategori`, dan properti dari kategori.  
  - **Elektronik** → memiliki properti *garansi (bulan)*.  
  - **Perabot** → memiliki properti *bahan*.  

Validasi input:  
- ID tidak boleh kosong/spasi.  
- Nama/lokasi/kategori tidak boleh kosong.  
- yang tipe data int hanya bisa angka bulat positif (tidak boleh negatif/koma) .  

**Tampilan:**

![Create Menu](https://github.com/user-attachments/assets/e0a19106-40d1-4b3d-ba6b-ae6d7ec8f94b)  
![Input ID](https://github.com/user-attachments/assets/a67ecab7-3a0f-460b-a661-b689a85a5681)  
![Validasi ID](https://github.com/user-attachments/assets/364315bd-4343-484e-a760-19190bc0618d)  
![Input Nama](https://github.com/user-attachments/assets/4aa27f2b-006a-4a3a-ac1b-a66bcb8f7c3a)  
![Input Stok](https://github.com/user-attachments/assets/6567359c-dfca-4b77-9314-947c7c52a7c3)  
![Input Lokasi](https://github.com/user-attachments/assets/a1a2e822-6d0c-48fe-8484-1e2f65499f43)  
![Input Kategori](https://github.com/user-attachments/assets/993eb772-28ab-440d-9057-373185155491)  
![Properti Elektronik/Perabot](https://github.com/user-attachments/assets/aab7b1a5-33a8-435e-8cfe-04380a5d277b)  
![Validasi Kosong](https://github.com/user-attachments/assets/f8e6a38c-be2b-4d80-ad91-e8076d2e784c)  
![Validasi Angka](https://github.com/user-attachments/assets/2859f882-4938-4d10-b19e-6e6410157f90)  

---

## Read
Menu **Read** digunakan untuk melihat daftar barang beserta total barang.  
Sekarang daftar sudah menampilkan kategori masing-masing barang.

**Tampilan:**

![Read Menu](https://github.com/user-attachments/assets/222c36b2-099e-42db-ae94-89b550ff618a)  
![Total Barang](https://github.com/user-attachments/assets/854649c0-0943-4bca-83fc-19bb8254feaa)  

---

## Update
Pada menu **Update**, pertama-tama daftar barang akan ditampilkan.  
User diminta memasukkan **ID barang** → sistem mengecek apakah ID ada atau tidak.
(sekarang bisa ngubah properti dari kategori barang)

- Jika **ID ada** → lanjut ke tahap pengisian data baru.  
- Jika **ID tidak ada** → kembali ke menu awal dengan pesan *"Barang tidak ditemukan"*.  

 Validasi:  
- Input kosong → data lama tetap dipakai.  
- tipe data int tetap harus angka bulat positif.  

**Tampilan:**

![Update Menu](https://github.com/user-attachments/assets/1e27ce59-a320-4ac7-8d3f-93a35814cb8b)  
![Input ID Update](https://github.com/user-attachments/assets/6feeeedd-07c9-4183-9306-d31314b49535)  
![Validasi ID Tidak Ada](https://github.com/user-attachments/assets/af659082-c6d3-4c96-ba5b-aac58e0d6635)  
![Input Nama Update](https://github.com/user-attachments/assets/f920ccb0-131c-4168-a935-eed6feec0a77)  
![Input Stok Update](https://github.com/user-attachments/assets/029c3c01-3710-4a1d-be08-aab4c87b8282)  
![Input Lokasi Update](https://github.com/user-attachments/assets/00151bcd-e057-4cb2-a49d-ffdf4faaa053)  

**Hasil:**

![Update Result](https://github.com/user-attachments/assets/9d59354d-030f-4492-90c1-5ae7bf00dcb8)  

---

## 4️ Delete
Menu **Delete** akan menampilkan daftar barang.  
User diminta memasukkan **ID barang** yang ingin dihapus.
(belum ada perubahan di alurnya kecuali dibagagian lihat barang yang sekarang sudah kelihatan ada kateogori nya)

- Jika **ID ada** → barang dihapus.  
- Jika **ID tidak ada** → kembali ke menu awal dengan pesan *"Barang tidak ditemukan"*.  

**Tampilan:**

![Delete Menu](https://github.com/user-attachments/assets/fd7a686a-05c8-495b-9950-8e0bbfb643fe)  
![Delete Confirm](https://github.com/user-attachments/assets/a6e02bc7-f549-4d63-95dc-5350d87c2f1f)  
![Delete Result](https://github.com/user-attachments/assets/1f277fef-843c-45bd-95ae-b4425fba0f97)  

---

## 5️ Search
Menu **Search** digunakan untuk mencari barang berdasarkan **ID** atau **Nama**.
(belum ada perubahan di alurnya kecuali dibagagian lihat barang yang sekarang sudah kelihatan ada kateogori nya)

- Jika input kosong → kembali ke menu awal dengan pesan *"Kata kunci tidak boleh kosong"*.  
- Jika ditemukan → tampilkan hasil pencarian.  
- Jika tidak ditemukan → tampil pesan *"Barang tidak ditemukan"*.  

**Tampilan:**

<img width="413" height="305" alt="image" src="https://github.com/user-attachments/assets/5651c565-1b08-424a-b5e7-41cc61dfa3c1" />
<img width="463" height="656" alt="image" src="https://github.com/user-attachments/assets/33a1d0cf-9f15-410e-b33f-f44b278d1995" />
<img width="477" height="642" alt="image" src="https://github.com/user-attachments/assets/ad427ff7-3479-461b-b086-103fb3cbeeb0" />
<img width="228" height="82" alt="image" src="https://github.com/user-attachments/assets/21cba3b5-c6d2-41ff-8bd9-b7746cd3d561" />

---

## 6️ Exit
Menu **Exit** digunakan untuk keluar dari program.  

**Tampilan:**

![Exit Menu](https://github.com/user-attachments/assets/6cf874d8-7003-418b-a314-51ebff3f35ea) 
</details>
