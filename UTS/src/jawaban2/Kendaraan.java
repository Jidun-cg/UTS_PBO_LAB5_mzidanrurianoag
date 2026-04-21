package jawaban2;

public class Kendaraan {
    private String jenisKendaraan;
    private int durasiParkir;

    // constructor jenis kendaraan
    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getDurasiParkir() {
        return durasiParkir;
    }

    // tentukan tarif
    private double getTarifPerJam() {
        if (jenisKendaraan.equalsIgnoreCase("Motor")) return 2000.0;
        if (jenisKendaraan.equalsIgnoreCase("Mobil")) return 5000.0;
        if (jenisKendaraan.equalsIgnoreCase("Truk")) return 10000.0;
        return 0.0;
    }

    // overloading hitung biaya manual
    public double hitungBiayaParkir(int durasi) {
        this.durasiParkir = durasi;
        return kalkulasiBiaya();
    }

    // overloading hitung biaya waktu
    public double hitungBiayaParkir(int jamMasuk, int jamKeluar) {
        this.durasiParkir = jamKeluar - jamMasuk;
        return kalkulasiBiaya();
    }

    // kalkulasi total & diskon
    private double kalkulasiBiaya() {
        double total = durasiParkir * getTarifPerJam();
        // diskon 10% jika durasi > 5 jam
        if (durasiParkir > 5) {
            total = total - (total * 0.10);
        }
        return total;
    }
}