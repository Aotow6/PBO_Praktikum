# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program Sederhana manajemen gudang yang untuk sekarang hanya bisa CRUD tapi memili security yang cukup lengkap
 # Source Code
<details>
  <summary> </> #️⃣ Source Code </summary>
 

  
## Main.java/PostTest1
```java
package com.mycompany.posttest1;



import java.util.Scanner;
import java.util.ArrayList;


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
```
</details>
<details>
  <summary> ✍🏿🥸 Penjelasan kode </summary>
## Package yang dipakai
``` java
import java.util.Scanner;
import java.util.ArrayList;
```
java.util.Scanner  digunakan untuk menerima input dari user melalui keyboard.

java.util.ArrayList  digunakan untuk menyimpan data barang dalam bentuk list dinamis (bisa bertambah & berkurang).

## Menu Awal & Array List
```java

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
```
Program ini menggunakan **`Scanner`** untuk membaca input dari user melalui keyboard dan **`ArrayList<String[]>`** untuk menyimpan data barang secara dinamis. Setiap elemen ArrayList berisi [0] ID, [1] Nama, [2] Stok, dan [3] Lokasi barang. Deklarasi boolean `jalan` digunakan sebagai flag untuk menjaga agar program tetap berjalan selama value dari jalan adalah true di dalam loop utama `while(jalan)` sampai user memilih menu keluar.

Di dalam loop utama ini, program menampilkan menu inventaris menggunakan **switch-case** untuk menentukan aksi berdasarkan input user. Input menu divalidasi terlebih dahulu dengan `hasNextInt()` agar program tidak error jika user memasukkan karakter non-angka. Setelah membaca angka menu dengan `nextInt()`, digunakan `nextLine()` untuk mengosongkan buffer agar input berikutnya bisa terbaca dengan benar karena kalau tidak kosongkan "\n" dari nexint akan terbawa kena nxtline berikutanya yang akan menyebabkan scaner tersebut akan terskip.


## Case 1 Create
```java
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
```
Pada **case 1 (Create)**, program pertama menampilkan daftar barang (arraylist) yang sudah ada menggunakan loop `for` agar user bisa melihat ID yang tersedia. Program kemudian meminta user memasukkan ID barang baru dan mengecek apakah ID tersebut sudah ada di ArrayList menggunakan boolean `ada`. Jika ID sudah ada, program menampilkan pesan error. Jika ID valid, user diminta memasukkan Nama, Stok, dan Lokasi. Nama dan Lokasi divalidasi menggunakan `trim().isEmpty()` agar tidak kosong, sedangkan Stok divalidasi dengan `hasNextInt()` dan dicek agar tidak negatif. Jika semua input valid, data barang baru ditambahkan ke ArrayList dan program menampilkan pesan berhasil menambahkan barang.


## Case 2 Read
```java
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

```
**Case 2 (Read)** menampilkan daftar barang yang ada di ArrayList. Jika ArrayList kosong, program menampilkan pesan “Daftar barang masih kosong”. Loop `for` digunakan untuk mengakses setiap elemen ArrayList dan menampilkannya secara rapi dengan format ID, Nama, Stok, dan Lokasi.


## Case 3 Update
```java
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

```
Pada **case 3 (Update)**, daftar barang ditampilkan terlebih dahulu sebelum user diminta memasukkan ID yang ingin diubah. Program menggunakan boolean `ditemukan` untuk menandai apakah ID tersebut ada di ArrayList. ID dibandingkan menggunakan `equalsIgnoreCase()`, sehingga pencarian tidak sensitif terhadap huruf besar atau kecil. Jika ID ditemukan, program meminta input data baru untuk Nama, Stok, dan Lokasi, dengan validasi yang sama seperti pada case Create. Data lama diupdate langsung pada ArrayList dan program menampilkan pesan berhasil memperbarui barang.



## Case 4 Delete & close
```java
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
```
**Case 4 (Delete)** mirip dengan case Update, di mana daftar barang ditampilkan terlebih dahulu. User diminta memasukkan ID barang yang ingin dihapus, dan boolean `terhapus` menandai apakah ID ditemukan. Jika ID valid, barang dihapus dari ArrayList menggunakan `daftarBarang.remove(i)` berdasarkan indeks, dan program menampilkan pesan berhasil menghapus. Jika ID tidak ditemukan, program menampilkan pesan error.

**Case 5 (Exit)** mengubah boolean `jalan` menjadi `false`, sehingga loop utama berhenti dan program keluar. Sebelum keluar, program menampilkan pesan terima kasih.



di program ini saya menggunakan `.trim` agar user tidak menginput hanya spasi karena kegunaan trim adalah untuk menghapus spasi yang berada sebelum dan sesudah karakter contoh "   lap top   " maka akan terbada "lap top" karena trim lalu saya menggunakan <0 untuk stok agar user tidak bisa menginput value negatif, koma, dan huruf, Tetapi karena ini nextInt dia tidak bisa menerima inputan `hanya` spasi jika itu terjadi maka inputan akan ngestuck sampai user menginput sesuatu yang invalid untuk hal ini adalah value negatif, koma, dan huruf baru kita bisa keluar dari inputan dan di kembalikan ke menu awal.

