# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program ini adalah sistem manajemen inventaris gudang yang dikembangkan menggunakan **Java**. Program ini mengimplementasikan konsep **OOP (Object-Oriented Programming)** secara menyeluruh dan terintegrasi dengan **MySQL** melalui **JDBC** untuk persistensi data, menerapkan pola **ORM (Object-Relational Mapping)** sederhana.

Sistem ini memungkinkan manajemen data barang secara efisien melalui fitur **CRUD** (Create, Read, Update, Delete) yang kini aman dan terpusat di database.
---



## 🟢 Status Implementasi Konsep & Teknologi

| Konsep | Status | Catatan Implementasi Utama |
| :--- | :--- | :--- |
| **Encapsulation** | ✅ Kuat | Getter & Setter digunakan dengan **validasi data** (misalnya, stok/garansi non-negatif) di *setter* subclass. |
| **Inheritance** | ✅ Diterapkan | `Elektronik` dan `Perabot` mewarisi dari `Barang`. |
| **Polymorphism** | ✅ Kuat | *Overriding* (`displayInfo()`, `getKategori()`) dan *Dynamic Dispatch* saat memproses data di `ManajemenGudang`& *OverrLoadding* di pencarian barang. |
| **Abstraction** | ✅ Kuat | `Barang` sebagai *abstract class* yang mendefinisikan kontrak `displayInfo()`. |
| **Interface** | ✅ Diterapkan | `Categorizable` memastikan konsistensi method `getKategori()`. |
| **JDBC** | ✅ Terintegrasi | Koneksi database, pemuatan driver, dan eksekusi SQL melalui `Connection`, `Statement`, dan `PreparedStatement`. |
| **ORM** | ✅ Diterapkan | Pola *Data Mapper* (`save`, `update`, `delete`) di `Barang.java` memetakan objek ke tabel database. |

---

## 📂 Struktur Packages (MVC)
<img width="328" height="281" alt="image" src="https://github.com/user-attachments/assets/beef47be-6c7f-44a1-837c-a011c85fa027" />

## 🆕 Apa Yang Baru?
Sekarang program telah tersambung secara Realtime ke database berkat jdbc.
<img width="815" height="161" alt="image" src="https://github.com/user-attachments/assets/763b4f41-b205-47f0-99b5-8fc05124dd16" />
<img width="350" height="691" alt="image" src="https://github.com/user-attachments/assets/d472e5c2-78f6-4865-b642-c8498cb8a008" />

- **Integrasi Database:** Seluruh operasi CRUD kini berinteraksi dengan tabel `barang` di MySQL.
- **ORM Penuh:** Class `Barang` bertindak sebagai dasar ORM dengan method `save()`, `update()`, dan `delete()` yang mengkonversi objek Java ke SQL dan sebaliknya.
- **Class Baru:**
    - `model/Conn.java` → Mengurus koneksi database (JDBC).
    - `model/View.java` → Class khusus untuk menampilkan semua data dari tabel menggunakan **JDBC `Statement`**.

---

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

### 🧱 `Barang` *(Abstract Class / ORM Base)*
* Superclass, basis ORM, dan penegak kontrak OOP.
* Menerapkan **Encapsulation**, **JDBC/ORM** (`save`, `update` atribut umum, `delete`), dan kontrak abstrak **`displayInfo()`**.

### ⚡ `Elektronik` & 🪑 `Perabot` *(Subclass)*
* Mewarisi `Barang`, menambahkan properti spesifik (`garansiBulan`, `bahan`).
* Mengimplementasikan validasi dan *override* **`displayInfo()`** dan **`getKategori()`**.

### 🔎 `ManajemenGudang` *(Service/Controller)*
* Mengelola alur program, *user input*, *error handling* terpusat, dan memanggil logika ORM.

### 📊 `View` *(Data Read)*
* Menggunakan **JDBC `Statement`** untuk menjalankan kueri `SELECT` dan `COUNT(*)` dan memformat output data.

### 🔌 `Conn` *(JDBC Utility)*
* Menyediakan detail dan fungsi koneksi database (`connect()`).

### 🖥️ `Main` *(View)*  
- Menyediakan tampilan menu utama dan menghubungkan pengguna dengan controller.  
- Menggunakan `switch-case` untuk navigasi fitur.

### 🏷️ `Categorizable` *(Interface)*  
- Interface sederhana yang mendefinisikan method `getKategori()`.  
- Dipakai oleh subclass (`Elektronik`, `Perabot`) untuk menampilkan kategori masing-masing.  
- Membantu menjaga konsistensi informasi kategori antar jenis barang.
---
## 🗃️ Penjelasan Implementasi Khusus

### Penjelasan Letak Abstraction (Abstract Class & Method)
Abstraction diterapkan pada class **`Barang`** di package `model`.
* **`Barang`** dijadikan `abstract class` karena hanya mendefinisikan struktur umum barang (ID, nama, stok, lokasi) tanpa implementasi penuh.
* Method **`displayInfo()`** dibuat `abstract`, memaksa setiap subclass (`Elektronik`, `Perabot`) untuk mendefinisikan implementasi tampilannya sendiri.

### Penjelasan Letak Interface
Interface **`Categorizable`** diimplementasikan oleh `Barang`.
* Interface ini mendefinisikan kontrak method **`String getKategori()`**, memastikan setiap objek barang dapat mengembalikan kategorinya secara konsisten.

