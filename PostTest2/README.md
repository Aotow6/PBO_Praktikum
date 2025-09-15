# Profil
Nama: Satria Rajawali Ektya Antara\
NIM: 2409116067\
Tema: Inventaris Gudang

# Deskripsi
Program Sederhana manajemen gudang yang untuk sekarang hanya bisa CRUD tapi memili security yang cukup lengkap
 # Source Code
<details>
  <summary> 🧑🏿‍💻 #️⃣ Whats new? </summary>
 

  

</details>
<!-- <details>
  <summary> ✍🏿🥸 Penjelasan kode </summary>
 

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