</details>
<details>
  <summary> 🖥️📤📥 Output </summary>
## Output Program
### Menu Utama
<img width="410" height="156" alt="Screenshot 2025-09-10 171628" src="https://github.com/user-attachments/assets/27a2b5a1-f04c-41cd-bbd4-8419cfbe227b" />

Ketika pertama kali menjalankan kode maka akan muncul menu utama yang berisi Create, Read, Update, Delete, dan Exit.

### Menu Create
<img width="418" height="391" alt="Screenshot 2025-09-10 171641" src="https://github.com/user-attachments/assets/b64e39d5-4be0-4a75-955d-cdfb042e60c4" />
<img width="327" height="94" alt="Screenshot 2025-09-10 171741" src="https://github.com/user-attachments/assets/e99d5e5a-4bbc-41d5-b769-91dddb658023" />
<img width="331" height="76" alt="Screenshot 2025-09-10 171705" src="https://github.com/user-attachments/assets/ec8e83ec-f7da-43e6-89ee-91d1127af8cc" />

pertama-tama Sistem menampilkan daftar barang (Read) agar user bisa melihar id mana yang sudah dipakai

Ketika memasukkan angka 1 di menu utama akan muncul menu membuat Barang. Jika ID ada di ArrayList/ kita memasukan data tidak sesuai format maka akan muncul pesan gagal dan mengembalikan kita ke menu awal.

<img width="343" height="307" alt="Screenshot 2025-09-10 171827" src="https://github.com/user-attachments/assets/95702092-21a3-41bf-8dc4-12a4072de2d0" />



Jika ID  tidak ada di data sebelumnya maka kita akan diminta untuk mengisi data yang diperlukan untuk barang yaitu nama, stok, dan lokasi pastikan memasukan data dengan benar karena kalau tidak maka akan gagal dan akan kembali ke menu awal.

### Menu Read
<img width="373" height="325" alt="Screenshot 2025-09-10 171839" src="https://github.com/user-attachments/assets/5811edbe-e93e-44ab-a06a-463d150d600e" />
<img width="236" height="19" alt="image" src="https://github.com/user-attachments/assets/9b802d92-17f0-47a8-a904-03644ad38828" />
<img width="332" height="89" alt="image" src="https://github.com/user-attachments/assets/7e7251a2-0b53-4593-963e-930b24fb8802" />


Ketika memasukkan angka 2 di menu utama maka akan muncul daftar data Barang dan jika tidak ada data  di dalam arraylist maka akan keluar pesan "daftar barang masih kosong" .

### Menu Update
<img width="369" height="145" alt="image" src="https://github.com/user-attachments/assets/3581d0e6-08e6-44e7-8d40-10b092a70a15" />



Ketika memasukkan angka 3 di menu utama maka akan muncul daftar data barang dan menu untuk memasukkan ID  yang ingin diubah. Jika berhasil diubah maka akan muncul pesan data pesawat berhasil diubah dan jika id salah/invalid input maka akan di kembalikan ke menu utama .

<img width="410" height="78" alt="Screenshot 2025-09-10 171913" src="https://github.com/user-attachments/assets/e3d2b1b4-9fc0-464e-8750-f4c65b1835fd" />


### Menu Delete
<img width="411" height="586" alt="Screenshot 2025-09-10 172820" src="https://github.com/user-attachments/assets/dfa13af0-a5cf-4afd-9861-3fbdadfa3cc5" />

<img width="429" height="720" alt="Screenshot 2025-09-10 172908" src="https://github.com/user-attachments/assets/035852d8-f63c-4fad-bc7a-4814c3c8949a" />

Ketika memasukkan angka 4 di menu utama maka akan muncul daftar barang dan inputan untuk memasukkan ID  yang ingin dihapus. Jika berhasil dihapus maka akan muncul pesan Barang berhasil dihapus.

<img width="390" height="382" alt="Screenshot 2025-09-10 172840" src="https://github.com/user-attachments/assets/fd5fc3e7-d953-4e77-903d-e074cdcc427c" />

Jika ID  tidak ada, maka akan muncul pesan Barang dengan ID tersebut tidak ditemukan.

oh iya karna saya pakai equalsIgnoreCase buat cocokin id maka inputan user tidak sensitif terhadap huruf besar/kecil.

### Exit
<img width="434" height="222" alt="Screenshot 2025-09-10 172918" src="https://github.com/user-attachments/assets/50f28da9-2084-4829-a9f6-d1efc7e16b76" />

Masukkan angka 5 pada menu utama untuk keluar dari program.

</details>