### Penjelasan Letak Polymorphism
* **Overriding:** Terjadi pada method **`displayInfo()`** dan **`getKategori()`** di subclass, menggantikan implementasi dari superclass.
* **Dynamic Dispatch:** Di `ManajemenGudang`, saat memanggil `barang.displayInfo()`, JVM secara dinamis menentukan method mana yang akan dijalankan berdasarkan tipe objek aktual (`Elektronik` atau `Perabot`) saat *runtime*.

#### Overloading
* Terjadi pada class **`ManajemenGudang`** di method pencarian, yang memiliki dua versi dengan nama sama tetapi tanda tangan parameter berbeda:

```java
// 1. Mencari berdasarkan ID atau Nama (String)
private static void cariBarang(String keyword) { ... } 

// 2. Mencari berdasarkan Stok Minimal (Integer)
private static void cariBarang(int minStok) { ... }
```

### Penjelasan Letak Penerapan JDBC
Program menggunakan JDBC untuk semua operasi data.
<img width="718" height="668" alt="image" src="https://github.com/user-attachments/assets/a61a4e89-6afe-422c-b168-5fba3d879935" />

* **`model/Conn.java`**: Bertanggung jawab memuat driver dan membuka koneksi (`connect()`).
* **`model/View.java`**: Menggunakan **`Statement`** untuk menjalankan kueri *Read All* dan *Count* data dari database.
* **`model/Barang.java`**: Menggunakan **`PreparedStatement`** untuk operasi `save`, `update`, dan `delete` yang lebih aman.

### Penjelasan Letak Penerapan ORM
Class **`Barang`** bertindak sebagai *Data Mapper* yang memetakan objek ke baris tabel `barang`.
``` java
// Dalam class Barang.java, di method public void save() { ...
// ...
if (this instanceof Elektronik) {
    ps.setInt(6, ((Elektronik) this).getGaransiBulan()); 
    ps.setNull(7, java.sql.Types.VARCHAR);
} else if (this instanceof Perabot) {
    ps.setNull(6, java.sql.Types.INTEGER);
    ps.setString(7, ((Perabot) this).getBahan()); 
}
ps.executeUpdate();
// ...

```
* **Create (`save()`):** Atribut objek (`this.idBarang`, `this.stok`, dll.) langsung dimasukkan ke `PreparedStatement`. Logika `instanceof` digunakan untuk memetakan atribut spesifik subclass (`garansiBulan` atau `bahan`) ke kolom yang benar.
``` java
// A. Update Atribut Umum (Barang.update())
// Dalam class Barang.java, di method public void update(...) { ...
String sql = "UPDATE barang SET nama_barang = ?, stok = ?, lokasi = ? WHERE id_barang = ?";
// ...
ps.setString(1, (namaBaru == null || namaBaru.isEmpty()) ? namaBarang : namaBaru);
// ...
ps.executeUpdate();


// B. Update Atribut Spesifik (Logic di ManajemenGudang.updateBarang())
if (barang instanceof Elektronik && inputSpesifik != null && !inputSpesifik.isEmpty()) {
    String sql = "UPDATE barang SET garansi_bulan = ? WHERE id_barang = ?";
    try (PreparedStatement psUpdate = conn.prepareStatement(sql)) {
        psUpdate.setInt(1, ((Elektronik) barang).getGaransiBulan()); 
        psUpdate.setString(2, barang.getIdBarang());
        psUpdate.executeUpdate();
    }
} 
// ...
```
* **Update (`ManajemenGudang`):** Logic update yang kompleks mengambil nilai dari objek di memori (`((Elektronik) barang).getGaransiBulan()`) dan mengirimkannya melalui `PreparedStatement` terpisah ke database, memastikan objek dan data database selalu sinkron.

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
Sekarang Search memilikin menu yang menggunakan switch case yaitu pilihan 1 untuk melakukan pilihan berdasarkan ID/Nama  dan 2 untuk melakukan pencarian berdasarkan minimal Stok dari barang.


- Jika input kosong/invalid → kembali ke menu awal dengan sebuah pesan.  
- Jika ditemukan → tampilkan hasil pencarian.  
- Jika tidak ditemukan → tampil pesan *"Barang tidak ditemukan"*.  

**Tampilan:**

<img width="355" height="112" alt="image" src="https://github.com/user-attachments/assets/8f4834b0-9fe2-4c84-b2ab-66930c7c5c41" />
<img width="568" height="545" alt="image" src="https://github.com/user-attachments/assets/03a93736-7b39-45fb-9ea3-1ba157c6b31d" />


<img width="228" height="82" alt="image" src="https://github.com/user-attachments/assets/21cba3b5-c6d2-41ff-8bd9-b7746cd3d561" />
<img width="779" height="264" alt="image" src="https://github.com/user-attachments/assets/1377191c-8438-40f9-86d2-bb30162e3155" />
<img width="779" height="463" alt="image" src="https://github.com/user-attachments/assets/e86f4a9a-77e5-4b03-9eac-421558301db4" />



---

## 6️ Exit
Menu **Exit** digunakan untuk keluar dari program.  

**Tampilan:**

![Exit Menu](https://github.com/user-attachments/assets/6cf874d8-7003-418b-a314-51ebff3f35ea) 
</details>
