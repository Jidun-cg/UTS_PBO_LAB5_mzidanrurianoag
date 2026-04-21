package jawaban1;

import java.util.ArrayList;

public class Perusahaan {
    //atribut daftar karyawan
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    //method mencari karyawan berdasarkan ID
    private Karyawan cariKaryawan(String id) {
        for (Karyawan k : daftarKaryawan) {
            if (k.getId().equals(id)) {
                return k;
            }
        }
        return null;
    }

    // Menambahkan Karyawan [cite: 114]
    public void tambahKaryawan(String id, String nama, String posisi, double gaji) {
        //validasi agar tidak ada duplikat
        if (cariKaryawan(id) != null) {
            System.out.println("Gagal: Karyawan dengan ID " + id + " sudah ada");
            return;
        }
        //validasi gaji agar tidak negatif
        if (gaji < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif");
            return;
        }

        Karyawan karyawanBaru = new Karyawan(id, nama, posisi, gaji);
        daftarKaryawan.add(karyawanBaru);
        System.out.println("Karyawan berhasil ditambahkan");
    }

    // hapus Karyawan
    public void hapusKaryawan(String id) {
        Karyawan k = cariKaryawan(id);
        //validasi kalau ID yang akan dihapus memang sudah ada di daftar
        if (k != null) {
            daftarKaryawan.remove(k);
            System.out.println("Karyawan berhasil dihapus");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan");
        }
    }

    //ubah Posisi Karyawan
    public void ubahPosisi(String id, String posisiBaru) {
        Karyawan k = cariKaryawan(id);
        //validasi kalua ID yang akan diubah memang sudah ada di daftar
        if (k != null) {
            k.setPosisi(posisiBaru);
            System.out.println("Posisi berhasil diubah");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan");
        }
    }

    // mengubah Gaji Karyawan
    public void ubahGaji(String id, double gajiBaru) {
        Karyawan k = cariKaryawan(id);
        if (k == null) {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan");
            return;
        }
        //validasi gaji agar tidak negatif
        if (gajiBaru < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif");
            return;
        }
        k.setGaji(gajiBaru);
        System.out.println("Gaji berhasil diubah");
    }

    //tampilkan semua karyawan
    public void tampilkanSemuaKaryawan() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan");
            return;
        }
        for (Karyawan k : daftarKaryawan) {
            k.tampilkanInfo();
        }
    }
}