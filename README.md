# AppInsurance

Aplikasi desktop berbasis Java Swing untuk **manajemen asuransi** yang mencakup fitur pengelolaan data polis, klaim asuransi, nasabah, dan perhitungan premi asuransi.

## Fitur Utama

- **Manajemen Nasabah**  
  Menampilkan daftar nasabah dengan detail seperti nama, umur, jenis kelamin, serta fitur tambah dan update data nasabah secara interaktif melalui dialog khusus.

- **Manajemen Polis Asuransi**  
  Pengelolaan polis yang dibuat untuk nasabah tertentu, lengkap dengan data premi, jenis asuransi, dan polis terkait. Terdapat fungsi tambah polis baru dengan input data nasabah terhubung.

- **Proses Klaim Asuransi**  
  Memudahkan pengajuan dan pemrosesan klaim melalui dialog input klaim dengan validasi data. Klaim disimpan dan daftar klaim dapat dilihat di tabel yang dapat di-refresh secara otomatis.

- **Perhitungan Premi Asuransi**  
  Dialog khusus untuk menghitung premi asuransi berdasarkan jenis asuransi (kesehatan atau jiwa) dengan input biaya dasar atau nilai pertanggungan. Premi dihitung otomatis dan ditampilkan dengan format mata uang yang sesuai.

- **User Interface Responsif**  
  Berbasis Java Swing dengan tampilan yang modern dan mudah digunakan. Menggunakan dialog dan tabel dengan warna tema yang konsisten, tombol interaktif dengan style profesional, serta calendar picker untuk input tanggal.

## Teknologi yang Digunakan

- Java SE dengan Swing Framework untuk UI desktop
- PostgreSQL sebagai database penyimpanan data (asumsi dari konteks)
- Model domain bisnis asuransi termasuk kelas seperti `Klaim`, `Polis`, `Customer`, `AsuransiKesehatan`, dan `AsuransiJiwa`
- SwingX library untuk komponen date picker kalendar (`JXDatePicker`)
- Modular dan berbasis event-driven programming untuk interaksi UI dan backend service

## Cara Menjalankan

1. Pastikan Java Development Kit (JDK) sudah terpasang (versi 8 ke atas direkomendasikan).  
2. Clone repositori ini:
   git clone https://github.com/AdiMaulana/AppInsurance.git
3. Import ke IDE Java favorit Anda (Eclipse, IntelliJ, NetBeans, dll).  
4. Pastikan library tambahan (misal SwingX) sudah ditambahkan ke classpath bila diperlukan.  
5. Atur koneksi database pada konfigurasi koneksi (`database.properties` atau konfigurasi yang ada) sesuai setup PostgreSQL Anda.  
6. Jalankan aplikasi utama (`MainFrame` atau sesuai kelas `main` yang disediakan).

## Struktur Proyek (Contoh)

- `form/` - Paket berisi tampilan dialog dan panel UI (ProsesKlaimDialog, HitungPremiDialog, AddCustomerDialog, dsb)  
- `model/` - Kelas model domain seperti `Klaim`, `Polis`, `Customer`, dan kelas `Asuransi` dengan perhitungan premi  
- `service/` - Logika bisnis dan akses data (Service dan DAO)  
- `constant/` - Berisi konstanta yang digunakan di aplikasi  
- `MainFrame.java` - Frame utama aplikasi

## Contoh Fitur UI

- Dialog input klaim dengan kalender picker untuk tanggal  
- Tombol aksi responsif dan terletak konsisten di kanan bawah panel  
- Tabel data dinamis dengan sorting dan kolom aksi tombol detail  
- Popup perhitungan premi sesuai jenis asuransi dengan kalkulasi tarif premi dasar

## Kontribusi

Kontribusi sangat diterima! Silakan:

1. Fork repositori  
2. Buat branch fitur baru (`feature/namafitur`)  
3. Buat perubahan dengan dokumentasi dan testing  
4. Buat Pull Request ke branch utama

---

Jika Anda menemukan masalah, ingin pertanyaan, atau tambahan fitur, silakan submit issue pada repositori GitHub ini.

---

**AppInsurance** dibuat oleh Adi Maulana sebagai aplikasi desktop edukasi dan pengelolaan asuransi berbasis Java Swing.

