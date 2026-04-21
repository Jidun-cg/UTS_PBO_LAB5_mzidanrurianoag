package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean lanjut = true;
        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;

        System.out.println("Welcome to ParkingKun (rival ParkingChan)");

        while (lanjut) {
            // input kendaraan
            System.out.print("Masukkan Tipe Kendaraan (Motor/Mobil/Truk): ");
            String jenis = scanner.nextLine();

            Kendaraan kendaraan = new Kendaraan(jenis);
            double biaya = 0;

            // input durasi
            System.out.print("Masukkan Tipe Durasi Parkir (Manual/Time): ");
            String tipeDurasi = scanner.nextLine();

            // cek tipe input
            if (tipeDurasi.equalsIgnoreCase("Manual")) {
                System.out.print("Masukkan durasi kamu (dalam jam): ");
                int durasi = Integer.parseInt(scanner.nextLine());
                biaya = kendaraan.hitungBiayaParkir(durasi);
            } else if (tipeDurasi.equalsIgnoreCase("Time")) {
                System.out.print("Masukkan jadwal masuk: ");
                int masuk = Integer.parseInt(scanner.nextLine());
                System.out.print("Masukkan jadwal keluar : ");
                int keluar = Integer.parseInt(scanner.nextLine());
                biaya = kendaraan.hitungBiayaParkir(masuk, keluar);
            }

            // cetak ringkasan
            System.out.println("---- INFORMASI PARKIR ----");
            System.out.println("Tipe Kendaraan   : " + kendaraan.getJenisKendaraan());
            System.out.println("Total Durasi Parkir   : " + kendaraan.getDurasiParkir() + " hour(s)");
            System.out.println("Total Biaya      : Rp" + biaya);

            // update rekap akhir
            totalKendaraan++;
            totalSemuaBiaya += biaya;

            // perulangan
            System.out.print("Tambakan kendaraan lain? (y/n): ");
            String pilihan = scanner.nextLine();
            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        // cetak rekap final
        System.out.println("==== LAPORAN AKHIR ====");
        System.out.println("Total Semua Kendaraan      : " + totalKendaraan);
        System.out.println("Total Semua Biaya : " + totalSemuaBiaya);
        System.out.println("Arigatouu.....");

        scanner.close();
    }
}